package android.support.v4.app;

import android.arch.lifecycle.o;
import android.os.Bundle;
import android.support.v4.a.b;
import android.support.v4.app.u;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoaderManagerImpl extends u {
    static boolean a = false;
    private final android.arch.lifecycle.e b;
    private final LoaderViewModel c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LoaderViewModel extends android.arch.lifecycle.n {
        private static final o.a a = new o.a() { // from class: android.support.v4.app.LoaderManagerImpl.LoaderViewModel.1
        };
        private android.support.v4.f.l<a> b = new android.support.v4.f.l<>();

        LoaderViewModel() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.arch.lifecycle.n
        public void a() {
            super.a();
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.e(i).a(true);
            }
            this.b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.b.b(); i++) {
                    a e = this.b.e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.d(i));
                    printWriter.print(": ");
                    printWriter.println(e.toString());
                    e.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void b() {
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.e(i).f();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a<D> extends android.arch.lifecycle.j<D> implements b.a<D> {
        private final int a;
        private final Bundle b;
        private final android.support.v4.a.b<D> c;
        private android.arch.lifecycle.e d;
        private b<D> e;
        private android.support.v4.a.b<D> f;

        android.support.v4.a.b<D> a(boolean z) {
            if (LoaderManagerImpl.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.c.c();
            this.c.g();
            b<D> bVar = this.e;
            if (bVar != null) {
                a(bVar);
                if (z) {
                    bVar.b();
                }
            }
            this.c.a((b.a) this);
            if ((bVar == null || bVar.a()) && !z) {
                return this.c;
            }
            this.c.i();
            return this.f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.LiveData
        public void a(android.arch.lifecycle.k<D> kVar) {
            super.a(kVar);
            this.d = null;
            this.e = null;
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.c);
            android.support.v4.a.b<D> bVar = this.c;
            bVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.e);
                b<D> bVar2 = this.e;
                bVar2.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().a((android.support.v4.a.b<D>) a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }

        @Override // android.arch.lifecycle.LiveData
        protected void b() {
            if (LoaderManagerImpl.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.c.a();
        }

        @Override // android.arch.lifecycle.LiveData
        protected void c() {
            if (LoaderManagerImpl.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.c.e();
        }

        android.support.v4.a.b<D> e() {
            return this.c;
        }

        void f() {
            android.arch.lifecycle.e eVar = this.d;
            b<D> bVar = this.e;
            if (eVar == null || bVar == null) {
                return;
            }
            super.a(bVar);
            a(eVar, bVar);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.a);
            sb.append(" : ");
            android.support.v4.f.d.a(this.c, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b<D> implements android.arch.lifecycle.k<D> {
        private final android.support.v4.a.b<D> a;
        private final u.a<D> b;
        private boolean c;

        @Override // android.arch.lifecycle.k
        public void a(D d) {
            if (LoaderManagerImpl.a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.a((android.support.v4.a.b<D>) d));
            }
            this.b.a(this.a, d);
            this.c = true;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        boolean a() {
            return this.c;
        }

        void b() {
            if (this.c) {
                if (LoaderManagerImpl.a) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.b.a(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.c.b();
    }

    @Override // android.support.v4.app.u
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.f.d.a(this.b, sb);
        sb.append("}}");
        return sb.toString();
    }
}