package android.support.v4.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.a.a.a;
import android.support.v4.e.b;
import android.support.v4.f.k;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
class e extends g {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        b = constructor;
        a = cls;
        c = method2;
        d = method;
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object b() {
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.b.g, android.support.v4.b.c.a
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0006b[] c0006bArr, int i) {
        Object b2 = b();
        k kVar = new k();
        for (b.C0006b c0006b : c0006bArr) {
            Uri a2 = c0006b.a();
            ByteBuffer byteBuffer = (ByteBuffer) kVar.get(a2);
            if (byteBuffer == null) {
                byteBuffer = h.a(context, cancellationSignal, a2);
                kVar.put(a2, byteBuffer);
            }
            if (!a(b2, byteBuffer, c0006b.b(), c0006b.c(), c0006b.d())) {
                return null;
            }
        }
        return Typeface.create(a(b2), i);
    }

    @Override // android.support.v4.b.g, android.support.v4.b.c.a
    public Typeface a(Context context, a.b bVar, Resources resources, int i) {
        a.c[] a2;
        Object b2 = b();
        for (a.c cVar : bVar.a()) {
            ByteBuffer a3 = h.a(context, resources, cVar.d());
            if (a3 == null || !a(b2, a3, 0, cVar.b(), cVar.c())) {
                return null;
            }
        }
        return a(b2);
    }
}