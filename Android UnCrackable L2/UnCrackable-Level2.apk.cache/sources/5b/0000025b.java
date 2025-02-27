package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
class s extends PopupWindow {
    private static final boolean a;
    private boolean b;

    static {
        a = Build.VERSION.SDK_INT < 21;
    }

    public s(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        aw a2 = aw.a(context, attributeSet, a.j.PopupWindow, i, i2);
        if (a2.g(a.j.PopupWindow_overlapAnchor)) {
            a(a2.a(a.j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.a(a.j.PopupWindow_android_popupBackground));
        a2.a();
    }

    private void a(boolean z) {
        if (a) {
            this.b = z;
        } else {
            android.support.v4.widget.j.a(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }
}