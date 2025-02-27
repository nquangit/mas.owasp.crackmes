package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.g.c;
import android.support.v7.view.menu.p;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public final class j implements android.support.v4.c.a.b {
    private static String F;
    private static String G;
    private static String H;
    private static String I;
    private View A;
    private android.support.v4.g.c B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;
    h a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private CharSequence f;
    private CharSequence g;
    private Intent h;
    private char i;
    private char k;
    private Drawable m;
    private u o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private int z;
    private int j = 4096;
    private int l = 4096;
    private int n = 0;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private boolean D = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.z = 0;
        this.a = hVar;
        this.b = i2;
        this.c = i;
        this.d = i3;
        this.e = i4;
        this.f = charSequence;
        this.z = i5;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = android.support.v4.b.a.a.f(drawable).mutate();
            if (this.v) {
                android.support.v4.b.a.a.a(drawable, this.t);
            }
            if (this.w) {
                android.support.v4.b.a.a.a(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    /* renamed from: a */
    public android.support.v4.c.a.b setActionView(int i) {
        Context e = this.a.e();
        setActionView(LayoutInflater.from(e).inflate(i, (ViewGroup) new LinearLayout(e), false));
        return this;
    }

    @Override // android.support.v4.c.a.b
    public android.support.v4.c.a.b a(android.support.v4.g.c cVar) {
        if (this.B != null) {
            this.B.f();
        }
        this.A = null;
        this.B = cVar;
        this.a.b(true);
        if (this.B != null) {
            this.B.a(new c.b() { // from class: android.support.v7.view.menu.j.1
                @Override // android.support.v4.g.c.b
                public void a(boolean z) {
                    j.this.a.a(j.this);
                }
            });
        }
        return this;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    /* renamed from: a */
    public android.support.v4.c.a.b setActionView(View view) {
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && this.b > 0) {
            view.setId(this.b);
        }
        this.a.b(this);
        return this;
    }

    @Override // android.view.MenuItem
    /* renamed from: a */
    public android.support.v4.c.a.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.a.b(false);
        return this;
    }

    @Override // android.support.v4.c.a.b
    public android.support.v4.g.c a() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence a(p.a aVar) {
        return (aVar == null || !aVar.a()) ? getTitle() : getTitleCondensed();
    }

    public void a(u uVar) {
        this.o = uVar;
        uVar.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    public void a(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    /* renamed from: b */
    public android.support.v4.c.a.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    /* renamed from: b */
    public android.support.v4.c.a.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.a.b(false);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        int i = this.y;
        this.y = (z ? 2 : 0) | (this.y & (-3));
        if (i != this.y) {
            this.a.b(false);
        }
    }

    public boolean b() {
        if ((this.q == null || !this.q.onMenuItemClick(this)) && !this.a.a(this.a, this)) {
            if (this.p != null) {
                this.p.run();
                return true;
            }
            if (this.h != null) {
                try {
                    this.a.e().startActivity(this.h);
                    return true;
                } catch (ActivityNotFoundException e) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
                }
            }
            return this.B != null && this.B.d();
        }
        return true;
    }

    public int c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(boolean z) {
        int i = this.y;
        this.y = (z ? 0 : 8) | (this.y & (-9));
        return i != this.y;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        if (this.C == null || this.C.onMenuItemActionCollapse(this)) {
            return this.a.d(this);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char d() {
        return this.a.b() ? this.k : this.i;
    }

    public void d(boolean z) {
        this.y = z ? this.y | 32 : this.y & (-33);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        String str;
        char d = d();
        if (d == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(F);
        if (d == '\b') {
            str = H;
        } else if (d == '\n') {
            str = G;
        } else if (d != ' ') {
            sb.append(d);
            return sb.toString();
        } else {
            str = I;
        }
        sb.append(str);
        return sb.toString();
    }

    public void e(boolean z) {
        this.D = z;
        this.a.b(false);
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (n()) {
            if (this.C == null || this.C.onMenuItemActionExpand(this)) {
                return this.a.c(this);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.a.c() && d() != 0;
    }

    public boolean g() {
        return (this.y & 4) != 0;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public View getActionView() {
        if (this.A != null) {
            return this.A;
        }
        if (this.B != null) {
            this.A = this.B.a(this);
            return this.A;
        }
        return null;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.l;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.k;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable b;
        if (this.m != null) {
            b = this.m;
        } else if (this.n == 0) {
            return null;
        } else {
            b = android.support.v7.b.a.b.b(this.a.e(), this.n);
            this.n = 0;
            this.m = b;
        }
        return a(b);
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.h;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.g != null ? this.g : this.f;
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }

    public void h() {
        this.a.b(this);
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public boolean i() {
        return this.a.q();
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.B == null || !this.B.b()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.c();
    }

    public boolean j() {
        return (this.y & 32) == 32;
    }

    public boolean k() {
        return (this.z & 1) == 1;
    }

    public boolean l() {
        return (this.z & 2) == 2;
    }

    public boolean m() {
        return (this.z & 4) == 4;
    }

    public boolean n() {
        if ((this.z & 8) != 0) {
            if (this.A == null && this.B != null) {
                this.A = this.B.a(this);
            }
            return this.A != null;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.k == c) {
            return this;
        }
        this.k = Character.toLowerCase(c);
        this.a.b(false);
        return this;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.k == c && this.l == i) {
            return this;
        }
        this.k = Character.toLowerCase(c);
        this.l = KeyEvent.normalizeMetaState(i);
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.y;
        this.y = (z ? 1 : 0) | (this.y & (-2));
        if (i != this.y) {
            this.a.b(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.a.a((MenuItem) this);
        } else {
            b(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.y = z ? this.y | 16 : this.y & (-17);
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.m = null;
        this.n = i;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.n = 0;
        this.m = drawable;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.i == c) {
            return this;
        }
        this.i = c;
        this.a.b(false);
        return this;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.i == c && this.j == i) {
            return this;
        }
        this.i = c;
        this.j = KeyEvent.normalizeMetaState(i);
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.i = c;
        this.k = Character.toLowerCase(c2);
        this.a.b(false);
        return this;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.i = c;
        this.j = KeyEvent.normalizeMetaState(i);
        this.k = Character.toLowerCase(c2);
        this.l = KeyEvent.normalizeMetaState(i2);
        this.a.b(false);
        return this;
    }

    @Override // android.support.v4.c.a.b, android.view.MenuItem
    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.z = i;
                this.a.b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.a.e().getString(i));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f = charSequence;
        this.a.b(false);
        if (this.o != null) {
            this.o.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f;
        }
        this.a.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (c(z)) {
            this.a.a(this);
        }
        return this;
    }

    public String toString() {
        if (this.f != null) {
            return this.f.toString();
        }
        return null;
    }
}