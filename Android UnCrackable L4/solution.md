# Android UnCrackable L3

## Install and explore the application

-   Install the application on a android mobile, it can be a physical devices or an emulator.
-   That devices must be rooted and had frida-server ran.
-   Then we try to access this app, and we got a crash

```
*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***
Build fingerprint: 'Android/aosp_marlin/marlin:9/PQ3A.190605.04081832/3793265:user/release-keys'
Revision: '0'
ABI: 'x86_64'
pid: 14057, tid: 14089, name: re.pwnme  >>> com.android.systemui <<<
signal 11 (SIGSEGV), code 1 (SEGV_MAPERR), fault addr 0xfaba4975
    rax 000000008164a67b  rbx 00000000faba4975  rcx 00000000ac4ca725  rdx 00007fff5777c601
    r8  00000000b7414965  r9  00007fff578cf200  r10 00007fff578cf1f0  r11 00000000000035b2
    r12 8766843f6add1a00  r13 cc35d8a47681da00  r14 000000000000d6c8  r15 5a6369ec35bd0101
    rdi 00007fff5777c618  rsi 00007fff5777c744
    rbp 00007fff578d24b0  rsp 00007fff578cf1f0  rip 00007fff575ed951

backtrace:
    #00 pc 0000000000044951  /data/app/re.pwnme-ZXHkaCUOBxZzz3dC2M4lhA==/lib/x86_64/libnative-lib.so
    #01 pc 000000000009079b  /system/lib64/libc.so (offset 0x7d000) (__pthread_start(void*)+27)
    #02 pc 000000000002bdad  /system/lib64/libc.so (offset 0x2a000) (__start_thread+61)
***
[Android Emulator 5554::re.pwnme ]->
```

It seems Crash is caused by Native Library

## Bypass the crash

-   Load file libnative-lib.so As we have seen from Backtrace to IDA for analysis
-   We can observe that almost all functions are not recognized only some functions from `libc` and especially `JNI_ONload`
-   It seems to look quite messy and a bit complicated to thoroughly analyze them
-   We can try another way

### Manually check the imported functions

-   We have some attractive functions that can be seen through

    -   strcmp
    -   open
    -   sprintf

-   Here is the sample code

```js
function hook_open() {
    let open_func = Module.findExportByName("libc.so", "open");
    Memory.protect(open_func, 0x1000000, "rwx");
    console.log(`Found open function address: ${open_func}`);
    Interceptor.attach(open_func, {
        onEnter: function (args) {
            let firstArg = Memory.readCString(args[0]);
            console.log(`Calling open(${firstArg})`);
        },
        onLeave: function (retVal) {
            // nothing
        },
    });
    console.log("-----------------");
}
```

-   After checking the above functions, we see that the s`strcmp` function is called too many times, so it is difficult to determine which one is needed to manipulate
-   With the function `open` we observe that they read the files in turn seem to be looking for the execution file `su` so that we can manipulate by modifying the input path into an irreversible path

```js
function hook_open() {
    let open_func = Module.findExportByName("libc.so", "open");
    // console.log(`Found open function address: ${open_func}`);
    Interceptor.attach(open_func, {
        onEnter: function (args) {
            let firstArg = args[0];
            let firstArgStr = Memory.readCString(firstArg);
            if (firstArgStr.includes("/su")) {
                firstArg.writeUtf8String("/nothing");
            }
            console.log(`Calling open("${Memory.readCString(firstArg)}")`);
        },
        onLeave: function (retVal) {
            // nothing
        },
    });
    console.log("-----------------");
}
```

-   And followed by sprintf, we can easily get the output of this function and also see the output is also the path.
-   We can run the application with Frida with the option `--pause` to prevent the application completely close.
-   Then we can check the links from the output of the sprintf function above and we see it exists, try changing it into the path without existence.

## Inside the application

-   After all (actually, just manipulate the function `snprintf`) of the above steps we can see that a new error message appears `Process crashed: java.lang.arithmeticexception: divide by zero`.
-   That happens because the problem lies in the source code of the app, not the native code anymore. We can easily recognize this thanks to Stack Trace in Command Line.

```
FATAL EXCEPTION: main
Process: re.pwnme, PID: 16011
java.lang.RuntimeException: Unable to start activity ComponentInfo{re.pwnme/re.pwnme.MainActivity}: java.lang.ArithmeticException: divide by zero
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2958)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3093)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1823)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:193)
        at android.app.ActivityThread.main(ActivityThread.java:6840)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:860)
Caused by: java.lang.ArithmeticException: divide by zero
        at re.pwnme.MainActivity.onCreate(SourceFile:38)
        at android.app.Activity.performCreate(Activity.java:7144)
        at android.app.Activity.performCreate(Activity.java:7135)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2938)
        ... 11 more
***
[Android Emulator 5554::re.pwnme ]->
```

-   Follow the stack trace then we got a method in MainActivity class with an divided by zero

```java
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation(1);
    setContentView(R.layout.activity_main);
    this.f1833a = (byte) -16;
    b rb = new b(getApplicationContext());
    if (rb.j() || (rb.a() && rb.e())) {
        int i = 1337 / 0;
        this.f1833a = (byte) (this.f1833a | 15);
    }
    g();
}
```

-   We have encountered a new challenge, with some methods of anti root and anti debug in class `b.a.a.b`
-   Re-implement the functions to bypass

**_Note:_** I don't know if it is about my script or not, but it seems that the script only runs once, and then it cannot work properly anymore.But after a certain period of time, they can still operate

## pthread_create

-   After studying the exam, I discovered that in IDA there is an imported function `pthreat_create` with another function called` start_routine`.After finding out, these will be the ingredients to create a new thread

```c
// prototype
int pthread_create(pthread_t *thread, const pthread_attr_t *attr, void*(*start_routine)(void*), void *arg);
```

-   But the Start_Routine function looks like a huge mess, I feel it like an electrical system or network.
-   I have read some articles that some thread security can be built from `pthread_create` with `attr` and `arg` are `null`
-   Let's try Hook into the function `pthread_create` from this `libc.so`.

```js
function thread_test() {
    let p_pthread_create = Module.findExportByName("libc.so", "pthread_create");
    let pthread_create = new NativeFunction(p_pthread_create, "int", [
        "pointer",
        "pointer",
        "pointer",
        "pointer",
    ]);
    send("NativeFunction pthread_create() replaced @ " + pthread_create);

    Interceptor.replace(
        p_pthread_create,
        new NativeCallback(
            function (ptr0, ptr1, ptr2, ptr3) {
                send("pthread_create() overloaded");
                let ret = ptr(0);
                if (ptr1.isNull() && ptr3.isNull()) {
                    send(
                        "loading fake pthread_create because ptr1 and ptr3 are equal to 0!"
                    );
                } else {
                    send("loading real pthread_create()");
                    ret = pthread_create(ptr0, ptr1, ptr2, ptr3);
                }
                send("ret: " + ret);
            },
            "int",
            ["pointer", "pointer", "pointer", "pointer"]
        )
    );
}
```

And boom, we have been in, hihi. Also next part, now I have a new task. See you again
