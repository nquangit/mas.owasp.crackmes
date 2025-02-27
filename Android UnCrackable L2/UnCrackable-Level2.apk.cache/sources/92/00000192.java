package android.support.v7.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
final class a {
    private static int a(int i, float f) {
        return android.support.v4.b.a.b(i, Math.round(Color.alpha(i) * f));
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return a(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.res.ColorStateList b(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) {
        /*
            r0 = r19
            int r1 = r18.getDepth()
            r2 = 1
            int r1 = r1 + r2
            r3 = 20
            int[][] r3 = new int[r3]
            int r4 = r3.length
            int[] r4 = new int[r4]
            r5 = 0
            r6 = 0
        L11:
            int r7 = r18.next()
            if (r7 == r2) goto Lb2
            int r8 = r18.getDepth()
            if (r8 >= r1) goto L20
            r9 = 3
            if (r7 == r9) goto Lb2
        L20:
            r9 = 2
            if (r7 != r9) goto Lab
            if (r8 > r1) goto Lab
            java.lang.String r7 = r18.getName()
            java.lang.String r8 = "item"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L33
            goto Lab
        L33:
            int[] r7 = android.support.v7.a.a.j.ColorStateListItem
            r8 = r17
            r9 = r20
            android.content.res.TypedArray r7 = a(r8, r9, r0, r7)
            int r10 = android.support.v7.a.a.j.ColorStateListItem_android_color
            r11 = -65281(0xffffffffffff00ff, float:NaN)
            int r10 = r7.getColor(r10, r11)
            r11 = 1065353216(0x3f800000, float:1.0)
            int r12 = android.support.v7.a.a.j.ColorStateListItem_android_alpha
            boolean r12 = r7.hasValue(r12)
            if (r12 == 0) goto L57
            int r12 = android.support.v7.a.a.j.ColorStateListItem_android_alpha
        L52:
            float r11 = r7.getFloat(r12, r11)
            goto L62
        L57:
            int r12 = android.support.v7.a.a.j.ColorStateListItem_alpha
            boolean r12 = r7.hasValue(r12)
            if (r12 == 0) goto L62
            int r12 = android.support.v7.a.a.j.ColorStateListItem_alpha
            goto L52
        L62:
            r7.recycle()
            int r7 = r19.getAttributeCount()
            int[] r12 = new int[r7]
            r13 = 0
            r14 = 0
        L6d:
            if (r13 >= r7) goto L92
            int r15 = r0.getAttributeNameResource(r13)
            r2 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r15 == r2) goto L8e
            r2 = 16843551(0x101031f, float:2.3695797E-38)
            if (r15 == r2) goto L8e
            int r2 = android.support.v7.a.a.C0011a.alpha
            if (r15 == r2) goto L8e
            int r2 = r14 + 1
            boolean r16 = r0.getAttributeBooleanValue(r13, r5)
            if (r16 == 0) goto L8a
            goto L8b
        L8a:
            int r15 = -r15
        L8b:
            r12[r14] = r15
            r14 = r2
        L8e:
            int r13 = r13 + 1
            r2 = 1
            goto L6d
        L92:
            int[] r2 = android.util.StateSet.trimStateSet(r12, r14)
            int r7 = a(r10, r11)
            if (r6 == 0) goto L9d
            int r10 = r2.length
        L9d:
            int[] r4 = android.support.v7.b.a.c.a(r4, r6, r7)
            java.lang.Object[] r2 = android.support.v7.b.a.c.a(r3, r6, r2)
            r3 = r2
            int[][] r3 = (int[][]) r3
            int r6 = r6 + 1
            goto Laf
        Lab:
            r8 = r17
            r9 = r20
        Laf:
            r2 = 1
            goto L11
        Lb2:
            int[] r0 = new int[r6]
            int[][] r1 = new int[r6]
            java.lang.System.arraycopy(r4, r5, r0, r5, r6)
            java.lang.System.arraycopy(r3, r5, r1, r5, r6)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.b.a.a.b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }
}