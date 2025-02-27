package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class p {
    private final ImageView a;
    private au b;
    private au c;
    private au d;

    public p(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new au();
        }
        au auVar = this.d;
        auVar.a();
        ColorStateList a = android.support.v4.widget.g.a(this.a);
        if (a != null) {
            auVar.d = true;
            auVar.a = a;
        }
        PorterDuff.Mode b = android.support.v4.widget.g.b(this.a);
        if (b != null) {
            auVar.c = true;
            auVar.b = b;
        }
        if (auVar.d || auVar.c) {
            l.a(drawable, auVar, this.a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b = android.support.v7.b.a.b.b(this.a.getContext(), i);
            if (b != null) {
                af.a(b);
            }
            this.a.setImageDrawable(b);
        } else {
            this.a.setImageDrawable(null);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new au();
        }
        this.c.a = colorStateList;
        this.c.d = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new au();
        }
        this.c.b = mode;
        this.c.c = true;
        d();
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        aw a = aw.a(this.a.getContext(), attributeSet, a.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (g = a.g(a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = android.support.v7.b.a.b.b(this.a.getContext(), g)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                af.a(drawable);
            }
            if (a.g(a.j.AppCompatImageView_tint)) {
                android.support.v4.widget.g.a(this.a, a.e(a.j.AppCompatImageView_tint));
            }
            if (a.g(a.j.AppCompatImageView_tintMode)) {
                android.support.v4.widget.g.a(this.a, af.a(a.a(a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        if (this.c != null) {
            return this.c.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        if (this.c != null) {
            return this.c.b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        au auVar;
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            af.a(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            if (this.c != null) {
                auVar = this.c;
            } else if (this.b == null) {
                return;
            } else {
                auVar = this.b;
            }
            l.a(drawable, auVar, this.a.getDrawableState());
        }
    }
}