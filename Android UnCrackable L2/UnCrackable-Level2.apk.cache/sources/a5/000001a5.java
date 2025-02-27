package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.ab;
import android.support.v7.widget.ai;
import android.support.v7.widget.ay;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class ActionMenuItemView extends ab implements p.a, ActionMenuView.a, View.OnClickListener {
    j b;
    h.b c;
    b d;
    private CharSequence e;
    private Drawable f;
    private ai g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* loaded from: classes.dex */
    private class a extends ai {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // android.support.v7.widget.ai
        public s a() {
            if (ActionMenuItemView.this.d != null) {
                return ActionMenuItemView.this.d.a();
            }
            return null;
        }

        @Override // android.support.v7.widget.ai
        protected boolean b() {
            s a;
            return ActionMenuItemView.this.c != null && ActionMenuItemView.this.c.a(ActionMenuItemView.this.b) && (a = a()) != null && a.d();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract s a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.h = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionMenuItemView, i, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.k = -1;
        setSaveEnabled(false);
    }

    private boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void f() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.e);
        if (this.f != null && (!this.b.m() || (!this.h && !this.i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.e : null);
        CharSequence contentDescription = this.b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z3 ? null : this.b.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.b.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            ay.a(this, z3 ? null : this.b.getTitle());
        } else {
            ay.a(this, tooltipText);
        }
    }

    @Override // android.support.v7.view.menu.p.a
    public void a(j jVar, int i) {
        this.b = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.a((p.a) this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.g == null) {
            this.g = new a();
        }
    }

    @Override // android.support.v7.view.menu.p.a
    public boolean a() {
        return true;
    }

    public boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public boolean c() {
        return b() && this.b.getIcon() == null;
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public boolean d() {
        return b();
    }

    @Override // android.support.v7.view.menu.p.a
    public j getItemData() {
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.c != null) {
            this.c.a(this.b);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h = e();
        f();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean b2 = b();
        if (b2 && this.k >= 0) {
            super.setPadding(this.k, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.j) : this.j;
        if (mode != 1073741824 && this.j > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (b2 || this.f == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.b.hasSubMenu() && this.g != null && this.g.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.i != z) {
            this.i = z;
            if (this.b != null) {
                this.b.h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.l) {
                float f = this.l / intrinsicWidth;
                intrinsicWidth = this.l;
                intrinsicHeight = (int) (intrinsicHeight * f);
            }
            if (intrinsicHeight > this.l) {
                float f2 = this.l / intrinsicHeight;
                intrinsicHeight = this.l;
                intrinsicWidth = (int) (intrinsicWidth * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        f();
    }

    public void setItemInvoker(h.b bVar) {
        this.c = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.k = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.d = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.e = charSequence;
        f();
    }
}