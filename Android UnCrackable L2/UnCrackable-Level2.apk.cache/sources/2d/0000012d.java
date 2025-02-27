package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class c {
    private static final C0010c a;

    /* loaded from: classes.dex */
    static class a extends C0010c {
        a() {
        }

        @Override // android.support.v4.widget.c.C0010c
        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        @Override // android.support.v4.widget.c.C0010c
        public void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    /* loaded from: classes.dex */
    static class b extends a {
        b() {
        }

        @Override // android.support.v4.widget.c.C0010c
        public Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    /* renamed from: android.support.v4.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0010c {
        private static Field a;
        private static boolean b;

        C0010c() {
        }

        public Drawable a(CompoundButton compoundButton) {
            if (!b) {
                try {
                    a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    a.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                b = true;
            }
            if (a != null) {
                try {
                    return (Drawable) a.get(compoundButton);
                } catch (IllegalAccessException e2) {
                    Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                    a = null;
                }
            }
            return null;
        }

        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof l) {
                ((l) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        public void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            if (compoundButton instanceof l) {
                ((l) compoundButton).setSupportButtonTintMode(mode);
            }
        }
    }

    static {
        a = Build.VERSION.SDK_INT >= 23 ? new b() : Build.VERSION.SDK_INT >= 21 ? new a() : new C0010c();
    }

    public static Drawable a(CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        a.a(compoundButton, colorStateList);
    }

    public static void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        a.a(compoundButton, mode);
    }
}