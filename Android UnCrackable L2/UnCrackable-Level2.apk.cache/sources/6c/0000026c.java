package sg.vantagepoint.uncrackable2;

/* loaded from: classes.dex */
public class CodeCheck {
    private native boolean bar(byte[] bArr);

    public boolean a(String str) {
        return bar(str.getBytes());
    }
}