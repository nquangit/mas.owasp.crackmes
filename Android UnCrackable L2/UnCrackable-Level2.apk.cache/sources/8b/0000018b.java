package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
class o {
    private static o a;
    private final Context b;
    private final LocationManager c;
    private final a d = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        boolean a;
        long b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }

    o(Context context, LocationManager locationManager) {
        this.b = context;
        this.c = locationManager;
    }

    private Location a(String str) {
        try {
            if (this.c.isProviderEnabled(str)) {
                return this.c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(Context context) {
        if (a == null) {
            Context applicationContext = context.getApplicationContext();
            a = new o(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return a;
    }

    private void a(Location location) {
        long j;
        a aVar = this.d;
        long currentTimeMillis = System.currentTimeMillis();
        n a2 = n.a();
        a2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.a;
        a2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.c == 1;
        long j3 = a2.b;
        long j4 = a2.a;
        boolean z2 = z;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a2.b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.a = z2;
        aVar.b = j2;
        aVar.c = j3;
        aVar.d = j4;
        aVar.e = j5;
        aVar.f = j;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location a2 = android.support.v4.a.c.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location a3 = android.support.v4.a.c.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        return (a3 == null || a2 == null) ? a3 != null ? a3 : a2 : a3.getTime() > a2.getTime() ? a3 : a2;
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        a aVar = this.d;
        if (c()) {
            return aVar.a;
        }
        Location b = b();
        if (b != null) {
            a(b);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}