package android.support.v4.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.a.a;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: android.support.v4.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0003a {
    }

    /* loaded from: classes.dex */
    public static final class b implements InterfaceC0003a {
        private final c[] a;

        public b(c[] cVarArr) {
            this.a = cVarArr;
        }

        public c[] a() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        private final String a;
        private int b;
        private boolean c;
        private int d;

        public c(String str, int i, boolean z, int i2) {
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = i2;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements InterfaceC0003a {
        private final android.support.v4.e.a a;
        private final int b;
        private final int c;

        public d(android.support.v4.e.a aVar, int i, int i2) {
            this.a = aVar;
            this.c = i;
            this.b = i2;
        }

        public android.support.v4.e.a a() {
            return this.a;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }
    }

    public static InterfaceC0003a a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        ArrayList arrayList = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                arrayList = new ArrayList();
                if (obtainTypedArray.getResourceId(0, 0) != 0) {
                    for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                        arrayList.add(a(resources.getStringArray(obtainTypedArray.getResourceId(i2, 0))));
                    }
                } else {
                    arrayList.add(a(resources.getStringArray(i)));
                }
            }
            obtainTypedArray.recycle();
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }

    private static InterfaceC0003a b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static InterfaceC0003a c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.b.FontFamily);
        String string = obtainAttributes.getString(a.b.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(a.b.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(a.b.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(a.b.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(a.b.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(a.b.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new android.support.v4.e.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(d(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
    }

    private static c d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.b.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(a.b.FontFamilyFont_fontWeight) ? a.b.FontFamilyFont_fontWeight : a.b.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(a.b.FontFamilyFont_fontStyle) ? a.b.FontFamilyFont_fontStyle : a.b.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(a.b.FontFamilyFont_font) ? a.b.FontFamilyFont_font : a.b.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i2, 0);
        String string = obtainAttributes.getString(i2);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new c(string, i, z, resourceId);
    }
}