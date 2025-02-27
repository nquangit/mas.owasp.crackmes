package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes.dex */
public class a extends android.support.v4.a.a {
    private static InterfaceC0004a a;

    /* renamed from: android.support.v4.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0004a {
        boolean a(Activity activity, int i, int i2, Intent intent);
    }

    public static InterfaceC0004a a() {
        return a;
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }
}