package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.a;
import android.support.v7.widget.aj;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class AlertDialogLayout extends aj {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private static int c(View view) {
        int c = android.support.v4.g.p.c(view);
        if (c > 0) {
            return c;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return c(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean c(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == a.f.topPanel) {
                    view = childAt;
                } else if (id == a.f.buttonPanel) {
                    view2 = childAt;
                } else if ((id != a.f.contentPanel && id != a.f.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i, 0);
            paddingTop += view.getMeasuredHeight();
            i3 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i3 = 0;
        }
        if (view2 != null) {
            view2.measure(i, 0);
            i4 = c(view2);
            i5 = view2.getMeasuredHeight() - i4;
            paddingTop += i4;
            i3 = View.combineMeasuredStates(i3, view2.getMeasuredState());
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            i6 = view3.getMeasuredHeight();
            paddingTop += i6;
            i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
        } else {
            i6 = 0;
        }
        int i8 = size - paddingTop;
        if (view2 != null) {
            int i9 = paddingTop - i4;
            int min = Math.min(i8, i5);
            if (min > 0) {
                i8 -= min;
                i4 += min;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            paddingTop = i9 + view2.getMeasuredHeight();
            i3 = View.combineMeasuredStates(i3, view2.getMeasuredState());
        }
        if (view3 != null && i8 > 0) {
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(i6 + i8, mode));
            paddingTop = (paddingTop - i6) + view3.getMeasuredHeight();
            i3 = View.combineMeasuredStates(i3, view3.getMeasuredState());
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                i10 = Math.max(i10, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i10 + getPaddingLeft() + getPaddingRight(), i, i3), View.resolveSizeAndState(paddingTop, i2, 0));
        if (mode2 != 1073741824) {
            d(childCount, i2);
            return true;
        }
        return true;
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                aj.a aVar = (aj.a) childAt.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5  */
    @Override // android.support.v7.widget.aj, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r2 = r21 - r19
            int r3 = r17.getPaddingRight()
            int r8 = r2 - r3
            int r2 = r2 - r7
            int r3 = r17.getPaddingRight()
            int r9 = r2 - r3
            int r2 = r17.getMeasuredHeight()
            int r10 = r17.getChildCount()
            int r3 = r17.getGravity()
            r4 = r3 & 112(0x70, float:1.57E-43)
            r5 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r3 & r5
            r3 = 16
            if (r4 == r3) goto L40
            r3 = 80
            if (r4 == r3) goto L35
            int r0 = r17.getPaddingTop()
            goto L4a
        L35:
            int r3 = r17.getPaddingTop()
            int r3 = r3 + r22
            int r3 = r3 - r20
            int r0 = r3 - r2
            goto L4a
        L40:
            int r3 = r17.getPaddingTop()
            int r0 = r22 - r20
            int r0 = r0 - r2
            int r0 = r0 / 2
            int r0 = r0 + r3
        L4a:
            android.graphics.drawable.Drawable r1 = r17.getDividerDrawable()
            r2 = 0
            if (r1 != 0) goto L53
            r12 = 0
            goto L58
        L53:
            int r1 = r1.getIntrinsicHeight()
            r12 = r1
        L58:
            r13 = 0
        L59:
            if (r13 >= r10) goto Lbc
            android.view.View r1 = r6.getChildAt(r13)
            if (r1 == 0) goto Lb9
            int r2 = r1.getVisibility()
            r3 = 8
            if (r2 == r3) goto Lb9
            int r4 = r1.getMeasuredWidth()
            int r14 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            r15 = r2
            android.support.v7.widget.aj$a r15 = (android.support.v7.widget.aj.a) r15
            int r2 = r15.h
            if (r2 >= 0) goto L7d
            r2 = r11
        L7d:
            int r3 = android.support.v4.g.p.b(r17)
            int r2 = android.support.v4.g.d.a(r2, r3)
            r2 = r2 & 7
            r3 = 1
            if (r2 == r3) goto L94
            r3 = 5
            if (r2 == r3) goto L91
            int r2 = r15.leftMargin
            int r2 = r2 + r7
            goto L9f
        L91:
            int r2 = r8 - r4
            goto L9c
        L94:
            int r2 = r9 - r4
            int r2 = r2 / 2
            int r2 = r2 + r7
            int r3 = r15.leftMargin
            int r2 = r2 + r3
        L9c:
            int r3 = r15.rightMargin
            int r2 = r2 - r3
        L9f:
            boolean r3 = r6.c(r13)
            if (r3 == 0) goto La6
            int r0 = r0 + r12
        La6:
            int r3 = r15.topMargin
            int r16 = r0 + r3
            r0 = r17
            r3 = r16
            r5 = r14
            r0.a(r1, r2, r3, r4, r5)
            int r0 = r15.bottomMargin
            int r14 = r14 + r0
            int r16 = r16 + r14
            r0 = r16
        Lb9:
            int r13 = r13 + 1
            goto L59
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.aj, android.view.View
    public void onMeasure(int i, int i2) {
        if (c(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }
}