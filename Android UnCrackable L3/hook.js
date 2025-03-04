console.log("Frida started");

function extract_secret() {
    setTimeout(function () {
        Java.perform(function () {
            const xor_key = "pizzapizzapizzapizzapizz";
            let gen_encrypted_secret_func =
                Module.findBaseAddress("libfoo.so").add(0x0012c0);

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
                    let secret_key = new Uint8Array(buff)
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

setTimeout(function () {
    Java.perform(function () {
        // Native
        let strstr_addr = Module.findExportByName("libc.so", "strstr");

        console.log("Found strstr address: " + strstr_addr);

        Interceptor.attach(strstr_addr, {
            onEnter: function (args) {
                let secondArg = Memory.readCString(args[1]);
                // Submit the input with value: frida0x8 to get the flag
                if (
                    secondArg.includes("frida") ||
                    secondArg.includes("xposed")
                ) {
                    this.check = true;
                }
            },
            onLeave: function (retval) {
                if (this.check) {
                    retval.replace(0);
                }
            },
        });

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

        extract_secret();
    });
}, 0);
