package android.support.v4.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

/* loaded from: classes.dex */
public final class b {

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void a(int i);

        public final void a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.a.a.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(i);
                }
            });
        }

        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.a.a.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(typeface);
                }
            });
        }
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, aVar, null, true);
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (a2 == null && aVar == null) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface a(android.content.Context r14, android.content.res.Resources r15, android.util.TypedValue r16, int r17, int r18, android.support.v4.a.a.b.a r19, android.os.Handler r20, boolean r21) {
        /*
            r0 = r15
            r1 = r16
            r4 = r17
            r5 = r18
            r9 = r19
            r10 = r20
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L9e
            java.lang.CharSequence r1 = r1.string
            java.lang.String r11 = r1.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r11.startsWith(r1)
            r12 = 0
            r13 = -3
            if (r1 != 0) goto L25
            if (r9 == 0) goto L24
            r9.a(r13, r10)
        L24:
            return r12
        L25:
            android.graphics.Typeface r1 = android.support.v4.b.c.a(r15, r4, r5)
            if (r1 == 0) goto L31
            if (r9 == 0) goto L30
            r9.a(r1, r10)
        L30:
            return r1
        L31:
            java.lang.String r1 = r11.toLowerCase()     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
            if (r1 == 0) goto L65
            android.content.res.XmlResourceParser r1 = r15.getXml(r4)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
            android.support.v4.a.a.a$a r2 = android.support.v4.a.a.a.a(r1, r15)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
            if (r2 != 0) goto L54
            java.lang.String r0 = "ResourcesCompat"
            java.lang.String r1 = "Failed to find font-family tag"
            android.util.Log.e(r0, r1)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
            if (r9 == 0) goto L53
            r9.a(r13, r10)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
        L53:
            return r12
        L54:
            r1 = r14
            r3 = r15
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            android.graphics.Typeface r0 = android.support.v4.b.c.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
            return r0
        L65:
            r1 = r14
            android.graphics.Typeface r0 = android.support.v4.b.c.a(r14, r15, r4, r11, r5)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
            if (r9 == 0) goto L75
            if (r0 == 0) goto L72
            r9.a(r0, r10)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
            goto L75
        L72:
            r9.a(r13, r10)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L81
        L75:
            return r0
        L76:
            r0 = move-exception
            java.lang.String r1 = "ResourcesCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to read xml resource "
            goto L8b
        L81:
            r0 = move-exception
            java.lang.String r1 = "ResourcesCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to parse xml resource "
        L8b:
            r2.append(r3)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2, r0)
            if (r9 == 0) goto L9d
            r9.a(r13, r10)
        L9d:
            return r12
        L9e:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r15.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r17)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.a.b.a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, android.support.v4.a.a.b$a, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static Drawable a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }
}