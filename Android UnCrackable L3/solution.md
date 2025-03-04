# Android UnCrackable L3

## Install and explore the application

-   Install the application on a android mobile, it can be a physical devices or an emulator.
-   That devices must be rooted and had frida-server ran.
-   Then we try to access this app, and we got a message "Root or tampering detected" and the app exit like the L1 & L2.

## Source code

-   First, we need to use a tool to extract and view the source code of the application.
-   We can use Jadx, ByteCode-Viewer,...
-   After load that application to a de-compiler application, we can clearly view the source code.

## Start hook to bypass

-   First, try to start the application with frida

```bash
frida -Uf owasp.mstg.uncrackable3
```

-   But the application crash

```
Build fingerprint: 'Android/aosp_marlin/marlin:9/PQ3A.190605.04081832/3793265:user/release-keys'
Revision: '0'
ABI: 'x86_64'
pid: 7369, tid: 7400, name: tg.uncrackable3  >>> owasp.mstg.uncrackable3 <<<
signal 6 (SIGABRT), code -6 (SI_TKILL), fault addr --------
    rax 0000000000000000  rbx 00007fff58866280  rcx 00007ffff58fdf47  rdx 0000000000000006
    r8  0000000000000031  r9  0000000000000031  r10 0000000000000000  r11 0000000000000202
    r12 00007fff59429b62  r13 00007fff59429b68  r14 00007fff59429b50  r15 00007fff59429b60
    rdi 0000000000001cc9  rsi 0000000000001ce8
    rbp 00007fff728140b0  rsp 00007fff58866268  rip 00007ffff58fdf47

backtrace:
    #00 pc 000000000007df47  /system/lib64/libc.so (offset 0x7d000) (tgkill+7)
    #01 pc 000000000000374a  /data/app/owasp.mstg.uncrackable3--sI-ddUhqniqfSpkzgbtPQ==/lib/x86_64/libfoo.so (goodbye()+10)
    #02 pc 000000000000389a  /data/app/owasp.mstg.uncrackable3--sI-ddUhqniqfSpkzgbtPQ==/lib/x86_64/libfoo.so
    #03 pc 000000000009079b  /system/lib64/libc.so (offset 0x7d000) (__pthread_start(void*)+27)
    #04 pc 000000000002bdad  /system/lib64/libc.so (offset 0x2a000) (__start_thread+61)
***
```

-   Read the backtrace, we got that crash due to flow like below:
    `(__start_thread+61) -> (__pthread_start(void*)+27) -> libfoo.so -> (goodbye()+10) -> (tgkill+7)`

-   Combined with logcat tests related to that process, we can see a log line as follows:
    `02-27 18:34:16.435  7369  7400 V UnCrackable3: Tampering detected! Terminating...`

-   With this, we can build this idea to find string in source code or native library.

### Find the `goodbye` function and the log message string.

-   We will not be able to find a method called Goodbye or a string content like "tampering detected! Terminating ..." in Java source code from Jadx because they are placed in native code.

-   Now we need to load the Native `libfoo.so` library file in IDA or Ghidra for analysis.
-   After some simple analysis from the function name 'goodbye`from the Backtrace Message and the "tampering detected! Terminating" string in the logcat, we can find it called from a function that checks the file`/process/self/maps` and see in this monitoring file has phrase like" frida "or" xposed "or not
-   Our ideas will be the hook into the `` strstr` function of `` libc.so` to manipulate that there are no phrase chains in the file.

```js
let strstr_addr = Module.findExportByName("libc.so", "strstr");

console.log("Found strstr address: " + strstr_addr);

Interceptor.attach(strstr_addr, {
    onEnter: function (args) {
        let secondArg = Memory.readCString(args[1]);
        // Submit the input with value: frida0x8 to get the flag
        if (secondArg.includes("frida") || secondArg.includes("xposed")) {
            this.check = true;
        }
    },
    onLeave: function (retval) {
        if (this.check) {
            retval.replace(0);
        }
    },
});
```

### Root checker

Like the previous lab

```js
let root_checker = Java.use("sg.vantagepoint.util.RootDetection");

// Reimplement the method
root_checker.checkRoot1.implementation = function () {
    // Check su executable in PATH
    return false;
};

root_checker.checkRoot2.implementation = function () {
    // Check Build.TAGS contains "test-keys"
    return false;
};

root_checker.checkRoot3.implementation = function () {
    // Check some su daemon
    return false;
};
```

## Find the flag

-   Through the BYPASS sections above, I was able to enter the app normally, and next we have to find Secret Message
-   This is the Codecheck class content in Jadx, we have another native method

```java
package sg.vantagepoint.uncrackable3;

/* loaded from: classes.dex */
public class CodeCheck {
    private static final String TAG = "CodeCheck";

    private native boolean bar(byte[] bArr);

    public boolean check_code(String str) {
        return bar(str.getBytes());
    }
}
```

-   After checking the bar function in Native Library, we can see that first we will call a function to create the secret that has been encrypt (xor) then will proceed (xor) with our output with `xor_key` found in the source code java is `pizzapizzapizzapizzzzizzzz`.
-   The idea is quite simple now, we just need to hook into the secret encrypt function to get it and then use it to xor with `xor_key` above, we will get the original message.

```js
function extract_secret() {
    setTimeout(function () {
        Java.perform(function () {
            const xor_key = "pizzapizzapizzapizzapizz";
            let gen_encrypted_secret_func =
                Module.findBaseAddress("libfoo.so").add(0x0012c0); // X86_64 offset

            console.log(gen_encrypted_secret_func);

            Interceptor.attach(gen_encrypted_secret_func, {
                onEnter: function (args) {
                    this.enc_secret = args[0];
                },
                onLeave: function (retval) {
                    const secret_len = 24;
                    // Read 24 byte from this.enc_secret
                    let buff = Memory.readByteArray(this.enc_secret, 24);
                    console.log("[*] Secret key hexdump");
                    console.log("---------------------");
                    console.log(
                        hexdump(buff, { length: secret_len, ansi: true })
                    );
                    let secret_key = new Uint8Array(buff);
                    console.log("---------------------");
                    console.log("[*] XOR key ");
                    console.log("---------------------");
                    console.log(xor_key);
                    console.log("---------------------");
                    console.log("[*] Plaintext secret");
                    console.log("---------------------");
                    let secret = [];
                    for (let i = 0; i < secret_len; i++) {
                        secret[i] = String.fromCharCode(
                            secret_key[i] ^ xor_key.charCodeAt(i)
                        );
                    }
                    console.log(secret.join(""));
                    console.log("---------------------");
                },
            });
        });
    }, 100);
}
```

-   Everything seems to be perfect, now just hook with code and click the verify and compensation button, we get the secret in the console log.

```
[*] Secret key hexdump
---------------------
           0  1  2  3  4  5  6  7  8  9  A  B  C  D  E  F  0123456789ABCDEF
00000000  1d 08 11 13 0f 17 49 15 0d 00 03 19 5a 1d 13 15  ......I.....Z...
00000010  08 0e 5a 00 17 08 13 14                          ..Z.....
---------------------
[*] XOR key
---------------------
pizzapizzapizzapizzapizz
---------------------
[*] Plaintext secret
---------------------
making owasp great again
---------------------
```
