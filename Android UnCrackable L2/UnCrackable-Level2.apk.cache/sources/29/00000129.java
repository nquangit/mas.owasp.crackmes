package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.g.p;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    final View b;
    boolean c;
    boolean d;
    boolean e;
    private Runnable g;
    private int j;
    private int k;
    private boolean o;
    private boolean p;
    private boolean q;
    final C0009a a = new C0009a();
    private final Interpolator f = new AccelerateInterpolator();
    private float[] h = {0.0f, 0.0f};
    private float[] i = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] l = {0.0f, 0.0f};
    private float[] m = {0.0f, 0.0f};
    private float[] n = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: android.support.v4.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0009a {
        private int a;
        private int b;
        private float c;
        private float d;
        private float j;
        private int k;
        private long e = Long.MIN_VALUE;
        private long i = -1;
        private long f = 0;
        private int g = 0;
        private int h = 0;

        C0009a() {
        }

        private float a(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        private float a(long j) {
            if (j < this.e) {
                return 0.0f;
            }
            if (this.i < 0 || j < this.i) {
                return a.a(((float) (j - this.e)) / this.a, 0.0f, 1.0f) * 0.5f;
            }
            return (1.0f - this.j) + (this.j * a.a(((float) (j - this.i)) / this.k, 0.0f, 1.0f));
        }

        public void a() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void a(float f, float f2) {
            this.c = f;
            this.d = f2;
        }

        public void a(int i) {
            this.a = i;
        }

        public void b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.e), 0, this.b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void b(int i) {
            this.b = i;
        }

        public boolean c() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void d() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = a(a(currentAnimationTimeMillis));
            this.f = currentAnimationTimeMillis;
            float f = ((float) (currentAnimationTimeMillis - this.f)) * a;
            this.g = (int) (this.c * f);
            this.h = (int) (f * this.d);
        }

        public int e() {
            return (int) (this.c / Math.abs(this.c));
        }

        public int f() {
            return (int) (this.d / Math.abs(this.d));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.e) {
                if (a.this.c) {
                    a.this.c = false;
                    a.this.a.a();
                }
                C0009a c0009a = a.this.a;
                if (c0009a.c() || !a.this.a()) {
                    a.this.e = false;
                    return;
                }
                if (a.this.d) {
                    a.this.d = false;
                    a.this.b();
                }
                c0009a.d();
                a.this.a(c0009a.g(), c0009a.h());
                p.a(a.this.b, this);
            }
        }
    }

    public a(View view) {
        this.b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float f = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        a(f, f);
        float f2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        b(f2, f2);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(500);
        d(500);
    }

    static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private float a(float f, float f2, float f3, float f4) {
        float interpolation;
        float a = a(f * f2, 0.0f, f3);
        float f5 = f(f2 - f4, a) - f(f4, a);
        if (f5 < 0.0f) {
            interpolation = -this.f.getInterpolation(-f5);
        } else if (f5 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f.getInterpolation(f5);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    private float a(int i, float f, float f2, float f3) {
        float a = a(this.h[i], f2, this.i[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.l[i];
        float f5 = this.m[i];
        float f6 = this.n[i];
        float f7 = f4 * f3;
        return a > 0.0f ? a(a * f7, f5, f6) : -a((-a) * f7, f5, f6);
    }

    static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void c() {
        if (this.g == null) {
            this.g = new b();
        }
        this.e = true;
        this.c = true;
        if (this.o || this.k <= 0) {
            this.g.run();
        } else {
            p.a(this.b, this.g, this.k);
        }
        this.o = true;
    }

    private void d() {
        if (this.c) {
            this.e = false;
        } else {
            this.a.b();
        }
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.j) {
            case 0:
            case 1:
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.e && this.j == 1) {
                        return 1.0f;
                    }
                }
                break;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                break;
        }
        return 0.0f;
    }

    public a a(float f, float f2) {
        this.n[0] = f / 1000.0f;
        this.n[1] = f2 / 1000.0f;
        return this;
    }

    public a a(int i) {
        this.j = i;
        return this;
    }

    public a a(boolean z) {
        if (this.p && !z) {
            d();
        }
        this.p = z;
        return this;
    }

    public abstract void a(int i, int i2);

    boolean a() {
        C0009a c0009a = this.a;
        int f = c0009a.f();
        int e = c0009a.e();
        return (f != 0 && f(f)) || (e != 0 && e(e));
    }

    public a b(float f, float f2) {
        this.m[0] = f / 1000.0f;
        this.m[1] = f2 / 1000.0f;
        return this;
    }

    public a b(int i) {
        this.k = i;
        return this;
    }

    void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.b.onTouchEvent(obtain);
        obtain.recycle();
    }

    public a c(float f, float f2) {
        this.l[0] = f / 1000.0f;
        this.l[1] = f2 / 1000.0f;
        return this;
    }

    public a c(int i) {
        this.a.a(i);
        return this;
    }

    public a d(float f, float f2) {
        this.h[0] = f;
        this.h[1] = f2;
        return this;
    }

    public a d(int i) {
        this.a.b(i);
        return this;
    }

    public a e(float f, float f2) {
        this.i[0] = f;
        this.i[1] = f2;
        return this;
    }

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.p) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.d = true;
                    this.o = false;
                    this.a.a(a(0, motionEvent.getX(), view.getWidth(), this.b.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.b.getHeight()));
                    if (!this.e && a()) {
                        c();
                        break;
                    }
                    break;
                case 1:
                case 3:
                    d();
                    break;
                case 2:
                    this.a.a(a(0, motionEvent.getX(), view.getWidth(), this.b.getWidth()), a(1, motionEvent.getY(), view.getHeight(), this.b.getHeight()));
                    if (!this.e) {
                        c();
                        break;
                    }
                    break;
            }
            return this.q && this.e;
        }
        return false;
    }
}