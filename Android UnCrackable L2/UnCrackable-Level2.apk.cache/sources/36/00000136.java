package android.support.v4.widget;

import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class f {
    private static final b a;

    /* loaded from: classes.dex */
    static class a extends b {
        a() {
        }

        @Override // android.support.v4.widget.f.b
        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static {
        a = Build.VERSION.SDK_INT >= 21 ? new a() : new b();
    }

    public static void a(EdgeEffect edgeEffect, float f, float f2) {
        a.a(edgeEffect, f, f2);
    }
}