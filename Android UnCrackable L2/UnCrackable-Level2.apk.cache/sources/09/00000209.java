package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;

/* loaded from: classes.dex */
public class af {
    public static final Rect a = new Rect();
    private static Class<?> b;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    public static boolean b(Drawable drawable) {
        Drawable drawable2;
        if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof InsetDrawable)) {
            if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof GradientDrawable)) {
                if (Build.VERSION.SDK_INT >= 17 || !(drawable instanceof LayerDrawable)) {
                    if (!(drawable instanceof DrawableContainer)) {
                        if (drawable instanceof android.support.v4.b.a.c) {
                            drawable2 = ((android.support.v4.b.a.c) drawable).a();
                        } else if (drawable instanceof android.support.v7.c.a.a) {
                            drawable2 = ((android.support.v7.c.a.a) drawable).a();
                        } else if (!(drawable instanceof ScaleDrawable)) {
                            return true;
                        } else {
                            drawable2 = ((ScaleDrawable) drawable).getDrawable();
                        }
                        return b(drawable2);
                    }
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState instanceof DrawableContainer.DrawableContainerState) {
                        for (Drawable drawable3 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                            if (!b(drawable3)) {
                                return false;
                            }
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        drawable.setState((state == null || state.length == 0) ? ar.e : ar.h);
        drawable.setState(state);
    }
}