package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.widget.aj;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ap extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();
    Runnable a;
    aj b;
    int c;
    int d;
    private b e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ap.this.b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) ap.this.b.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ap.this.a((a.c) getItem(i), true);
            }
            ((c) view).a((a.c) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().d();
            int childCount = ap.this.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ap.this.b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends LinearLayout {
        private final int[] b;
        private a.c c;
        private TextView d;
        private ImageView e;
        private View f;

        public c(Context context, a.c cVar, boolean z) {
            super(context, null, a.C0011a.actionBarTabStyle);
            this.b = new int[]{16842964};
            this.c = cVar;
            aw a = aw.a(context, null, this.b, a.C0011a.actionBarTabStyle, 0);
            if (a.g(0)) {
                setBackgroundDrawable(a.a(0));
            }
            a.a();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a() {
            a.c cVar = this.c;
            View c = cVar.c();
            if (c != null) {
                ViewParent parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c);
                    }
                    addView(c);
                }
                this.f = c;
                if (this.d != null) {
                    this.d.setVisibility(8);
                }
                if (this.e != null) {
                    this.e.setVisibility(8);
                    this.e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f != null) {
                removeView(this.f);
                this.f = null;
            }
            Drawable a = cVar.a();
            CharSequence b = cVar.b();
            if (a != null) {
                if (this.e == null) {
                    q qVar = new q(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    qVar.setLayoutParams(layoutParams);
                    addView(qVar, 0);
                    this.e = qVar;
                }
                this.e.setImageDrawable(a);
                this.e.setVisibility(0);
            } else if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(b);
            if (z) {
                if (this.d == null) {
                    ab abVar = new ab(getContext(), null, a.C0011a.actionBarTabTextStyle);
                    abVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    abVar.setLayoutParams(layoutParams2);
                    addView(abVar);
                    this.d = abVar;
                }
                this.d.setText(b);
                this.d.setVisibility(0);
            } else if (this.d != null) {
                this.d.setVisibility(8);
                this.d.setText((CharSequence) null);
            }
            if (this.e != null) {
                this.e.setContentDescription(cVar.e());
            }
            ay.a(this, z ? null : cVar.e());
        }

        public void a(a.c cVar) {
            this.c = cVar;
            a();
        }

        public a.c b() {
            return this.c;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.c.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.c.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ap.this.c <= 0 || getMeasuredWidth() <= ap.this.c) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ap.this.c, 1073741824), i2);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private boolean a() {
        return this.f != null && this.f.getParent() == this;
    }

    private void b() {
        if (a()) {
            return;
        }
        if (this.f == null) {
            this.f = d();
        }
        removeView(this.b);
        addView(this.f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f.getAdapter() == null) {
            this.f.setAdapter((SpinnerAdapter) new a());
        }
        if (this.a != null) {
            removeCallbacks(this.a);
            this.a = null;
        }
        this.f.setSelection(this.i);
    }

    private boolean c() {
        if (a()) {
            removeView(this.f);
            addView(this.b, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    private Spinner d() {
        y yVar = new y(getContext(), null, a.C0011a.actionDropDownStyle);
        yVar.setLayoutParams(new aj.a(-2, -1));
        yVar.setOnItemSelectedListener(this);
        return yVar;
    }

    c a(a.c cVar, boolean z) {
        c cVar2 = new c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            cVar2.setFocusable(true);
            if (this.e == null) {
                this.e = new b();
            }
            cVar2.setOnClickListener(this.e);
        }
        return cVar2;
    }

    public void a(int i) {
        final View childAt = this.b.getChildAt(i);
        if (this.a != null) {
            removeCallbacks(this.a);
        }
        this.a = new Runnable() { // from class: android.support.v7.widget.ap.1
            @Override // java.lang.Runnable
            public void run() {
                ap.this.smoothScrollTo(childAt.getLeft() - ((ap.this.getWidth() - childAt.getWidth()) / 2), 0);
                ap.this.a = null;
            }
        };
        post(this.a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            post(this.a);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        android.support.v7.view.a a2 = android.support.v7.view.a.a(getContext());
        setContentHeight(a2.e());
        this.d = a2.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            removeCallbacks(this.a);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
        ((c) view).b().d();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i3 = -1;
        } else {
            if (childCount > 2) {
                this.c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.c = View.MeasureSpec.getSize(i) / 2;
            }
            i3 = Math.min(this.c, this.d);
        }
        this.c = i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if ((z2 || !this.g) ? false : false) {
            this.b.measure(0, makeMeasureSpec);
            if (this.b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                b();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z2 || measuredWidth == measuredWidth2) {
                }
                setTabSelected(this.i);
                return;
            }
        }
        c();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z2) {
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.i = i;
        int childCount = this.b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        if (this.f == null || i < 0) {
            return;
        }
        this.f.setSelection(i);
    }
}