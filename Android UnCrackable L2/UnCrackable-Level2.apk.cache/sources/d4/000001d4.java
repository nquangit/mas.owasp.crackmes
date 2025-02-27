package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ActionBarContextView extends a {
    private CharSequence g;
    private CharSequence h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private boolean p;
    private int q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aw a = aw.a(context, attributeSet, a.j.ActionMode, i, 0);
        android.support.v4.g.p.a(this, a.a(a.j.ActionMode_background));
        this.n = a.g(a.j.ActionMode_titleTextStyle, 0);
        this.o = a.g(a.j.ActionMode_subtitleTextStyle, 0);
        this.e = a.f(a.j.ActionMode_height, 0);
        this.q = a.g(a.j.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
        a.a();
    }

    private void e() {
        if (this.k == null) {
            LayoutInflater.from(getContext()).inflate(a.g.abc_action_bar_title_item, this);
            this.k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.l = (TextView) this.k.findViewById(a.f.action_bar_title);
            this.m = (TextView) this.k.findViewById(a.f.action_bar_subtitle);
            if (this.n != 0) {
                this.l.setTextAppearance(getContext(), this.n);
            }
            if (this.o != 0) {
                this.m.setTextAppearance(getContext(), this.o);
            }
        }
        this.l.setText(this.g);
        this.m.setText(this.h);
        boolean z = !TextUtils.isEmpty(this.g);
        boolean z2 = !TextUtils.isEmpty(this.h);
        int i = 8;
        this.m.setVisibility(z2 ? 0 : 8);
        this.k.setVisibility((z || z2) ? 0 : 0);
        if (this.k.getParent() == null) {
            addView(this.k);
        }
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ android.support.v4.g.s a(int i, long j) {
        return super.a(i, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (r3.i.getParent() == null) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(final android.support.v7.view.b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.i
            if (r0 != 0) goto L1b
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.q
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.i = r0
        L15:
            android.view.View r0 = r3.i
            r3.addView(r0)
            goto L24
        L1b:
            android.view.View r0 = r3.i
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L24
            goto L15
        L24:
            android.view.View r0 = r3.i
            int r1 = android.support.v7.a.a.f.action_mode_close_button
            android.view.View r0 = r0.findViewById(r1)
            android.support.v7.widget.ActionBarContextView$1 r1 = new android.support.v7.widget.ActionBarContextView$1
            r1.<init>()
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.b()
            android.support.v7.view.menu.h r4 = (android.support.v7.view.menu.h) r4
            android.support.v7.widget.d r0 = r3.d
            if (r0 == 0) goto L43
            android.support.v7.widget.d r0 = r3.d
            r0.f()
        L43:
            android.support.v7.widget.d r0 = new android.support.v7.widget.d
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.d = r0
            android.support.v7.widget.d r0 = r3.d
            r1 = 1
            r0.c(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            android.support.v7.widget.d r1 = r3.d
            android.content.Context r2 = r3.b
            r4.a(r1, r2)
            android.support.v7.widget.d r4 = r3.d
            android.support.v7.view.menu.p r4 = r4.a(r3)
            android.support.v7.widget.ActionMenuView r4 = (android.support.v7.widget.ActionMenuView) r4
            r3.c = r4
            android.support.v7.widget.ActionMenuView r4 = r3.c
            r1 = 0
            android.support.v4.g.p.a(r4, r1)
            android.support.v7.widget.ActionMenuView r4 = r3.c
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContextView.a(android.support.v7.view.b):void");
    }

    @Override // android.support.v7.widget.a
    public boolean a() {
        if (this.d != null) {
            return this.d.d();
        }
        return false;
    }

    public void b() {
        if (this.i == null) {
            c();
        }
    }

    public void c() {
        removeAllViews();
        this.j = null;
        this.c = null;
    }

    public boolean d() {
        return this.p;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.h;
    }

    public CharSequence getTitle() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.e();
            this.d.g();
        }
    }

    @Override // android.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.g);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = bc.a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.i == null || this.i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a2 = a(paddingRight, i6, a);
            i5 = a(a2 + a(this.i, a2, paddingTop, paddingTop2, a), i7, a);
        }
        if (this.k != null && this.j == null && this.k.getVisibility() != 8) {
            i5 += a(this.k, i5, paddingTop, paddingTop2, a);
        }
        int i8 = i5;
        if (this.j != null) {
            a(this.j, i8, paddingTop, paddingTop2, a);
        }
        int paddingLeft = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a(this.c, paddingLeft, paddingTop, paddingTop2, !a);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int size = View.MeasureSpec.getSize(i);
            int size2 = this.e > 0 ? this.e : View.MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i3 = size2 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
            if (this.i != null) {
                int a = a(this.i, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.k != null && this.j == null) {
                if (this.p) {
                    this.k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.k.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.k.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = a(this.k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.j != null) {
                ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
                int i4 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                int i5 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
                if (layoutParams.height >= 0) {
                    i3 = Math.min(layoutParams.height, i3);
                }
                this.j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(i3, i5));
            }
            if (this.e > 0) {
                setMeasuredDimension(size, size2);
                return;
            }
            int childCount = getChildCount();
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                int measuredHeight = getChildAt(i7).getMeasuredHeight() + paddingTop;
                if (measuredHeight > i6) {
                    i6 = measuredHeight;
                }
            }
            setMeasuredDimension(size, i6);
        }
    }

    @Override // android.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.a
    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.j != null) {
            removeView(this.j);
        }
        this.j = view;
        if (view != null && this.k != null) {
            removeView(this.k);
            this.k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.h = charSequence;
        e();
    }

    public void setTitle(CharSequence charSequence) {
        this.g = charSequence;
        e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.p) {
            requestLayout();
        }
        this.p = z;
    }

    @Override // android.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}