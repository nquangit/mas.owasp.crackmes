package android.support.v4.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.a.a.a;
import android.support.v4.e.b;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes.dex */
public class f extends d {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;
    private static final Method e;
    private static final Method f;
    private static final Method g;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
            method3 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            method4 = cls.getMethod("freeze", new Class[0]);
            method5 = cls.getMethod("abortCreation", new Class[0]);
            method = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
            method.setAccessible(true);
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        b = constructor;
        a = cls;
        c = method2;
        d = method3;
        e = method4;
        f = method5;
        g = method;
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static boolean a(Context context, Object obj, String str, int i, int i2, int i3) {
        try {
            return ((Boolean) c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Object b() {
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean b(Object obj) {
        try {
            return ((Boolean) e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void c(Object obj) {
        try {
            f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.support.v4.b.g, android.support.v4.b.c.a
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (a()) {
            Object b2 = b();
            if (!a(context, b2, str, 0, -1, -1)) {
                c(b2);
                return null;
            } else if (b(b2)) {
                return a(b2);
            } else {
                return null;
            }
        }
        return super.a(context, resources, i, str, i2);
    }

    @Override // android.support.v4.b.d, android.support.v4.b.g, android.support.v4.b.c.a
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0006b[] c0006bArr, int i) {
        if (c0006bArr.length < 1) {
            return null;
        }
        if (!a()) {
            b.C0006b a2 = a(c0006bArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.a(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.c()).setItalic(a2.d()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> a3 = android.support.v4.e.b.a(context, c0006bArr, cancellationSignal);
        Object b2 = b();
        boolean z = false;
        for (b.C0006b c0006b : c0006bArr) {
            ByteBuffer byteBuffer = a3.get(c0006b.a());
            if (byteBuffer != null) {
                if (!a(b2, byteBuffer, c0006b.b(), c0006b.c(), c0006b.d() ? 1 : 0)) {
                    c(b2);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            c(b2);
            return null;
        } else if (b(b2)) {
            return Typeface.create(a(b2), i);
        } else {
            return null;
        }
    }

    @Override // android.support.v4.b.g, android.support.v4.b.c.a
    public Typeface a(Context context, a.b bVar, Resources resources, int i) {
        a.c[] a2;
        if (a()) {
            Object b2 = b();
            for (a.c cVar : bVar.a()) {
                if (!a(context, b2, cVar.a(), 0, cVar.b(), cVar.c() ? 1 : 0)) {
                    c(b2);
                    return null;
                }
            }
            if (b(b2)) {
                return a(b2);
            }
            return null;
        }
        return super.a(context, bVar, resources, i);
    }
}