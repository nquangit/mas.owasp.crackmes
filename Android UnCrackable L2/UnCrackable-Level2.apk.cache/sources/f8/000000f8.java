package android.support.v4.g;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class e {
    static final b a;
    private static Field b;
    private static boolean c;

    /* loaded from: classes.dex */
    static class a extends b {
        a() {
        }

        @Override // android.support.v4.g.e.b
        public void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        public void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                e.a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                e.a(layoutInflater, factory2);
            }
        }
    }

    static {
        a = Build.VERSION.SDK_INT >= 21 ? new a() : new b();
    }

    static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!c) {
            try {
                b = LayoutInflater.class.getDeclaredField("mFactory2");
                b.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            c = true;
        }
        if (b != null) {
            try {
                b.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        a.a(layoutInflater, factory2);
    }
}