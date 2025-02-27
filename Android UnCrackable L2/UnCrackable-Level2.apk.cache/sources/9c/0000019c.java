package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.b;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements h.a {
    private Context a;
    private ActionBarContextView b;
    private b.a c;
    private WeakReference<View> d;
    private boolean e;
    private boolean f;
    private android.support.v7.view.menu.h g;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.a = context;
        this.b = actionBarContextView;
        this.c = aVar;
        this.g = new android.support.v7.view.menu.h(actionBarContextView.getContext()).a(1);
        this.g.a(this);
        this.f = z;
    }

    @Override // android.support.v7.view.b
    public MenuInflater a() {
        return new g(this.b.getContext());
    }

    @Override // android.support.v7.view.b
    public void a(int i) {
        b(this.a.getString(i));
    }

    @Override // android.support.v7.view.menu.h.a
    public void a(android.support.v7.view.menu.h hVar) {
        d();
        this.b.a();
    }

    @Override // android.support.v7.view.b
    public void a(View view) {
        this.b.setCustomView(view);
        this.d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // android.support.v7.view.b
    public void a(CharSequence charSequence) {
        this.b.setSubtitle(charSequence);
    }

    @Override // android.support.v7.view.b
    public void a(boolean z) {
        super.a(z);
        this.b.setTitleOptional(z);
    }

    @Override // android.support.v7.view.menu.h.a
    public boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
        return this.c.a(this, menuItem);
    }

    @Override // android.support.v7.view.b
    public Menu b() {
        return this.g;
    }

    @Override // android.support.v7.view.b
    public void b(int i) {
        a((CharSequence) this.a.getString(i));
    }

    @Override // android.support.v7.view.b
    public void b(CharSequence charSequence) {
        this.b.setTitle(charSequence);
    }

    @Override // android.support.v7.view.b
    public void c() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.b.sendAccessibilityEvent(32);
        this.c.a(this);
    }

    @Override // android.support.v7.view.b
    public void d() {
        this.c.b(this, this.g);
    }

    @Override // android.support.v7.view.b
    public CharSequence f() {
        return this.b.getTitle();
    }

    @Override // android.support.v7.view.b
    public CharSequence g() {
        return this.b.getSubtitle();
    }

    @Override // android.support.v7.view.b
    public boolean h() {
        return this.b.d();
    }

    @Override // android.support.v7.view.b
    public View i() {
        if (this.d != null) {
            return this.d.get();
        }
        return null;
    }
}