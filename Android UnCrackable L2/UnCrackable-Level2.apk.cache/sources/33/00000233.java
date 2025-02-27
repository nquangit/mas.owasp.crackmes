package android.support.v7.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
class az implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static az i;
    private static az j;
    private final View a;
    private final CharSequence b;
    private final Runnable c = new Runnable() { // from class: android.support.v7.widget.az.1
        @Override // java.lang.Runnable
        public void run() {
            az.this.a(false);
        }
    };
    private final Runnable d = new Runnable() { // from class: android.support.v7.widget.az.2
        @Override // java.lang.Runnable
        public void run() {
            az.this.a();
        }
    };
    private int e;
    private int f;
    private ba g;
    private boolean h;

    private az(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.a.setOnLongClickListener(this);
        this.a.setOnHoverListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (j == this) {
            j = null;
            if (this.g != null) {
                this.g.a();
                this.g = null;
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (i == this) {
            b(null);
        }
        this.a.removeCallbacks(this.d);
    }

    public static void a(View view, CharSequence charSequence) {
        if (i != null && i.a == view) {
            b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new az(view, charSequence);
            return;
        }
        if (j != null && j.a == view) {
            j.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        long longPressTimeout;
        if (android.support.v4.g.p.m(this.a)) {
            b(null);
            if (j != null) {
                j.a();
            }
            j = this;
            this.h = z;
            this.g = new ba(this.a.getContext());
            this.g.a(this.a, this.e, this.f, this.h, this.b);
            this.a.addOnAttachStateChangeListener(this);
            if (this.h) {
                longPressTimeout = 2500;
            } else {
                longPressTimeout = ((android.support.v4.g.p.f(this.a) & 1) == 1 ? 3000L : 15000L) - ViewConfiguration.getLongPressTimeout();
            }
            this.a.removeCallbacks(this.d);
            this.a.postDelayed(this.d, longPressTimeout);
        }
    }

    private void b() {
        this.a.postDelayed(this.c, ViewConfiguration.getLongPressTimeout());
    }

    private static void b(az azVar) {
        if (i != null) {
            i.c();
        }
        i = azVar;
        if (i != null) {
            i.b();
        }
    }

    private void c() {
        this.a.removeCallbacks(this.c);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.g == null || !this.h) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    a();
                }
            } else if (this.a.isEnabled() && this.g == null) {
                this.e = (int) motionEvent.getX();
                this.f = (int) motionEvent.getY();
                b(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.e = view.getWidth() / 2;
        this.f = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}