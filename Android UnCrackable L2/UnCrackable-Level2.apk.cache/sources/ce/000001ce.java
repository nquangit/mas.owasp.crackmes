package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.a.a;
import android.support.v7.view.menu.o;
import android.support.v7.widget.am;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends m implements o, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    final am a;
    View b;
    private final Context c;
    private final h d;
    private final g e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    private PopupWindow.OnDismissListener l;
    private View m;
    private o.a n;
    private ViewTreeObserver o;
    private boolean p;
    private boolean q;
    private int r;
    private boolean t;
    private final ViewTreeObserver.OnGlobalLayoutListener j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.t.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!t.this.d() || t.this.a.g()) {
                return;
            }
            View view = t.this.b;
            if (view == null || !view.isShown()) {
                t.this.c();
            } else {
                t.this.a.a();
            }
        }
    };
    private final View.OnAttachStateChangeListener k = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.t.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (t.this.o != null) {
                if (!t.this.o.isAlive()) {
                    t.this.o = view.getViewTreeObserver();
                }
                t.this.o.removeGlobalOnLayoutListener(t.this.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int s = 0;

    public t(Context context, h hVar, View view, int i, int i2, boolean z) {
        this.c = context;
        this.d = hVar;
        this.f = z;
        this.e = new g(hVar, LayoutInflater.from(context), this.f);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.m = view;
        this.a = new am(this.c, null, this.h, this.i);
        hVar.a(this, context);
    }

    private boolean h() {
        if (d()) {
            return true;
        }
        if (this.p || this.m == null) {
            return false;
        }
        this.b = this.m;
        this.a.a((PopupWindow.OnDismissListener) this);
        this.a.a((AdapterView.OnItemClickListener) this);
        this.a.a(true);
        View view = this.b;
        boolean z = this.o == null;
        this.o = view.getViewTreeObserver();
        if (z) {
            this.o.addOnGlobalLayoutListener(this.j);
        }
        view.addOnAttachStateChangeListener(this.k);
        this.a.b(view);
        this.a.e(this.s);
        if (!this.q) {
            this.r = a(this.e, null, this.c, this.g);
            this.q = true;
        }
        this.a.g(this.r);
        this.a.h(2);
        this.a.a(g());
        this.a.a();
        ListView e = this.a.e();
        e.setOnKeyListener(this);
        if (this.t && this.d.m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.d.m());
            }
            frameLayout.setEnabled(false);
            e.addHeaderView(frameLayout, null, false);
        }
        this.a.a((ListAdapter) this.e);
        this.a.a();
        return true;
    }

    @Override // android.support.v7.view.menu.s
    public void a() {
        if (!h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // android.support.v7.view.menu.m
    public void a(int i) {
        this.s = i;
    }

    @Override // android.support.v7.view.menu.m
    public void a(h hVar) {
    }

    @Override // android.support.v7.view.menu.o
    public void a(h hVar, boolean z) {
        if (hVar != this.d) {
            return;
        }
        c();
        if (this.n != null) {
            this.n.a(hVar, z);
        }
    }

    @Override // android.support.v7.view.menu.o
    public void a(o.a aVar) {
        this.n = aVar;
    }

    @Override // android.support.v7.view.menu.m
    public void a(View view) {
        this.m = view;
    }

    @Override // android.support.v7.view.menu.m
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    @Override // android.support.v7.view.menu.m
    public void a(boolean z) {
        this.e.a(z);
    }

    @Override // android.support.v7.view.menu.o
    public boolean a(u uVar) {
        if (uVar.hasVisibleItems()) {
            n nVar = new n(this.c, uVar, this.b, this.f, this.h, this.i);
            nVar.a(this.n);
            nVar.a(m.b(uVar));
            nVar.a(this.s);
            nVar.a(this.l);
            this.l = null;
            this.d.a(false);
            if (nVar.a(this.a.j(), this.a.k())) {
                if (this.n != null) {
                    this.n.a(uVar);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.m
    public void b(int i) {
        this.a.c(i);
    }

    @Override // android.support.v7.view.menu.o
    public void b(boolean z) {
        this.q = false;
        if (this.e != null) {
            this.e.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.o
    public boolean b() {
        return false;
    }

    @Override // android.support.v7.view.menu.s
    public void c() {
        if (d()) {
            this.a.c();
        }
    }

    @Override // android.support.v7.view.menu.m
    public void c(int i) {
        this.a.d(i);
    }

    @Override // android.support.v7.view.menu.m
    public void c(boolean z) {
        this.t = z;
    }

    @Override // android.support.v7.view.menu.s
    public boolean d() {
        return !this.p && this.a.d();
    }

    @Override // android.support.v7.view.menu.s
    public ListView e() {
        return this.a.e();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.p = true;
        this.d.close();
        if (this.o != null) {
            if (!this.o.isAlive()) {
                this.o = this.b.getViewTreeObserver();
            }
            this.o.removeGlobalOnLayoutListener(this.j);
            this.o = null;
        }
        this.b.removeOnAttachStateChangeListener(this.k);
        if (this.l != null) {
            this.l.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            c();
            return true;
        }
        return false;
    }
}