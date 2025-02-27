# Android UnCrackable L1

## Install and discover

-   Install the application on a android mobile, it can be a physical devices or an emulator.
-   That devices must be rooted and had frida-server ran.
-   Then we try to access this app, and we got a message "Root detected" and the app exit like the L1.

## Source code

-   First, we need to use a tool to extract and view the source code of the application.
-   We can use Jadx, ByteCode-Viewer,...
-   After load that application to a de-compiler application, we can clearly view the source code.

# Bypass root detect

> Like the L1

## Like the L1 but the secret in the native code.

-   We can find some `native` method in MainActivity and sg.vantagepoint.uncrackable2.CodeCheck class.
-   Load the native from MainActivity

```java
    static {
        System.loadLibrary("foo");
    }

```

-   Extract the apk file with apktool
-   Look for the lib <APKname>/lib/<ABI>/libfoo.so
-   Open `.so` file with IDA or Ghidra,....
-   Find 2 function

    -   Java_sg_vantagepoint_uncrackable2_MainActivity_init
    -   Java_sg_vantagepoint_uncrackable2_CodeCheck_bar

-   From `Java_sg_vantagepoint_uncrackable2_CodeCheck_bar` method that map to the `bar` native method in the CodeCheck class we can analysis the asm code and got the secret is: `Thanks for all the fish`
-   Got the secret

## Just a little Frida hook
