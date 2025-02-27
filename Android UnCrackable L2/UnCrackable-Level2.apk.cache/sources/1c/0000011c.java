package android.support.v4.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class s {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    /* loaded from: classes.dex */
    static class a implements t {
        s a;
        boolean b;

        a(s sVar) {
            this.a = sVar;
        }

        @Override // android.support.v4.g.t
        public void a(View view) {
            this.b = false;
            if (this.a.c > -1) {
                view.setLayerType(2, null);
            }
            if (this.a.a != null) {
                Runnable runnable = this.a.a;
                this.a.a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            t tVar = tag instanceof t ? (t) tag : null;
            if (tVar != null) {
                tVar.a(view);
            }
        }

        @Override // android.support.v4.g.t
        public void b(View view) {
            if (this.a.c > -1) {
                view.setLayerType(this.a.c, null);
                this.a.c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                if (this.a.b != null) {
                    Runnable runnable = this.a.b;
                    this.a.b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                t tVar = tag instanceof t ? (t) tag : null;
                if (tVar != null) {
                    tVar.b(view);
                }
                this.b = true;
            }
        }

        @Override // android.support.v4.g.t
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            t tVar = tag instanceof t ? (t) tag : null;
            if (tVar != null) {
                tVar.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(View view) {
        this.d = new WeakReference<>(view);
    }

    private void a(final View view, final t tVar) {
        if (tVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: android.support.v4.g.s.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    tVar.c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    tVar.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    tVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public long a() {
        View view = this.d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public s a(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public s a(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public s a(t tVar) {
        View view = this.d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, tVar);
                tVar = new a(this);
            }
            a(view, tVar);
        }
        return this;
    }

    public s a(final v vVar) {
        final View view = this.d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(vVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.g.s.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    vVar.a(view);
                }
            } : null);
        }
        return this;
    }

    public s a(Interpolator interpolator) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public s b(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public s b(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}