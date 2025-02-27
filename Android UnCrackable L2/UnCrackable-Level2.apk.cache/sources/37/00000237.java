package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.a.a;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: classes.dex */
class ba {
    private final Context a;
    private final View b;
    private final TextView c;
    private final WindowManager.LayoutParams d = new WindowManager.LayoutParams();
    private final Rect e = new Rect();
    private final int[] f = new int[2];
    private final int[] g = new int[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(Context context) {
        this.a = context;
        this.b = LayoutInflater.from(this.a).inflate(a.g.abc_tooltip, (ViewGroup) null);
        this.c = (TextView) this.b.findViewById(a.f.message);
        this.d.setTitle(getClass().getSimpleName());
        this.d.packageName = this.a.getPackageName();
        this.d.type = 1002;
        this.d.width = -2;
        this.d.height = -2;
        this.d.format = -3;
        this.d.windowAnimations = a.i.Animation_AppCompat_Tooltip;
        this.d.flags = 24;
    }

    private static View a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    private void a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.a.getResources().getDimensionPixelOffset(z ? a.d.tooltip_y_offset_touch : a.d.tooltip_y_offset_non_touch);
        View a = a(view);
        if (a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a.getWindowVisibleDisplayFrame(this.e);
        if (this.e.left < 0 && this.e.top < 0) {
            Resources resources = this.a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a.getLocationOnScreen(this.g);
        view.getLocationOnScreen(this.f);
        int[] iArr = this.f;
        iArr[0] = iArr[0] - this.g[0];
        int[] iArr2 = this.f;
        iArr2[1] = iArr2[1] - this.g[1];
        layoutParams.x = (this.f[0] + i) - (a.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.b.getMeasuredHeight();
        int i4 = ((this.f[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i5 = this.f[1] + height + dimensionPixelOffset3;
        if (!z ? measuredHeight + i5 <= this.e.height() : i4 < 0) {
            layoutParams.y = i4;
        } else {
            layoutParams.y = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (b()) {
            ((WindowManager) this.a.getSystemService("window")).removeView(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.c.setText(charSequence);
        a(view, i, i2, z, this.d);
        ((WindowManager) this.a.getSystemService("window")).addView(this.b, this.d);
    }

    boolean b() {
        return this.b.getParent() != null;
    }
}