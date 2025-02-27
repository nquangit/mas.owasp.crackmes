package android.support.v4.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.a.a.a;
import android.support.v4.b.c;
import android.support.v4.e.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements c.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    private a.c a(a.b bVar, int i) {
        return (a.c) a(bVar.a(), i, new a<a.c>() { // from class: android.support.v4.b.g.2
            @Override // android.support.v4.b.g.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public int b(a.c cVar) {
                return cVar.b();
            }

            @Override // android.support.v4.b.g.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(a.c cVar) {
                return cVar.c();
            }
        });
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.b(t2) - i2) * 2) + (aVar.a(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    @Override // android.support.v4.b.c.a
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File a2 = h.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (h.a(a2, resources, i)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    @Override // android.support.v4.b.c.a
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0006b[] c0006bArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (c0006bArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(c0006bArr, i).a());
            try {
                Typeface a2 = a(context, inputStream);
                h.a(inputStream);
                return a2;
            } catch (IOException unused) {
                h.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                h.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.support.v4.b.c.a
    public Typeface a(Context context, a.b bVar, Resources resources, int i) {
        a.c a2 = a(bVar, i);
        if (a2 == null) {
            return null;
        }
        return c.a(context, resources, a2.d(), a2.a(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = h.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (h.a(a2, inputStream)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b.C0006b a(b.C0006b[] c0006bArr, int i) {
        return (b.C0006b) a(c0006bArr, i, new a<b.C0006b>() { // from class: android.support.v4.b.g.1
            @Override // android.support.v4.b.g.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public int b(b.C0006b c0006b) {
                return c0006b.c();
            }

            @Override // android.support.v4.b.g.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(b.C0006b c0006b) {
                return c0006b.d();
            }
        });
    }
}