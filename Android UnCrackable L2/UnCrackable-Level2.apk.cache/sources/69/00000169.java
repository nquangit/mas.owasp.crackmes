package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.v;
import android.support.v7.view.b;
import android.support.v7.widget.bb;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* loaded from: classes.dex */
public class c extends android.support.v4.app.h implements aa.a, d {
    private e m;
    private int n = 0;
    private Resources o;

    private boolean a(int i, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.support.v7.app.d
    public android.support.v7.view.b a(b.a aVar) {
        return null;
    }

    public void a(aa aaVar) {
        aaVar.a((Activity) this);
    }

    @Override // android.support.v7.app.d
    public void a(android.support.v7.view.b bVar) {
    }

    public boolean a(Intent intent) {
        return v.a(this, intent);
    }

    @Override // android.support.v4.app.aa.a
    public Intent a_() {
        return v.a(this);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j().b(view, layoutParams);
    }

    public void b(Intent intent) {
        v.b(this, intent);
    }

    public void b(aa aaVar) {
    }

    @Override // android.support.v7.app.d
    public void b(android.support.v7.view.b bVar) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a g = g();
        if (getWindow().hasFeature(0)) {
            if (g == null || !g.d()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // android.support.v4.app.h
    public void d() {
        j().f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a g = g();
        if (keyCode == 82 && g != null && g.a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) j().a(i);
    }

    public a g() {
        return j().a();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return j().b();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.o == null && bb.a()) {
            this.o = new bb(this, super.getResources());
        }
        return this.o == null ? super.getResources() : this.o;
    }

    public boolean h() {
        Intent a_ = a_();
        if (a_ != null) {
            if (!a(a_)) {
                b(a_);
                return true;
            }
            aa a = aa.a((Context) this);
            a(a);
            b(a);
            a.a();
            try {
                android.support.v4.app.a.a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public void i() {
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        j().f();
    }

    public e j() {
        if (this.m == null) {
            this.m = e.a(this, this);
        }
        return this.m;
    }

    @Override // android.support.v4.app.h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j().a(configuration);
        if (this.o != null) {
            this.o.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.h, android.support.v4.app.z, android.app.Activity
    public void onCreate(Bundle bundle) {
        e j = j();
        j.h();
        j.a(bundle);
        if (j.i() && this.n != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.n, false);
            } else {
                setTheme(this.n);
            }
        }
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.h, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        j().g();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.h, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a g = g();
        if (menuItem.getItemId() != 16908332 || g == null || (g.a() & 4) == 0) {
            return false;
        }
        return h();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // android.support.v4.app.h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        j().b(bundle);
    }

    @Override // android.support.v4.app.h, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        j().e();
    }

    @Override // android.support.v4.app.h, android.support.v4.app.z, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j().c(bundle);
    }

    @Override // android.support.v4.app.h, android.app.Activity
    protected void onStart() {
        super.onStart();
        j().c();
    }

    @Override // android.support.v4.app.h, android.app.Activity
    protected void onStop() {
        super.onStop();
        j().d();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        j().a(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a g = g();
        if (getWindow().hasFeature(0)) {
            if (g == null || !g.c()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        j().b(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        j().a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j().a(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        this.n = i;
    }
}