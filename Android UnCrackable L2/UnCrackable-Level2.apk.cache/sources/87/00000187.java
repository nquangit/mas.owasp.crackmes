package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.ae;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends android.support.v7.app.a {
    ae a;
    Window.Callback b;
    private boolean c;
    private boolean d;
    private ArrayList<a.b> e;
    private final Runnable f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements o.a {
        private boolean b;

        a() {
        }

        @Override // android.support.v7.view.menu.o.a
        public void a(android.support.v7.view.menu.h hVar, boolean z) {
            if (this.b) {
                return;
            }
            this.b = true;
            m.this.a.n();
            if (m.this.b != null) {
                m.this.b.onPanelClosed(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
            }
            this.b = false;
        }

        @Override // android.support.v7.view.menu.o.a
        public boolean a(android.support.v7.view.menu.h hVar) {
            if (m.this.b != null) {
                m.this.b.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements h.a {
        b() {
        }

        @Override // android.support.v7.view.menu.h.a
        public void a(android.support.v7.view.menu.h hVar) {
            if (m.this.b != null) {
                if (m.this.a.i()) {
                    m.this.b.onPanelClosed(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
                } else if (m.this.b.onPreparePanel(0, null, hVar)) {
                    m.this.b.onMenuOpened(a.j.AppCompatTheme_tooltipFrameBackground, hVar);
                }
            }
        }

        @Override // android.support.v7.view.menu.h.a
        public boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            return false;
        }
    }

    private Menu h() {
        if (!this.c) {
            this.a.a(new a(), new b());
            this.c = true;
        }
        return this.a.q();
    }

    @Override // android.support.v7.app.a
    public int a() {
        return this.a.o();
    }

    @Override // android.support.v7.app.a
    public void a(float f) {
        android.support.v4.g.p.a(this.a.a(), f);
    }

    @Override // android.support.v7.app.a
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // android.support.v7.app.a
    public void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    @Override // android.support.v7.app.a
    public void a(boolean z) {
    }

    @Override // android.support.v7.app.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu h = h();
        if (h != null) {
            h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return h.performShortcut(i, keyEvent, 0);
        }
        return false;
    }

    @Override // android.support.v7.app.a
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    @Override // android.support.v7.app.a
    public Context b() {
        return this.a.b();
    }

    @Override // android.support.v7.app.a
    public void c(boolean z) {
    }

    @Override // android.support.v7.app.a
    public boolean c() {
        return this.a.k();
    }

    @Override // android.support.v7.app.a
    public void d(boolean z) {
    }

    @Override // android.support.v7.app.a
    public boolean d() {
        return this.a.l();
    }

    @Override // android.support.v7.app.a
    public void e(boolean z) {
        if (z == this.d) {
            return;
        }
        this.d = z;
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).a(z);
        }
    }

    @Override // android.support.v7.app.a
    public boolean e() {
        this.a.a().removeCallbacks(this.f);
        android.support.v4.g.p.a(this.a.a(), this.f);
        return true;
    }

    @Override // android.support.v7.app.a
    public boolean f() {
        if (this.a.c()) {
            this.a.d();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.a
    public void g() {
        this.a.a().removeCallbacks(this.f);
    }
}