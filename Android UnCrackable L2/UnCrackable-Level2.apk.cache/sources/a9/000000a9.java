package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class d extends Drawable implements Drawable.Callback, android.support.v4.b.a.b, c {
    static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    a b;
    Drawable c;
    private int d;
    private PorterDuff.Mode e;
    private boolean f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static abstract class a extends Drawable.ConstantState {
        int a;
        Drawable.ConstantState b;
        ColorStateList c;
        PorterDuff.Mode d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, Resources resources) {
            this.c = null;
            this.d = d.a;
            if (aVar != null) {
                this.a = aVar.a;
                this.b = aVar.b;
                this.c = aVar.c;
                this.d = aVar.d;
            }
        }

        boolean a() {
            return this.b != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a | (this.b != null ? this.b.getChangingConfigurations() : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends a {
        b(a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.b.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Drawable drawable) {
        this.b = b();
        a(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Resources resources) {
        this.b = aVar;
        a(resources);
    }

    private void a(Resources resources) {
        if (this.b == null || this.b.b == null) {
            return;
        }
        a(this.b.b.newDrawable(resources));
    }

    private boolean a(int[] iArr) {
        if (c()) {
            ColorStateList colorStateList = this.b.c;
            PorterDuff.Mode mode = this.b.d;
            if (colorStateList == null || mode == null) {
                this.f = false;
                clearColorFilter();
            } else {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.f || colorForState != this.d || mode != this.e) {
                    setColorFilter(colorForState, mode);
                    this.d = colorForState;
                    this.e = mode;
                    this.f = true;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.support.v4.b.a.c
    public final Drawable a() {
        return this.c;
    }

    @Override // android.support.v4.b.a.c
    public final void a(Drawable drawable) {
        if (this.c != null) {
            this.c.setCallback(null);
        }
        this.c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.b != null) {
                this.b.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    a b() {
        return new b(this.b, null);
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.c.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | (this.b != null ? this.b.getChangingConfigurations() : 0) | this.c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.b == null || !this.b.a()) {
            return null;
        }
        this.b.a = getChangingConfigurations();
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.c.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.c.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.c.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.c.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.c.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.c.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = (!c() || this.b == null) ? null : this.b.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.c.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.g && super.mutate() == this) {
            this.b = b();
            if (this.c != null) {
                this.c.mutate();
            }
            if (this.b != null) {
                this.b.b = this.c != null ? this.c.getConstantState() : null;
            }
            this.g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.c.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.c.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.c.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.c.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.c.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.b
    public void setTintList(ColorStateList colorStateList) {
        this.b.c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.b.d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.c.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}