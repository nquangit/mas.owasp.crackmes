package android.support.v4.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.a.a.a;
import android.support.v4.a.a.b;
import android.support.v4.e.b;

/* loaded from: classes.dex */
public class c {
    private static final a a;
    private static final android.support.v4.f.g<String, Typeface> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        Typeface a(Context context, Resources resources, int i, String str, int i2);

        Typeface a(Context context, CancellationSignal cancellationSignal, b.C0006b[] c0006bArr, int i);

        Typeface a(Context context, a.b bVar, Resources resources, int i);
    }

    static {
        a = Build.VERSION.SDK_INT >= 26 ? new f() : (Build.VERSION.SDK_INT < 24 || !e.a()) ? Build.VERSION.SDK_INT >= 21 ? new d() : new g() : new e();
        b = new android.support.v4.f.g<>(16);
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = a.a(context, resources, i, str, i2);
        if (a2 != null) {
            b.a(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.C0006b[] c0006bArr, int i) {
        return a.a(context, cancellationSignal, c0006bArr, i);
    }

    public static Typeface a(Context context, a.InterfaceC0003a interfaceC0003a, Resources resources, int i, int i2, b.a aVar, Handler handler, boolean z) {
        Typeface a2;
        if (interfaceC0003a instanceof a.d) {
            a.d dVar = (a.d) interfaceC0003a;
            boolean z2 = false;
            if (!z ? aVar == null : dVar.b() == 0) {
                z2 = true;
            }
            a2 = android.support.v4.e.b.a(context, dVar.a(), aVar, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            a2 = a.a(context, (a.b) interfaceC0003a, resources, i2);
            if (aVar != null) {
                if (a2 != null) {
                    aVar.a(a2, handler);
                } else {
                    aVar.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            b.a(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return b.a((android.support.v4.f.g<String, Typeface>) b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}