package android.support.v4.g.b;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class d implements Interpolator {
    private final float[] a;
    private final float b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(float[] fArr) {
        this.a = fArr;
        this.b = 1.0f / (this.a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) ((this.a.length - 1) * f), this.a.length - 2);
        return this.a[min] + (((f - (min * this.b)) / this.b) * (this.a[min + 1] - this.a[min]));
    }
}