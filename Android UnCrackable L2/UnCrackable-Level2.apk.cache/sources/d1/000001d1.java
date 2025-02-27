package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.h;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class u extends h implements SubMenu {
    private h d;
    private j e;

    public u(Context context, h hVar, j jVar) {
        super(context);
        this.d = hVar;
        this.e = jVar;
    }

    @Override // android.support.v7.view.menu.h
    public String a() {
        int itemId = this.e != null ? this.e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.a() + ":" + itemId;
    }

    @Override // android.support.v7.view.menu.h
    public void a(h.a aVar) {
        this.d.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.view.menu.h
    public boolean a(h hVar, MenuItem menuItem) {
        return super.a(hVar, menuItem) || this.d.a(hVar, menuItem);
    }

    @Override // android.support.v7.view.menu.h
    public boolean b() {
        return this.d.b();
    }

    @Override // android.support.v7.view.menu.h
    public boolean c() {
        return this.d.c();
    }

    @Override // android.support.v7.view.menu.h
    public boolean c(j jVar) {
        return this.d.c(jVar);
    }

    @Override // android.support.v7.view.menu.h
    public boolean d(j jVar) {
        return this.d.d(jVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.e;
    }

    @Override // android.support.v7.view.menu.h
    public h p() {
        return this.d.p();
    }

    public Menu s() {
        return this.d;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.e(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.d(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.a(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }

    @Override // android.support.v7.view.menu.h, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }
}