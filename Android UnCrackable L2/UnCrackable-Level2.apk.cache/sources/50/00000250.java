package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class l {
    private static l b;
    private WeakHashMap<Context, android.support.v4.f.l<ColorStateList>> j;
    private android.support.v4.f.a<String, c> k;
    private android.support.v4.f.l<String> l;
    private final Object m = new Object();
    private final WeakHashMap<Context, android.support.v4.f.f<WeakReference<Drawable.ConstantState>>> n = new WeakHashMap<>(0);
    private TypedValue o;
    private boolean p;
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private static final b c = new b(6);
    private static final int[] d = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};
    private static final int[] i = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements c {
        a() {
        }

        @Override // android.support.v7.widget.l.c
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.b.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends android.support.v4.f.g<Integer, PorterDuffColorFilter> {
        public b(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return a((b) Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a((b) Integer.valueOf(b(i, mode)), (Integer) porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements c {
        d() {
        }

        @Override // android.support.v7.widget.l.c
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.b.a.i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    static PorterDuff.Mode a(int i2) {
        if (i2 == a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public static PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2 = c.a(i2, mode);
        if (a2 == null) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
            c.a(i2, mode, porterDuffColorFilter);
            return porterDuffColorFilter;
        }
        return a2;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        LayerDrawable layerDrawable;
        Drawable findDrawableByLayerId;
        int i3;
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (af.b(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable f2 = android.support.v4.b.a.a.f(drawable);
            android.support.v4.b.a.a.a(f2, b2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 != null) {
                android.support.v4.b.a.a.a(f2, a2);
                return f2;
            }
            return f2;
        }
        if (i2 == a.e.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ar.a(context, a.C0011a.colorControlNormal), a);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i3 = a.C0011a.colorControlNormal;
        } else if (i2 != a.e.abc_ratingbar_material && i2 != a.e.abc_ratingbar_indicator_material && i2 != a.e.abc_ratingbar_small_material) {
            if (a(context, i2, drawable) || !z) {
                return drawable;
            }
            return null;
        } else {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), ar.c(context, a.C0011a.colorControlNormal), a);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i3 = a.C0011a.colorControlActivated;
        }
        a(findDrawableByLayerId, ar.a(context, i3), a);
        a(layerDrawable.findDrawableByLayerId(16908301), ar.a(context, a.C0011a.colorControlActivated), a);
        return drawable;
    }

    private Drawable a(Context context, long j) {
        synchronized (this.m) {
            android.support.v4.f.f<WeakReference<Drawable.ConstantState>> fVar = this.n.get(context);
            if (fVar == null) {
                return null;
            }
            WeakReference<Drawable.ConstantState> a2 = fVar.a(j);
            if (a2 != null) {
                Drawable.ConstantState constantState = a2.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                fVar.b(j);
            }
            return null;
        }
    }

    public static l a() {
        if (b == null) {
            b = new l();
            a(b);
        }
        return b;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap<>();
        }
        android.support.v4.f.l<ColorStateList> lVar = this.j.get(context);
        if (lVar == null) {
            lVar = new android.support.v4.f.l<>();
            this.j.put(context, lVar);
        }
        lVar.c(i2, colorStateList);
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (af.b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable, au auVar, int[] iArr) {
        if (af.b(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (auVar.d || auVar.c) {
            drawable.setColorFilter(a(auVar.d ? auVar.a : null, auVar.c ? auVar.b : a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static void a(l lVar) {
        if (Build.VERSION.SDK_INT < 24) {
            lVar.a("vector", new d());
            lVar.a("animated-vector", new a());
        }
    }

    private void a(String str, c cVar) {
        if (this.k == null) {
            this.k = new android.support.v4.f.a<>();
        }
        this.k.put(str, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = android.support.v7.widget.l.a
            int[] r1 = android.support.v7.widget.l.d
            boolean r1 = a(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            int r2 = android.support.v7.a.a.C0011a.colorControlNormal
        L12:
            r7 = 1
            r1 = -1
            goto L44
        L15:
            int[] r1 = android.support.v7.widget.l.f
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L20
            int r2 = android.support.v7.a.a.C0011a.colorControlActivated
            goto L12
        L20:
            int[] r1 = android.support.v7.widget.l.g
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L2b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L12
        L2b:
            int r1 = android.support.v7.a.a.e.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L3c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L44
        L3c:
            int r1 = android.support.v7.a.a.e.abc_dialog_material_background
            if (r7 != r1) goto L41
            goto L12
        L41:
            r7 = 0
            r1 = -1
            r2 = 0
        L44:
            if (r7 == 0) goto L61
            boolean r7 = android.support.v7.widget.af.b(r8)
            if (r7 == 0) goto L50
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L50:
            int r6 = android.support.v7.widget.ar.a(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = a(r6, r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L60
            r8.setAlpha(r1)
        L60:
            return r5
        L61:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    private boolean a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            synchronized (this.m) {
                android.support.v4.f.f<WeakReference<Drawable.ConstantState>> fVar = this.n.get(context);
                if (fVar == null) {
                    fVar = new android.support.v4.f.f<>();
                    this.n.put(context, fVar);
                }
                fVar.b(j, new WeakReference<>(constantState));
            }
            return true;
        }
        return false;
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof android.support.b.a.i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList b(Context context) {
        return f(context, ar.a(context, a.C0011a.colorButtonNormal));
    }

    private ColorStateList c(Context context) {
        return f(context, 0);
    }

    private Drawable c(Context context, int i2) {
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        if (i2 == a.e.abc_cab_background_top_material) {
            a3 = new LayerDrawable(new Drawable[]{a(context, a.e.abc_cab_background_internal_bg), a(context, a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a3);
        }
        return a3;
    }

    private ColorStateList d(Context context) {
        return f(context, ar.a(context, a.C0011a.colorAccent));
    }

    private Drawable d(Context context, int i2) {
        int next;
        if (this.k == null || this.k.isEmpty()) {
            return null;
        }
        if (this.l != null) {
            String a2 = this.l.a(i2);
            if ("appcompat_skip_skip".equals(a2) || (a2 != null && this.k.get(a2) == null)) {
                return null;
            }
        } else {
            this.l = new android.support.v4.f.l<>();
        }
        if (this.o == null) {
            this.o = new TypedValue();
        }
        TypedValue typedValue = this.o;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long a3 = a(typedValue);
        Drawable a4 = a(context, a3);
        if (a4 != null) {
            return a4;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.l.c(i2, name);
                c cVar = this.k.get(name);
                if (cVar != null) {
                    a4 = cVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a4 != null) {
                    a4.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a3, a4);
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (a4 == null) {
            this.l.c(i2, "appcompat_skip_skip");
        }
        return a4;
    }

    private ColorStateList e(Context context) {
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        ColorStateList b2 = ar.b(context, a.C0011a.colorSwitchThumbNormal);
        if (b2 == null || !b2.isStateful()) {
            iArr[0] = ar.a;
            iArr2[0] = ar.c(context, a.C0011a.colorSwitchThumbNormal);
            iArr[1] = ar.e;
            iArr2[1] = ar.a(context, a.C0011a.colorControlActivated);
            iArr[2] = ar.h;
            iArr2[2] = ar.a(context, a.C0011a.colorSwitchThumbNormal);
        } else {
            iArr[0] = ar.a;
            iArr2[0] = b2.getColorForState(iArr[0], 0);
            iArr[1] = ar.e;
            iArr2[1] = ar.a(context, a.C0011a.colorControlActivated);
            iArr[2] = ar.h;
            iArr2[2] = b2.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList e(Context context, int i2) {
        android.support.v4.f.l<ColorStateList> lVar;
        if (this.j == null || (lVar = this.j.get(context)) == null) {
            return null;
        }
        return lVar.a(i2);
    }

    private ColorStateList f(Context context, int i2) {
        int a2 = ar.a(context, a.C0011a.colorControlHighlight);
        return new ColorStateList(new int[][]{ar.a, ar.d, ar.b, ar.h}, new int[]{ar.c(context, a.C0011a.colorButtonNormal), android.support.v4.b.a.a(a2, i2), android.support.v4.b.a.a(a2, i2), i2});
    }

    private void f(Context context) {
        if (this.p) {
            return;
        }
        this.p = true;
        Drawable a2 = a(context, a.e.abc_vector_test);
        if (a2 == null || !a(a2)) {
            this.p = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable a(Context context, int i2, boolean z) {
        f(context);
        Drawable d2 = d(context, i2);
        if (d2 == null) {
            d2 = c(context, i2);
        }
        if (d2 == null) {
            d2 = android.support.v4.a.a.a(context, i2);
        }
        if (d2 != null) {
            d2 = a(context, i2, z, d2);
        }
        if (d2 != null) {
            af.a(d2);
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable a(Context context, bb bbVar, int i2) {
        Drawable d2 = d(context, i2);
        if (d2 == null) {
            d2 = bbVar.a(i2);
        }
        if (d2 != null) {
            return a(context, i2, false, d2);
        }
        return null;
    }

    public void a(Context context) {
        synchronized (this.m) {
            android.support.v4.f.f<WeakReference<Drawable.ConstantState>> fVar = this.n.get(context);
            if (fVar != null) {
                fVar.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.res.ColorStateList b(android.content.Context r3, int r4) {
        /*
            r2 = this;
            android.content.res.ColorStateList r0 = r2.e(r3, r4)
            if (r0 != 0) goto L7a
            int r1 = android.support.v7.a.a.e.abc_edit_text_material
            if (r4 != r1) goto L12
            int r0 = android.support.v7.a.a.c.abc_tint_edittext
        Lc:
            android.content.res.ColorStateList r0 = android.support.v7.b.a.b.a(r3, r0)
            goto L75
        L12:
            int r1 = android.support.v7.a.a.e.abc_switch_track_mtrl_alpha
            if (r4 != r1) goto L19
            int r0 = android.support.v7.a.a.c.abc_tint_switch_track
            goto Lc
        L19:
            int r1 = android.support.v7.a.a.e.abc_switch_thumb_material
            if (r4 != r1) goto L22
            android.content.res.ColorStateList r0 = r2.e(r3)
            goto L75
        L22:
            int r1 = android.support.v7.a.a.e.abc_btn_default_mtrl_shape
            if (r4 != r1) goto L2b
            android.content.res.ColorStateList r0 = r2.b(r3)
            goto L75
        L2b:
            int r1 = android.support.v7.a.a.e.abc_btn_borderless_material
            if (r4 != r1) goto L34
            android.content.res.ColorStateList r0 = r2.c(r3)
            goto L75
        L34:
            int r1 = android.support.v7.a.a.e.abc_btn_colored_material
            if (r4 != r1) goto L3d
            android.content.res.ColorStateList r0 = r2.d(r3)
            goto L75
        L3d:
            int r1 = android.support.v7.a.a.e.abc_spinner_mtrl_am_alpha
            if (r4 == r1) goto L72
            int r1 = android.support.v7.a.a.e.abc_spinner_textfield_background_material
            if (r4 != r1) goto L46
            goto L72
        L46:
            int[] r1 = android.support.v7.widget.l.e
            boolean r1 = a(r1, r4)
            if (r1 == 0) goto L55
            int r0 = android.support.v7.a.a.C0011a.colorControlNormal
            android.content.res.ColorStateList r0 = android.support.v7.widget.ar.b(r3, r0)
            goto L75
        L55:
            int[] r1 = android.support.v7.widget.l.h
            boolean r1 = a(r1, r4)
            if (r1 == 0) goto L60
            int r0 = android.support.v7.a.a.c.abc_tint_default
            goto Lc
        L60:
            int[] r1 = android.support.v7.widget.l.i
            boolean r1 = a(r1, r4)
            if (r1 == 0) goto L6b
            int r0 = android.support.v7.a.a.c.abc_tint_btn_checkable
            goto Lc
        L6b:
            int r1 = android.support.v7.a.a.e.abc_seekbar_thumb_material
            if (r4 != r1) goto L75
            int r0 = android.support.v7.a.a.c.abc_tint_seek_thumb
            goto Lc
        L72:
            int r0 = android.support.v7.a.a.c.abc_tint_spinner
            goto Lc
        L75:
            if (r0 == 0) goto L7a
            r2.a(r3, r4, r0)
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.b(android.content.Context, int):android.content.res.ColorStateList");
    }
}