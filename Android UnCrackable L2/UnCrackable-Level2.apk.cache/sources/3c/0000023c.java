package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.g.c;
import android.support.v7.a.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends android.support.v7.view.menu.b implements c.a {
    private b A;
    C0015d g;
    e h;
    a i;
    c j;
    final f k;
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y;
    private View z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends android.support.v7.view.menu.n {
        public a(Context context, android.support.v7.view.menu.u uVar, View view) {
            super(context, uVar, view, false, a.C0011a.actionOverflowMenuStyle);
            if (!((android.support.v7.view.menu.j) uVar.getItem()).j()) {
                a(d.this.g == null ? (View) d.this.f : d.this.g);
            }
            a(d.this.k);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v7.view.menu.n
        public void e() {
            d.this.i = null;
            d.this.l = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.b
        public android.support.v7.view.menu.s a() {
            if (d.this.i != null) {
                return d.this.i.b();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        private e b;

        public c(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.c != null) {
                d.this.c.f();
            }
            View view = (View) d.this.f;
            if (view != null && view.getWindowToken() != null && this.b.c()) {
                d.this.h = this.b;
            }
            d.this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: android.support.v7.widget.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0015d extends q implements ActionMenuView.a {
        private final float[] b;

        public C0015d(Context context) {
            super(context, null, a.C0011a.actionOverflowButtonStyle);
            this.b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            ay.a(this, getContentDescription());
            setOnTouchListener(new ai(this) { // from class: android.support.v7.widget.d.d.1
                @Override // android.support.v7.widget.ai
                public android.support.v7.view.menu.s a() {
                    if (d.this.h == null) {
                        return null;
                    }
                    return d.this.h.b();
                }

                @Override // android.support.v7.widget.ai
                public boolean b() {
                    d.this.d();
                    return true;
                }

                @Override // android.support.v7.widget.ai
                public boolean c() {
                    if (d.this.j != null) {
                        return false;
                    }
                    d.this.e();
                    return true;
                }
            });
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            d.this.d();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.b.a.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends android.support.v7.view.menu.n {
        public e(Context context, android.support.v7.view.menu.h hVar, View view, boolean z) {
            super(context, hVar, view, z, a.C0011a.actionOverflowMenuStyle);
            a(8388613);
            a(d.this.k);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v7.view.menu.n
        public void e() {
            if (d.this.c != null) {
                d.this.c.close();
            }
            d.this.h = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements o.a {
        f() {
        }

        @Override // android.support.v7.view.menu.o.a
        public void a(android.support.v7.view.menu.h hVar, boolean z) {
            if (hVar instanceof android.support.v7.view.menu.u) {
                hVar.p().a(false);
            }
            o.a a = d.this.a();
            if (a != null) {
                a.a(hVar, z);
            }
        }

        @Override // android.support.v7.view.menu.o.a
        public boolean a(android.support.v7.view.menu.h hVar) {
            if (hVar == null) {
                return false;
            }
            d.this.l = ((android.support.v7.view.menu.u) hVar).getItem().getItemId();
            o.a a = d.this.a();
            if (a != null) {
                return a.a(hVar);
            }
            return false;
        }
    }

    public d(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
        this.y = new SparseBooleanArray();
        this.k = new f();
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof p.a) && ((p.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.support.v7.view.menu.b
    public android.support.v7.view.menu.p a(ViewGroup viewGroup) {
        android.support.v7.view.menu.p pVar = this.f;
        android.support.v7.view.menu.p a2 = super.a(viewGroup);
        if (pVar != a2) {
            ((ActionMenuView) a2).setPresenter(this);
        }
        return a2;
    }

    @Override // android.support.v7.view.menu.b
    public View a(android.support.v7.view.menu.j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.n()) {
            actionView = super.a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    public void a(Context context, android.support.v7.view.menu.h hVar) {
        super.a(context, hVar);
        Resources resources = context.getResources();
        android.support.v7.view.a a2 = android.support.v7.view.a.a(context);
        if (!this.p) {
            this.o = a2.b();
        }
        if (!this.v) {
            this.q = a2.c();
        }
        if (!this.t) {
            this.s = a2.a();
        }
        int i = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new C0015d(this.a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = i;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.z = null;
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = android.support.v7.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void a(Drawable drawable) {
        if (this.g != null) {
            this.g.setImageDrawable(drawable);
            return;
        }
        this.n = true;
        this.m = drawable;
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    public void a(android.support.v7.view.menu.h hVar, boolean z) {
        f();
        super.a(hVar, z);
    }

    @Override // android.support.v7.view.menu.b
    public void a(android.support.v7.view.menu.j jVar, p.a aVar) {
        aVar.a(jVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    @Override // android.support.v4.g.c.a
    public void a(boolean z) {
        if (z) {
            super.a((android.support.v7.view.menu.u) null);
        } else if (this.c != null) {
            this.c.a(false);
        }
    }

    @Override // android.support.v7.view.menu.b
    public boolean a(int i, android.support.v7.view.menu.j jVar) {
        return jVar.j();
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    public boolean a(android.support.v7.view.menu.u uVar) {
        boolean z = false;
        if (uVar.hasVisibleItems()) {
            android.support.v7.view.menu.u uVar2 = uVar;
            while (uVar2.s() != this.c) {
                uVar2 = (android.support.v7.view.menu.u) uVar2.s();
            }
            View a2 = a(uVar2.getItem());
            if (a2 == null) {
                return false;
            }
            this.l = uVar.getItem().getItemId();
            int size = uVar.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = uVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            this.i = new a(this.b, uVar, a2);
            this.i.a(z);
            this.i.a();
            super.a(uVar);
            return true;
        }
        return false;
    }

    @Override // android.support.v7.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.g) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    public void b(boolean z) {
        super.b(z);
        ((View) this.f).requestLayout();
        boolean z2 = false;
        if (this.c != null) {
            ArrayList<android.support.v7.view.menu.j> k = this.c.k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                android.support.v4.g.c a2 = k.get(i).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        ArrayList<android.support.v7.view.menu.j> l = this.c != null ? this.c.l() : null;
        if (this.o && l != null) {
            int size2 = l.size();
            if (size2 == 1) {
                z2 = !l.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.g == null) {
                this.g = new C0015d(this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else if (this.g != null && this.g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    public boolean b() {
        ArrayList<android.support.v7.view.menu.j> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        d dVar = this;
        int i5 = 0;
        if (dVar.c != null) {
            arrayList = dVar.c.i();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = dVar.s;
        int i7 = dVar.r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) dVar.f;
        int i8 = i6;
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            android.support.v7.view.menu.j jVar = arrayList.get(i11);
            if (jVar.l()) {
                i9++;
            } else if (jVar.k()) {
                i10++;
            } else {
                z2 = true;
            }
            if (dVar.w && jVar.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (dVar.o && (z2 || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = dVar.y;
        sparseBooleanArray.clear();
        if (dVar.u) {
            i2 = i7 / dVar.x;
            i3 = ((i7 % dVar.x) / i2) + dVar.x;
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i13 = i7;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i) {
            android.support.v7.view.menu.j jVar2 = arrayList.get(i14);
            if (jVar2.l()) {
                View a2 = dVar.a(jVar2, dVar.z, viewGroup);
                if (dVar.z == null) {
                    dVar.z = a2;
                }
                if (dVar.u) {
                    i2 -= ActionMenuView.a(a2, i3, i2, makeMeasureSpec, i5);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i13 -= measuredWidth;
                if (i15 != 0) {
                    measuredWidth = i15;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                jVar2.d(z);
                i4 = i;
                i15 = measuredWidth;
            } else if (jVar2.k()) {
                int groupId2 = jVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i13 > 0 && (!dVar.u || i2 > 0);
                if (z4) {
                    boolean z5 = z4;
                    View a3 = dVar.a(jVar2, dVar.z, viewGroup);
                    i4 = i;
                    if (dVar.z == null) {
                        dVar.z = a3;
                    }
                    if (dVar.u) {
                        int a4 = ActionMenuView.a(a3, i3, i2, makeMeasureSpec, 0);
                        i2 -= a4;
                        if (a4 == 0) {
                            z5 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i13 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    z4 = z5 & (!dVar.u ? i13 + i15 <= 0 : i13 < 0);
                } else {
                    i4 = i;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i16 = 0; i16 < i14; i16++) {
                        android.support.v7.view.menu.j jVar3 = arrayList.get(i16);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.j()) {
                                i12++;
                            }
                            jVar3.d(false);
                        }
                    }
                }
                if (z4) {
                    i12--;
                }
                jVar2.d(z4);
            } else {
                i4 = i;
                jVar2.d(false);
                i14++;
                i = i4;
                dVar = this;
                i5 = 0;
            }
            i14++;
            i = i4;
            dVar = this;
            i5 = 0;
        }
        return true;
    }

    public Drawable c() {
        if (this.g != null) {
            return this.g.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    public void c(boolean z) {
        this.o = z;
        this.p = true;
    }

    public void d(boolean z) {
        this.w = z;
    }

    public boolean d() {
        if (!this.o || h() || this.c == null || this.f == null || this.j != null || this.c.l().isEmpty()) {
            return false;
        }
        this.j = new c(new e(this.b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        super.a((android.support.v7.view.menu.u) null);
        return true;
    }

    public boolean e() {
        if (this.j != null && this.f != null) {
            ((View) this.f).removeCallbacks(this.j);
            this.j = null;
            return true;
        }
        e eVar = this.h;
        if (eVar != null) {
            eVar.d();
            return true;
        }
        return false;
    }

    public boolean f() {
        return e() | g();
    }

    public boolean g() {
        if (this.i != null) {
            this.i.d();
            return true;
        }
        return false;
    }

    public boolean h() {
        return this.h != null && this.h.f();
    }

    public boolean i() {
        return this.j != null || h();
    }
}