package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ak implements android.support.v7.view.menu.s {
    private static Method a;
    private static Method b;
    private static Method h;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    ag c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ak.this.m();
        }
    }

    /* loaded from: classes.dex */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ak.this.d()) {
                ak.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ak.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ak.this.n() || ak.this.g.getContentView() == null) {
                return;
            }
            ak.this.f.removeCallbacks(ak.this.e);
            ak.this.e.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ak.this.g != null && ak.this.g.isShowing() && x >= 0 && x < ak.this.g.getWidth() && y >= 0 && y < ak.this.g.getHeight()) {
                ak.this.f.postDelayed(ak.this.e, 250L);
                return false;
            } else if (action == 1) {
                ak.this.f.removeCallbacks(ak.this.e);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ak.this.c == null || !android.support.v4.g.p.m(ak.this.c) || ak.this.c.getCount() <= ak.this.c.getChildCount() || ak.this.c.getChildCount() > ak.this.d) {
                return;
            }
            ak.this.g.setInputMethodMode(2);
            ak.this.a();
        }
    }

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ak(Context context) {
        this(context, null, a.C0011a.listPopupWindowStyle);
    }

    public ak(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ak(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = Integer.MAX_VALUE;
        this.x = 0;
        this.e = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ListPopupWindow, i, i2);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        this.g = new s(context, attributeSet, i, i2);
        this.g.setInputMethodMode(1);
    }

    private int a(View view, int i, boolean z) {
        if (b != null) {
            try {
                return ((Integer) b.invoke(this.g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.g.getMaxAvailableHeight(view, i);
    }

    private void b() {
        if (this.w != null) {
            ViewParent parent = this.w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    private void c(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.g, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int f() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        int i4;
        int i5;
        if (this.c == null) {
            Context context = this.i;
            this.G = new Runnable() { // from class: android.support.v7.widget.ak.1
                @Override // java.lang.Runnable
                public void run() {
                    View i6 = ak.this.i();
                    if (i6 == null || i6.getWindowToken() == null) {
                        return;
                    }
                    ak.this.a();
                }
            };
            this.c = a(context, !this.J);
            if (this.A != null) {
                this.c.setSelector(this.A);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ak.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i6, long j) {
                    ag agVar;
                    if (i6 == -1 || (agVar = ak.this.c) == null) {
                        return;
                    }
                    agVar.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.c.setOnScrollListener(this.E);
            if (this.C != null) {
                this.c.setOnItemSelectedListener(this.C);
            }
            ag agVar = this.c;
            View view = this.w;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    case 0:
                        linearLayout.addView(view);
                        linearLayout.addView(agVar, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(agVar, layoutParams);
                        linearLayout.addView(view);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.x);
                        break;
                }
                if (this.l >= 0) {
                    i4 = this.l;
                    i5 = Integer.MIN_VALUE;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i4, i5), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                agVar = linearLayout;
            } else {
                i = 0;
            }
            this.g.setContentView(agVar);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.g.getContentView();
            View view2 = this.w;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            i2 = this.H.top + this.H.bottom;
            if (!this.p) {
                this.n = -this.H.top;
            }
        } else {
            this.H.setEmpty();
            i2 = 0;
        }
        int a2 = a(i(), this.n, this.g.getInputMethodMode() == 2);
        if (this.u || this.k == -1) {
            return a2 + i2;
        }
        switch (this.l) {
            case -2:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), Integer.MIN_VALUE);
                break;
            case -1:
                i3 = this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right);
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                break;
            default:
                i3 = this.l;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                break;
        }
        int a3 = this.c.a(makeMeasureSpec, 0, -1, a2 - i, -1);
        if (a3 > 0) {
            i += i2 + this.c.getPaddingTop() + this.c.getPaddingBottom();
        }
        return a3 + i;
    }

    ag a(Context context, boolean z) {
        return new ag(context, z);
    }

    @Override // android.support.v7.view.menu.s
    public void a() {
        int f = f();
        boolean n = n();
        android.support.v4.widget.j.a(this.g, this.o);
        boolean z = true;
        if (this.g.isShowing()) {
            if (android.support.v4.g.p.m(i())) {
                int width = this.l == -1 ? -1 : this.l == -2 ? i().getWidth() : this.l;
                if (this.k == -1) {
                    if (!n) {
                        f = -1;
                    }
                    if (n) {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(0);
                    } else {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(-1);
                    }
                } else if (this.k != -2) {
                    f = this.k;
                }
                this.g.setOutsideTouchable((this.v || this.u) ? false : false);
                this.g.update(i(), this.m, this.n, width < 0 ? -1 : width, f < 0 ? -1 : f);
                return;
            }
            return;
        }
        int width2 = this.l == -1 ? -1 : this.l == -2 ? i().getWidth() : this.l;
        if (this.k == -1) {
            f = -1;
        } else if (this.k != -2) {
            f = this.k;
        }
        this.g.setWidth(width2);
        this.g.setHeight(f);
        c(true);
        this.g.setOutsideTouchable((this.v || this.u) ? false : true);
        this.g.setTouchInterceptor(this.D);
        if (this.s) {
            android.support.v4.widget.j.a(this.g, this.r);
        }
        if (h != null) {
            try {
                h.invoke(this.g, this.I);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        android.support.v4.widget.j.a(this.g, i(), this.m, this.n, this.t);
        this.c.setSelection(-1);
        if (!this.J || this.c.isInTouchMode()) {
            m();
        }
        if (this.J) {
            return;
        }
        this.f.post(this.F);
    }

    public void a(int i) {
        this.x = i;
    }

    public void a(Rect rect) {
        this.I = rect;
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        if (this.y == null) {
            this.y = new b();
        } else if (this.j != null) {
            this.j.unregisterDataSetObserver(this.y);
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        if (this.c != null) {
            this.c.setAdapter(this.j);
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z) {
        this.J = z;
        this.g.setFocusable(z);
    }

    public void b(int i) {
        this.g.setAnimationStyle(i);
    }

    public void b(View view) {
        this.z = view;
    }

    public void b(boolean z) {
        this.s = true;
        this.r = z;
    }

    @Override // android.support.v7.view.menu.s
    public void c() {
        this.g.dismiss();
        b();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    public void c(int i) {
        this.m = i;
    }

    public void d(int i) {
        this.n = i;
        this.p = true;
    }

    @Override // android.support.v7.view.menu.s
    public boolean d() {
        return this.g.isShowing();
    }

    @Override // android.support.v7.view.menu.s
    public ListView e() {
        return this.c;
    }

    public void e(int i) {
        this.t = i;
    }

    public void f(int i) {
        this.l = i;
    }

    public void g(int i) {
        Drawable background = this.g.getBackground();
        if (background == null) {
            f(i);
            return;
        }
        background.getPadding(this.H);
        this.l = this.H.left + this.H.right + i;
    }

    public boolean g() {
        return this.J;
    }

    public Drawable h() {
        return this.g.getBackground();
    }

    public void h(int i) {
        this.g.setInputMethodMode(i);
    }

    public View i() {
        return this.z;
    }

    public void i(int i) {
        ag agVar = this.c;
        if (!d() || agVar == null) {
            return;
        }
        agVar.setListSelectionHidden(false);
        agVar.setSelection(i);
        if (agVar.getChoiceMode() != 0) {
            agVar.setItemChecked(i, true);
        }
    }

    public int j() {
        return this.m;
    }

    public int k() {
        if (this.p) {
            return this.n;
        }
        return 0;
    }

    public int l() {
        return this.l;
    }

    public void m() {
        ag agVar = this.c;
        if (agVar != null) {
            agVar.setListSelectionHidden(true);
            agVar.requestLayout();
        }
    }

    public boolean n() {
        return this.g.getInputMethodMode() == 2;
    }
}