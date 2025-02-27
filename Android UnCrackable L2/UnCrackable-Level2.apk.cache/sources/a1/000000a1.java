package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
class w implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;

    private w(View view, Runnable runnable) {
        this.a = view;
        this.b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static w a(View view, Runnable runnable) {
        w wVar = new w(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(wVar);
        view.addOnAttachStateChangeListener(wVar);
        return wVar;
    }

    public void a() {
        (this.b.isAlive() ? this.b : this.a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}