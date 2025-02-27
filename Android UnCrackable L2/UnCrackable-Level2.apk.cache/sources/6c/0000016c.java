package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.widget.aw;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f extends e {
    private static boolean m;
    private static final boolean n;
    private static final int[] o;
    final Context a;
    final Window b;
    final Window.Callback c;
    final Window.Callback d;
    final d e;
    android.support.v7.app.a f;
    MenuInflater g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private CharSequence p;
    private boolean q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends android.support.v7.view.i {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof android.support.v7.view.menu.h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.b(i, menu);
            return true;
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.a(i, menu);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            android.support.v7.view.menu.h hVar = menu instanceof android.support.v7.view.menu.h ? (android.support.v7.view.menu.h) menu : null;
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar != null) {
                hVar.c(false);
            }
            return onPreparePanel;
        }
    }

    static {
        n = Build.VERSION.SDK_INT < 21;
        if (n && !m) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: android.support.v7.app.f.1
                private boolean a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }

                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    if (!a(th)) {
                        defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                        return;
                    }
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                }
            });
            m = true;
        }
        o = new int[]{16842836};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, Window window, d dVar) {
        this.a = context;
        this.b = window;
        this.e = dVar;
        this.c = this.b.getCallback();
        if (this.c instanceof a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.d = a(this.c);
        this.b.setCallback(this.d);
        aw a2 = aw.a(context, (AttributeSet) null, o);
        Drawable b = a2.b(0);
        if (b != null) {
            this.b.setBackgroundDrawable(b);
        }
        a2.a();
    }

    @Override // android.support.v7.app.e
    public android.support.v7.app.a a() {
        l();
        return this.f;
    }

    abstract android.support.v7.view.b a(b.a aVar);

    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    abstract void a(int i, Menu menu);

    @Override // android.support.v7.app.e
    public final void a(CharSequence charSequence) {
        this.p = charSequence;
        b(charSequence);
    }

    abstract boolean a(int i, KeyEvent keyEvent);

    abstract boolean a(KeyEvent keyEvent);

    @Override // android.support.v7.app.e
    public MenuInflater b() {
        if (this.g == null) {
            l();
            this.g = new android.support.v7.view.g(this.f != null ? this.f.b() : this.a);
        }
        return this.g;
    }

    abstract void b(CharSequence charSequence);

    abstract boolean b(int i, Menu menu);

    @Override // android.support.v7.app.e
    public void c() {
        this.q = true;
    }

    @Override // android.support.v7.app.e
    public void c(Bundle bundle) {
    }

    @Override // android.support.v7.app.e
    public void d() {
        this.q = false;
    }

    @Override // android.support.v7.app.e
    public void g() {
        this.r = true;
    }

    @Override // android.support.v7.app.e
    public boolean i() {
        return false;
    }

    abstract void l();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final android.support.v7.app.a m() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context n() {
        android.support.v7.app.a a2 = a();
        Context b = a2 != null ? a2.b() : null;
        return b == null ? this.a : b;
    }

    public boolean o() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean p() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Window.Callback q() {
        return this.b.getCallback();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CharSequence r() {
        return this.c instanceof Activity ? ((Activity) this.c).getTitle() : this.p;
    }
}