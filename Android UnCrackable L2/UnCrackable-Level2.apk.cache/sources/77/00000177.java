package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.v;
import android.support.v4.g.s;
import android.support.v4.g.t;
import android.support.v4.g.u;
import android.support.v4.g.w;
import android.support.v7.a.a;
import android.support.v7.view.b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ad;
import android.support.v7.widget.ah;
import android.support.v7.widget.bb;
import android.support.v7.widget.bc;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends f implements h.a, LayoutInflater.Factory2 {
    private static final boolean t;
    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private d[] E;
    private d F;
    private boolean G;
    private final Runnable H;
    private boolean I;
    private Rect J;
    private Rect K;
    private AppCompatViewInflater L;
    android.support.v7.view.b m;
    ActionBarContextView n;
    PopupWindow o;
    Runnable p;
    s q;
    boolean r;
    int s;
    private ad u;
    private a v;
    private e w;
    private boolean x;
    private ViewGroup y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements o.a {
        a() {
        }

        @Override // android.support.v7.view.menu.o.a
        public void a(android.support.v7.view.menu.h hVar, boolean z) {
            j.this.b(hVar);
        }

        @Override // android.support.v7.view.menu.o.a
        public boolean a(android.support.v7.view.menu.h hVar) {
            Window.Callback q = j.this.q();
            if (q != null) {
                q.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements b.a {
        private b.a b;

        public b(b.a aVar) {
            this.b = aVar;
        }

        @Override // android.support.v7.view.b.a
        public void a(android.support.v7.view.b bVar) {
            this.b.a(bVar);
            if (j.this.o != null) {
                j.this.b.getDecorView().removeCallbacks(j.this.p);
            }
            if (j.this.n != null) {
                j.this.t();
                j.this.q = android.support.v4.g.p.d(j.this.n).a(0.0f);
                j.this.q.a(new u() { // from class: android.support.v7.app.j.b.1
                    @Override // android.support.v4.g.u, android.support.v4.g.t
                    public void b(View view) {
                        j.this.n.setVisibility(8);
                        if (j.this.o != null) {
                            j.this.o.dismiss();
                        } else if (j.this.n.getParent() instanceof View) {
                            android.support.v4.g.p.g((View) j.this.n.getParent());
                        }
                        j.this.n.removeAllViews();
                        j.this.q.a((t) null);
                        j.this.q = null;
                    }
                });
            }
            if (j.this.e != null) {
                j.this.e.b(j.this.m);
            }
            j.this.m = null;
        }

        @Override // android.support.v7.view.b.a
        public boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.b.a(bVar, menu);
        }

        @Override // android.support.v7.view.b.a
        public boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.b.a(bVar, menuItem);
        }

        @Override // android.support.v7.view.b.a
        public boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.b.b(bVar, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends ContentFrameLayout {
        public c(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return j.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                j.this.e(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(android.support.v7.b.a.b.b(getContext(), i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class d {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        android.support.v7.view.menu.h j;
        android.support.v7.view.menu.f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        d(int i) {
            this.a = i;
        }

        android.support.v7.view.menu.p a(o.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new android.support.v7.view.menu.f(this.l, a.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(a.C0011a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(a.C0011a.panelMenuListTheme, typedValue, true);
            newTheme.applyStyle(typedValue.resourceId != 0 ? typedValue.resourceId : a.i.Theme_AppCompat_CompactMenu, true);
            android.support.v7.view.d dVar = new android.support.v7.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.j.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(android.support.v7.view.menu.h hVar) {
            if (hVar == this.j) {
                return;
            }
            if (this.j != null) {
                this.j.b(this.k);
            }
            this.j = hVar;
            if (hVar == null || this.k == null) {
                return;
            }
            hVar.a(this.k);
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e implements o.a {
        e() {
        }

        @Override // android.support.v7.view.menu.o.a
        public void a(android.support.v7.view.menu.h hVar, boolean z) {
            android.support.v7.view.menu.h p = hVar.p();
            boolean z2 = p != hVar;
            j jVar = j.this;
            if (z2) {
                hVar = p;
            }
            d a = jVar.a((Menu) hVar);
            if (a != null) {
                if (!z2) {
                    j.this.a(a, z);
                    return;
                }
                j.this.a(a.a, a, p);
                j.this.a(a, true);
            }
        }

        @Override // android.support.v7.view.menu.o.a
        public boolean a(android.support.v7.view.menu.h hVar) {
            Window.Callback q;
            if (hVar != null || !j.this.h || (q = j.this.q()) == null || j.this.p()) {
                return true;
            }
            q.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
            return true;
        }
    }

    static {
        t = Build.VERSION.SDK_INT < 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, Window window, android.support.v7.app.d dVar) {
        super(context, window, dVar);
        this.q = null;
        this.H = new Runnable() { // from class: android.support.v7.app.j.1
            @Override // java.lang.Runnable
            public void run() {
                if ((j.this.s & 1) != 0) {
                    j.this.f(0);
                }
                if ((j.this.s & 4096) != 0) {
                    j.this.f(a.j.AppCompatTheme_tooltipFrameBackground);
                }
                j.this.r = false;
                j.this.s = 0;
            }
        };
    }

    private void a(d dVar, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (dVar.o || p()) {
            return;
        }
        if (dVar.a == 0) {
            if ((this.a.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback q = q();
        if (q != null && !q.onMenuOpened(dVar.a, dVar.j)) {
            a(dVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (windowManager != null && b(dVar, keyEvent)) {
            if (dVar.g == null || dVar.q) {
                if (dVar.g == null) {
                    if (!a(dVar) || dVar.g == null) {
                        return;
                    }
                } else if (dVar.q && dVar.g.getChildCount() > 0) {
                    dVar.g.removeAllViews();
                }
                if (!c(dVar) || !dVar.a()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = dVar.h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                dVar.g.setBackgroundResource(dVar.b);
                ViewParent parent = dVar.h.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(dVar.h);
                }
                dVar.g.addView(dVar.h, layoutParams2);
                if (!dVar.h.hasFocus()) {
                    dVar.h.requestFocus();
                }
            } else if (dVar.i != null && (layoutParams = dVar.i.getLayoutParams()) != null && layoutParams.width == -1) {
                i = -1;
                dVar.n = false;
                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, dVar.d, dVar.e, 1002, 8519680, -3);
                layoutParams3.gravity = dVar.c;
                layoutParams3.windowAnimations = dVar.f;
                windowManager.addView(dVar.g, layoutParams3);
                dVar.o = true;
            }
            i = -2;
            dVar.n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, dVar.d, dVar.e, 1002, 8519680, -3);
            layoutParams32.gravity = dVar.c;
            layoutParams32.windowAnimations = dVar.f;
            windowManager.addView(dVar.g, layoutParams32);
            dVar.o = true;
        }
    }

    private void a(android.support.v7.view.menu.h hVar, boolean z) {
        if (this.u == null || !this.u.e() || (ViewConfiguration.get(this.a).hasPermanentMenuKey() && !this.u.g())) {
            d a2 = a(0, true);
            a2.q = true;
            a(a2, false);
            a(a2, (KeyEvent) null);
            return;
        }
        Window.Callback q = q();
        if (this.u.f() && z) {
            this.u.i();
            if (p()) {
                return;
            }
            q.onPanelClosed(a.j.AppCompatTheme_tooltipFrameBackground, a(0, true).j);
        } else if (q == null || p()) {
        } else {
            if (this.r && (this.s & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.H);
                this.H.run();
            }
            d a3 = a(0, true);
            if (a3.j == null || a3.r || !q.onPreparePanel(0, a3.i, a3.j)) {
                return;
            }
            q.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, a3.j);
            this.u.h();
        }
    }

    private boolean a(d dVar) {
        dVar.a(n());
        dVar.g = new c(dVar.l);
        dVar.c = 81;
        return true;
    }

    private boolean a(d dVar, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((dVar.m || b(dVar, keyEvent)) && dVar.j != null) {
            z = dVar.j.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.u == null) {
            a(dVar, true);
        }
        return z;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.b.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || android.support.v4.g.p.m((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean b(d dVar) {
        Context context = this.a;
        if ((dVar.a == 0 || dVar.a == 108) && this.u != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.C0011a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(a.C0011a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.C0011a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                android.support.v7.view.d dVar2 = new android.support.v7.view.d(context, 0);
                dVar2.getTheme().setTo(theme2);
                context = dVar2;
            }
        }
        android.support.v7.view.menu.h hVar = new android.support.v7.view.menu.h(context);
        hVar.a(this);
        dVar.a(hVar);
        return true;
    }

    private boolean b(d dVar, KeyEvent keyEvent) {
        if (p()) {
            return false;
        }
        if (dVar.m) {
            return true;
        }
        if (this.F != null && this.F != dVar) {
            a(this.F, false);
        }
        Window.Callback q = q();
        if (q != null) {
            dVar.i = q.onCreatePanelView(dVar.a);
        }
        boolean z = dVar.a == 0 || dVar.a == 108;
        if (z && this.u != null) {
            this.u.j();
        }
        if (dVar.i == null && (!z || !(m() instanceof m))) {
            if (dVar.j == null || dVar.r) {
                if (dVar.j == null && (!b(dVar) || dVar.j == null)) {
                    return false;
                }
                if (z && this.u != null) {
                    if (this.v == null) {
                        this.v = new a();
                    }
                    this.u.a(dVar.j, this.v);
                }
                dVar.j.g();
                if (!q.onCreatePanelMenu(dVar.a, dVar.j)) {
                    dVar.a((android.support.v7.view.menu.h) null);
                    if (z && this.u != null) {
                        this.u.a(null, this.v);
                    }
                    return false;
                }
                dVar.r = false;
            }
            dVar.j.g();
            if (dVar.s != null) {
                dVar.j.b(dVar.s);
                dVar.s = null;
            }
            if (!q.onPreparePanel(0, dVar.i, dVar.j)) {
                if (z && this.u != null) {
                    this.u.a(null, this.v);
                }
                dVar.j.h();
                return false;
            }
            dVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            dVar.j.setQwertyMode(dVar.p);
            dVar.j.h();
        }
        dVar.m = true;
        dVar.n = false;
        this.F = dVar;
        return true;
    }

    private boolean c(d dVar) {
        if (dVar.i != null) {
            dVar.h = dVar.i;
            return true;
        } else if (dVar.j == null) {
            return false;
        } else {
            if (this.w == null) {
                this.w = new e();
            }
            dVar.h = (View) dVar.a(this.w);
            return dVar.h != null;
        }
    }

    private void d(int i) {
        this.s = (1 << i) | this.s;
        if (this.r) {
            return;
        }
        android.support.v4.g.p.a(this.b.getDecorView(), this.H);
        this.r = true;
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            d a2 = a(i, true);
            if (a2.o) {
                return false;
            }
            return b(a2, keyEvent);
        }
        return false;
    }

    private boolean e(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        if (this.m != null) {
            return false;
        }
        d a2 = a(i, true);
        if (i != 0 || this.u == null || !this.u.e() || ViewConfiguration.get(this.a).hasPermanentMenuKey()) {
            if (a2.o || a2.n) {
                z = a2.o;
                a(a2, true);
            } else {
                if (a2.m) {
                    if (a2.r) {
                        a2.m = false;
                        z2 = b(a2, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        a(a2, keyEvent);
                        z = true;
                    }
                }
                z = false;
            }
        } else if (this.u.f()) {
            z = this.u.i();
        } else {
            if (!p() && b(a2, keyEvent)) {
                z = this.u.h();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private int h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return a.j.AppCompatTheme_tooltipFrameBackground;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return a.j.AppCompatTheme_viewInflaterClass;
        } else {
            return i;
        }
    }

    private void w() {
        if (this.x) {
            return;
        }
        this.y = x();
        CharSequence r = r();
        if (!TextUtils.isEmpty(r)) {
            b(r);
        }
        y();
        a(this.y);
        this.x = true;
        d a2 = a(0, false);
        if (p()) {
            return;
        }
        if (a2 == null || a2.j == null) {
            d(a.j.AppCompatTheme_tooltipFrameBackground);
        }
    }

    private ViewGroup x() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(a.j.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowNoTitle, false)) {
            c(1);
        } else if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
            c(a.j.AppCompatTheme_tooltipFrameBackground);
        }
        if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            c(a.j.AppCompatTheme_viewInflaterClass);
        }
        if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            c(10);
        }
        this.k = obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        this.b.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.a);
        if (this.l) {
            viewGroup = (ViewGroup) from.inflate(this.j ? a.g.abc_screen_simple_overlay_action_mode : a.g.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                android.support.v4.g.p.a(viewGroup, new android.support.v4.g.n() { // from class: android.support.v7.app.j.2
                    @Override // android.support.v4.g.n
                    public w a(View view, w wVar) {
                        int b2 = wVar.b();
                        int g = j.this.g(b2);
                        if (b2 != g) {
                            wVar = wVar.a(wVar.a(), g, wVar.c(), wVar.d());
                        }
                        return android.support.v4.g.p.a(view, wVar);
                    }
                });
            } else {
                ((ah) viewGroup).setOnFitSystemWindowsListener(new ah.a() { // from class: android.support.v7.app.j.3
                    @Override // android.support.v7.widget.ah.a
                    public void a(Rect rect) {
                        rect.top = j.this.g(rect.top);
                    }
                });
            }
        } else if (this.k) {
            viewGroup = (ViewGroup) from.inflate(a.g.abc_dialog_title_material, (ViewGroup) null);
            this.i = false;
            this.h = false;
        } else if (this.h) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(a.C0011a.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.a, typedValue.resourceId) : this.a).inflate(a.g.abc_screen_toolbar, (ViewGroup) null);
            this.u = (ad) viewGroup.findViewById(a.f.decor_content_parent);
            this.u.setWindowCallback(q());
            if (this.i) {
                this.u.a(a.j.AppCompatTheme_viewInflaterClass);
            }
            if (this.B) {
                this.u.a(2);
            }
            if (this.C) {
                this.u.a(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
        }
        if (this.u == null) {
            this.z = (TextView) viewGroup.findViewById(a.f.title);
        }
        bc.b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(16908290);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.b.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a() { // from class: android.support.v7.app.j.4
            @Override // android.support.v7.widget.ContentFrameLayout.a
            public void a() {
            }

            @Override // android.support.v7.widget.ContentFrameLayout.a
            public void b() {
                j.this.v();
            }
        });
        return viewGroup;
    }

    private void y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.y.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void z() {
        if (this.x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d a(int i, boolean z) {
        d[] dVarArr = this.E;
        if (dVarArr == null || dVarArr.length <= i) {
            d[] dVarArr2 = new d[i + 1];
            if (dVarArr != null) {
                System.arraycopy(dVarArr, 0, dVarArr2, 0, dVarArr.length);
            }
            this.E = dVarArr2;
            dVarArr = dVarArr2;
        }
        d dVar = dVarArr[i];
        if (dVar == null) {
            d dVar2 = new d(i);
            dVarArr[i] = dVar2;
            return dVar2;
        }
        return dVar;
    }

    d a(Menu menu) {
        d[] dVarArr = this.E;
        int length = dVarArr != null ? dVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            d dVar = dVarArr[i];
            if (dVar != null && dVar.j == menu) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    @Override // android.support.v7.app.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.support.v7.view.b a(android.support.v7.view.b.a r8) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.j.a(android.support.v7.view.b$a):android.support.v7.view.b");
    }

    @Override // android.support.v7.app.e
    public <T extends View> T a(int i) {
        w();
        return (T) this.b.findViewById(i);
    }

    View a(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        if (!(this.c instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    void a(int i, d dVar, Menu menu) {
        if (menu == null) {
            if (dVar == null && i >= 0 && i < this.E.length) {
                dVar = this.E[i];
            }
            if (dVar != null) {
                menu = dVar.j;
            }
        }
        if ((dVar == null || dVar.o) && !p()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    @Override // android.support.v7.app.f
    void a(int i, Menu menu) {
        if (i == 108) {
            android.support.v7.app.a a2 = a();
            if (a2 != null) {
                a2.e(false);
            }
        } else if (i == 0) {
            d a3 = a(i, true);
            if (a3.o) {
                a(a3, false);
            }
        }
    }

    @Override // android.support.v7.app.e
    public void a(Configuration configuration) {
        android.support.v7.app.a a2;
        if (this.h && this.x && (a2 = a()) != null) {
            a2.a(configuration);
        }
        android.support.v7.widget.l.a().a(this.a);
        i();
    }

    @Override // android.support.v7.app.e
    public void a(Bundle bundle) {
        if (!(this.c instanceof Activity) || v.b((Activity) this.c) == null) {
            return;
        }
        android.support.v7.app.a m = m();
        if (m == null) {
            this.I = true;
        } else {
            m.c(true);
        }
    }

    void a(d dVar, boolean z) {
        if (z && dVar.a == 0 && this.u != null && this.u.f()) {
            b(dVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (windowManager != null && dVar.o && dVar.g != null) {
            windowManager.removeView(dVar.g);
            if (z) {
                a(dVar.a, dVar, (Menu) null);
            }
        }
        dVar.m = false;
        dVar.n = false;
        dVar.o = false;
        dVar.h = null;
        dVar.q = true;
        if (this.F == dVar) {
            this.F = null;
        }
    }

    @Override // android.support.v7.view.menu.h.a
    public void a(android.support.v7.view.menu.h hVar) {
        a(hVar, true);
    }

    @Override // android.support.v7.app.e
    public void a(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    @Override // android.support.v7.app.e
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void a(ViewGroup viewGroup) {
    }

    @Override // android.support.v7.app.f
    boolean a(int i, KeyEvent keyEvent) {
        android.support.v7.app.a a2 = a();
        if (a2 == null || !a2.a(i, keyEvent)) {
            if (this.F != null && a(this.F, keyEvent.getKeyCode(), keyEvent, 1)) {
                if (this.F != null) {
                    this.F.n = true;
                }
                return true;
            }
            if (this.F == null) {
                d a3 = a(0, true);
                b(a3, keyEvent);
                boolean a4 = a(a3, keyEvent.getKeyCode(), keyEvent, 1);
                a3.m = false;
                if (a4) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.support.v7.view.menu.h.a
    public boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
        d a2;
        Window.Callback q = q();
        if (q == null || p() || (a2 = a((Menu) hVar.p())) == null) {
            return false;
        }
        return q.onMenuItemSelected(a2.a, menuItem);
    }

    @Override // android.support.v7.app.f
    boolean a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    public android.support.v7.view.b b(b.a aVar) {
        if (aVar != null) {
            if (this.m != null) {
                this.m.c();
            }
            b bVar = new b(aVar);
            android.support.v7.app.a a2 = a();
            if (a2 != null) {
                this.m = a2.a(bVar);
                if (this.m != null && this.e != null) {
                    this.e.a(this.m);
                }
            }
            if (this.m == null) {
                this.m = a(bVar);
            }
            return this.m;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public View b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        AppCompatViewInflater appCompatViewInflater;
        boolean z2 = false;
        if (this.L == null) {
            String string = this.a.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.L = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                }
            }
            this.L = appCompatViewInflater;
        }
        if (t) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.L.a(view, str, context, attributeSet, z, t, true, bb.a());
    }

    @Override // android.support.v7.app.e
    public void b(int i) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.y.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    @Override // android.support.v7.app.e
    public void b(Bundle bundle) {
        w();
    }

    void b(android.support.v7.view.menu.h hVar) {
        if (this.D) {
            return;
        }
        this.D = true;
        this.u.k();
        Window.Callback q = q();
        if (q != null && !p()) {
            q.onPanelClosed(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
        }
        this.D = false;
    }

    @Override // android.support.v7.app.e
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ((ViewGroup) this.y.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    @Override // android.support.v7.app.f
    void b(CharSequence charSequence) {
        if (this.u != null) {
            this.u.setWindowTitle(charSequence);
        } else if (m() != null) {
            m().a(charSequence);
        } else if (this.z != null) {
            this.z.setText(charSequence);
        }
    }

    boolean b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.G;
            this.G = false;
            d a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z) {
                    a(a2, true);
                }
                return true;
            } else if (u()) {
                return true;
            }
        } else if (i == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // android.support.v7.app.f
    boolean b(int i, Menu menu) {
        if (i == 108) {
            android.support.v7.app.a a2 = a();
            if (a2 != null) {
                a2.e(true);
            }
            return true;
        }
        return false;
    }

    @Override // android.support.v7.app.e
    public boolean c(int i) {
        int h = h(i);
        if (this.l && h == 108) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                z();
                this.l = true;
                return true;
            case 2:
                z();
                this.B = true;
                return true;
            case 5:
                z();
                this.C = true;
                return true;
            case 10:
                z();
                this.j = true;
                return true;
            case a.j.AppCompatTheme_tooltipFrameBackground /* 108 */:
                z();
                this.h = true;
                return true;
            case a.j.AppCompatTheme_viewInflaterClass /* 109 */:
                z();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    boolean c(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.G = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // android.support.v7.app.f, android.support.v7.app.e
    public void d() {
        android.support.v7.app.a a2 = a();
        if (a2 != null) {
            a2.d(false);
        }
    }

    @Override // android.support.v7.app.e
    public void e() {
        android.support.v7.app.a a2 = a();
        if (a2 != null) {
            a2.d(true);
        }
    }

    void e(int i) {
        a(a(i, true), true);
    }

    @Override // android.support.v7.app.e
    public void f() {
        android.support.v7.app.a a2 = a();
        if (a2 == null || !a2.e()) {
            d(0);
        }
    }

    void f(int i) {
        d a2;
        d a3 = a(i, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.a(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.g();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i != 108 && i != 0) || this.u == null || (a2 = a(0, false)) == null) {
            return;
        }
        a2.m = false;
        b(a2, (KeyEvent) null);
    }

    int g(int i) {
        boolean z;
        boolean z2;
        if (this.n == null || !(this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
            if (this.n.isShown()) {
                if (this.J == null) {
                    this.J = new Rect();
                    this.K = new Rect();
                }
                Rect rect = this.J;
                Rect rect2 = this.K;
                rect.set(0, i, 0, 0);
                bc.a(this.y, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.A == null) {
                        this.A = new View(this.a);
                        this.A.setBackgroundColor(this.a.getResources().getColor(a.c.abc_input_method_navigation_guard));
                        this.y.addView(this.A, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.A.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.A != null;
                if (!this.j && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.n.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.A != null) {
            this.A.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    @Override // android.support.v7.app.f, android.support.v7.app.e
    public void g() {
        if (this.r) {
            this.b.getDecorView().removeCallbacks(this.H);
        }
        super.g();
        if (this.f != null) {
            this.f.g();
        }
    }

    @Override // android.support.v7.app.e
    public void h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            android.support.v4.g.e.b(from, this);
        } else if (from.getFactory2() instanceof j) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // android.support.v7.app.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l() {
        /*
            r3 = this;
            r3.w()
            boolean r0 = r3.h
            if (r0 == 0) goto L3b
            android.support.v7.app.a r0 = r3.f
            if (r0 == 0) goto Lc
            goto L3b
        Lc:
            android.view.Window$Callback r0 = r3.c
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L20
            android.support.v7.app.p r0 = new android.support.v7.app.p
            android.view.Window$Callback r1 = r3.c
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.i
            r0.<init>(r1, r2)
        L1d:
            r3.f = r0
            goto L30
        L20:
            android.view.Window$Callback r0 = r3.c
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L30
            android.support.v7.app.p r0 = new android.support.v7.app.p
            android.view.Window$Callback r1 = r3.c
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L30:
            android.support.v7.app.a r0 = r3.f
            if (r0 == 0) goto L3b
            android.support.v7.app.a r0 = r3.f
            boolean r1 = r3.I
            r0.c(r1)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.j.l():void");
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 != null ? a2 : b(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    final boolean s() {
        return this.x && this.y != null && android.support.v4.g.p.l(this.y);
    }

    void t() {
        if (this.q != null) {
            this.q.b();
        }
    }

    boolean u() {
        if (this.m != null) {
            this.m.c();
            return true;
        }
        android.support.v7.app.a a2 = a();
        return a2 != null && a2.f();
    }

    void v() {
        if (this.u != null) {
            this.u.k();
        }
        if (this.o != null) {
            this.b.getDecorView().removeCallbacks(this.p);
            if (this.o.isShowing()) {
                try {
                    this.o.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.o = null;
        }
        t();
        d a2 = a(0, false);
        if (a2 == null || a2.j == null) {
            return;
        }
        a2.j.close();
    }
}