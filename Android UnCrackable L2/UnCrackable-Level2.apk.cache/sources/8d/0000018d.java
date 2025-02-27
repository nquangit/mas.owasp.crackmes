package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.g.s;
import android.support.v4.g.t;
import android.support.v4.g.u;
import android.support.v4.g.v;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.view.b;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ae;
import android.support.v7.widget.ap;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class p extends android.support.v7.app.a implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s = !p.class.desiredAssertionStatus();
    private static final Interpolator t = new AccelerateInterpolator();
    private static final Interpolator u = new DecelerateInterpolator();
    private boolean A;
    private boolean B;
    private boolean D;
    private boolean F;
    private boolean H;
    Context a;
    ActionBarOverlayLayout b;
    ActionBarContainer c;
    ae d;
    ActionBarContextView e;
    View f;
    ap g;
    a h;
    android.support.v7.view.b i;
    b.a j;
    boolean l;
    boolean m;
    android.support.v7.view.h n;
    boolean o;
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList<>();
    private int z = -1;
    private ArrayList<a.b> C = new ArrayList<>();
    private int E = 0;
    boolean k = true;
    private boolean G = true;
    final t p = new u() { // from class: android.support.v7.app.p.1
        @Override // android.support.v4.g.u, android.support.v4.g.t
        public void b(View view) {
            if (p.this.k && p.this.f != null) {
                p.this.f.setTranslationY(0.0f);
                p.this.c.setTranslationY(0.0f);
            }
            p.this.c.setVisibility(8);
            p.this.c.setTransitioning(false);
            p.this.n = null;
            p.this.h();
            if (p.this.b != null) {
                android.support.v4.g.p.g(p.this.b);
            }
        }
    };
    final t q = new u() { // from class: android.support.v7.app.p.2
        @Override // android.support.v4.g.u, android.support.v4.g.t
        public void b(View view) {
            p.this.n = null;
            p.this.c.requestLayout();
        }
    };
    final v r = new v() { // from class: android.support.v7.app.p.3
        @Override // android.support.v4.g.v
        public void a(View view) {
            ((View) p.this.c.getParent()).invalidate();
        }
    };

    /* loaded from: classes.dex */
    public class a extends android.support.v7.view.b implements h.a {
        private final Context b;
        private final android.support.v7.view.menu.h c;
        private b.a d;
        private WeakReference<View> e;

        public a(Context context, b.a aVar) {
            this.b = context;
            this.d = aVar;
            this.c = new android.support.v7.view.menu.h(context).a(1);
            this.c.a(this);
        }

        @Override // android.support.v7.view.b
        public MenuInflater a() {
            return new android.support.v7.view.g(this.b);
        }

        @Override // android.support.v7.view.b
        public void a(int i) {
            b(p.this.a.getResources().getString(i));
        }

        @Override // android.support.v7.view.menu.h.a
        public void a(android.support.v7.view.menu.h hVar) {
            if (this.d == null) {
                return;
            }
            d();
            p.this.e.a();
        }

        @Override // android.support.v7.view.b
        public void a(View view) {
            p.this.e.setCustomView(view);
            this.e = new WeakReference<>(view);
        }

        @Override // android.support.v7.view.b
        public void a(CharSequence charSequence) {
            p.this.e.setSubtitle(charSequence);
        }

        @Override // android.support.v7.view.b
        public void a(boolean z) {
            super.a(z);
            p.this.e.setTitleOptional(z);
        }

        @Override // android.support.v7.view.menu.h.a
        public boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            if (this.d != null) {
                return this.d.a(this, menuItem);
            }
            return false;
        }

        @Override // android.support.v7.view.b
        public Menu b() {
            return this.c;
        }

        @Override // android.support.v7.view.b
        public void b(int i) {
            a((CharSequence) p.this.a.getResources().getString(i));
        }

        @Override // android.support.v7.view.b
        public void b(CharSequence charSequence) {
            p.this.e.setTitle(charSequence);
        }

        @Override // android.support.v7.view.b
        public void c() {
            if (p.this.h != this) {
                return;
            }
            if (p.a(p.this.l, p.this.m, false)) {
                this.d.a(this);
            } else {
                p.this.i = this;
                p.this.j = this.d;
            }
            this.d = null;
            p.this.j(false);
            p.this.e.b();
            p.this.d.a().sendAccessibilityEvent(32);
            p.this.b.setHideOnContentScrollEnabled(p.this.o);
            p.this.h = null;
        }

        @Override // android.support.v7.view.b
        public void d() {
            if (p.this.h != this) {
                return;
            }
            this.c.g();
            try {
                this.d.b(this, this.c);
            } finally {
                this.c.h();
            }
        }

        public boolean e() {
            this.c.g();
            try {
                return this.d.a(this, this.c);
            } finally {
                this.c.h();
            }
        }

        @Override // android.support.v7.view.b
        public CharSequence f() {
            return p.this.e.getTitle();
        }

        @Override // android.support.v7.view.b
        public CharSequence g() {
            return p.this.e.getSubtitle();
        }

        @Override // android.support.v7.view.b
        public boolean h() {
            return p.this.e.d();
        }

        @Override // android.support.v7.view.b
        public View i() {
            if (this.e != null) {
                return this.e.get();
            }
            return null;
        }
    }

    public p(Activity activity, boolean z) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (z) {
            return;
        }
        this.f = decorView.findViewById(16908290);
    }

    public p(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.b = (ActionBarOverlayLayout) view.findViewById(a.f.decor_content_parent);
        if (this.b != null) {
            this.b.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(a.f.action_bar));
        this.e = (ActionBarContextView) view.findViewById(a.f.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(a.f.action_bar_container);
        if (this.d == null || this.e == null || this.c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = this.d.b();
        boolean z = (this.d.o() & 4) != 0;
        if (z) {
            this.A = true;
        }
        android.support.v7.view.a a2 = android.support.v7.view.a.a(this.a);
        a(a2.f() || z);
        k(a2.d());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, a.j.ActionBar, a.C0011a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
            b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    private ae b(View view) {
        if (view instanceof ae) {
            return (ae) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view);
        throw new IllegalStateException(sb.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private void k(boolean z) {
        this.D = z;
        if (this.D) {
            this.c.setTabContainer(null);
            this.d.a(this.g);
        } else {
            this.d.a((ap) null);
            this.c.setTabContainer(this.g);
        }
        boolean z2 = true;
        boolean z3 = i() == 2;
        if (this.g != null) {
            if (z3) {
                this.g.setVisibility(0);
                if (this.b != null) {
                    android.support.v4.g.p.g(this.b);
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        this.d.a(!this.D && z3);
        this.b.setHasNonEmbeddedTabs((this.D || !z3) ? false : false);
    }

    private void l(boolean z) {
        if (a(this.l, this.m, this.F)) {
            if (this.G) {
                return;
            }
            this.G = true;
            h(z);
        } else if (this.G) {
            this.G = false;
            i(z);
        }
    }

    private void n() {
        if (this.F) {
            return;
        }
        this.F = true;
        if (this.b != null) {
            this.b.setShowingForActionMode(true);
        }
        l(false);
    }

    private void o() {
        if (this.F) {
            this.F = false;
            if (this.b != null) {
                this.b.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private boolean p() {
        return android.support.v4.g.p.l(this.c);
    }

    @Override // android.support.v7.app.a
    public int a() {
        return this.d.o();
    }

    @Override // android.support.v7.app.a
    public android.support.v7.view.b a(b.a aVar) {
        if (this.h != null) {
            this.h.c();
        }
        this.b.setHideOnContentScrollEnabled(false);
        this.e.c();
        a aVar2 = new a(this.e.getContext(), aVar);
        if (aVar2.e()) {
            this.h = aVar2;
            aVar2.d();
            this.e.a(aVar2);
            j(true);
            this.e.sendAccessibilityEvent(32);
            return aVar2;
        }
        return null;
    }

    @Override // android.support.v7.app.a
    public void a(float f) {
        android.support.v4.g.p.a(this.c, f);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void a(int i) {
        this.E = i;
    }

    public void a(int i, int i2) {
        int o = this.d.o();
        if ((i2 & 4) != 0) {
            this.A = true;
        }
        this.d.c((i & i2) | ((i2 ^ (-1)) & o));
    }

    @Override // android.support.v7.app.a
    public void a(Configuration configuration) {
        k(android.support.v7.view.a.a(this.a).d());
    }

    @Override // android.support.v7.app.a
    public void a(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    @Override // android.support.v7.app.a
    public void a(boolean z) {
        this.d.b(z);
    }

    @Override // android.support.v7.app.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu b;
        if (this.h == null || (b = this.h.b()) == null) {
            return false;
        }
        b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return b.performShortcut(i, keyEvent, 0);
    }

    @Override // android.support.v7.app.a
    public Context b() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(a.C0011a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.v = new ContextThemeWrapper(this.a, i);
            } else {
                this.v = this.a;
            }
        }
        return this.v;
    }

    @Override // android.support.v7.app.a
    public void b(boolean z) {
        if (z && !this.b.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.o = z;
        this.b.setHideOnContentScrollEnabled(z);
    }

    @Override // android.support.v7.app.a
    public void c(boolean z) {
        if (this.A) {
            return;
        }
        f(z);
    }

    @Override // android.support.v7.app.a
    public void d(boolean z) {
        this.H = z;
        if (z || this.n == null) {
            return;
        }
        this.n.c();
    }

    @Override // android.support.v7.app.a
    public void e(boolean z) {
        if (z == this.B) {
            return;
        }
        this.B = z;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).a(z);
        }
    }

    public void f(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.a
    public boolean f() {
        if (this.d == null || !this.d.c()) {
            return false;
        }
        this.d.d();
        return true;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void g(boolean z) {
        this.k = z;
    }

    void h() {
        if (this.j != null) {
            this.j.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    public void h(boolean z) {
        int[] iArr;
        if (this.n != null) {
            this.n.c();
        }
        this.c.setVisibility(0);
        if (this.E == 0 && (this.H || z)) {
            this.c.setTranslationY(0.0f);
            float f = -this.c.getHeight();
            if (z) {
                this.c.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            this.c.setTranslationY(f);
            android.support.v7.view.h hVar = new android.support.v7.view.h();
            s b = android.support.v4.g.p.d(this.c).b(0.0f);
            b.a(this.r);
            hVar.a(b);
            if (this.k && this.f != null) {
                this.f.setTranslationY(f);
                hVar.a(android.support.v4.g.p.d(this.f).b(0.0f));
            }
            hVar.a(u);
            hVar.a(250L);
            hVar.a(this.q);
            this.n = hVar;
            hVar.a();
        } else {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && this.f != null) {
                this.f.setTranslationY(0.0f);
            }
            this.q.b(null);
        }
        if (this.b != null) {
            android.support.v4.g.p.g(this.b);
        }
    }

    public int i() {
        return this.d.p();
    }

    public void i(boolean z) {
        int[] iArr;
        if (this.n != null) {
            this.n.c();
        }
        if (this.E != 0 || (!this.H && !z)) {
            this.p.b(null);
            return;
        }
        this.c.setAlpha(1.0f);
        this.c.setTransitioning(true);
        android.support.v7.view.h hVar = new android.support.v7.view.h();
        float f = -this.c.getHeight();
        if (z) {
            this.c.getLocationInWindow(new int[]{0, 0});
            f -= iArr[1];
        }
        s b = android.support.v4.g.p.d(this.c).b(f);
        b.a(this.r);
        hVar.a(b);
        if (this.k && this.f != null) {
            hVar.a(android.support.v4.g.p.d(this.f).b(f));
        }
        hVar.a(t);
        hVar.a(250L);
        hVar.a(this.p);
        this.n = hVar;
        hVar.a();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void j() {
        if (this.m) {
            this.m = false;
            l(true);
        }
    }

    public void j(boolean z) {
        s a2;
        s a3;
        if (z) {
            n();
        } else {
            o();
        }
        if (!p()) {
            if (z) {
                this.d.d(4);
                this.e.setVisibility(0);
                return;
            }
            this.d.d(0);
            this.e.setVisibility(8);
            return;
        }
        if (z) {
            a3 = this.d.a(4, 100L);
            a2 = this.e.a(0, 200L);
        } else {
            a2 = this.d.a(0, 200L);
            a3 = this.e.a(8, 100L);
        }
        android.support.v7.view.h hVar = new android.support.v7.view.h();
        hVar.a(a3, a2);
        hVar.a();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void k() {
        if (this.m) {
            return;
        }
        this.m = true;
        l(true);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void l() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.a
    public void m() {
    }
}