package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.a.a.b;
import android.support.v7.a.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class z {
    final TextView a;
    private au b;
    private au c;
    private au d;
    private au e;
    private final ac f;
    private int g = 0;
    private Typeface h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TextView textView) {
        this.a = textView;
        this.f = new ac(this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static au a(Context context, l lVar, int i) {
        ColorStateList b = lVar.b(context, i);
        if (b != null) {
            au auVar = new au();
            auVar.d = true;
            auVar.a = b;
            return auVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z a(TextView textView) {
        return Build.VERSION.SDK_INT >= 17 ? new aa(textView) : new z(textView);
    }

    private void a(Context context, aw awVar) {
        String d;
        Typeface typeface;
        this.g = awVar.a(a.j.TextAppearance_android_textStyle, this.g);
        boolean z = true;
        if (awVar.g(a.j.TextAppearance_android_fontFamily) || awVar.g(a.j.TextAppearance_fontFamily)) {
            this.h = null;
            int i = awVar.g(a.j.TextAppearance_fontFamily) ? a.j.TextAppearance_fontFamily : a.j.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.a);
                try {
                    this.h = awVar.a(i, this.g, new b.a() { // from class: android.support.v7.widget.z.1
                        @Override // android.support.v4.a.a.b.a
                        public void a(int i2) {
                        }

                        @Override // android.support.v4.a.a.b.a
                        public void a(Typeface typeface2) {
                            z.this.a(weakReference, typeface2);
                        }
                    });
                    if (this.h != null) {
                        z = false;
                    }
                    this.i = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.h != null || (d = awVar.d(i)) == null) {
                return;
            }
            this.h = Typeface.create(d, this.g);
        } else if (awVar.g(a.j.TextAppearance_android_typeface)) {
            this.i = false;
            switch (awVar.a(a.j.TextAppearance_android_typeface, 1)) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    return;
            }
            this.h = typeface;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.i) {
            this.h = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.g);
            }
        }
    }

    private void b(int i, float f) {
        this.f.a(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.b == null && this.c == null && this.d == null && this.e == null) {
            return;
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        a(compoundDrawables[0], this.b);
        a(compoundDrawables[1], this.c);
        a(compoundDrawables[2], this.d);
        a(compoundDrawables[3], this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        if (android.support.v4.widget.b.a || c()) {
            return;
        }
        b(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        this.f.a(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i) {
        ColorStateList e;
        aw a = aw.a(context, i, a.j.TextAppearance);
        if (a.g(a.j.TextAppearance_textAllCaps)) {
            a(a.a(a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a.g(a.j.TextAppearance_android_textColor) && (e = a.e(a.j.TextAppearance_android_textColor)) != null) {
            this.a.setTextColor(e);
        }
        a(context, a);
        a.a();
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Drawable drawable, au auVar) {
        if (drawable == null || auVar == null) {
            return;
        }
        l.a(drawable, auVar, this.a.getDrawableState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        Context context = this.a.getContext();
        l a = l.a();
        aw a2 = aw.a(context, attributeSet, a.j.AppCompatTextHelper, i, 0);
        int g = a2.g(a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.g(a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.g(a.j.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.g(a.j.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.g(a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a, a2.g(a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a2.a();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        if (g != -1) {
            aw a3 = aw.a(context, g, a.j.TextAppearance);
            if (z3 || !a3.g(a.j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a3.a(a.j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, a3);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList e = a3.g(a.j.TextAppearance_android_textColor) ? a3.e(a.j.TextAppearance_android_textColor) : null;
                colorStateList2 = a3.g(a.j.TextAppearance_android_textColorHint) ? a3.e(a.j.TextAppearance_android_textColorHint) : null;
                ColorStateList colorStateList3 = e;
                colorStateList = a3.g(a.j.TextAppearance_android_textColorLink) ? a3.e(a.j.TextAppearance_android_textColorLink) : null;
                r7 = colorStateList3;
            } else {
                colorStateList = null;
                colorStateList2 = null;
            }
            a3.a();
        } else {
            colorStateList = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
        }
        aw a4 = aw.a(context, attributeSet, a.j.TextAppearance, i, 0);
        if (z3 || !a4.g(a.j.TextAppearance_textAllCaps)) {
            z4 = z;
        } else {
            z2 = a4.a(a.j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a4.g(a.j.TextAppearance_android_textColor)) {
                r7 = a4.e(a.j.TextAppearance_android_textColor);
            }
            if (a4.g(a.j.TextAppearance_android_textColorHint)) {
                colorStateList2 = a4.e(a.j.TextAppearance_android_textColorHint);
            }
            if (a4.g(a.j.TextAppearance_android_textColorLink)) {
                colorStateList = a4.e(a.j.TextAppearance_android_textColorLink);
            }
        }
        a(context, a4);
        a4.a();
        if (r7 != null) {
            this.a.setTextColor(r7);
        }
        if (colorStateList2 != null) {
            this.a.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.a.setLinkTextColor(colorStateList);
        }
        if (!z3 && z4) {
            a(z2);
        }
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
        this.f.a(attributeSet, i);
        if (!android.support.v4.widget.b.a || this.f.a() == 0) {
            return;
        }
        int[] e2 = this.f.e();
        if (e2.length > 0) {
            if (this.a.getAutoSizeStepGranularity() != -1.0f) {
                this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f.c(), this.f.d(), this.f.b(), 0);
            } else {
                this.a.setAutoSizeTextTypeUniformWithPresetSizes(e2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i, int i2, int i3, int i4) {
        if (android.support.v4.widget.b.a) {
            return;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr, int i) {
        this.f.a(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f.e();
    }
}