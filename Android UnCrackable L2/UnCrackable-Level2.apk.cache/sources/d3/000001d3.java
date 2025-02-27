package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    Drawable a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        android.support.v4.g.p.a(this, Build.VERSION.SDK_INT >= 21 ? new c(this) : new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionBar);
        this.a = obtainStyledAttributes.getDrawable(a.j.ActionBar_background);
        this.b = obtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_height, -1);
        if (getId() == a.f.split_action_bar) {
            this.d = true;
            this.c = obtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.d ? !(this.a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null && this.a.isStateful()) {
            this.a.setState(getDrawableState());
        }
        if (this.b != null && this.b.isStateful()) {
            this.b.setState(getDrawableState());
        }
        if (this.c == null || !this.c.isStateful()) {
            return;
        }
        this.c.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.a != null) {
            this.a.jumpToCurrentState();
        }
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
        if (this.c != null) {
            this.c.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(a.f.action_bar);
        this.i = findViewById(a.f.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z, i, i2, i3, i4);
        View view2 = this.g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (view2 != null && view2.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            view2.layout(i, (measuredHeight - view2.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.d) {
            if (this.a != null) {
                if (this.h.getVisibility() == 0) {
                    drawable = this.a;
                    left = this.h.getLeft();
                    top = this.h.getTop();
                    right = this.h.getRight();
                    view = this.h;
                } else if (this.i == null || this.i.getVisibility() != 0) {
                    this.a.setBounds(0, 0, 0, 0);
                    z3 = true;
                } else {
                    drawable = this.a;
                    left = this.i.getLeft();
                    top = this.i.getTop();
                    right = this.i.getRight();
                    view = this.i;
                }
                drawable.setBounds(left, top, right, view.getBottom());
                z3 = true;
            }
            this.e = z4;
            if (!z4 || this.b == null) {
                z2 = z3;
            } else {
                this.b.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        } else if (this.c != null) {
            this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z2 = false;
        }
        if (z2) {
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.h
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L1e
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L1e
            int r0 = r3.j
            if (r0 < 0) goto L1e
            int r0 = r3.j
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L1e:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.h
            if (r4 != 0) goto L26
            return
        L26:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.g
            if (r0 == 0) goto L73
            android.view.View r0 = r3.g
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L73
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L73
            android.view.View r0 = r3.h
            boolean r0 = r3.a(r0)
            if (r0 != 0) goto L4b
            android.view.View r0 = r3.h
        L46:
            int r0 = r3.b(r0)
            goto L57
        L4b:
            android.view.View r0 = r3.i
            boolean r0 = r3.a(r0)
            if (r0 != 0) goto L56
            android.view.View r0 = r3.i
            goto L46
        L56:
            r0 = 0
        L57:
            if (r4 != r1) goto L5e
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L61
        L5e:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L61:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.g
            int r1 = r3.b(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        if (this.a != null) {
            this.a.setCallback(null);
            unscheduleDrawable(this.a);
        }
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.h != null) {
                this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        boolean z = false;
        if (!this.d ? !(this.a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        if (this.c != null) {
            this.c.setCallback(null);
            unscheduleDrawable(this.c);
        }
        this.c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d && this.c != null) {
                this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.d ? !(this.a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback(null);
            unscheduleDrawable(this.b);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.e && this.b != null) {
                this.b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }
        boolean z = false;
        if (!this.d ? !(this.a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ap apVar) {
        if (this.g != null) {
            removeView(this.g);
        }
        this.g = apVar;
        if (apVar != null) {
            addView(apVar);
            ViewGroup.LayoutParams layoutParams = apVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            apVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.a != null) {
            this.a.setVisible(z, false);
        }
        if (this.b != null) {
            this.b.setVisible(z, false);
        }
        if (this.c != null) {
            this.c.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.a && !this.d) || (drawable == this.b && this.e) || ((drawable == this.c && this.d) || super.verifyDrawable(drawable));
    }
}