# Android UnCrackable L1

## Install and discover

-   Install the application on a android mobile, it can be a physical devices or an emulator.
-   That devices must be rooted and had frida-server ran.
-   Then we try to access this app, and we got a message "Root detected" and the app exit.

## Source code

-   First, we need to use a tool to extract and view the source code of the application.
-   We can use Jadx, ByteCode-Viewer,...
-   After load that application to a de-compiler application, we can clearly view the source code.

## Where to start

-   We can start from the EntryPoint of that application (check it in AndroidManifest.xml file): `sg.vantagepoint.uncrackable1.MainActivity`
-   Or we can find the the string "Root detected!" like we just open this app and got it.

## Root checking bypass

-   By any way, we will go to MainActivity class with a onCreate method that will check if the root access and app debuggable first.
-   Take a look and we got that it use a class `import sg.vantagepoint.a.c;` with method `a`, `b`, `c` to check the root.
-   Access this class then we got

```java
/* loaded from: classes.dex */
public class c {
    public static boolean a() {
        for (String str : System.getenv("PATH").split(":")) {
            if (new File(str, "su").exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean c() {
        for (String str : new String[]{"/system/app/Superuser.apk", "/system/xbin/daemonsu", "/system/etc/init.d/99SuperSUDaemon", "/system/bin/.ext/.su", "/system/etc/.has_su_daemon", "/system/etc/.installed_su_daemon", "/dev/com.koushikdutta.superuser.daemon/"}) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }
}
```

-   We need to re-implementation these method to bypass the root checking.

```js
console.log("Frida started");

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
    });
}, 0);
```

-   Then we can successfully bypass the root checker

## Get the secret

-   Now we have accessed to the main application, we can see an input field and a Verify button.
-   Try to enter something and submit to watch the behavior.
-   An popup that notice that "Nope..." "That's not it. Try again".
-   Now, come back to the source code. Just look around the MainActivity class we find a `verify` method that have these strings like the message above.

```java

    public void verify(View view) {
        String str;
        String obj = ((EditText) findViewById(R.id.edit_text)).getText().toString();
        AlertDialog create = new AlertDialog.Builder(this).create();
        if (a.a(obj)) {
            create.setTitle("Success!");
            str = "This is the correct secret.";
        } else {
            create.setTitle("Nope...");
            str = "That's not it. Try again.";
        }
        create.setMessage(str);
        create.setButton(-3, "OK", new DialogInterface.OnClickListener() { // from class: sg.vantagepoint.uncrackable1.MainActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        create.show();
    }
```

-   Read the code then we got that the app get the input from input field as string then pass to a method `a.a(obj)`
-   Go deeper (class sg.vantagepoint.uncrackable1.a)

```java
public class a {
    public static boolean a(String str) {
        byte[] bArr;
        byte[] bArr2 = new byte[0];
        try {
            bArr = sg.vantagepoint.a.a.a(b("8d127684cbc37c17616d806cf50473cc"), Base64.decode("5UJiFctbmgbDoLXmpL12mkno8HT4Lv8dlat8FxR2GOc=", 0));
        } catch (Exception e) {
            Log.d("CodeCheck", "AES error:" + e.getMessage());
            bArr = bArr2;
        }
        return str.equals(new String(bArr));
    }

    public static byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
```

-   Got some code for decrypt with AES, Base64 decode and a custom decrypt method.
-   With the Reverse Engineering way we can try to recreate the algorithm to get the secret.
-   But I am too lazy to do it :))))

## Hook to find

-   We con recognize that the final secret value will be store in bArr (a byte array) that is result of `sg.vantagepoint.a.a.a`
-   Yeahhh, I will hook to this method and get the secret.

```js
console.log("Frida started");

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
            return res;
        };
    });
}, 0);
```

-   The `res` variable above is a Java byte array. Convert it to string and print it out. Got the flag.

## The final script

```js
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

            let string_res = byte_array_to_str(res);
            console.log("Return value: " + string_res);
            return res;
        };
    });
}, 0);
```

## Flag

`I want to believe`
