package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* loaded from: classes.dex */
public class y extends Spinner implements android.support.v4.g.o {
    private static final int[] a = {16843505};
    private final g b;
    private final Context c;
    private ai d;
    private SpinnerAdapter e;
    private final boolean f;
    private b g;
    private int h;
    private final Rect i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof as) {
                    as asVar = (as) spinnerAdapter;
                    if (asVar.a() == null) {
                        asVar.a(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.a == null) {
                return 0;
            }
            return this.a.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.a == null) {
                return null;
            }
            return this.a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.a == null) {
                return null;
            }
            return this.a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.a == null) {
                return -1L;
            }
            return this.a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.a != null && this.a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends ak {
        ListAdapter a;
        private CharSequence h;
        private final Rect i;

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.i = new Rect();
            b(y.this);
            a(true);
            a(0);
            a(new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.y.b.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    y.this.setSelection(i2);
                    if (y.this.getOnItemClickListener() != null) {
                        y.this.performItemClick(view, i2, b.this.a.getItemId(i2));
                    }
                    b.this.c();
                }
            });
        }

        @Override // android.support.v7.widget.ak, android.support.v7.view.menu.s
        public void a() {
            ViewTreeObserver viewTreeObserver;
            boolean d = d();
            f();
            h(2);
            super.a();
            e().setChoiceMode(1);
            i(y.this.getSelectedItemPosition());
            if (d || (viewTreeObserver = y.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.y.b.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!b.this.a(y.this)) {
                        b.this.c();
                        return;
                    }
                    b.this.f();
                    b.super.a();
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            a(new PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.y.b.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = y.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        @Override // android.support.v7.widget.ak
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.a = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        boolean a(View view) {
            return android.support.v4.g.p.m(view) && view.getGlobalVisibleRect(this.i);
        }

        public CharSequence b() {
            return this.h;
        }

        void f() {
            int i;
            Drawable h = h();
            int i2 = 0;
            if (h != null) {
                h.getPadding(y.this.i);
                i2 = bc.a(y.this) ? y.this.i.right : -y.this.i.left;
            } else {
                Rect rect = y.this.i;
                y.this.i.right = 0;
                rect.left = 0;
            }
            int paddingLeft = y.this.getPaddingLeft();
            int paddingRight = y.this.getPaddingRight();
            int width = y.this.getWidth();
            if (y.this.h == -2) {
                int a = y.this.a((SpinnerAdapter) this.a, h());
                int i3 = (y.this.getContext().getResources().getDisplayMetrics().widthPixels - y.this.i.left) - y.this.i.right;
                if (a > i3) {
                    a = i3;
                }
                i = Math.max(a, (width - paddingLeft) - paddingRight);
            } else {
                i = y.this.h == -1 ? (width - paddingLeft) - paddingRight : y.this.h;
            }
            g(i);
            c(bc.a(y.this) ? i2 + ((width - paddingRight) - l()) : i2 + paddingLeft);
        }
    }

    public y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.spinnerStyle);
    }

    public y(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public y(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r12 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
        r12.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
        if (r12 == null) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public y(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
            r7 = this;
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.i = r0
            int[] r0 = android.support.v7.a.a.j.Spinner
            r1 = 0
            android.support.v7.widget.aw r0 = android.support.v7.widget.aw.a(r8, r9, r0, r10, r1)
            android.support.v7.widget.g r2 = new android.support.v7.widget.g
            r2.<init>(r7)
            r7.b = r2
            r2 = 0
            if (r12 == 0) goto L23
            android.support.v7.view.d r3 = new android.support.v7.view.d
            r3.<init>(r8, r12)
        L20:
            r7.c = r3
            goto L3c
        L23:
            int r12 = android.support.v7.a.a.j.Spinner_popupTheme
            int r12 = r0.g(r12, r1)
            if (r12 == 0) goto L31
            android.support.v7.view.d r3 = new android.support.v7.view.d
            r3.<init>(r8, r12)
            goto L20
        L31:
            int r12 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r12 >= r3) goto L39
            r12 = r8
            goto L3a
        L39:
            r12 = r2
        L3a:
            r7.c = r12
        L3c:
            android.content.Context r12 = r7.c
            r3 = 1
            if (r12 == 0) goto Lab
            r12 = -1
            if (r11 != r12) goto L73
            int[] r12 = android.support.v7.widget.y.a     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            android.content.res.TypedArray r12 = r8.obtainStyledAttributes(r9, r12, r10, r1)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            boolean r4 = r12.hasValue(r1)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L6c
            if (r4 == 0) goto L55
            int r4 = r12.getInt(r1, r1)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L6c
            r11 = r4
        L55:
            if (r12 == 0) goto L73
        L57:
            r12.recycle()
            goto L73
        L5b:
            r4 = move-exception
            goto L62
        L5d:
            r8 = move-exception
            r12 = r2
            goto L6d
        L60:
            r4 = move-exception
            r12 = r2
        L62:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r4)     // Catch: java.lang.Throwable -> L6c
            if (r12 == 0) goto L73
            goto L57
        L6c:
            r8 = move-exception
        L6d:
            if (r12 == 0) goto L72
            r12.recycle()
        L72:
            throw r8
        L73:
            if (r11 != r3) goto Lab
            android.support.v7.widget.y$b r11 = new android.support.v7.widget.y$b
            android.content.Context r12 = r7.c
            r11.<init>(r12, r9, r10)
            android.content.Context r12 = r7.c
            int[] r4 = android.support.v7.a.a.j.Spinner
            android.support.v7.widget.aw r12 = android.support.v7.widget.aw.a(r12, r9, r4, r10, r1)
            int r1 = android.support.v7.a.a.j.Spinner_android_dropDownWidth
            r4 = -2
            int r1 = r12.f(r1, r4)
            r7.h = r1
            int r1 = android.support.v7.a.a.j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r12.a(r1)
            r11.a(r1)
            int r1 = android.support.v7.a.a.j.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r11.a(r1)
            r12.a()
            r7.g = r11
            android.support.v7.widget.y$1 r12 = new android.support.v7.widget.y$1
            r12.<init>(r7)
            r7.d = r12
        Lab:
            int r11 = android.support.v7.a.a.j.Spinner_android_entries
            java.lang.CharSequence[] r11 = r0.f(r11)
            if (r11 == 0) goto Lc3
            android.widget.ArrayAdapter r12 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r12.<init>(r8, r1, r11)
            int r8 = android.support.v7.a.a.g.support_simple_spinner_dropdown_item
            r12.setDropDownViewResource(r8)
            r7.setAdapter(r12)
        Lc3:
            r0.a()
            r7.f = r3
            android.widget.SpinnerAdapter r8 = r7.e
            if (r8 == 0) goto Ld3
            android.widget.SpinnerAdapter r8 = r7.e
            r7.setAdapter(r8)
            r7.e = r2
        Ld3:
            android.support.v7.widget.g r8 = r7.b
            r8.a(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.y.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.i);
            return i2 + this.i.left + this.i.right;
        }
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.g != null) {
            return this.g.j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.g != null) {
            return this.g.k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.g != null) {
            return this.h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.g != null) {
            return this.g.h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.g != null) {
            return this.c;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.g != null ? this.g.b() : super.getPrompt();
    }

    @Override // android.support.v4.g.o
    public ColorStateList getSupportBackgroundTintList() {
        if (this.b != null) {
            return this.b.a();
        }
        return null;
    }

    @Override // android.support.v4.g.o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.b != null) {
            return this.b.b();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g == null || !this.g.d()) {
            return;
        }
        this.g.c();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d == null || !this.d.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (this.g != null) {
            if (this.g.d()) {
                return true;
            }
            this.g.a();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f) {
            this.e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.g != null) {
            this.g.a(new a(spinnerAdapter, (this.c == null ? getContext() : this.c).getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.g != null) {
            this.g.c(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.g != null) {
            this.g.d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.g != null) {
            this.h = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.g != null) {
            this.g.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v7.b.a.b.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.g != null) {
            this.g.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.support.v4.g.o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    @Override // android.support.v4.g.o
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }
}