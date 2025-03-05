function hook_open() {
    let open_func = Module.findExportByName("libc.so", "open");
    // console.log(`Found open function address: ${open_func}`);
    Interceptor.attach(open_func, {
        onEnter: function (args) {
            let firstArgStr = args[0].readUtf8String();
            if (firstArgStr.includes("/su")) {
                const buf = Memory.allocUtf8String(
                    firstArgStr.replace("/su", "/path-not-found")
                );
                args[0] = buf;
            }
            // console.log(`Calling open("${args[0].readUtf8String()}")`);
        },
        onLeave: function (retVal) {},
    });
    // console.log("-----------------");
}

function hook_snprintf() {
    let snprintf_func = Module.findExportByName("libc.so", "snprintf");
    // console.log(`Found snprintf function address: ${snprintf_func}`);
    Interceptor.attach(snprintf_func, {
        onEnter: function (real_args) {
            this.args = real_args[0];
        },
        onLeave: function (retVal) {
            let argStr = this.args.readUtf8String();
            if (argStr.includes("/status")) {
                this.args.writeUtf8String(
                    argStr.replace("/status", "/path-not-found")
                );
            }
            // console.log(`snprintf return value: ${this.args.readUtf8String()}`);
        },
    });
    // console.log("-----------------");
}

// function hook_tool_checker() {
//     let objects = Module.enumerateExports("libtool-checker.so");

//     let check_for_root = Module.findExportByName(
//         "libtool-checker.so",
//         "Java_com_scottyab_rootbeer_RootBeerNative_checkForRoot"
//     );
//     console.log(`Found checkForRoot function address: ${check_for_root}`);
//     Interceptor.attach(check_for_root, {
//         onEnter: function (args) {
//             let firstArg = Memory.readCString(args[0]);
//             console.log(`Calling checkForRoot("${firstArg}")`);
//         },
//         onLeave: function (retVal) {
//             console.log(`checkForRoot return value: ${retVal}`);
//         },
//     });
// }

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

function bypass_java_check() {
    let checker_class = Java.use("b.a.a.b");
    // console.log(`Found b.a.a.b class address: ${checker_class}`);

    checker_class.j.implementation = function () {
        return false;
    };

    checker_class.a.overload().implementation = function () {
        return false;
    };

    checker_class.e.implementation = function () {
        return false;
    };
}

setTimeout(function () {
    Java.perform(function () {
        console.log("Start Frida");
        thread_test();
        bypass_java_check();
        // hook_tool_checker();
        console.log("_____________________________________________");

        hook_snprintf();
        hook_open();
    });
}, 0);
