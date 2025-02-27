package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public class aj extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float g;
        public int h;

        public a(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }

    public aj(Context context) {
        this(context, null);
    }

    public aj(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public aj(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        aw a2 = aw.a(context, attributeSet, a.j.LinearLayoutCompat, i, 0);
        int a3 = a2.a(a.j.LinearLayoutCompat_android_orientation, -1);
        if (a3 >= 0) {
            setOrientation(a3);
        }
        int a4 = a2.a(a.j.LinearLayoutCompat_android_gravity, -1);
        if (a4 >= 0) {
            setGravity(a4);
        }
        boolean a5 = a2.a(a.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a5) {
            setBaselineAligned(a5);
        }
        this.g = a2.a(a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a2.a(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a2.a(a.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a2.a(a.j.LinearLayoutCompat_divider));
        this.n = a2.a(a.j.LinearLayoutCompat_showDividers, 0);
        this.o = a2.e(a.j.LinearLayoutCompat_dividerPadding, 0);
        a2.a();
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private void c(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    int a(View view) {
        return 0;
    }

    int a(View view, int i) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x02dd, code lost:
        if (r15 > 0) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02e8, code lost:
        if (r15 < 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02ea, code lost:
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02eb, code lost:
        r13.measure(r9, android.view.View.MeasureSpec.makeMeasureSpec(r15, r10));
        r1 = android.view.View.combineMeasuredStates(r1, r13.getMeasuredState() & (-256));
        r9 = r9;
        r10 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x032a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(int r41, int r42) {
        /*
            Method dump skipped, instructions count: 922
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.a(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r2 = r20 - r18
            int r3 = r17.getPaddingRight()
            int r8 = r2 - r3
            int r2 = r2 - r7
            int r3 = r17.getPaddingRight()
            int r9 = r2 - r3
            int r10 = r17.getVirtualChildCount()
            int r2 = r6.e
            r2 = r2 & 112(0x70, float:1.57E-43)
            int r3 = r6.e
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r3 & r4
            r3 = 16
            if (r2 == r3) goto L3e
            r3 = 80
            if (r2 == r3) goto L31
            int r0 = r17.getPaddingTop()
            goto L4a
        L31:
            int r2 = r17.getPaddingTop()
            int r2 = r2 + r21
            int r2 = r2 - r19
            int r0 = r6.f
            int r0 = r2 - r0
            goto L4a
        L3e:
            int r2 = r17.getPaddingTop()
            int r0 = r21 - r19
            int r1 = r6.f
            int r0 = r0 - r1
            int r0 = r0 / 2
            int r0 = r0 + r2
        L4a:
            r1 = 0
            r12 = 0
        L4c:
            if (r12 >= r10) goto Lcb
            android.view.View r13 = r6.b(r12)
            r14 = 1
            if (r13 != 0) goto L5d
            int r1 = r6.d(r12)
            int r0 = r0 + r1
        L5a:
            r1 = 1
            goto Lc9
        L5d:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L5a
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            android.support.v7.widget.aj$a r5 = (android.support.v7.widget.aj.a) r5
            int r1 = r5.h
            if (r1 >= 0) goto L79
            r1 = r11
        L79:
            int r2 = android.support.v4.g.p.b(r17)
            int r1 = android.support.v4.g.d.a(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L90
            r2 = 5
            if (r1 == r2) goto L8d
            int r1 = r5.leftMargin
            int r1 = r1 + r7
        L8b:
            r2 = r1
            goto L9c
        L8d:
            int r1 = r8 - r4
            goto L98
        L90:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
        L98:
            int r2 = r5.rightMargin
            int r1 = r1 - r2
            goto L8b
        L9c:
            boolean r1 = r6.c(r12)
            if (r1 == 0) goto La5
            int r1 = r6.m
            int r0 = r0 + r1
        La5:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.a(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.a(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.b(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.a(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            goto L5a
        Lc9:
            int r12 = r12 + r1
            goto L4c
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.a(int, int, int, int):void");
    }

    void a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View b = b(i);
            if (b != null && b.getVisibility() != 8 && c(i)) {
                a(canvas, (b.getTop() - ((a) b.getLayoutParams()).topMargin) - this.m);
            }
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            a(canvas, b2 == null ? (getHeight() - getPaddingBottom()) - this.m : b2.getBottom() + ((a) b2.getLayoutParams()).bottomMargin);
        }
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int b(View view) {
        return 0;
    }

    @Override // android.view.ViewGroup
    /* renamed from: b */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    View b(int i) {
        return getChildAt(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x03b0, code lost:
        if (r8 > 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03bb, code lost:
        if (r8 < 0) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03bd, code lost:
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03be, code lost:
        r14.measure(android.view.View.MeasureSpec.makeMeasureSpec(r8, r4), r2);
        r9 = android.view.View.combineMeasuredStates(r9, r14.getMeasuredState() & (-16777216));
        r2 = r2;
        r4 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(int r45, int r46) {
        /*
            Method dump skipped, instructions count: 1299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.b(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.b(int, int, int, int):void");
    }

    void b(Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean a2 = bc.a(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View b = b(i2);
            if (b != null && b.getVisibility() != 8 && c(i2)) {
                a aVar = (a) b.getLayoutParams();
                b(canvas, a2 ? b.getRight() + aVar.rightMargin : (b.getLeft() - aVar.leftMargin) - this.l);
            }
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            if (b2 != null) {
                a aVar2 = (a) b2.getLayoutParams();
                if (a2) {
                    left = b2.getLeft();
                    i = aVar2.leftMargin;
                    right = (left - i) - this.l;
                } else {
                    right = b2.getRight() + aVar2.rightMargin;
                }
            } else if (a2) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                i = getPaddingRight();
                right = (left - i) - this.l;
            }
            b(canvas, right);
        }
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(int i) {
        if (i == 0) {
            return (this.n & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.n & 4) != 0;
        } else if ((this.n & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    int d(int i) {
        return 0;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() > this.b) {
            View childAt = getChildAt(this.b);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.b == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i2 = this.c;
            if (this.d == 1 && (i = this.e & a.j.AppCompatTheme_windowActionModeOverlay) != 48) {
                if (i == 16) {
                    i2 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2;
                } else if (i == 80) {
                    i2 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                }
            }
            return i2 + ((a) childAt.getLayoutParams()).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: j */
    public a generateDefaultLayoutParams() {
        if (this.d == 0) {
            return new a(-2, -2);
        }
        if (this.d == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        if (this.d == 1) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(aj.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(aj.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.d == 1) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.k) {
            return;
        }
        this.k = drawable;
        if (drawable != null) {
            this.l = drawable.getIntrinsicWidth();
            this.m = drawable.getIntrinsicHeight();
        } else {
            this.l = 0;
            this.m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & a.j.AppCompatTheme_windowActionModeOverlay) == 0) {
                i |= 48;
            }
            this.e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((8388615 & this.e) != i2) {
            this.e = i2 | (this.e & (-8388616));
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & a.j.AppCompatTheme_windowActionModeOverlay;
        if ((this.e & a.j.AppCompatTheme_windowActionModeOverlay) != i2) {
            this.e = i2 | (this.e & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}