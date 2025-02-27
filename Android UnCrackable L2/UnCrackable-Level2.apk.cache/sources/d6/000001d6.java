package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.a.a;
import android.support.v7.view.menu.o;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements android.support.v4.g.k, ad {
    static final int[] e = {a.C0011a.actionBarSize, 16842841};
    private final Runnable A;
    private final Runnable B;
    private final android.support.v4.g.m C;
    ActionBarContainer a;
    boolean b;
    ViewPropertyAnimator c;
    final AnimatorListenerAdapter d;
    private int f;
    private int g;
    private ContentFrameLayout h;
    private ae i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private a x;
    private final int y;
    private OverScroller z;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);

        void g(boolean z);

        void j();

        void k();

        void l();

        void m();
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.y = 600;
        this.d = new AnimatorListenerAdapter() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.c = null;
                ActionBarOverlayLayout.this.b = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.c = null;
                ActionBarOverlayLayout.this.b = false;
            }
        };
        this.A = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.d);
            }
        };
        this.B = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(-ActionBarOverlayLayout.this.a.getHeight()).setListener(ActionBarOverlayLayout.this.d);
            }
        };
        a(context);
        this.C = new android.support.v4.g.m(this);
    }

    private ae a(View view) {
        if (view instanceof ae) {
            return (ae) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(e);
        this.f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.j == null);
        obtainStyledAttributes.recycle();
        this.k = context.getApplicationInfo().targetSdkVersion < 19;
        this.z = new OverScroller(context);
    }

    private boolean a(float f, float f2) {
        this.z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.z.getFinalY() > this.a.getHeight();
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        b bVar = (b) view.getLayoutParams();
        if (!z || bVar.leftMargin == rect.left) {
            z5 = false;
        } else {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    private void l() {
        d();
        postDelayed(this.A, 600L);
    }

    private void m() {
        d();
        postDelayed(this.B, 600L);
    }

    private void n() {
        d();
        this.A.run();
    }

    private void o() {
        d();
        this.B.run();
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.support.v7.widget.ad
    public void a(int i) {
        c();
        if (i == 2) {
            this.i.f();
        } else if (i == 5) {
            this.i.g();
        } else if (i != 109) {
        } else {
            setOverlayMode(true);
        }
    }

    @Override // android.support.v7.widget.ad
    public void a(Menu menu, o.a aVar) {
        c();
        this.i.a(menu, aVar);
    }

    public boolean a() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public b generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    void c() {
        if (this.h == null) {
            this.h = (ContentFrameLayout) findViewById(a.f.action_bar_activity_content);
            this.a = (ActionBarContainer) findViewById(a.f.action_bar_container);
            this.i = a(findViewById(a.f.action_bar));
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    void d() {
        removeCallbacks(this.A);
        removeCallbacks(this.B);
        if (this.c != null) {
            this.c.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j == null || this.k) {
            return;
        }
        int bottom = this.a.getVisibility() == 0 ? (int) (this.a.getBottom() + this.a.getTranslationY() + 0.5f) : 0;
        this.j.setBounds(0, bottom, getWidth(), this.j.getIntrinsicHeight() + bottom);
        this.j.draw(canvas);
    }

    @Override // android.support.v7.widget.ad
    public boolean e() {
        c();
        return this.i.h();
    }

    @Override // android.support.v7.widget.ad
    public boolean f() {
        c();
        return this.i.i();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        c();
        int f = android.support.v4.g.p.f(this) & 256;
        boolean a2 = a(this.a, rect, true, true, false, true);
        this.t.set(rect);
        bc.a(this, this.t, this.q);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            a2 = true;
        }
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    @Override // android.support.v7.widget.ad
    public boolean g() {
        c();
        return this.i.j();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public int getActionBarHideOffset() {
        if (this.a != null) {
            return -((int) this.a.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.C.a();
    }

    public CharSequence getTitle() {
        c();
        return this.i.e();
    }

    @Override // android.support.v7.widget.ad
    public boolean h() {
        c();
        return this.i.k();
    }

    @Override // android.support.v7.widget.ad
    public boolean i() {
        c();
        return this.i.l();
    }

    @Override // android.support.v7.widget.ad
    public void j() {
        c();
        this.i.m();
    }

    @Override // android.support.v7.widget.ad
    public void k() {
        c();
        this.i.n();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        android.support.v4.g.p.g(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = bVar.leftMargin + paddingLeft;
                int i7 = bVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        Rect rect;
        c();
        measureChildWithMargins(this.a, i, 0, i2, 0);
        b bVar = (b) this.a.getLayoutParams();
        int max = Math.max(0, this.a.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int max2 = Math.max(0, this.a.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.a.getMeasuredState());
        boolean z = (android.support.v4.g.p.f(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f;
            if (this.m && this.a.getTabContainer() != null) {
                measuredHeight += this.f;
            }
        } else {
            measuredHeight = this.a.getVisibility() != 8 ? this.a.getMeasuredHeight() : 0;
        }
        this.s.set(this.q);
        this.v.set(this.t);
        if (this.l || z) {
            this.v.top += measuredHeight;
            rect = this.v;
        } else {
            this.s.top += measuredHeight;
            rect = this.s;
        }
        rect.bottom += 0;
        a(this.h, this.s, true, true, true, true);
        if (!this.w.equals(this.v)) {
            this.w.set(this.v);
            this.h.a(this.v);
        }
        measureChildWithMargins(this.h, i, 0, i2, 0);
        b bVar2 = (b) this.h.getLayoutParams();
        int max3 = Math.max(max, this.h.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
        int max4 = Math.max(max2, this.h.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.g.k
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (this.n && z) {
            if (a(f, f2)) {
                o();
            } else {
                n();
            }
            this.b = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.g.k
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.g.k
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.g.k
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.o += i2;
        setActionBarHideOffset(this.o);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.g.k
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.C.a(view, view2, i);
        this.o = getActionBarHideOffset();
        d();
        if (this.x != null) {
            this.x.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.g.k
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.a.getVisibility() != 0) {
            return false;
        }
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.g.k
    public void onStopNestedScroll(View view) {
        if (this.n && !this.b) {
            if (this.o <= this.a.getHeight()) {
                l();
            } else {
                m();
            }
        }
        if (this.x != null) {
            this.x.m();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.p ^ i;
        this.p = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.x != null) {
            this.x.g(!z2);
            if (z || !z2) {
                this.x.j();
            } else {
                this.x.k();
            }
        }
        if ((i2 & 256) == 0 || this.x == null) {
            return;
        }
        android.support.v4.g.p.g(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.g = i;
        if (this.x != null) {
            this.x.a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        d();
        this.a.setTranslationY(-Math.max(0, Math.min(i, this.a.getHeight())));
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.x = aVar;
        if (getWindowToken() != null) {
            this.x.a(this.g);
            if (this.p != 0) {
                onWindowSystemUiVisibilityChanged(this.p);
                android.support.v4.g.p.g(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.m = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.n) {
            this.n = z;
            if (z) {
                return;
            }
            d();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        c();
        this.i.a(i);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.i.a(drawable);
    }

    public void setLogo(int i) {
        c();
        this.i.b(i);
    }

    public void setOverlayMode(boolean z) {
        this.l = z;
        this.k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.support.v7.widget.ad
    public void setWindowCallback(Window.Callback callback) {
        c();
        this.i.a(callback);
    }

    @Override // android.support.v7.widget.ad
    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.i.a(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}