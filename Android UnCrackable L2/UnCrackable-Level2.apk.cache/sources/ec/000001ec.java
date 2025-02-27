package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ah;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements ah {
    private ah.a a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.a != null) {
            this.a.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.support.v7.widget.ah
    public void setOnFitSystemWindowsListener(ah.a aVar) {
        this.a = aVar;
    }
}