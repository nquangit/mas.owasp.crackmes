package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.c;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class g implements android.arch.lifecycle.e, ComponentCallbacks, View.OnCreateContextMenuListener {
    private static final android.support.v4.f.k<String, Class<?>> V = new android.support.v4.f.k<>();
    static final Object a = new Object();
    String A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean H;
    ViewGroup I;
    View J;
    View K;
    boolean L;
    LoaderManagerImpl N;
    a O;
    boolean P;
    boolean Q;
    float R;
    LayoutInflater S;
    boolean T;
    Bundle c;
    SparseArray<Parcelable> d;
    Boolean e;
    String g;
    Bundle h;
    g i;
    int k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    int r;
    m s;
    k t;
    m u;
    n v;
    android.arch.lifecycle.p w;
    g x;
    int y;
    int z;
    int b = 0;
    int f = -1;
    int j = -1;
    boolean G = true;
    boolean M = true;
    android.arch.lifecycle.f U = new android.arch.lifecycle.f(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        View a;
        Animator b;
        int c;
        int d;
        int e;
        int f;
        boolean i;
        c j;
        boolean k;
        private Boolean r;
        private Boolean s;
        private Object l = null;
        private Object m = g.a;
        private Object n = null;
        private Object o = g.a;
        private Object p = null;
        private Object q = g.a;
        x g = null;
        x h = null;

        a() {
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RuntimeException {
        public b(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        c cVar;
        if (this.O == null) {
            cVar = null;
        } else {
            this.O.i = false;
            cVar = this.O.j;
            this.O.j = null;
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    private a Z() {
        if (this.O == null) {
            this.O = new a();
        }
        return this.O;
    }

    public static g a(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = V.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                V.put(str, cls);
            }
            g gVar = (g) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(gVar.getClass().getClassLoader());
                gVar.b(bundle);
            }
            return gVar;
        } catch (ClassNotFoundException e) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        try {
            Class<?> cls = V.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                V.put(str, cls);
            }
            return g.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public boolean A() {
        if (this.O == null || this.O.s == null) {
            return true;
        }
        return this.O.s.booleanValue();
    }

    public boolean B() {
        if (this.O == null || this.O.r == null) {
            return true;
        }
        return this.O.r.booleanValue();
    }

    public void C() {
        if (this.s == null || this.s.m == null) {
            Z().i = false;
        } else if (Looper.myLooper() != this.s.m.h().getLooper()) {
            this.s.m.h().postAtFrontOfQueue(new Runnable() { // from class: android.support.v4.app.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.Y();
                }
            });
        } else {
            Y();
        }
    }

    void D() {
        if (this.t == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        this.u = new m();
        this.u.a(this.t, new i() { // from class: android.support.v4.app.g.2
            @Override // android.support.v4.app.i
            public g a(Context context, String str, Bundle bundle) {
                return g.this.t.a(context, str, bundle);
            }

            @Override // android.support.v4.app.i
            public View a(int i) {
                if (g.this.J != null) {
                    return g.this.J.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            @Override // android.support.v4.app.i
            public boolean a() {
                return g.this.J != null;
            }
        }, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        if (this.u != null) {
            this.u.k();
            this.u.e();
        }
        this.b = 4;
        this.H = false;
        l();
        if (this.H) {
            if (this.u != null) {
                this.u.n();
            }
            this.U.a(c.a.ON_START);
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onStart()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        if (this.u != null) {
            this.u.k();
            this.u.e();
        }
        this.b = 5;
        this.H = false;
        m();
        if (this.H) {
            if (this.u != null) {
                this.u.o();
                this.u.e();
            }
            this.U.a(c.a.ON_RESUME);
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onResume()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        if (this.u != null) {
            this.u.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        onLowMemory();
        if (this.u != null) {
            this.u.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        this.U.a(c.a.ON_PAUSE);
        if (this.u != null) {
            this.u.p();
        }
        this.b = 4;
        this.H = false;
        n();
        if (this.H) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        this.U.a(c.a.ON_STOP);
        if (this.u != null) {
            this.u.q();
        }
        this.b = 3;
        this.H = false;
        o();
        if (this.H) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onStop()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        if (this.u != null) {
            this.u.r();
        }
        this.b = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L() {
        if (this.u != null) {
            this.u.s();
        }
        this.b = 1;
        this.H = false;
        p();
        if (this.H) {
            if (this.N != null) {
                this.N.a();
            }
            this.q = false;
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M() {
        this.U.a(c.a.ON_DESTROY);
        if (this.u != null) {
            this.u.t();
        }
        this.b = 0;
        this.H = false;
        this.T = false;
        q();
        if (this.H) {
            this.u = null;
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N() {
        this.H = false;
        s();
        this.S = null;
        if (!this.H) {
            throw new y("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.u != null) {
            if (this.E) {
                this.u.t();
                this.u = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not  destroyed and this fragment is not retaining instance");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int O() {
        if (this.O == null) {
            return 0;
        }
        return this.O.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int P() {
        if (this.O == null) {
            return 0;
        }
        return this.O.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Q() {
        if (this.O == null) {
            return 0;
        }
        return this.O.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x R() {
        if (this.O == null) {
            return null;
        }
        return this.O.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x S() {
        if (this.O == null) {
            return null;
        }
        return this.O.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View T() {
        if (this.O == null) {
            return null;
        }
        return this.O.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator U() {
        if (this.O == null) {
            return null;
        }
        return this.O.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int V() {
        if (this.O == null) {
            return 0;
        }
        return this.O.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean W() {
        if (this.O == null) {
            return false;
        }
        return this.O.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean X() {
        if (this.O == null) {
            return false;
        }
        return this.O.k;
    }

    @Override // android.arch.lifecycle.e
    public android.arch.lifecycle.c a() {
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(String str) {
        if (str.equals(this.g)) {
            return this;
        }
        if (this.u != null) {
            return this.u.b(str);
        }
        return null;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.O == null && i == 0) {
            return;
        }
        Z().d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        if (this.O == null && i == 0 && i2 == 0) {
            return;
        }
        Z();
        this.O.e = i;
        this.O.f = i2;
    }

    public void a(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, g gVar) {
        StringBuilder sb;
        String str;
        this.f = i;
        if (gVar != null) {
            sb = new StringBuilder();
            sb.append(gVar.g);
            str = ":";
        } else {
            sb = new StringBuilder();
            str = "android:fragment:";
        }
        sb.append(str);
        sb.append(this.f);
        this.g = sb.toString();
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Animator animator) {
        Z().b = animator;
    }

    @Deprecated
    public void a(Activity activity) {
        this.H = true;
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.H = true;
    }

    public void a(Context context) {
        this.H = true;
        Activity f = this.t == null ? null : this.t.f();
        if (f != null) {
            this.H = false;
            a(f);
        }
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.H = true;
        Activity f = this.t == null ? null : this.t.f();
        if (f != null) {
            this.H = false;
            a(f, attributeSet, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.u != null) {
            this.u.a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        if (this.d != null) {
            this.K.restoreHierarchyState(this.d);
            this.d = null;
        }
        this.H = false;
        i(bundle);
        if (this.H) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        Z();
        if (cVar == this.O.j) {
            return;
        }
        if (cVar != null && this.O.j != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (this.O.i) {
            this.O.j = cVar;
        }
        if (cVar != null) {
            cVar.b();
        }
    }

    public void a(g gVar) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        Z().a = view;
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.y));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.z));
        printWriter.print(" mTag=");
        printWriter.println(this.A);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.b);
        printWriter.print(" mIndex=");
        printWriter.print(this.f);
        printWriter.print(" mWho=");
        printWriter.print(this.g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.B);
        printWriter.print(" mDetached=");
        printWriter.print(this.C);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.G);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.F);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.D);
        printWriter.print(" mRetaining=");
        printWriter.print(this.E);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.M);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.x);
        }
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.h);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.c);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.d);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.k);
        }
        if (O() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(O());
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.I);
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.J);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.J);
        }
        if (T() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(T());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(V());
        }
        if (this.N != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            LoaderManagerImpl loaderManagerImpl = this.N;
            loaderManagerImpl.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.u + ":");
            m mVar = this.u;
            mVar.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void a(boolean z) {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public Animator b(int i, boolean z, int i2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.u != null) {
            this.u.k();
        }
        this.q = true;
        return a(layoutInflater, viewGroup, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        Z().c = i;
    }

    public void b(Bundle bundle) {
        if (this.f >= 0 && c()) {
            throw new IllegalStateException("Fragment already active and state has been saved");
        }
        this.h = bundle;
    }

    public void b(Menu menu) {
    }

    public void b(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.r > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.B) {
            return false;
        }
        if (this.F && this.G) {
            z = true;
            a(menu, menuInflater);
        }
        return this.u != null ? z | this.u.a(menu, menuInflater) : z;
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public LayoutInflater c(Bundle bundle) {
        return e(bundle);
    }

    public void c(boolean z) {
    }

    public final boolean c() {
        if (this.s == null) {
            return false;
        }
        return this.s.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Menu menu) {
        boolean z = false;
        if (this.B) {
            return false;
        }
        if (this.F && this.G) {
            z = true;
            a(menu);
        }
        return this.u != null ? z | this.u.a(menu) : z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(MenuItem menuItem) {
        if (this.B) {
            return false;
        }
        if (this.F && this.G && a(menuItem)) {
            return true;
        }
        return this.u != null && this.u.a(menuItem);
    }

    public Context d() {
        if (this.t == null) {
            return null;
        }
        return this.t.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater d(Bundle bundle) {
        this.S = c(bundle);
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Menu menu) {
        if (this.B) {
            return;
        }
        if (this.F && this.G) {
            b(menu);
        }
        if (this.u != null) {
            this.u.b(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z) {
        b(z);
        if (this.u != null) {
            this.u.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(MenuItem menuItem) {
        if (this.B) {
            return false;
        }
        if (b(menuItem)) {
            return true;
        }
        return this.u != null && this.u.b(menuItem);
    }

    public final Context e() {
        Context d = d();
        if (d != null) {
            return d;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    public LayoutInflater e(Bundle bundle) {
        if (this.t != null) {
            LayoutInflater b2 = this.t.b();
            i();
            android.support.v4.g.e.b(b2, this.u.w());
            return b2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z) {
        c(z);
        if (this.u != null) {
            this.u.b(z);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final h f() {
        if (this.t == null) {
            return null;
        }
        return (h) this.t.f();
    }

    public void f(Bundle bundle) {
        this.H = true;
        g(bundle);
        if (this.u == null || this.u.a(1)) {
            return;
        }
        this.u.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z) {
        Z().k = z;
    }

    public final Resources g() {
        return e().getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        if (this.u == null) {
            D();
        }
        this.u.a(parcelable, this.v);
        this.v = null;
        this.u.l();
    }

    public final l h() {
        return this.s;
    }

    public void h(Bundle bundle) {
        this.H = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final l i() {
        if (this.u == null) {
            D();
            if (this.b >= 5) {
                this.u.o();
            } else if (this.b >= 4) {
                this.u.n();
            } else if (this.b >= 2) {
                this.u.m();
            } else if (this.b >= 1) {
                this.u.l();
            }
        }
        return this.u;
    }

    public void i(Bundle bundle) {
        this.H = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l j() {
        return this.u;
    }

    public void j(Bundle bundle) {
    }

    public View k() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Bundle bundle) {
        if (this.u != null) {
            this.u.k();
        }
        this.b = 1;
        this.H = false;
        f(bundle);
        this.T = true;
        if (this.H) {
            this.U.a(c.a.ON_CREATE);
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onCreate()");
    }

    public void l() {
        this.H = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Bundle bundle) {
        if (this.u != null) {
            this.u.k();
        }
        this.b = 2;
        this.H = false;
        h(bundle);
        if (this.H) {
            if (this.u != null) {
                this.u.m();
                return;
            }
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public void m() {
        this.H = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Bundle bundle) {
        Parcelable j;
        j(bundle);
        if (this.u == null || (j = this.u.j()) == null) {
            return;
        }
        bundle.putParcelable("android:support:fragments", j);
    }

    public void n() {
        this.H = true;
    }

    public void o() {
        this.H = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.H = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        f().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.H = true;
    }

    public void p() {
        this.H = true;
    }

    public void q() {
        this.H = true;
        if (this.w == null || this.t.d.s) {
            return;
        }
        this.w.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f = -1;
        this.g = null;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = 0;
        this.s = null;
        this.u = null;
        this.t = null;
        this.y = 0;
        this.z = 0;
        this.A = null;
        this.B = false;
        this.C = false;
        this.E = false;
    }

    public void s() {
        this.H = true;
    }

    public void t() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        android.support.v4.f.d.a(this, sb);
        if (this.f >= 0) {
            sb.append(" #");
            sb.append(this.f);
        }
        if (this.y != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.y));
        }
        if (this.A != null) {
            sb.append(" ");
            sb.append(this.A);
        }
        sb.append('}');
        return sb.toString();
    }

    public Object u() {
        if (this.O == null) {
            return null;
        }
        return this.O.l;
    }

    public Object v() {
        if (this.O == null) {
            return null;
        }
        return this.O.m == a ? u() : this.O.m;
    }

    public Object w() {
        if (this.O == null) {
            return null;
        }
        return this.O.n;
    }

    public Object x() {
        if (this.O == null) {
            return null;
        }
        return this.O.o == a ? w() : this.O.o;
    }

    public Object y() {
        if (this.O == null) {
            return null;
        }
        return this.O.p;
    }

    public Object z() {
        if (this.O == null) {
            return null;
        }
        return this.O.q == a ? y() : this.O.q;
    }
}