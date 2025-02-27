package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.support.v7.view.menu.p;
import android.support.v7.widget.aw;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements p.a {
    private j a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private Drawable h;
    private int i;
    private Context j;
    private boolean k;
    private Drawable l;
    private int m;
    private LayoutInflater n;
    private boolean o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        aw a = aw.a(getContext(), attributeSet, a.j.MenuView, i, 0);
        this.h = a.a(a.j.MenuView_android_itemBackground);
        this.i = a.g(a.j.MenuView_android_itemTextAppearance, -1);
        this.k = a.a(a.j.MenuView_preserveIconSpacing, false);
        this.j = context;
        this.l = a.a(a.j.MenuView_subMenuArrow);
        a.a();
    }

    private void b() {
        this.b = (ImageView) getInflater().inflate(a.g.abc_list_menu_item_icon, (ViewGroup) this, false);
        addView(this.b, 0);
    }

    private void c() {
        this.c = (RadioButton) getInflater().inflate(a.g.abc_list_menu_item_radio, (ViewGroup) this, false);
        addView(this.c);
    }

    private void d() {
        this.e = (CheckBox) getInflater().inflate(a.g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        addView(this.e);
    }

    private LayoutInflater getInflater() {
        if (this.n == null) {
            this.n = LayoutInflater.from(getContext());
        }
        return this.n;
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.g != null) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.support.v7.view.menu.p.a
    public void a(j jVar, int i) {
        this.a = jVar;
        this.m = i;
        setVisibility(jVar.isVisible() ? 0 : 8);
        setTitle(jVar.a((p.a) this));
        setCheckable(jVar.isCheckable());
        a(jVar.f(), jVar.d());
        setIcon(jVar.getIcon());
        setEnabled(jVar.isEnabled());
        setSubMenuArrowVisible(jVar.hasSubMenu());
        setContentDescription(jVar.getContentDescription());
    }

    public void a(boolean z, char c) {
        int i = (z && this.a.f()) ? 0 : 8;
        if (i == 0) {
            this.f.setText(this.a.e());
        }
        if (this.f.getVisibility() != i) {
            this.f.setVisibility(i);
        }
    }

    @Override // android.support.v7.view.menu.p.a
    public boolean a() {
        return false;
    }

    @Override // android.support.v7.view.menu.p.a
    public j getItemData() {
        return this.a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        android.support.v4.g.p.a(this, this.h);
        this.d = (TextView) findViewById(a.f.title);
        if (this.i != -1) {
            this.d.setTextAppearance(this.j, this.i);
        }
        this.f = (TextView) findViewById(a.f.shortcut);
        this.g = (ImageView) findViewById(a.f.submenuarrow);
        if (this.g != null) {
            this.g.setImageDrawable(this.l);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.b != null && this.k) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.c == null && this.e == null) {
            return;
        }
        if (this.a.g()) {
            if (this.c == null) {
                c();
            }
            compoundButton = this.c;
            compoundButton2 = this.e;
        } else {
            if (this.e == null) {
                d();
            }
            compoundButton = this.e;
            compoundButton2 = this.c;
        }
        if (!z) {
            if (this.e != null) {
                this.e.setVisibility(8);
            }
            if (this.c != null) {
                this.c.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.a.isChecked());
        int i = z ? 0 : 8;
        if (compoundButton.getVisibility() != i) {
            compoundButton.setVisibility(i);
        }
        if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
            return;
        }
        compoundButton2.setVisibility(8);
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.a.g()) {
            if (this.c == null) {
                c();
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                d();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.o = z;
        this.k = z;
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.a.i() || this.o;
        if (z || this.k) {
            if (this.b == null && drawable == null && !this.k) {
                return;
            }
            if (this.b == null) {
                b();
            }
            if (drawable == null && !this.k) {
                this.b.setVisibility(8);
                return;
            }
            ImageView imageView = this.b;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i;
        TextView textView;
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() == 0) {
                return;
            }
            textView = this.d;
            i = 0;
        } else {
            i = 8;
            if (this.d.getVisibility() == 8) {
                return;
            }
            textView = this.d;
        }
        textView.setVisibility(i);
    }
}