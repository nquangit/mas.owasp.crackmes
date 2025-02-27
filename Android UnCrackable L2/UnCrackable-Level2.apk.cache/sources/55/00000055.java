package android.support.v4.a;

import android.support.v4.f.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class b<D> {
    int a;
    a<D> b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    /* loaded from: classes.dex */
    public interface a<D> {
    }

    public String a(D d) {
        StringBuilder sb = new StringBuilder(64);
        d.a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
        b();
    }

    public void a(a<D> aVar) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.b != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.b = null;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.c || this.f || this.g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g);
        }
        if (this.d || this.e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d);
            printWriter.print(" mReset=");
            printWriter.println(this.e);
        }
    }

    protected void b() {
    }

    public boolean c() {
        return d();
    }

    protected boolean d() {
        return false;
    }

    public void e() {
        this.c = false;
        f();
    }

    protected void f() {
    }

    public void g() {
        this.d = true;
        h();
    }

    protected void h() {
    }

    public void i() {
        j();
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }

    protected void j() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        d.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}