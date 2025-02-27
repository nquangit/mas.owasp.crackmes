package android.support.v4.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class a {
    private static final Object a = new Object();
    private static TypedValue b;

    public static Drawable a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (Build.VERSION.SDK_INT < 16) {
            synchronized (a) {
                if (b == null) {
                    b = new TypedValue();
                }
                context.getResources().getValue(i, b, true);
                i = b.resourceId;
            }
        }
        return context.getResources().getDrawable(i);
    }

    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static ColorStateList b(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }
}