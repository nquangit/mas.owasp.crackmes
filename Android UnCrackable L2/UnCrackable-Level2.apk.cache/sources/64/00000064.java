package android.support.v4.app;

import android.support.v4.app.g;
import android.support.v4.app.m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends q implements m.g {
    final m a;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    String k;
    boolean l;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    ArrayList<Runnable> u;
    ArrayList<a> b = new ArrayList<>();
    boolean j = true;
    int m = -1;
    boolean t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {
        int a;
        g b;
        int c;
        int d;
        int e;
        int f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        a(int i, g gVar) {
            this.a = i;
            this.b = gVar;
        }
    }

    public c(m mVar) {
        this.a = mVar;
    }

    private static boolean b(a aVar) {
        g gVar = aVar.b;
        return (gVar == null || !gVar.l || gVar.J == null || gVar.C || gVar.B || !gVar.W()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(ArrayList<g> arrayList, g gVar) {
        g gVar2 = gVar;
        int i = 0;
        while (i < this.b.size()) {
            a aVar = this.b.get(i);
            switch (aVar.a) {
                case 1:
                case 7:
                    arrayList.add(aVar.b);
                    break;
                case 2:
                    g gVar3 = aVar.b;
                    int i2 = gVar3.z;
                    g gVar4 = gVar2;
                    int i3 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        g gVar5 = arrayList.get(size);
                        if (gVar5.z == i2) {
                            if (gVar5 == gVar3) {
                                z = true;
                            } else {
                                if (gVar5 == gVar4) {
                                    this.b.add(i3, new a(9, gVar5));
                                    i3++;
                                    gVar4 = null;
                                }
                                a aVar2 = new a(3, gVar5);
                                aVar2.c = aVar.c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.b.add(i3, aVar2);
                                arrayList.remove(gVar5);
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        this.b.remove(i3);
                        i3--;
                    } else {
                        aVar.a = 1;
                        arrayList.add(gVar3);
                    }
                    i = i3;
                    gVar2 = gVar4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.b);
                    if (aVar.b == gVar2) {
                        this.b.add(i, new a(9, aVar.b));
                        i++;
                        gVar2 = null;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    this.b.add(i, new a(9, gVar2));
                    i++;
                    gVar2 = aVar.b;
                    break;
            }
            i++;
        }
        return gVar2;
    }

    public void a() {
        if (this.u != null) {
            int size = this.u.size();
            for (int i = 0; i < size; i++) {
                this.u.get(i).run();
            }
            this.u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.i) {
            if (m.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.b.get(i2);
                if (aVar.b != null) {
                    aVar.b.r += i;
                    if (m.a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.r);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.b.add(aVar);
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g.c cVar) {
        for (int i = 0; i < this.b.size(); i++) {
            a aVar = this.b.get(i);
            if (b(aVar)) {
                aVar.b.a(cVar);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.c != 0 || this.d != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (this.p != 0 || this.q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (this.b.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        String str3 = str + "    ";
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.b.get(i);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.b);
            if (z) {
                if (aVar.c != 0 || aVar.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.d));
                }
                if (aVar.e != 0 || aVar.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            a aVar = this.b.get(size);
            g gVar = aVar.b;
            if (gVar != null) {
                gVar.a(m.d(this.g), this.h);
            }
            int i = aVar.a;
            if (i != 1) {
                switch (i) {
                    case 3:
                        gVar.a(aVar.e);
                        this.a.a(gVar, false);
                        break;
                    case 4:
                        gVar.a(aVar.e);
                        this.a.j(gVar);
                        break;
                    case 5:
                        gVar.a(aVar.f);
                        this.a.i(gVar);
                        break;
                    case 6:
                        gVar.a(aVar.e);
                        this.a.l(gVar);
                        break;
                    case 7:
                        gVar.a(aVar.f);
                        this.a.k(gVar);
                        break;
                    case 8:
                        this.a.o(null);
                        break;
                    case 9:
                        this.a.o(gVar);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                }
            } else {
                gVar.a(aVar.f);
                this.a.h(gVar);
            }
            if (!this.t && aVar.a != 3 && gVar != null) {
                this.a.e(gVar);
            }
        }
        if (this.t || !z) {
            return;
        }
        this.a.a(this.a.l, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ArrayList<c> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = this.b.get(i4);
            int i5 = aVar.b != null ? aVar.b.z : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    c cVar = arrayList.get(i6);
                    int size2 = cVar.b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        a aVar2 = cVar.b.get(i7);
                        if ((aVar2.b != null ? aVar2.b.z : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    @Override // android.support.v4.app.m.g
    public boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        if (m.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.i) {
            this.a.a(this);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g b(ArrayList<g> arrayList, g gVar) {
        for (int i = 0; i < this.b.size(); i++) {
            a aVar = this.b.get(i);
            int i2 = aVar.a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            gVar = null;
                            break;
                        case 9:
                            gVar = aVar.b;
                            break;
                    }
                }
                arrayList.add(aVar.b);
            }
            arrayList.remove(aVar.b);
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.b.get(i);
            g gVar = aVar.b;
            if (gVar != null) {
                gVar.a(this.g, this.h);
            }
            int i2 = aVar.a;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        gVar.a(aVar.d);
                        this.a.h(gVar);
                        break;
                    case 4:
                        gVar.a(aVar.d);
                        this.a.i(gVar);
                        break;
                    case 5:
                        gVar.a(aVar.c);
                        this.a.j(gVar);
                        break;
                    case 6:
                        gVar.a(aVar.d);
                        this.a.k(gVar);
                        break;
                    case 7:
                        gVar.a(aVar.c);
                        this.a.l(gVar);
                        break;
                    case 8:
                        this.a.o(gVar);
                        break;
                    case 9:
                        this.a.o(null);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                }
            } else {
                gVar.a(aVar.c);
                this.a.a(gVar, false);
            }
            if (!this.t && aVar.a != 1 && gVar != null) {
                this.a.e(gVar);
            }
        }
        if (this.t) {
            return;
        }
        this.a.a(this.a.l, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.b.get(i2);
            int i3 = aVar.b != null ? aVar.b.z : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        for (int i = 0; i < this.b.size(); i++) {
            if (b(this.b.get(i))) {
                return true;
            }
        }
        return false;
    }

    public String d() {
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            sb.append(" #");
            sb.append(this.m);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }
}