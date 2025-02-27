package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.g;
import android.support.v4.app.l;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends l implements LayoutInflater.Factory2 {
    static final Interpolator F = new DecelerateInterpolator(2.5f);
    static final Interpolator G = new DecelerateInterpolator(1.5f);
    static final Interpolator H = new AccelerateInterpolator(2.5f);
    static final Interpolator I = new AccelerateInterpolator(1.5f);
    static boolean a = false;
    static Field q;
    ArrayList<h> C;
    n D;
    ArrayList<g> b;
    boolean c;
    SparseArray<android.support.v4.app.g> f;
    ArrayList<android.support.v4.app.c> g;
    ArrayList<android.support.v4.app.g> h;
    ArrayList<android.support.v4.app.c> i;
    ArrayList<Integer> j;
    ArrayList<l.b> k;
    k m;
    i n;
    android.support.v4.app.g o;
    android.support.v4.app.g p;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    ArrayList<android.support.v4.app.c> x;
    ArrayList<Boolean> y;
    ArrayList<android.support.v4.app.g> z;
    int d = 0;
    final ArrayList<android.support.v4.app.g> e = new ArrayList<>();
    private final CopyOnWriteArrayList<android.support.v4.f.i<l.a, Boolean>> J = new CopyOnWriteArrayList<>();
    int l = 0;
    Bundle A = null;
    SparseArray<Parcelable> B = null;
    Runnable E = new Runnable() { // from class: android.support.v4.app.m.1
        @Override // java.lang.Runnable
        public void run() {
            m.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends b {
        View a;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.a = view;
        }

        @Override // android.support.v4.app.m.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (android.support.v4.g.p.m(this.a) || Build.VERSION.SDK_INT >= 24) {
                this.a.post(new Runnable() { // from class: android.support.v4.app.m.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a.setLayerType(0, null);
                    }
                });
            } else {
                this.a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* loaded from: classes.dex */
    private static class b implements Animation.AnimationListener {
        private final Animation.AnimationListener a;

        private b(Animation.AnimationListener animationListener) {
            this.a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.a != null) {
                this.a.onAnimationStart(animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        public final Animation a;
        public final Animator b;

        private c(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        private c(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends AnimatorListenerAdapter {
        View a;

        d(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setLayerType(0, null);
            animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends AnimationSet implements Runnable {
        private final ViewGroup a;
        private final View b;
        private boolean c;
        private boolean d;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.a = viewGroup;
            this.b = view;
            addAnimation(animation);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                w.a(this.a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                w.a(this.a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.endViewTransition(this.b);
            this.d = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f {
        public static final int[] a = {16842755, 16842960, 16842961};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface g {
        boolean a(ArrayList<android.support.v4.app.c> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h implements g.c {
        private final boolean a;
        private final android.support.v4.app.c b;
        private int c;

        h(android.support.v4.app.c cVar, boolean z) {
            this.a = z;
            this.b = cVar;
        }

        @Override // android.support.v4.app.g.c
        public void a() {
            this.c--;
            if (this.c != 0) {
                return;
            }
            this.b.a.y();
        }

        @Override // android.support.v4.app.g.c
        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            boolean z = this.c > 0;
            m mVar = this.b.a;
            int size = mVar.e.size();
            for (int i = 0; i < size; i++) {
                android.support.v4.app.g gVar = mVar.e.get(i);
                gVar.a((g.c) null);
                if (z && gVar.W()) {
                    gVar.C();
                }
            }
            this.b.a.a(this.b, this.a, !z, true);
        }

        public void e() {
            this.b.a.a(this.b, this.a, false, false);
        }
    }

    private void A() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private void B() {
        int size = this.f == null ? 0 : this.f.size();
        for (int i = 0; i < size; i++) {
            android.support.v4.app.g valueAt = this.f.valueAt(i);
            if (valueAt != null) {
                if (valueAt.T() != null) {
                    int V = valueAt.V();
                    View T = valueAt.T();
                    Animation animation = T.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        T.clearAnimation();
                    }
                    valueAt.a((View) null);
                    a(valueAt, V, 0, 0, false);
                } else if (valueAt.U() != null) {
                    valueAt.U().end();
                }
            }
        }
    }

    private void C() {
        if (this.f != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                if (this.f.valueAt(size) == null) {
                    this.f.delete(this.f.keyAt(size));
                }
            }
        }
    }

    private int a(ArrayList<android.support.v4.app.c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, android.support.v4.f.b<android.support.v4.app.g> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            android.support.v4.app.c cVar = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (cVar.c() && !cVar.a(arrayList, i4 + 1, i2)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                h hVar = new h(cVar, booleanValue);
                this.C.add(hVar);
                cVar.a(hVar);
                if (booleanValue) {
                    cVar.b();
                } else {
                    cVar.a(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, cVar);
                }
                b(bVar);
            }
        }
        return i3;
    }

    static c a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220L);
        return new c(alphaAnimation);
    }

    static c a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(F);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(G);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new c(animationSet);
    }

    private static Animation.AnimationListener a(Animation animation) {
        String str;
        String str2;
        try {
            if (q == null) {
                q = Animation.class.getDeclaredField("mListener");
                q.setAccessible(true);
            }
            return (Animation.AnimationListener) q.get(animation);
        } catch (IllegalAccessException e2) {
            e = e2;
            str = "FragmentManager";
            str2 = "Cannot access Animation's mListener field";
            Log.e(str, str2, e);
            return null;
        } catch (NoSuchFieldException e3) {
            e = e3;
            str = "FragmentManager";
            str2 = "No field with the name mListener is found in Animation class";
            Log.e(str, str2, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.support.v4.app.c cVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            cVar.a(z3);
        } else {
            cVar.b();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(cVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            r.a(this, (ArrayList<android.support.v4.app.c>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.l, true);
        }
        if (this.f != null) {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                android.support.v4.app.g valueAt = this.f.valueAt(i);
                if (valueAt != null && valueAt.J != null && valueAt.P && cVar.b(valueAt.z)) {
                    if (valueAt.R > 0.0f) {
                        valueAt.J.setAlpha(valueAt.R);
                    }
                    if (z3) {
                        valueAt.R = 0.0f;
                    } else {
                        valueAt.R = -1.0f;
                        valueAt.P = false;
                    }
                }
            }
        }
    }

    private void a(final android.support.v4.app.g gVar, c cVar, int i) {
        final View view = gVar.J;
        final ViewGroup viewGroup = gVar.I;
        viewGroup.startViewTransition(view);
        gVar.b(i);
        if (cVar.a != null) {
            e eVar = new e(cVar.a, viewGroup, view);
            gVar.a(gVar.J);
            eVar.setAnimationListener(new b(a(eVar)) { // from class: android.support.v4.app.m.2
                @Override // android.support.v4.app.m.b, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() { // from class: android.support.v4.app.m.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (gVar.T() != null) {
                                gVar.a((View) null);
                                m.this.a(gVar, gVar.V(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            b(view, cVar);
            gVar.J.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.b;
        gVar.a(cVar.b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.v4.app.m.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator U = gVar.U();
                gVar.a((Animator) null);
                if (U == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                m.this.a(gVar, gVar.V(), 0, 0, false);
            }
        });
        animator.setTarget(gVar.J);
        b(gVar.J, cVar);
        animator.start();
    }

    private static void a(n nVar) {
        if (nVar == null) {
            return;
        }
        List<android.support.v4.app.g> a2 = nVar.a();
        if (a2 != null) {
            for (android.support.v4.app.g gVar : a2) {
                gVar.E = true;
            }
        }
        List<n> b2 = nVar.b();
        if (b2 != null) {
            for (n nVar2 : b2) {
                a(nVar2);
            }
        }
    }

    private void a(android.support.v4.f.b<android.support.v4.app.g> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            android.support.v4.app.g b2 = bVar.b(i);
            if (!b2.l) {
                View k = b2.k();
                b2.R = k.getAlpha();
                k.setAlpha(0.0f);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new android.support.v4.f.e("FragmentManager"));
        try {
            if (this.m != null) {
                this.m.a("  ", null, printWriter, new String[0]);
            } else {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            }
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
        }
        throw runtimeException;
    }

    private void a(ArrayList<android.support.v4.app.c> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        int size = this.C == null ? 0 : this.C.size();
        int i = 0;
        while (i < size) {
            h hVar = this.C.get(i);
            if (arrayList == null || hVar.a || (indexOf2 = arrayList.indexOf(hVar.b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (hVar.c() || (arrayList != null && hVar.b.a(arrayList, 0, arrayList.size()))) {
                    this.C.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || hVar.a || (indexOf = arrayList.indexOf(hVar.b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        hVar.d();
                    }
                }
                i++;
            }
            hVar.e();
            i++;
        }
    }

    private void a(ArrayList<android.support.v4.app.c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4 = i;
        boolean z = arrayList.get(i4).t;
        if (this.z == null) {
            this.z = new ArrayList<>();
        } else {
            this.z.clear();
        }
        this.z.addAll(this.e);
        android.support.v4.app.g v = v();
        boolean z2 = false;
        for (int i5 = i4; i5 < i2; i5++) {
            android.support.v4.app.c cVar = arrayList.get(i5);
            v = !arrayList2.get(i5).booleanValue() ? cVar.a(this.z, v) : cVar.b(this.z, v);
            z2 = z2 || cVar.i;
        }
        this.z.clear();
        if (!z) {
            r.a(this, arrayList, arrayList2, i, i2, false);
        }
        b(arrayList, arrayList2, i, i2);
        if (z) {
            android.support.v4.f.b<android.support.v4.app.g> bVar = new android.support.v4.f.b<>();
            b(bVar);
            int a2 = a(arrayList, arrayList2, i, i2, bVar);
            a(bVar);
            i3 = a2;
        } else {
            i3 = i2;
        }
        if (i3 != i4 && z) {
            r.a(this, arrayList, arrayList2, i, i3, true);
            a(this.l, true);
        }
        while (i4 < i2) {
            android.support.v4.app.c cVar2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue() && cVar2.m >= 0) {
                c(cVar2.m);
                cVar2.m = -1;
            }
            cVar2.a();
            i4++;
        }
        if (z2) {
            g();
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (a(childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(c cVar) {
        if (cVar.a instanceof AlphaAnimation) {
            return true;
        }
        if (cVar.a instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) cVar.a).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
            return false;
        }
        return a(cVar.b);
    }

    static boolean a(View view, c cVar) {
        return view != null && cVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && android.support.v4.g.p.h(view) && a(cVar);
    }

    private boolean a(String str, int i, int i2) {
        l j;
        e();
        c(true);
        if (this.p == null || i >= 0 || str != null || (j = this.p.j()) == null || !j.a()) {
            boolean a2 = a(this.x, this.y, str, i, i2);
            if (a2) {
                this.c = true;
                try {
                    b(this.x, this.y);
                } finally {
                    z();
                }
            }
            f();
            C();
            return a2;
        }
        return true;
    }

    public static int b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        } else if (i == 4099) {
            return z ? 5 : 6;
        } else if (i != 8194) {
            return -1;
        } else {
            return z ? 3 : 4;
        }
    }

    private void b(android.support.v4.f.b<android.support.v4.app.g> bVar) {
        if (this.l < 1) {
            return;
        }
        int min = Math.min(this.l, 4);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            android.support.v4.app.g gVar = this.e.get(i);
            if (gVar.b < min) {
                a(gVar, min, gVar.O(), gVar.P(), false);
                if (gVar.J != null && !gVar.B && gVar.P) {
                    bVar.add(gVar);
                }
            }
        }
    }

    private static void b(View view, c cVar) {
        if (view == null || cVar == null || !a(view, cVar)) {
            return;
        }
        if (cVar.b != null) {
            cVar.b.addListener(new d(view));
            return;
        }
        Animation.AnimationListener a2 = a(cVar.a);
        view.setLayerType(2, null);
        cVar.a.setAnimationListener(new a(view, a2));
    }

    private void b(ArrayList<android.support.v4.app.c> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        a(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).t) {
                if (i2 != i) {
                    a(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).t) {
                        i2++;
                    }
                }
                a(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            a(arrayList, arrayList2, i2, size);
        }
    }

    private static void b(ArrayList<android.support.v4.app.c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            android.support.v4.app.c cVar = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                cVar.a(-1);
                cVar.a(i == i2 + (-1));
            } else {
                cVar.a(1);
                cVar.b();
            }
            i++;
        }
    }

    private void c(boolean z) {
        if (this.c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.m.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            x();
        }
        if (this.x == null) {
            this.x = new ArrayList<>();
            this.y = new ArrayList<>();
        }
        this.c = true;
        try {
            a((ArrayList<android.support.v4.app.c>) null, (ArrayList<Boolean>) null);
        } finally {
            this.c = false;
        }
    }

    private boolean c(ArrayList<android.support.v4.app.c> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.b != null && this.b.size() != 0) {
                int size = this.b.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    z |= this.b.get(i).a(arrayList, arrayList2);
                }
                this.b.clear();
                this.m.h().removeCallbacks(this.E);
                return z;
            }
            return false;
        }
    }

    public static int d(int i) {
        if (i != 4097) {
            if (i != 4099) {
                return i != 8194 ? 0 : 4097;
            }
            return 4099;
        }
        return 8194;
    }

    private void e(int i) {
        try {
            this.c = true;
            a(i, false);
            this.c = false;
            e();
        } catch (Throwable th) {
            this.c = false;
            throw th;
        }
    }

    private android.support.v4.app.g p(android.support.v4.app.g gVar) {
        ViewGroup viewGroup = gVar.I;
        View view = gVar.J;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.e.indexOf(gVar) - 1; indexOf >= 0; indexOf--) {
                android.support.v4.app.g gVar2 = this.e.get(indexOf);
                if (gVar2.I == viewGroup && gVar2.J != null) {
                    return gVar2;
                }
            }
        }
        return null;
    }

    private void x() {
        if (c()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.v == null) {
            return;
        }
        throw new IllegalStateException("Can not perform this action inside of " + this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.C == null || this.C.isEmpty()) ? false : true;
            if (this.b != null && this.b.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.m.h().removeCallbacks(this.E);
                this.m.h().post(this.E);
            }
        }
    }

    private void z() {
        this.c = false;
        this.y.clear();
        this.x.clear();
    }

    public android.support.v4.app.g a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        android.support.v4.app.g gVar = this.f.get(i);
        if (gVar == null) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        return gVar;
    }

    public android.support.v4.app.g a(String str) {
        if (str != null) {
            for (int size = this.e.size() - 1; size >= 0; size--) {
                android.support.v4.app.g gVar = this.e.get(size);
                if (gVar != null && str.equals(gVar.A)) {
                    return gVar;
                }
            }
        }
        if (this.f == null || str == null) {
            return null;
        }
        for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
            android.support.v4.app.g valueAt = this.f.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.A)) {
                return valueAt;
            }
        }
        return null;
    }

    c a(android.support.v4.app.g gVar, int i, boolean z, int i2) {
        int b2;
        int O = gVar.O();
        Animation a2 = gVar.a(i, z, O);
        if (a2 != null) {
            return new c(a2);
        }
        Animator b3 = gVar.b(i, z, O);
        if (b3 != null) {
            return new c(b3);
        }
        if (O != 0) {
            boolean equals = "anim".equals(this.m.g().getResources().getResourceTypeName(O));
            boolean z2 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.m.g(), O);
                    if (loadAnimation != null) {
                        return new c(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.m.g(), O);
                    if (loadAnimator != null) {
                        return new c(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(this.m.g(), O);
                    if (loadAnimation2 != null) {
                        return new c(loadAnimation2);
                    }
                }
            }
        }
        if (i != 0 && (b2 = b(i, z)) >= 0) {
            switch (b2) {
                case 1:
                    return a(this.m.g(), 1.125f, 1.0f, 0.0f, 1.0f);
                case 2:
                    return a(this.m.g(), 1.0f, 0.975f, 1.0f, 0.0f);
                case 3:
                    return a(this.m.g(), 0.975f, 1.0f, 0.0f, 1.0f);
                case 4:
                    return a(this.m.g(), 1.0f, 1.075f, 1.0f, 0.0f);
                case 5:
                    return a(this.m.g(), 0.0f, 1.0f);
                case 6:
                    return a(this.m.g(), 1.0f, 0.0f);
                default:
                    if (i2 == 0 && this.m.d()) {
                        i2 = this.m.e();
                    }
                    if (i2 == 0) {
                    }
                    return null;
            }
        }
        return null;
    }

    public void a(int i, android.support.v4.app.c cVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (i < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + cVar);
                }
                this.i.set(i, cVar);
            } else {
                while (size < i) {
                    this.i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + cVar);
                }
                this.i.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        if (this.m == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.l) {
            this.l = i;
            if (this.f != null) {
                int size = this.e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    e(this.e.get(i2));
                }
                int size2 = this.f.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    android.support.v4.app.g valueAt = this.f.valueAt(i3);
                    if (valueAt != null && ((valueAt.m || valueAt.C) && !valueAt.P)) {
                        e(valueAt);
                    }
                }
                d();
                if (this.r && this.m != null && this.l == 5) {
                    this.m.c();
                    this.r = false;
                }
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i = 0; i < this.e.size(); i++) {
            android.support.v4.app.g gVar = this.e.get(i);
            if (gVar != null) {
                gVar.a(configuration);
            }
        }
    }

    public void a(Bundle bundle, String str, android.support.v4.app.g gVar) {
        if (gVar.f < 0) {
            a(new IllegalStateException("Fragment " + gVar + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, gVar.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, n nVar) {
        List<n> list;
        List<android.arch.lifecycle.p> list2;
        if (parcelable == null) {
            return;
        }
        o oVar = (o) parcelable;
        if (oVar.a == null) {
            return;
        }
        if (nVar != null) {
            List<android.support.v4.app.g> a2 = nVar.a();
            list = nVar.b();
            list2 = nVar.c();
            int size = a2 != null ? a2.size() : 0;
            for (int i = 0; i < size; i++) {
                android.support.v4.app.g gVar = a2.get(i);
                if (a) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + gVar);
                }
                int i2 = 0;
                while (i2 < oVar.a.length && oVar.a[i2].b != gVar.f) {
                    i2++;
                }
                if (i2 == oVar.a.length) {
                    a(new IllegalStateException("Could not find active fragment with index " + gVar.f));
                }
                p pVar = oVar.a[i2];
                pVar.l = gVar;
                gVar.d = null;
                gVar.r = 0;
                gVar.o = false;
                gVar.l = false;
                gVar.i = null;
                if (pVar.k != null) {
                    pVar.k.setClassLoader(this.m.g().getClassLoader());
                    gVar.d = pVar.k.getSparseParcelableArray("android:view_state");
                    gVar.c = pVar.k;
                }
            }
        } else {
            list = null;
            list2 = null;
        }
        this.f = new SparseArray<>(oVar.a.length);
        int i3 = 0;
        while (i3 < oVar.a.length) {
            p pVar2 = oVar.a[i3];
            if (pVar2 != null) {
                android.support.v4.app.g a3 = pVar2.a(this.m, this.n, this.o, (list == null || i3 >= list.size()) ? null : list.get(i3), (list2 == null || i3 >= list2.size()) ? null : list2.get(i3));
                if (a) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + a3);
                }
                this.f.put(a3.f, a3);
                pVar2.l = null;
            }
            i3++;
        }
        if (nVar != null) {
            List<android.support.v4.app.g> a4 = nVar.a();
            int size2 = a4 != null ? a4.size() : 0;
            for (int i4 = 0; i4 < size2; i4++) {
                android.support.v4.app.g gVar2 = a4.get(i4);
                if (gVar2.j >= 0) {
                    gVar2.i = this.f.get(gVar2.j);
                    if (gVar2.i == null) {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + gVar2 + " target no longer exists: " + gVar2.j);
                    }
                }
            }
        }
        this.e.clear();
        if (oVar.b != null) {
            for (int i5 = 0; i5 < oVar.b.length; i5++) {
                android.support.v4.app.g gVar3 = this.f.get(oVar.b[i5]);
                if (gVar3 == null) {
                    a(new IllegalStateException("No instantiated fragment for index #" + oVar.b[i5]));
                }
                gVar3.l = true;
                if (a) {
                    Log.v("FragmentManager", "restoreAllState: added #" + i5 + ": " + gVar3);
                }
                if (this.e.contains(gVar3)) {
                    throw new IllegalStateException("Already added!");
                }
                synchronized (this.e) {
                    this.e.add(gVar3);
                }
            }
        }
        if (oVar.c != null) {
            this.g = new ArrayList<>(oVar.c.length);
            for (int i6 = 0; i6 < oVar.c.length; i6++) {
                android.support.v4.app.c a5 = oVar.c[i6].a(this);
                if (a) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + a5.m + "): " + a5);
                    PrintWriter printWriter = new PrintWriter(new android.support.v4.f.e("FragmentManager"));
                    a5.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.g.add(a5);
                if (a5.m >= 0) {
                    a(a5.m, a5);
                }
            }
        } else {
            this.g = null;
        }
        if (oVar.d >= 0) {
            this.p = this.f.get(oVar.d);
        }
        this.d = oVar.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(android.support.v4.app.c cVar) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.add(cVar);
    }

    public void a(android.support.v4.app.g gVar) {
        if (gVar.L) {
            if (this.c) {
                this.w = true;
                return;
            }
            gVar.L = false;
            a(gVar, this.l, 0, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:152:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.support.v4.app.g r16, int r17, int r18, int r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 1200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.m.a(android.support.v4.app.g, int, int, int, boolean):void");
    }

    void a(android.support.v4.app.g gVar, Context context, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).a(gVar, context, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.a(this, gVar, context);
            }
        }
    }

    void a(android.support.v4.app.g gVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).a(gVar, bundle, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.a(this, gVar, bundle);
            }
        }
    }

    void a(android.support.v4.app.g gVar, View view, Bundle bundle, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).a(gVar, view, bundle, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.a(this, gVar, view, bundle);
            }
        }
    }

    public void a(android.support.v4.app.g gVar, boolean z) {
        if (a) {
            Log.v("FragmentManager", "add: " + gVar);
        }
        f(gVar);
        if (gVar.C) {
            return;
        }
        if (this.e.contains(gVar)) {
            throw new IllegalStateException("Fragment already added: " + gVar);
        }
        synchronized (this.e) {
            this.e.add(gVar);
        }
        gVar.l = true;
        gVar.m = false;
        if (gVar.J == null) {
            gVar.Q = false;
        }
        if (gVar.F && gVar.G) {
            this.r = true;
        }
        if (z) {
            b(gVar);
        }
    }

    public void a(k kVar, i iVar, android.support.v4.app.g gVar) {
        if (this.m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.m = kVar;
        this.n = iVar;
        this.o = gVar;
    }

    @Override // android.support.v4.app.l
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        if (this.f != null && (size5 = this.f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                android.support.v4.app.g valueAt = this.f.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.e.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.e.get(i2).toString());
            }
        }
        if (this.h != null && (size4 = this.h.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.h.get(i3).toString());
            }
        }
        if (this.g != null && (size3 = this.g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                android.support.v4.app.c cVar = this.g.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(cVar.toString());
                cVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.i != null && (size2 = this.i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((android.support.v4.app.c) this.i.get(i5));
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        if (this.b != null && (size = this.b.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println((g) this.b.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
    }

    public void a(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            android.support.v4.app.g gVar = this.e.get(size);
            if (gVar != null) {
                gVar.d(z);
            }
        }
    }

    @Override // android.support.v4.app.l
    public boolean a() {
        x();
        return a((String) null, -1, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return this.l >= i;
    }

    public boolean a(Menu menu) {
        if (this.l < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.e.size(); i++) {
            android.support.v4.app.g gVar = this.e.get(i);
            if (gVar != null && gVar.c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.l < 1) {
            return false;
        }
        ArrayList<android.support.v4.app.g> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.e.size(); i++) {
            android.support.v4.app.g gVar = this.e.get(i);
            if (gVar != null && gVar.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(gVar);
                z = true;
            }
        }
        if (this.h != null) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                android.support.v4.app.g gVar2 = this.h.get(i2);
                if (arrayList == null || !arrayList.contains(gVar2)) {
                    gVar2.t();
                }
            }
        }
        this.h = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            android.support.v4.app.g gVar = this.e.get(i);
            if (gVar != null && gVar.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<android.support.v4.app.c> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        if (this.g == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = this.g.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.g.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.g.size() - 1;
                while (size >= 0) {
                    android.support.v4.app.c cVar = this.g.get(size);
                    if ((str != null && str.equals(cVar.d())) || (i >= 0 && i == cVar.m)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        android.support.v4.app.c cVar2 = this.g.get(size);
                        if (str == null || !str.equals(cVar2.d())) {
                            if (i < 0 || i != cVar2.m) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.g.size() - 1) {
                return false;
            }
            for (int size3 = this.g.size() - 1; size3 > size; size3--) {
                arrayList.add(this.g.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public android.support.v4.app.g b(int i) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            android.support.v4.app.g gVar = this.e.get(size);
            if (gVar != null && gVar.y == i) {
                return gVar;
            }
        }
        if (this.f != null) {
            for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
                android.support.v4.app.g valueAt = this.f.valueAt(size2);
                if (valueAt != null && valueAt.y == i) {
                    return valueAt;
                }
            }
            return null;
        }
        return null;
    }

    public android.support.v4.app.g b(String str) {
        android.support.v4.app.g a2;
        if (this.f == null || str == null) {
            return null;
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            android.support.v4.app.g valueAt = this.f.valueAt(size);
            if (valueAt != null && (a2 = valueAt.a(str)) != null) {
                return a2;
            }
        }
        return null;
    }

    @Override // android.support.v4.app.l
    public List<android.support.v4.app.g> b() {
        List<android.support.v4.app.g> list;
        if (this.e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.e) {
            list = (List) this.e.clone();
        }
        return list;
    }

    void b(android.support.v4.app.g gVar) {
        a(gVar, this.l, 0, 0, false);
    }

    void b(android.support.v4.app.g gVar, Context context, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).b(gVar, context, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.b(this, gVar, context);
            }
        }
    }

    void b(android.support.v4.app.g gVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).b(gVar, bundle, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.b(this, gVar, bundle);
            }
        }
    }

    void b(android.support.v4.app.g gVar, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).b(gVar, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.a(this, gVar);
            }
        }
    }

    public void b(Menu menu) {
        if (this.l < 1) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            android.support.v4.app.g gVar = this.e.get(i);
            if (gVar != null) {
                gVar.d(menu);
            }
        }
    }

    public void b(boolean z) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            android.support.v4.app.g gVar = this.e.get(size);
            if (gVar != null) {
                gVar.e(z);
            }
        }
    }

    public boolean b(MenuItem menuItem) {
        if (this.l < 1) {
            return false;
        }
        for (int i = 0; i < this.e.size(); i++) {
            android.support.v4.app.g gVar = this.e.get(i);
            if (gVar != null && gVar.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void c(int i) {
        synchronized (this) {
            this.i.set(i, null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.j.add(Integer.valueOf(i));
        }
    }

    void c(android.support.v4.app.g gVar) {
        if (!gVar.n || gVar.q) {
            return;
        }
        gVar.J = gVar.b(gVar.d(gVar.c), (ViewGroup) null, gVar.c);
        if (gVar.J == null) {
            gVar.K = null;
            return;
        }
        gVar.K = gVar.J;
        gVar.J.setSaveFromParentEnabled(false);
        if (gVar.B) {
            gVar.J.setVisibility(8);
        }
        gVar.a(gVar.J, gVar.c);
        a(gVar, gVar.J, gVar.c, false);
    }

    void c(android.support.v4.app.g gVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).c(gVar, bundle, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.c(this, gVar, bundle);
            }
        }
    }

    void c(android.support.v4.app.g gVar, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).c(gVar, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.b(this, gVar);
            }
        }
    }

    @Override // android.support.v4.app.l
    public boolean c() {
        return this.s || this.t;
    }

    void d() {
        if (this.f == null) {
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            android.support.v4.app.g valueAt = this.f.valueAt(i);
            if (valueAt != null) {
                a(valueAt);
            }
        }
    }

    void d(final android.support.v4.app.g gVar) {
        if (gVar.J != null) {
            c a2 = a(gVar, gVar.P(), !gVar.B, gVar.Q());
            if (a2 == null || a2.b == null) {
                if (a2 != null) {
                    b(gVar.J, a2);
                    gVar.J.startAnimation(a2.a);
                    a2.a.start();
                }
                gVar.J.setVisibility((!gVar.B || gVar.X()) ? 0 : 8);
                if (gVar.X()) {
                    gVar.f(false);
                }
            } else {
                a2.b.setTarget(gVar.J);
                if (!gVar.B) {
                    gVar.J.setVisibility(0);
                } else if (gVar.X()) {
                    gVar.f(false);
                } else {
                    final ViewGroup viewGroup = gVar.I;
                    final View view = gVar.J;
                    viewGroup.startViewTransition(view);
                    a2.b.addListener(new AnimatorListenerAdapter() { // from class: android.support.v4.app.m.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (gVar.J != null) {
                                gVar.J.setVisibility(8);
                            }
                        }
                    });
                }
                b(gVar.J, a2);
                a2.b.start();
            }
        }
        if (gVar.l && gVar.F && gVar.G) {
            this.r = true;
        }
        gVar.Q = false;
        gVar.a(gVar.B);
    }

    void d(android.support.v4.app.g gVar, Bundle bundle, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).d(gVar, bundle, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.d(this, gVar, bundle);
            }
        }
    }

    void d(android.support.v4.app.g gVar, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).d(gVar, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.c(this, gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(android.support.v4.app.g gVar) {
        if (gVar == null) {
            return;
        }
        int i = this.l;
        if (gVar.m) {
            i = gVar.b() ? Math.min(i, 1) : Math.min(i, 0);
        }
        a(gVar, i, gVar.P(), gVar.Q(), false);
        if (gVar.J != null) {
            android.support.v4.app.g p = p(gVar);
            if (p != null) {
                View view = p.J;
                ViewGroup viewGroup = gVar.I;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(gVar.J);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(gVar.J, indexOfChild);
                }
            }
            if (gVar.P && gVar.I != null) {
                if (gVar.R > 0.0f) {
                    gVar.J.setAlpha(gVar.R);
                }
                gVar.R = 0.0f;
                gVar.P = false;
                c a2 = a(gVar, gVar.P(), true, gVar.Q());
                if (a2 != null) {
                    b(gVar.J, a2);
                    if (a2.a != null) {
                        gVar.J.startAnimation(a2.a);
                    } else {
                        a2.b.setTarget(gVar.J);
                        a2.b.start();
                    }
                }
            }
        }
        if (gVar.Q) {
            d(gVar);
        }
    }

    void e(android.support.v4.app.g gVar, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).e(gVar, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.d(this, gVar);
            }
        }
    }

    public boolean e() {
        c(true);
        boolean z = false;
        while (c(this.x, this.y)) {
            this.c = true;
            try {
                b(this.x, this.y);
                z();
                z = true;
            } catch (Throwable th) {
                z();
                throw th;
            }
        }
        f();
        C();
        return z;
    }

    void f() {
        if (this.w) {
            this.w = false;
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(android.support.v4.app.g gVar) {
        if (gVar.f >= 0) {
            return;
        }
        int i = this.d;
        this.d = i + 1;
        gVar.a(i, this.o);
        if (this.f == null) {
            this.f = new SparseArray<>();
        }
        this.f.put(gVar.f, gVar);
        if (a) {
            Log.v("FragmentManager", "Allocated fragment index " + gVar);
        }
    }

    void f(android.support.v4.app.g gVar, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).f(gVar, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.e(this, gVar);
            }
        }
    }

    void g() {
        if (this.k != null) {
            for (int i = 0; i < this.k.size(); i++) {
                this.k.get(i).a();
            }
        }
    }

    void g(android.support.v4.app.g gVar) {
        if (gVar.f < 0) {
            return;
        }
        if (a) {
            Log.v("FragmentManager", "Freeing fragment index " + gVar);
        }
        this.f.put(gVar.f, null);
        gVar.r();
    }

    void g(android.support.v4.app.g gVar, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).g(gVar, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.f(this, gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n h() {
        a(this.D);
        return this.D;
    }

    public void h(android.support.v4.app.g gVar) {
        if (a) {
            Log.v("FragmentManager", "remove: " + gVar + " nesting=" + gVar.r);
        }
        boolean z = !gVar.b();
        if (!gVar.C || z) {
            synchronized (this.e) {
                this.e.remove(gVar);
            }
            if (gVar.F && gVar.G) {
                this.r = true;
            }
            gVar.l = false;
            gVar.m = true;
        }
    }

    void h(android.support.v4.app.g gVar, boolean z) {
        if (this.o != null) {
            l h2 = this.o.h();
            if (h2 instanceof m) {
                ((m) h2).h(gVar, true);
            }
        }
        Iterator<android.support.v4.f.i<l.a, Boolean>> it = this.J.iterator();
        while (it.hasNext()) {
            android.support.v4.f.i<l.a, Boolean> next = it.next();
            if (!z || next.b.booleanValue()) {
                next.a.g(this, gVar);
            }
        }
    }

    void i() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        n nVar;
        if (this.f != null) {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            for (int i = 0; i < this.f.size(); i++) {
                android.support.v4.app.g valueAt = this.f.valueAt(i);
                if (valueAt != null) {
                    if (valueAt.D) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAt);
                        valueAt.j = valueAt.i != null ? valueAt.i.f : -1;
                        if (a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    if (valueAt.u != null) {
                        valueAt.u.i();
                        nVar = valueAt.u.D;
                    } else {
                        nVar = valueAt.v;
                    }
                    if (arrayList2 == null && nVar != null) {
                        arrayList2 = new ArrayList(this.f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(nVar);
                    }
                    if (arrayList3 == null && valueAt.w != null) {
                        arrayList3 = new ArrayList(this.f.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(valueAt.w);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.D = null;
        } else {
            this.D = new n(arrayList, arrayList2, arrayList3);
        }
    }

    public void i(android.support.v4.app.g gVar) {
        if (a) {
            Log.v("FragmentManager", "hide: " + gVar);
        }
        if (gVar.B) {
            return;
        }
        gVar.B = true;
        gVar.Q = true ^ gVar.Q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable j() {
        int[] iArr;
        int size;
        A();
        B();
        e();
        this.s = true;
        android.support.v4.app.d[] dVarArr = null;
        this.D = null;
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size2 = this.f.size();
        p[] pVarArr = new p[size2];
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            android.support.v4.app.g valueAt = this.f.valueAt(i);
            if (valueAt != null) {
                if (valueAt.f < 0) {
                    a(new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.f));
                }
                p pVar = new p(valueAt);
                pVarArr[i] = pVar;
                if (valueAt.b <= 0 || pVar.k != null) {
                    pVar.k = valueAt.c;
                } else {
                    pVar.k = n(valueAt);
                    if (valueAt.i != null) {
                        if (valueAt.i.f < 0) {
                            a(new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.i));
                        }
                        if (pVar.k == null) {
                            pVar.k = new Bundle();
                        }
                        a(pVar.k, "android:target_state", valueAt.i);
                        if (valueAt.k != 0) {
                            pVar.k.putInt("android:target_req_state", valueAt.k);
                        }
                    }
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + valueAt + ": " + pVar.k);
                }
                z = true;
            }
        }
        if (!z) {
            if (a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.e.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i2 = 0; i2 < size3; i2++) {
                iArr[i2] = this.e.get(i2).f;
                if (iArr[i2] < 0) {
                    a(new IllegalStateException("Failure saving state: active " + this.e.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.e.get(i2));
                }
            }
        } else {
            iArr = null;
        }
        if (this.g != null && (size = this.g.size()) > 0) {
            dVarArr = new android.support.v4.app.d[size];
            for (int i3 = 0; i3 < size; i3++) {
                dVarArr[i3] = new android.support.v4.app.d(this.g.get(i3));
                if (a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.g.get(i3));
                }
            }
        }
        o oVar = new o();
        oVar.a = pVarArr;
        oVar.b = iArr;
        oVar.c = dVarArr;
        if (this.p != null) {
            oVar.d = this.p.f;
        }
        oVar.e = this.d;
        i();
        return oVar;
    }

    public void j(android.support.v4.app.g gVar) {
        if (a) {
            Log.v("FragmentManager", "show: " + gVar);
        }
        if (gVar.B) {
            gVar.B = false;
            gVar.Q = !gVar.Q;
        }
    }

    public void k() {
        this.D = null;
        this.s = false;
        this.t = false;
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            android.support.v4.app.g gVar = this.e.get(i);
            if (gVar != null) {
                gVar.G();
            }
        }
    }

    public void k(android.support.v4.app.g gVar) {
        if (a) {
            Log.v("FragmentManager", "detach: " + gVar);
        }
        if (gVar.C) {
            return;
        }
        gVar.C = true;
        if (gVar.l) {
            if (a) {
                Log.v("FragmentManager", "remove from detach: " + gVar);
            }
            synchronized (this.e) {
                this.e.remove(gVar);
            }
            if (gVar.F && gVar.G) {
                this.r = true;
            }
            gVar.l = false;
        }
    }

    public void l() {
        this.s = false;
        this.t = false;
        e(1);
    }

    public void l(android.support.v4.app.g gVar) {
        if (a) {
            Log.v("FragmentManager", "attach: " + gVar);
        }
        if (gVar.C) {
            gVar.C = false;
            if (gVar.l) {
                return;
            }
            if (this.e.contains(gVar)) {
                throw new IllegalStateException("Fragment already added: " + gVar);
            }
            if (a) {
                Log.v("FragmentManager", "add from attach: " + gVar);
            }
            synchronized (this.e) {
                this.e.add(gVar);
            }
            gVar.l = true;
            if (gVar.F && gVar.G) {
                this.r = true;
            }
        }
    }

    public void m() {
        this.s = false;
        this.t = false;
        e(2);
    }

    void m(android.support.v4.app.g gVar) {
        if (gVar.K == null) {
            return;
        }
        if (this.B == null) {
            this.B = new SparseArray<>();
        } else {
            this.B.clear();
        }
        gVar.K.saveHierarchyState(this.B);
        if (this.B.size() > 0) {
            gVar.d = this.B;
            this.B = null;
        }
    }

    Bundle n(android.support.v4.app.g gVar) {
        Bundle bundle;
        if (this.A == null) {
            this.A = new Bundle();
        }
        gVar.m(this.A);
        d(gVar, this.A, false);
        if (this.A.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.A;
            this.A = null;
        }
        if (gVar.J != null) {
            m(gVar);
        }
        if (gVar.d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", gVar.d);
        }
        if (!gVar.M) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", gVar.M);
        }
        return bundle;
    }

    public void n() {
        this.s = false;
        this.t = false;
        e(4);
    }

    public void o() {
        this.s = false;
        this.t = false;
        e(5);
    }

    public void o(android.support.v4.app.g gVar) {
        if (gVar == null || (this.f.get(gVar.f) == gVar && (gVar.t == null || gVar.h() == this))) {
            this.p = gVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + gVar + " is not an active fragment of FragmentManager " + this);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        android.support.v4.app.g gVar;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            String str2 = attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (android.support.v4.app.g.a(this.m.g(), str2)) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
                }
                android.support.v4.app.g b2 = resourceId != -1 ? b(resourceId) : null;
                if (b2 == null && string != null) {
                    b2 = a(string);
                }
                if (b2 == null && id != -1) {
                    b2 = b(id);
                }
                if (a) {
                    Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + b2);
                }
                if (b2 == null) {
                    android.support.v4.app.g a2 = this.n.a(context, str2, null);
                    a2.n = true;
                    a2.y = resourceId != 0 ? resourceId : id;
                    a2.z = id;
                    a2.A = string;
                    a2.o = true;
                    a2.s = this;
                    a2.t = this.m;
                    a2.a(this.m.g(), attributeSet, a2.c);
                    a(a2, true);
                    gVar = a2;
                } else if (b2.o) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
                } else {
                    b2.o = true;
                    b2.t = this.m;
                    if (!b2.E) {
                        b2.a(this.m.g(), attributeSet, b2.c);
                    }
                    gVar = b2;
                }
                if (this.l >= 1 || !gVar.n) {
                    b(gVar);
                } else {
                    a(gVar, 1, 0, 0, false);
                }
                if (gVar.J != null) {
                    if (resourceId != 0) {
                        gVar.J.setId(resourceId);
                    }
                    if (gVar.J.getTag() == null) {
                        gVar.J.setTag(string);
                    }
                    return gVar.J;
                }
                throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
            }
            return null;
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void p() {
        e(4);
    }

    public void q() {
        this.t = true;
        e(3);
    }

    public void r() {
        e(2);
    }

    public void s() {
        e(1);
    }

    public void t() {
        this.u = true;
        e();
        e(0);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        android.support.v4.f.d.a(this.o != null ? this.o : this.m, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void u() {
        for (int i = 0; i < this.e.size(); i++) {
            android.support.v4.app.g gVar = this.e.get(i);
            if (gVar != null) {
                gVar.H();
            }
        }
    }

    public android.support.v4.app.g v() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 w() {
        return this;
    }
}