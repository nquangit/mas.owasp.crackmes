package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.aj;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class ActionMenuView extends aj implements h.b, android.support.v7.view.menu.p {
    h.a a;
    e b;
    private android.support.v7.view.menu.h c;
    private Context d;
    private int e;
    private boolean f;
    private android.support.v7.widget.d g;
    private o.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* loaded from: classes.dex */
    public interface a {
        boolean c();

        boolean d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements o.a {
        b() {
        }

        @Override // android.support.v7.view.menu.o.a
        public void a(android.support.v7.view.menu.h hVar, boolean z) {
        }

        @Override // android.support.v7.view.menu.o.a
        public boolean a(android.support.v7.view.menu.h hVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends aj.a {
        @ViewDebug.ExportedProperty
        public boolean a;
        @ViewDebug.ExportedProperty
        public int b;
        @ViewDebug.ExportedProperty
        public int c;
        @ViewDebug.ExportedProperty
        public boolean d;
        @ViewDebug.ExportedProperty
        public boolean e;
        boolean f;

        public c(int i, int i2) {
            super(i, i2);
            this.a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(c cVar) {
            super(cVar);
            this.a = cVar.a;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements h.a {
        d() {
        }

        @Override // android.support.v7.view.menu.h.a
        public void a(android.support.v7.view.menu.h hVar) {
            if (ActionMenuView.this.a != null) {
                ActionMenuView.this.a.a(hVar);
            }
        }

        @Override // android.support.v7.view.menu.h.a
        public boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            return ActionMenuView.this.b != null && ActionMenuView.this.b.a(menuItem);
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (f * 4.0f);
        this.d = context;
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.b();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        cVar.d = (cVar.a || !z2) ? false : false;
        cVar.b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x024f A[LOOP:5: B:139:0x024f->B:144:0x0272, LOOP_START, PHI: r3 r32 
      PHI: (r3v8 int) = (r3v7 int), (r3v9 int) binds: [B:138:0x024d, B:144:0x0272] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r32v1 int) = (r32v0 int), (r32v2 int) binds: [B:138:0x024d, B:144:0x0272] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x027e  */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r35, int r36) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionMenuView.c(int, int):void");
    }

    @Override // android.support.v7.widget.aj, android.view.ViewGroup
    /* renamed from: a */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.aj, android.view.ViewGroup
    /* renamed from: a */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
            if (cVar.h <= 0) {
                cVar.h = 16;
            }
            return cVar;
        }
        return j();
    }

    @Override // android.support.v7.view.menu.p
    public void a(android.support.v7.view.menu.h hVar) {
        this.c = hVar;
    }

    public void a(o.a aVar, h.a aVar2) {
        this.h = aVar;
        this.a = aVar2;
    }

    public boolean a() {
        return this.f;
    }

    protected boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).d();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).c();
    }

    @Override // android.support.v7.view.menu.h.b
    public boolean a(android.support.v7.view.menu.j jVar) {
        return this.c.a(jVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.aj
    /* renamed from: b */
    public c j() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    public c c() {
        c j = j();
        j.a = true;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.aj, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public android.support.v7.view.menu.h d() {
        return this.c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        return this.g != null && this.g.d();
    }

    public boolean f() {
        return this.g != null && this.g.e();
    }

    public boolean g() {
        return this.g != null && this.g.h();
    }

    public Menu getMenu() {
        if (this.c == null) {
            Context context = getContext();
            this.c = new android.support.v7.view.menu.h(context);
            this.c.a(new d());
            this.g = new android.support.v7.widget.d(context);
            this.g.c(true);
            this.g.a(this.h != null ? this.h : new b());
            this.c.a(this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.c();
    }

    public int getPopupTheme() {
        return this.e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        return this.g != null && this.g.i();
    }

    public void i() {
        if (this.g != null) {
            this.g.f();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.g != null) {
            this.g.b(false);
            if (this.g.h()) {
                this.g.e();
                this.g.d();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.aj, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int i7;
        if (!this.i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i3 - i;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = bc.a(this);
        int i10 = paddingRight;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (a(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i7 = getPaddingLeft() + cVar.leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i14 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i14, width, measuredHeight + i14);
                    i10 -= measuredWidth;
                    i11 = 1;
                } else {
                    i10 -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    a(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i9 / 2) - (measuredWidth2 / 2);
            int i16 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        if (i17 > 0) {
            i6 = i10 / i17;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int max = Math.max(i5, i6);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.a) {
                    int i18 = width2 - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
                i5++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.a) {
                int i20 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + cVar3.rightMargin + max;
            }
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.aj, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z = this.i;
        this.i = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.i) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.i && this.c != null && size != this.j) {
            this.j = size;
            this.c.b(true);
        }
        int childCount = getChildCount();
        if (this.i && childCount > 0) {
            c(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            cVar.rightMargin = 0;
            cVar.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.d(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.b = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    public void setPopupTheme(int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(android.support.v7.widget.d dVar) {
        this.g = dVar;
        this.g.a(this);
    }
}