package android.support.v4.b;

import android.graphics.Path;
import android.support.v7.a.a;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int a;
        boolean b;

        a() {
        }
    }

    /* renamed from: android.support.v4.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0005b {
        public char a;
        public float[] b;

        C0005b(char c, float[] fArr) {
            this.a = c;
            this.b = fArr;
        }

        C0005b(C0005b c0005b) {
            this.a = c0005b.a;
            this.b = b.a(c0005b.b, 0, c0005b.b.length);
        }

        private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = d11 * sin;
            double d15 = d4 * cos;
            double d16 = (sin2 * d14) + (cos2 * d15);
            double d17 = ceil;
            Double.isNaN(d17);
            double d18 = d9 / d17;
            int i = 0;
            double d19 = d6;
            double d20 = d16;
            double d21 = (d12 * sin2) - (d13 * cos2);
            double d22 = d5;
            double d23 = d8;
            while (i < ceil) {
                double d24 = d23 + d18;
                double sin3 = Math.sin(d24);
                double cos3 = Math.cos(d24);
                double d25 = d18;
                double d26 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d27 = d2 + (d10 * sin * cos3) + (d15 * sin3);
                double d28 = (d12 * sin3) - (d13 * cos3);
                double d29 = (sin3 * d14) + (cos3 * d15);
                double d30 = d24 - d23;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d22 + (d21 * sin4)), (float) (d19 + (d20 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
                i++;
                d19 = d27;
                d22 = d26;
                d23 = d24;
                d20 = d29;
                d21 = d28;
                d18 = d25;
                d15 = d15;
                d14 = d14;
                ceil = ceil;
                cos = cos;
                sin = sin;
                d10 = d3;
            }
        }

        private static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = f;
            Double.isNaN(d3);
            double d4 = d3 * cos;
            double d5 = f2;
            Double.isNaN(d5);
            double d6 = f5;
            Double.isNaN(d6);
            double d7 = (d4 + (d5 * sin)) / d6;
            double d8 = -f;
            Double.isNaN(d8);
            Double.isNaN(d5);
            double d9 = f6;
            Double.isNaN(d9);
            double d10 = ((d8 * sin) + (d5 * cos)) / d9;
            double d11 = f3;
            Double.isNaN(d11);
            double d12 = f4;
            Double.isNaN(d12);
            Double.isNaN(d6);
            double d13 = ((d11 * cos) + (d12 * sin)) / d6;
            double d14 = -f3;
            Double.isNaN(d14);
            Double.isNaN(d12);
            Double.isNaN(d9);
            double d15 = ((d14 * sin) + (d12 * cos)) / d9;
            double d16 = d7 - d13;
            double d17 = d10 - d15;
            double d18 = (d7 + d13) / 2.0d;
            double d19 = (d10 + d15) / 2.0d;
            double d20 = (d16 * d16) + (d17 * d17);
            if (d20 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d21 = (1.0d / d20) - 0.25d;
            if (d21 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d20);
                float sqrt = (float) (Math.sqrt(d20) / 1.99999d);
                a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d21);
            double d22 = d16 * sqrt2;
            double d23 = sqrt2 * d17;
            if (z == z2) {
                d = d18 - d23;
                d2 = d19 + d22;
            } else {
                d = d18 + d23;
                d2 = d19 - d22;
            }
            double atan2 = Math.atan2(d10 - d2, d7 - d);
            double atan22 = Math.atan2(d15 - d2, d13 - d) - atan2;
            if (z2 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d6);
            double d24 = d * d6;
            Double.isNaN(d9);
            double d25 = d2 * d9;
            a(path, (d24 * cos) - (d25 * sin), (d24 * sin) + (d25 * cos), d6, d9, d3, d5, radians, atan2, atan22);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[2];
            float f15 = fArr[3];
            float f16 = fArr[4];
            float f17 = fArr[5];
            switch (c2) {
                case a.j.AppCompatTheme_editTextBackground /* 65 */:
                case a.j.AppCompatTheme_textAppearanceListItemSecondary /* 97 */:
                    i = 7;
                    break;
                case a.j.AppCompatTheme_editTextStyle /* 67 */:
                case a.j.AppCompatTheme_textAppearancePopupMenuHeader /* 99 */:
                    i = 6;
                    break;
                case a.j.AppCompatTheme_listMenuViewStyle /* 72 */:
                case a.j.AppCompatTheme_ratingBarStyleIndicator /* 86 */:
                case a.j.AppCompatTheme_textColorSearchUrl /* 104 */:
                case a.j.AppCompatTheme_windowMinWidthMinor /* 118 */:
                    i = 1;
                    break;
                case a.j.AppCompatTheme_listPreferredItemHeightSmall /* 76 */:
                case a.j.AppCompatTheme_listPreferredItemPaddingLeft /* 77 */:
                case a.j.AppCompatTheme_radioButtonStyle /* 84 */:
                case a.j.AppCompatTheme_tooltipFrameBackground /* 108 */:
                case a.j.AppCompatTheme_viewInflaterClass /* 109 */:
                case a.j.AppCompatTheme_windowFixedWidthMinor /* 116 */:
                default:
                    i = 2;
                    break;
                case a.j.AppCompatTheme_panelMenuListWidth /* 81 */:
                case a.j.AppCompatTheme_popupWindowStyle /* 83 */:
                case a.j.AppCompatTheme_windowFixedHeightMajor /* 113 */:
                case a.j.AppCompatTheme_windowFixedWidthMajor /* 115 */:
                    i = 4;
                    break;
                case a.j.AppCompatTheme_selectableItemBackground /* 90 */:
                case 'z':
                    path.close();
                    path.moveTo(f16, f17);
                    f12 = f16;
                    f14 = f12;
                    f13 = f17;
                    f15 = f13;
                    i = 2;
                    break;
            }
            float f18 = f12;
            float f19 = f13;
            float f20 = f16;
            float f21 = f17;
            int i3 = 0;
            char c3 = c;
            while (i3 < fArr2.length) {
                float f22 = 0.0f;
                switch (c2) {
                    case a.j.AppCompatTheme_editTextBackground /* 65 */:
                        i2 = i3;
                        int i4 = i2 + 5;
                        int i5 = i2 + 6;
                        a(path, f18, f19, fArr2[i4], fArr2[i5], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f18 = fArr2[i4];
                        f19 = fArr2[i5];
                        f15 = f19;
                        f14 = f18;
                        break;
                    case a.j.AppCompatTheme_editTextStyle /* 67 */:
                        i2 = i3;
                        int i6 = i2 + 2;
                        int i7 = i2 + 3;
                        int i8 = i2 + 4;
                        int i9 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i6], fArr2[i7], fArr2[i8], fArr2[i9]);
                        f18 = fArr2[i8];
                        float f23 = fArr2[i9];
                        float f24 = fArr2[i6];
                        float f25 = fArr2[i7];
                        f19 = f23;
                        f15 = f25;
                        f14 = f24;
                        break;
                    case a.j.AppCompatTheme_listMenuViewStyle /* 72 */:
                        i2 = i3;
                        int i10 = i2 + 0;
                        path.lineTo(fArr2[i10], f19);
                        f18 = fArr2[i10];
                        break;
                    case a.j.AppCompatTheme_listPreferredItemHeightSmall /* 76 */:
                        i2 = i3;
                        int i11 = i2 + 0;
                        int i12 = i2 + 1;
                        path.lineTo(fArr2[i11], fArr2[i12]);
                        f18 = fArr2[i11];
                        f19 = fArr2[i12];
                        break;
                    case a.j.AppCompatTheme_listPreferredItemPaddingLeft /* 77 */:
                        i2 = i3;
                        int i13 = i2 + 0;
                        f18 = fArr2[i13];
                        int i14 = i2 + 1;
                        f19 = fArr2[i14];
                        if (i2 <= 0) {
                            path.moveTo(fArr2[i13], fArr2[i14]);
                            f21 = f19;
                            f20 = f18;
                            break;
                        } else {
                            path.lineTo(fArr2[i13], fArr2[i14]);
                            break;
                        }
                    case a.j.AppCompatTheme_panelMenuListWidth /* 81 */:
                        i2 = i3;
                        int i15 = i2 + 0;
                        int i16 = i2 + 1;
                        int i17 = i2 + 2;
                        int i18 = i2 + 3;
                        path.quadTo(fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                        f = fArr2[i15];
                        f2 = fArr2[i16];
                        f18 = fArr2[i17];
                        f19 = fArr2[i18];
                        f14 = f;
                        f15 = f2;
                        break;
                    case a.j.AppCompatTheme_popupWindowStyle /* 83 */:
                        float f26 = f19;
                        float f27 = f18;
                        i2 = i3;
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f28 = (f27 * 2.0f) - f14;
                            f3 = (f26 * 2.0f) - f15;
                            f4 = f28;
                        } else {
                            f4 = f27;
                            f3 = f26;
                        }
                        int i19 = i2 + 0;
                        int i20 = i2 + 1;
                        int i21 = i2 + 2;
                        int i22 = i2 + 3;
                        path.cubicTo(f4, f3, fArr2[i19], fArr2[i20], fArr2[i21], fArr2[i22]);
                        f = fArr2[i19];
                        f2 = fArr2[i20];
                        f18 = fArr2[i21];
                        f19 = fArr2[i22];
                        f14 = f;
                        f15 = f2;
                        break;
                    case a.j.AppCompatTheme_radioButtonStyle /* 84 */:
                        float f29 = f19;
                        float f30 = f18;
                        i2 = i3;
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f29 = (f29 * 2.0f) - f15;
                            f30 = (f30 * 2.0f) - f14;
                        }
                        int i23 = i2 + 0;
                        int i24 = i2 + 1;
                        path.quadTo(f30, f29, fArr2[i23], fArr2[i24]);
                        f18 = fArr2[i23];
                        f19 = fArr2[i24];
                        f14 = f30;
                        f15 = f29;
                        break;
                    case a.j.AppCompatTheme_ratingBarStyleIndicator /* 86 */:
                        i2 = i3;
                        int i25 = i2 + 0;
                        path.lineTo(f18, fArr2[i25]);
                        f19 = fArr2[i25];
                        break;
                    case a.j.AppCompatTheme_textAppearanceListItemSecondary /* 97 */:
                        int i26 = i3 + 5;
                        float f31 = fArr2[i26] + f18;
                        int i27 = i3 + 6;
                        float f32 = fArr2[i27] + f19;
                        float f33 = fArr2[i3 + 0];
                        float f34 = fArr2[i3 + 1];
                        float f35 = fArr2[i3 + 2];
                        float f36 = f18;
                        boolean z = fArr2[i3 + 3] != 0.0f;
                        i2 = i3;
                        a(path, f18, f19, f31, f32, f33, f34, f35, z, fArr2[i3 + 4] != 0.0f);
                        f18 = f36 + fArr2[i26];
                        f19 += fArr2[i27];
                        f15 = f19;
                        f14 = f18;
                        break;
                    case a.j.AppCompatTheme_textAppearancePopupMenuHeader /* 99 */:
                        int i28 = i3 + 2;
                        int i29 = i3 + 3;
                        int i30 = i3 + 4;
                        int i31 = i3 + 5;
                        path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i28], fArr2[i29], fArr2[i30], fArr2[i31]);
                        f5 = fArr2[i28] + f18;
                        f6 = fArr2[i29] + f19;
                        f18 += fArr2[i30];
                        f7 = fArr2[i31];
                        f19 += f7;
                        f14 = f5;
                        f15 = f6;
                        i2 = i3;
                        break;
                    case a.j.AppCompatTheme_textColorSearchUrl /* 104 */:
                        int i32 = i3 + 0;
                        path.rLineTo(fArr2[i32], 0.0f);
                        f18 += fArr2[i32];
                        i2 = i3;
                        break;
                    case a.j.AppCompatTheme_tooltipFrameBackground /* 108 */:
                        int i33 = i3 + 0;
                        int i34 = i3 + 1;
                        path.rLineTo(fArr2[i33], fArr2[i34]);
                        f18 += fArr2[i33];
                        f8 = fArr2[i34];
                        f19 += f8;
                        i2 = i3;
                        break;
                    case a.j.AppCompatTheme_viewInflaterClass /* 109 */:
                        int i35 = i3 + 0;
                        f18 += fArr2[i35];
                        int i36 = i3 + 1;
                        f19 += fArr2[i36];
                        if (i3 > 0) {
                            path.rLineTo(fArr2[i35], fArr2[i36]);
                        } else {
                            path.rMoveTo(fArr2[i35], fArr2[i36]);
                            f21 = f19;
                            f20 = f18;
                        }
                        i2 = i3;
                        break;
                    case a.j.AppCompatTheme_windowFixedHeightMajor /* 113 */:
                        int i37 = i3 + 0;
                        int i38 = i3 + 1;
                        int i39 = i3 + 2;
                        int i40 = i3 + 3;
                        path.rQuadTo(fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                        f5 = fArr2[i37] + f18;
                        f6 = fArr2[i38] + f19;
                        f18 += fArr2[i39];
                        f7 = fArr2[i40];
                        f19 += f7;
                        f14 = f5;
                        f15 = f6;
                        i2 = i3;
                        break;
                    case a.j.AppCompatTheme_windowFixedWidthMajor /* 115 */:
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f37 = f18 - f14;
                            f9 = f19 - f15;
                            f10 = f37;
                        } else {
                            f10 = 0.0f;
                            f9 = 0.0f;
                        }
                        int i41 = i3 + 0;
                        int i42 = i3 + 1;
                        int i43 = i3 + 2;
                        int i44 = i3 + 3;
                        path.rCubicTo(f10, f9, fArr2[i41], fArr2[i42], fArr2[i43], fArr2[i44]);
                        f5 = fArr2[i41] + f18;
                        f6 = fArr2[i42] + f19;
                        f18 += fArr2[i43];
                        f7 = fArr2[i44];
                        f19 += f7;
                        f14 = f5;
                        f15 = f6;
                        i2 = i3;
                        break;
                    case a.j.AppCompatTheme_windowFixedWidthMinor /* 116 */:
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f22 = f18 - f14;
                            f11 = f19 - f15;
                        } else {
                            f11 = 0.0f;
                        }
                        int i45 = i3 + 0;
                        int i46 = i3 + 1;
                        path.rQuadTo(f22, f11, fArr2[i45], fArr2[i46]);
                        float f38 = f22 + f18;
                        float f39 = f11 + f19;
                        f18 += fArr2[i45];
                        f19 += fArr2[i46];
                        f15 = f39;
                        f14 = f38;
                        i2 = i3;
                        break;
                    case a.j.AppCompatTheme_windowMinWidthMinor /* 118 */:
                        int i47 = i3 + 0;
                        path.rLineTo(0.0f, fArr2[i47]);
                        f8 = fArr2[i47];
                        f19 += f8;
                        i2 = i3;
                        break;
                    default:
                        i2 = i3;
                        break;
                }
                i3 = i2 + i;
                c3 = c2;
            }
            fArr[0] = f18;
            fArr[1] = f19;
            fArr[2] = f14;
            fArr[3] = f15;
            fArr[4] = f20;
            fArr[5] = f21;
        }

        public static void a(C0005b[] c0005bArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < c0005bArr.length; i++) {
                a(path, fArr, c, c0005bArr[i].a, c0005bArr[i].b);
                c = c0005bArr[i].a;
            }
        }

        public void a(C0005b c0005b, C0005b c0005b2, float f) {
            for (int i = 0; i < c0005b.b.length; i++) {
                this.b[i] = (c0005b.b[i] * (1.0f - f)) + (c0005b2.b[i] * f);
            }
        }
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static Path a(String str) {
        Path path = new Path();
        C0005b[] b = b(str);
        if (b != null) {
            try {
                C0005b.a(b, path);
                return path;
            } catch (RuntimeException e) {
                throw new RuntimeException("Error in parsing " + str, e);
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (r2 == false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038 A[LOOP:0: B:3:0x0007->B:24:0x0038, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r8, int r9, android.support.v4.b.b.a r10) {
        /*
            r0 = 0
            r10.b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3b
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L33
            r6 = 69
            if (r5 == r6) goto L31
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L31
            switch(r5) {
                case 44: goto L33;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L2f
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L35
        L27:
            r10.b = r7
            goto L33
        L2a:
            if (r1 == r9) goto L2f
            if (r2 != 0) goto L2f
            goto L27
        L2f:
            r2 = 0
            goto L35
        L31:
            r2 = 1
            goto L35
        L33:
            r2 = 0
            r4 = 1
        L35:
            if (r4 == 0) goto L38
            goto L3b
        L38:
            int r1 = r1 + 1
            goto L7
        L3b:
            r10.a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.b.a(java.lang.String, int, android.support.v4.b.b$a):void");
    }

    private static void a(ArrayList<C0005b> arrayList, char c, float[] fArr) {
        arrayList.add(new C0005b(c, fArr));
    }

    public static boolean a(C0005b[] c0005bArr, C0005b[] c0005bArr2) {
        if (c0005bArr == null || c0005bArr2 == null || c0005bArr.length != c0005bArr2.length) {
            return false;
        }
        for (int i = 0; i < c0005bArr.length; i++) {
            if (c0005bArr[i].a != c0005bArr2[i].a || c0005bArr[i].b.length != c0005bArr2[i].b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] a(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static C0005b[] a(C0005b[] c0005bArr) {
        if (c0005bArr == null) {
            return null;
        }
        C0005b[] c0005bArr2 = new C0005b[c0005bArr.length];
        for (int i = 0; i < c0005bArr.length; i++) {
            c0005bArr2[i] = new C0005b(c0005bArr[i]);
        }
        return c0005bArr2;
    }

    public static void b(C0005b[] c0005bArr, C0005b[] c0005bArr2) {
        for (int i = 0; i < c0005bArr2.length; i++) {
            c0005bArr[i].a = c0005bArr2[i].a;
            for (int i2 = 0; i2 < c0005bArr2[i].b.length; i2++) {
                c0005bArr[i].b[i2] = c0005bArr2[i].b[i2];
            }
        }
    }

    public static C0005b[] b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a2 = a(str, i);
            String trim = str.substring(i2, a2).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), c(trim));
            }
            i2 = a2;
            i = a2 + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (C0005b[]) arrayList.toArray(new C0005b[arrayList.size()]);
    }

    private static float[] c(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                a(str, i, aVar);
                int i3 = aVar.a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = aVar.b ? i3 : i3 + 1;
            }
            return a(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }
}