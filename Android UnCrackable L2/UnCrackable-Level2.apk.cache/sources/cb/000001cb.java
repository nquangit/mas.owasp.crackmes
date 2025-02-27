package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
public final class q {
    public static Menu a(Context context, android.support.v4.c.a.a aVar) {
        return new r(context, aVar);
    }

    public static MenuItem a(Context context, android.support.v4.c.a.b bVar) {
        return Build.VERSION.SDK_INT >= 16 ? new l(context, bVar) : new k(context, bVar);
    }

    public static SubMenu a(Context context, android.support.v4.c.a.c cVar) {
        return new v(context, cVar);
    }
}