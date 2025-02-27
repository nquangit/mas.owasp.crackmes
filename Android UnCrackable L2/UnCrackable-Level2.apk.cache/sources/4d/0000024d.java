package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* loaded from: classes.dex */
public class i extends CheckBox implements android.support.v4.widget.l {
    private final k a;

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.checkboxStyle);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(at.a(context), attributeSet, i);
        this.a = new k(this);
        this.a.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.a != null ? this.a.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.a != null) {
            return this.a.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(android.support.v7.b.a.b.b(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.a != null) {
            this.a.c();
        }
    }

    @Override // android.support.v4.widget.l
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    @Override // android.support.v4.widget.l
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }
}