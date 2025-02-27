package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    private final ActionMenuView.e H;
    private ax I;
    private android.support.v7.widget.d J;
    private a K;
    private o.a L;
    private h.a M;
    private boolean N;
    private final Runnable O;
    ImageButton a;
    View b;
    int c;
    c d;
    private ActionMenuView e;
    private TextView f;
    private TextView g;
    private ImageButton h;
    private ImageView i;
    private Drawable j;
    private CharSequence k;
    private Context l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private ao u;
    private int v;
    private int w;
    private int x;
    private CharSequence y;
    private CharSequence z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements android.support.v7.view.menu.o {
        android.support.v7.view.menu.h a;
        android.support.v7.view.menu.j b;

        a() {
        }

        @Override // android.support.v7.view.menu.o
        public void a(Context context, android.support.v7.view.menu.h hVar) {
            if (this.a != null && this.b != null) {
                this.a.d(this.b);
            }
            this.a = hVar;
        }

        @Override // android.support.v7.view.menu.o
        public void a(android.support.v7.view.menu.h hVar, boolean z) {
        }

        @Override // android.support.v7.view.menu.o
        public void a(o.a aVar) {
        }

        @Override // android.support.v7.view.menu.o
        public boolean a(android.support.v7.view.menu.h hVar, android.support.v7.view.menu.j jVar) {
            Toolbar.this.i();
            ViewParent parent = Toolbar.this.a.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.a);
                }
                Toolbar.this.addView(Toolbar.this.a);
            }
            Toolbar.this.b = jVar.getActionView();
            this.b = jVar;
            ViewParent parent2 = Toolbar.this.b.getParent();
            if (parent2 != Toolbar.this) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(Toolbar.this.b);
                }
                b generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.a = 8388611 | (Toolbar.this.c & a.j.AppCompatTheme_windowActionModeOverlay);
                generateDefaultLayoutParams.b = 2;
                Toolbar.this.b.setLayoutParams(generateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.b);
            }
            Toolbar.this.k();
            Toolbar.this.requestLayout();
            jVar.e(true);
            if (Toolbar.this.b instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) Toolbar.this.b).a();
            }
            return true;
        }

        @Override // android.support.v7.view.menu.o
        public boolean a(android.support.v7.view.menu.u uVar) {
            return false;
        }

        @Override // android.support.v7.view.menu.o
        public void b(boolean z) {
            if (this.b != null) {
                boolean z2 = false;
                if (this.a != null) {
                    int size = this.a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.a.getItem(i) == this.b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                b(this.a, this.b);
            }
        }

        @Override // android.support.v7.view.menu.o
        public boolean b() {
            return false;
        }

        @Override // android.support.v7.view.menu.o
        public boolean b(android.support.v7.view.menu.h hVar, android.support.v7.view.menu.j jVar) {
            if (Toolbar.this.b instanceof android.support.v7.view.c) {
                ((android.support.v7.view.c) Toolbar.this.b).b();
            }
            Toolbar.this.removeView(Toolbar.this.b);
            Toolbar.this.removeView(Toolbar.this.a);
            Toolbar.this.b = null;
            Toolbar.this.l();
            this.b = null;
            Toolbar.this.requestLayout();
            jVar.e(false);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a.C0013a {
        int b;

        public b(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public b(a.C0013a c0013a) {
            super(c0013a);
            this.b = 0;
        }

        public b(b bVar) {
            super((a.C0013a) bVar);
            this.b = 0;
            this.b = bVar.b;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public static class d extends android.support.v4.g.a {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>() { // from class: android.support.v7.widget.Toolbar.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };
        int b;
        boolean c;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readInt();
            this.c = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.g.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.H = new ActionMenuView.e() { // from class: android.support.v7.widget.Toolbar.1
            @Override // android.support.v7.widget.ActionMenuView.e
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.d != null) {
                    return Toolbar.this.d.a(menuItem);
                }
                return false;
            }
        };
        this.O = new Runnable() { // from class: android.support.v7.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.d();
            }
        };
        aw a2 = aw.a(getContext(), attributeSet, a.j.Toolbar, i, 0);
        this.n = a2.g(a.j.Toolbar_titleTextAppearance, 0);
        this.o = a2.g(a.j.Toolbar_subtitleTextAppearance, 0);
        this.x = a2.c(a.j.Toolbar_android_gravity, this.x);
        this.c = a2.c(a.j.Toolbar_buttonGravity, 48);
        int d2 = a2.d(a.j.Toolbar_titleMargin, 0);
        d2 = a2.g(a.j.Toolbar_titleMargins) ? a2.d(a.j.Toolbar_titleMargins, d2) : d2;
        this.t = d2;
        this.s = d2;
        this.r = d2;
        this.q = d2;
        int d3 = a2.d(a.j.Toolbar_titleMarginStart, -1);
        if (d3 >= 0) {
            this.q = d3;
        }
        int d4 = a2.d(a.j.Toolbar_titleMarginEnd, -1);
        if (d4 >= 0) {
            this.r = d4;
        }
        int d5 = a2.d(a.j.Toolbar_titleMarginTop, -1);
        if (d5 >= 0) {
            this.s = d5;
        }
        int d6 = a2.d(a.j.Toolbar_titleMarginBottom, -1);
        if (d6 >= 0) {
            this.t = d6;
        }
        this.p = a2.e(a.j.Toolbar_maxButtonHeight, -1);
        int d7 = a2.d(a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d8 = a2.d(a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e = a2.e(a.j.Toolbar_contentInsetLeft, 0);
        int e2 = a2.e(a.j.Toolbar_contentInsetRight, 0);
        s();
        this.u.b(e, e2);
        if (d7 != Integer.MIN_VALUE || d8 != Integer.MIN_VALUE) {
            this.u.a(d7, d8);
        }
        this.v = a2.d(a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = a2.d(a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.j = a2.a(a.j.Toolbar_collapseIcon);
        this.k = a2.c(a.j.Toolbar_collapseContentDescription);
        CharSequence c2 = a2.c(a.j.Toolbar_title);
        if (!TextUtils.isEmpty(c2)) {
            setTitle(c2);
        }
        CharSequence c3 = a2.c(a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c3)) {
            setSubtitle(c3);
        }
        this.l = getContext();
        setPopupTheme(a2.g(a.j.Toolbar_popupTheme, 0));
        Drawable a3 = a2.a(a.j.Toolbar_navigationIcon);
        if (a3 != null) {
            setNavigationIcon(a3);
        }
        CharSequence c4 = a2.c(a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c4)) {
            setNavigationContentDescription(c4);
        }
        Drawable a4 = a2.a(a.j.Toolbar_logo);
        if (a4 != null) {
            setLogo(a4);
        }
        CharSequence c5 = a2.c(a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c5)) {
            setLogoDescription(c5);
        }
        if (a2.g(a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.b(a.j.Toolbar_titleTextColor, -1));
        }
        if (a2.g(a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.b(a.j.Toolbar_subtitleTextColor, -1));
        }
        a2.a();
    }

    private int a(int i) {
        int i2 = i & a.j.AppCompatTheme_windowActionModeOverlay;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.x & a.j.AppCompatTheme_windowActionModeOverlay;
    }

    private int a(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int a2 = a(bVar.a);
        if (a2 != 48) {
            if (a2 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i3 < bVar.topMargin) {
                    i3 = bVar.topMargin;
                } else {
                    int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                    if (i4 < bVar.bottomMargin) {
                        i3 = Math.max(0, i3 - (bVar.bottomMargin - i4));
                    }
                }
                return paddingTop + i3;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
        }
        return getPaddingTop() - i2;
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int a2 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return max + measuredWidth + bVar.rightMargin;
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View view = list.get(i4);
            b bVar = (b) view.getLayoutParams();
            int i6 = bVar.leftMargin - i;
            int i7 = bVar.rightMargin - i3;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            int max4 = Math.max(0, -i7);
            i5 += max + view.getMeasuredWidth() + max2;
            i4++;
            i3 = max4;
            i = max3;
        }
        return i5;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        b generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (b) layoutParams;
        generateDefaultLayoutParams.b = 1;
        if (!z || this.b == null) {
            addView(view, generateDefaultLayoutParams);
            return;
        }
        view.setLayoutParams(generateDefaultLayoutParams);
        this.F.add(view);
    }

    private void a(List<View> list, int i) {
        boolean z = android.support.v4.g.p.b(this) == 1;
        int childCount = getChildCount();
        int a2 = android.support.v4.g.d.a(i, android.support.v4.g.p.b(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.b == 0 && a(childAt) && b(bVar.a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.b == 0 && a(childAt2) && b(bVar2.a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i) {
        int b2 = android.support.v4.g.p.b(this);
        int a2 = android.support.v4.g.d.a(i, b2) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : b2 == 1 ? 5 : 3;
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.g.f.a(marginLayoutParams) + android.support.v4.g.f.b(marginLayoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a2 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (measuredWidth + bVar.leftMargin);
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new android.support.v7.view.g(getContext());
    }

    private void m() {
        if (this.i == null) {
            this.i = new q(getContext());
        }
    }

    private void n() {
        o();
        if (this.e.d() == null) {
            android.support.v7.view.menu.h hVar = (android.support.v7.view.menu.h) this.e.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.e.setExpandedActionViewsExclusive(true);
            hVar.a(this.K, this.l);
        }
    }

    private void o() {
        if (this.e == null) {
            this.e = new ActionMenuView(getContext());
            this.e.setPopupTheme(this.m);
            this.e.setOnMenuItemClickListener(this.H);
            this.e.a(this.L, this.M);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388613 | (this.c & a.j.AppCompatTheme_windowActionModeOverlay);
            this.e.setLayoutParams(generateDefaultLayoutParams);
            a((View) this.e, false);
        }
    }

    private void p() {
        if (this.h == null) {
            this.h = new o(getContext(), null, a.C0011a.toolbarNavigationButtonStyle);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.c & a.j.AppCompatTheme_windowActionModeOverlay);
            this.h.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private void q() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean r() {
        if (this.N) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void s() {
        if (this.u == null) {
            this.u = new ao();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b ? new b((b) layoutParams) : layoutParams instanceof a.C0013a ? new b((a.C0013a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void a(int i, int i2) {
        s();
        this.u.a(i, i2);
    }

    public void a(Context context, int i) {
        this.n = i;
        if (this.f != null) {
            this.f.setTextAppearance(context, i);
        }
    }

    public void a(android.support.v7.view.menu.h hVar, android.support.v7.widget.d dVar) {
        if (hVar == null && this.e == null) {
            return;
        }
        o();
        android.support.v7.view.menu.h d2 = this.e.d();
        if (d2 == hVar) {
            return;
        }
        if (d2 != null) {
            d2.b(this.J);
            d2.b(this.K);
        }
        if (this.K == null) {
            this.K = new a();
        }
        dVar.d(true);
        if (hVar != null) {
            hVar.a(dVar, this.l);
            hVar.a(this.K, this.l);
        } else {
            dVar.a(this.l, (android.support.v7.view.menu.h) null);
            this.K.a(this.l, (android.support.v7.view.menu.h) null);
            dVar.b(true);
            this.K.b(true);
        }
        this.e.setPopupTheme(this.m);
        this.e.setPresenter(dVar);
        this.J = dVar;
    }

    public void a(o.a aVar, h.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        if (this.e != null) {
            this.e.a(aVar, aVar2);
        }
    }

    public boolean a() {
        return getVisibility() == 0 && this.e != null && this.e.a();
    }

    public void b(Context context, int i) {
        this.o = i;
        if (this.g != null) {
            this.g.setTextAppearance(context, i);
        }
    }

    public boolean b() {
        return this.e != null && this.e.g();
    }

    public boolean c() {
        return this.e != null && this.e.h();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public boolean d() {
        return this.e != null && this.e.e();
    }

    public boolean e() {
        return this.e != null && this.e.f();
    }

    public void f() {
        if (this.e != null) {
            this.e.i();
        }
    }

    public boolean g() {
        return (this.K == null || this.K.b == null) ? false : true;
    }

    public int getContentInsetEnd() {
        if (this.u != null) {
            return this.u.d();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        return this.w != Integer.MIN_VALUE ? this.w : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        if (this.u != null) {
            return this.u.a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.u != null) {
            return this.u.b();
        }
        return 0;
    }

    public int getContentInsetStart() {
        if (this.u != null) {
            return this.u.c();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.v != Integer.MIN_VALUE ? this.v : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        android.support.v7.view.menu.h d2;
        return this.e != null && (d2 = this.e.d()) != null && d2.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return android.support.v4.g.p.b(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return android.support.v4.g.p.b(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        if (this.i != null) {
            return this.i.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        if (this.i != null) {
            return this.i.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        n();
        return this.e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        if (this.h != null) {
            return this.h.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        if (this.h != null) {
            return this.h.getDrawable();
        }
        return null;
    }

    android.support.v7.widget.d getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        n();
        return this.e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.l;
    }

    public int getPopupTheme() {
        return this.m;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public ae getWrapper() {
        if (this.I == null) {
            this.I = new ax(this, true);
        }
        return this.I;
    }

    public void h() {
        android.support.v7.view.menu.j jVar = this.K == null ? null : this.K.b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    void i() {
        if (this.a == null) {
            this.a = new o(getContext(), null, a.C0011a.toolbarNavigationButtonStyle);
            this.a.setImageDrawable(this.j);
            this.a.setContentDescription(this.k);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.c & a.j.AppCompatTheme_windowActionModeOverlay);
            generateDefaultLayoutParams.b = 2;
            this.a.setLayoutParams(generateDefaultLayoutParams);
            this.a.setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.h();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: j */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    void k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((b) childAt.getLayoutParams()).b != 2 && childAt != this.e) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    void l() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02aa A[LOOP:0: B:104:0x02a8->B:105:0x02aa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02cc A[LOOP:1: B:107:0x02ca->B:108:0x02cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0306 A[LOOP:2: B:116:0x0304->B:117:0x0306, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 795
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.G;
        if (bc.a(this)) {
            c2 = 1;
            c3 = 0;
        } else {
            c2 = 0;
            c3 = 1;
        }
        if (a(this.h)) {
            a(this.h, i, 0, i2, 0, this.p);
            i3 = this.h.getMeasuredWidth() + b(this.h);
            i4 = Math.max(0, this.h.getMeasuredHeight() + c(this.h));
            i5 = View.combineMeasuredStates(0, this.h.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (a(this.a)) {
            a(this.a, i, 0, i2, 0, this.p);
            i3 = this.a.getMeasuredWidth() + b(this.a);
            i4 = Math.max(i4, this.a.getMeasuredHeight() + c(this.a));
            i5 = View.combineMeasuredStates(i5, this.a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i3) + 0;
        iArr[c2] = Math.max(0, currentContentInsetStart - i3);
        if (a(this.e)) {
            a(this.e, i, max, i2, 0, this.p);
            i6 = this.e.getMeasuredWidth() + b(this.e);
            i4 = Math.max(i4, this.e.getMeasuredHeight() + c(this.e));
            i5 = View.combineMeasuredStates(i5, this.e.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c3] = Math.max(0, currentContentInsetEnd - i6);
        if (a(this.b)) {
            max2 += a(this.b, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.b.getMeasuredHeight() + c(this.b));
            i5 = View.combineMeasuredStates(i5, this.b.getMeasuredState());
        }
        if (a(this.i)) {
            max2 += a(this.i, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.i.getMeasuredHeight() + c(this.i));
            i5 = View.combineMeasuredStates(i5, this.i.getMeasuredState());
        }
        int childCount = getChildCount();
        int i10 = i4;
        int i11 = max2;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((b) childAt.getLayoutParams()).b == 0 && a(childAt)) {
                i11 += a(childAt, i, i11, i2, 0, iArr);
                i10 = Math.max(i10, childAt.getMeasuredHeight() + c(childAt));
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        int i13 = this.s + this.t;
        int i14 = this.q + this.r;
        if (a(this.f)) {
            a(this.f, i, i11 + i14, i2, i13, iArr);
            int measuredWidth = this.f.getMeasuredWidth() + b(this.f);
            i9 = this.f.getMeasuredHeight() + c(this.f);
            i7 = View.combineMeasuredStates(i5, this.f.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i7 = i5;
            i8 = 0;
            i9 = 0;
        }
        if (a(this.g)) {
            i8 = Math.max(i8, a(this.g, i, i11 + i14, i2, i9 + i13, iArr));
            i9 += this.g.getMeasuredHeight() + c(this.g);
            i7 = View.combineMeasuredStates(i7, this.g.getMeasuredState());
        }
        int max3 = Math.max(i10, i9);
        int paddingLeft = i11 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i7);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (r()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        android.support.v7.view.menu.h d2 = this.e != null ? this.e.d() : null;
        if (dVar.b != 0 && this.K != null && d2 != null && (findItem = d2.findItem(dVar.b)) != null) {
            findItem.expandActionView();
        }
        if (dVar.c) {
            q();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        s();
        this.u.a(i == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        if (this.K != null && this.K.b != null) {
            dVar.b = this.K.b.getItemId();
        }
        dVar.c = b();
        return dVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.w) {
            this.w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(android.support.v7.b.a.b.b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!d(this.i)) {
                a((View) this.i, true);
            }
        } else if (this.i != null && d(this.i)) {
            removeView(this.i);
            this.F.remove(this.i);
        }
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        if (this.i != null) {
            this.i.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            p();
        }
        if (this.h != null) {
            this.h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(android.support.v7.b.a.b.b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            p();
            if (!d(this.h)) {
                a((View) this.h, true);
            }
        } else if (this.h != null && d(this.h)) {
            removeView(this.h);
            this.F.remove(this.h);
        }
        if (this.h != null) {
            this.h.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        p();
        this.h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.d = cVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        n();
        this.e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.m != i) {
            this.m = i;
            if (i == 0) {
                this.l = getContext();
            } else {
                this.l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.g == null) {
                Context context = getContext();
                this.g = new ab(context);
                this.g.setSingleLine();
                this.g.setEllipsize(TextUtils.TruncateAt.END);
                if (this.o != 0) {
                    this.g.setTextAppearance(context, this.o);
                }
                if (this.B != 0) {
                    this.g.setTextColor(this.B);
                }
            }
            if (!d(this.g)) {
                a((View) this.g, true);
            }
        } else if (this.g != null && d(this.g)) {
            removeView(this.g);
            this.F.remove(this.g);
        }
        if (this.g != null) {
            this.g.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.B = i;
        if (this.g != null) {
            this.g.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f == null) {
                Context context = getContext();
                this.f = new ab(context);
                this.f.setSingleLine();
                this.f.setEllipsize(TextUtils.TruncateAt.END);
                if (this.n != 0) {
                    this.f.setTextAppearance(context, this.n);
                }
                if (this.A != 0) {
                    this.f.setTextColor(this.A);
                }
            }
            if (!d(this.f)) {
                a((View) this.f, true);
            }
        } else if (this.f != null && d(this.f)) {
            removeView(this.f);
            this.F.remove(this.f);
        }
        if (this.f != null) {
            this.f.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.A = i;
        if (this.f != null) {
            this.f.setTextColor(i);
        }
    }
}