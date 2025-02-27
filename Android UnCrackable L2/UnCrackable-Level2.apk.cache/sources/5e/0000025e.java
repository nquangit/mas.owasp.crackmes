package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* loaded from: classes.dex */
public class v extends RatingBar {
    private final t a;

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.ratingBarStyle);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new t(this);
        this.a.a(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.a.a();
        if (a != null) {
            setMeasuredDimension(View.resolveSizeAndState(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}