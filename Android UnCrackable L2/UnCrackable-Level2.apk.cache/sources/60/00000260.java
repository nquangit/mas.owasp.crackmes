package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes.dex */
class x extends t {
    private final SeekBar a;
    private Drawable b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SeekBar seekBar) {
        super(seekBar);
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.a = seekBar;
    }

    private void d() {
        if (this.b != null) {
            if (this.e || this.f) {
                this.b = android.support.v4.b.a.a.f(this.b.mutate());
                if (this.e) {
                    android.support.v4.b.a.a.a(this.b, this.c);
                }
                if (this.f) {
                    android.support.v4.b.a.a.a(this.b, this.d);
                }
                if (this.b.isStateful()) {
                    this.b.setState(this.a.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.b != null) {
            int max = this.a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.b.getIntrinsicWidth();
                int intrinsicHeight = this.b.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.b.setBounds(-i, -i2, i, i2);
                float width = ((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.a.getPaddingLeft(), this.a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    void a(Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.a);
            android.support.v4.b.a.a.b(drawable, android.support.v4.g.p.b(this.a));
            if (drawable.isStateful()) {
                drawable.setState(this.a.getDrawableState());
            }
            d();
        }
        this.a.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.widget.t
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        aw a = aw.a(this.a.getContext(), attributeSet, a.j.AppCompatSeekBar, i, 0);
        Drawable b = a.b(a.j.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.a.setThumb(b);
        }
        a(a.a(a.j.AppCompatSeekBar_tickMark));
        if (a.g(a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = af.a(a.a(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (a.g(a.j.AppCompatSeekBar_tickMarkTint)) {
            this.c = a.e(a.j.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        a.a();
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.a.getDrawableState())) {
            this.a.invalidateDrawable(drawable);
        }
    }
}