package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* loaded from: classes.dex */
public class h extends Button implements android.support.v4.g.o, android.support.v4.widget.b {
    private final g b;
    private final z c;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.buttonStyle);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(at.a(context), attributeSet, i);
        this.b = new g(this);
        this.b.a(attributeSet, i);
        this.c = z.a(this);
        this.c.a(attributeSet, i);
        this.c.a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (a) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.c != null) {
            return this.c.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (a) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.c != null) {
            return this.c.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (a) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.c != null) {
            return this.c.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        return a ? super.getAutoSizeTextAvailableSizes() : this.c != null ? this.c.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        } else if (this.c != null) {
            return this.c.d();
        } else {
            return 0;
        }
    }

    @Override // android.support.v4.g.o
    public ColorStateList getSupportBackgroundTintList() {
        if (this.b != null) {
            return this.b.a();
        }
        return null;
    }

    @Override // android.support.v4.g.o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.b != null) {
            return this.b.b();
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c != null) {
            this.c.a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.c == null || a || !this.c.c()) {
            return;
        }
        this.c.b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.c != null) {
            this.c.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.c != null) {
            this.c.a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (a) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.c != null) {
            this.c.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public void setSupportAllCaps(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
    }

    @Override // android.support.v4.g.o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    @Override // android.support.v4.g.o
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (a) {
            super.setTextSize(i, f);
        } else if (this.c != null) {
            this.c.a(i, f);
        }
    }
}