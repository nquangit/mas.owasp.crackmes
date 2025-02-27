package android.support.v4.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class c {
    public static float a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static String a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (a(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static boolean a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    public static TypedValue b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (a(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }

    public static int c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }
}