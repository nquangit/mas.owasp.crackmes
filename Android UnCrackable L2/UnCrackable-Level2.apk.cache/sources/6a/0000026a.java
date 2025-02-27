package sg.vantagepoint.a;

import android.content.Context;

/* loaded from: classes.dex */
public class a {
    public static boolean a(Context context) {
        return (context.getApplicationContext().getApplicationInfo().flags & 2) != 0;
    }
}