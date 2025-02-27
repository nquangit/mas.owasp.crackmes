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
        let root_checker = Java.use("sg.vantagepoint.a.c");

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

        // sg.vantagepoint.uncrackable1
        let secret_dec = Java.use("sg.vantagepoint.a.a");
        
        secret_dec.a.implementation = function (bArr, bArr2) {

            let res = this.a(bArr, bArr2);

            let string_res = byte_array_to_str(res)
            console.log("Return value: " + string_res);
            return res;
        };
    });
}, 0);
