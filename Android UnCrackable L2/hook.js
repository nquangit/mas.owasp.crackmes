console.log("Frida started");

function byte_array_to_str(x) {
    let StringClass = Java.use("java.lang.String");
    let CharsetClass = Java.use("java.nio.charset.Charset");


    let jByteArray = Java.array("byte", x);
    let utf8Charset = CharsetClass.forName("UTF-8");

    let javaString = StringClass.$new(jByteArray, utf8Charset);
    return javaString;
}

setTimeout(function () {
    Java.perform(function () {
        let root_checker = Java.use("sg.vantagepoint.a.b");

        // Reimplement the method
        root_checker.a.implementation = function () {
            // Check su executable in PATH
            return false;
        };

        root_checker.b.implementation = function () {
            // Check Build.TAGS contains "test-keys"
            return false;
        };

        root_checker.c.implementation = function () {
            // Check some su daemon
            return false;
        };
    });
}, 0);
