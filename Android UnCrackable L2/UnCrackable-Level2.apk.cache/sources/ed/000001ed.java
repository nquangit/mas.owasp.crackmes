package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends aj implements android.support.v7.view.c {
    static final a i = new a();
    private View.OnClickListener A;
    private boolean B;
    private boolean C;
    private boolean D;
    private CharSequence E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private CharSequence J;
    private boolean K;
    private int L;
    private Bundle M;
    private final Runnable N;
    private Runnable O;
    private final WeakHashMap<String, Drawable.ConstantState> P;
    final SearchAutoComplete a;
    final ImageView b;
    final ImageView c;
    final ImageView d;
    final ImageView e;
    View.OnFocusChangeListener f;
    android.support.v4.widget.d g;
    SearchableInfo h;
    private final View j;
    private final View k;
    private f l;
    private Rect m;
    private Rect n;
    private int[] o;
    private int[] p;
    private final ImageView q;
    private final Drawable r;
    private final int s;
    private final int t;
    private final Intent u;
    private final Intent v;
    private final CharSequence w;
    private c x;
    private b y;
    private d z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends android.support.v7.widget.f {
        final Runnable a;
        private int b;
        private SearchView c;
        private boolean d;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.C0011a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = new Runnable() { // from class: android.support.v7.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.a();
                }
            };
            this.b = getThreshold();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.d = false;
            }
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i < 960 || i2 < 720 || configuration.orientation != 2) {
                if (i < 600) {
                    return (i < 640 || i2 < 480) ? 160 : 192;
                }
                return 192;
            }
            return 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.d = false;
                removeCallbacks(this.a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (!inputMethodManager.isActive(this)) {
                this.d = true;
            } else {
                this.d = false;
                removeCallbacks(this.a);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.b <= 0 || super.enoughToFilter();
        }

        @Override // android.support.v7.widget.f, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.d) {
                removeCallbacks(this.a);
                post(this.a);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.c.g();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.c.hasFocus() && getVisibility() == 0) {
                this.d = true;
                if (SearchView.a(getContext())) {
                    SearchView.i.a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.c = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private Method a;
        private Method b;
        private Method c;

        a() {
            try {
                this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.a != null) {
                try {
                    this.a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.c != null) {
                try {
                    this.c.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.b != null) {
                try {
                    this.b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(String str);
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e extends android.support.v4.g.a {
        public static final Parcelable.Creator<e> CREATOR = new Parcelable.ClassLoaderCreator<e>() { // from class: android.support.v7.widget.SearchView.e.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e[] newArray(int i) {
                return new e[i];
            }
        };
        boolean b;

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.b + "}";
        }

        @Override // android.support.v4.g.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.b));
        }
    }

    /* loaded from: classes.dex */
    private static class f extends TouchDelegate {
        private final View a;
        private final Rect b;
        private final Rect c;
        private final Rect d;
        private final int e;
        private boolean f;

        public f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            this.d.inset(-this.e, -this.e);
            this.c.set(rect2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            float f;
            int i;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            boolean z2 = true;
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.b.contains(x, y)) {
                        this.f = true;
                        z = true;
                        break;
                    }
                    z = false;
                    break;
                case 1:
                case 2:
                    z = this.f;
                    if (z && !this.d.contains(x, y)) {
                        z2 = false;
                        break;
                    }
                    break;
                case 3:
                    z = this.f;
                    this.f = false;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                if (!z2 || this.c.contains(x, y)) {
                    f = x - this.c.left;
                    i = y - this.c.top;
                } else {
                    f = this.a.getWidth() / 2;
                    i = this.a.getHeight() / 2;
                }
                motionEvent.setLocation(f, i);
                return this.a.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.J);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.M != null) {
            intent.putExtra("app_data", this.M);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.h.getSearchActivity());
        return intent;
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.o);
        getLocationInWindow(this.p);
        int i2 = this.o[1] - this.p[1];
        int i3 = this.o[0] - this.p[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    private void a(boolean z) {
        this.C = z;
        int i2 = 8;
        int i3 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.a.getText());
        this.b.setVisibility(i3);
        b(z2);
        this.j.setVisibility(z ? 8 : 0);
        if (this.q.getDrawable() != null && !this.B) {
            i2 = 0;
        }
        this.q.setVisibility(i2);
        m();
        c(z2 ? false : true);
        l();
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private CharSequence b(CharSequence charSequence) {
        if (!this.B || this.r == null) {
            return charSequence;
        }
        double textSize = this.a.getTextSize();
        Double.isNaN(textSize);
        int i2 = (int) (textSize * 1.25d);
        this.r.setBounds(0, 0, i2, i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.r), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void b(boolean z) {
        this.c.setVisibility((this.D && k() && hasFocus() && (z || !this.I)) ? 0 : 8);
    }

    private void c(boolean z) {
        int i2;
        if (this.I && !c() && z) {
            i2 = 0;
            this.c.setVisibility(8);
        } else {
            i2 = 8;
        }
        this.e.setVisibility(i2);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_width);
    }

    private boolean i() {
        if (this.h == null || !this.h.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.h.getVoiceSearchLaunchWebSearch()) {
            intent = this.u;
        } else if (this.h.getVoiceSearchLaunchRecognizer()) {
            intent = this.v;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean k() {
        return (this.D || this.I) && !c();
    }

    private void l() {
        this.k.setVisibility((k() && (this.c.getVisibility() == 0 || this.e.getVisibility() == 0)) ? 0 : 8);
    }

    private void m() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.a.getText());
        if (!z2 && (!this.B || this.K)) {
            z = false;
        }
        this.d.setVisibility(z ? 0 : 8);
        Drawable drawable = this.d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void n() {
        post(this.N);
    }

    private void o() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(b(queryHint));
    }

    private void p() {
        this.a.setThreshold(this.h.getSuggestThreshold());
        this.a.setImeOptions(this.h.getImeOptions());
        int inputType = this.h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.h.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.a.setInputType(inputType);
        if (this.g != null) {
            this.g.a((Cursor) null);
        }
        if (this.h.getSuggestAuthority() != null) {
            this.g = new aq(getContext(), this, this.h, this.P);
            this.a.setAdapter(this.g);
            ((aq) this.g).a(this.F ? 2 : 1);
        }
    }

    private void q() {
        this.a.dismissDropDown();
    }

    private void setQuery(CharSequence charSequence) {
        this.a.setText(charSequence);
        this.a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // android.support.v7.view.c
    public void a() {
        if (this.K) {
            return;
        }
        this.K = true;
        this.L = this.a.getImeOptions();
        this.a.setImeOptions(this.L | 33554432);
        this.a.setText("");
        setIconified(false);
    }

    void a(int i2, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i2, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void a(CharSequence charSequence, boolean z) {
        this.a.setText(charSequence);
        if (charSequence != null) {
            this.a.setSelection(this.a.length());
            this.J = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        d();
    }

    @Override // android.support.v7.view.c
    public void b() {
        a("", false);
        clearFocus();
        a(true);
        this.a.setImeOptions(this.L);
        this.K = false;
    }

    public boolean c() {
        return this.C;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.G = true;
        super.clearFocus();
        this.a.clearFocus();
        this.a.setImeVisibility(false);
        this.G = false;
    }

    void d() {
        Editable text = this.a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.x == null || !this.x.a(text.toString())) {
            if (this.h != null) {
                a(0, null, text.toString());
            }
            this.a.setImeVisibility(false);
            q();
        }
    }

    void e() {
        if (!TextUtils.isEmpty(this.a.getText())) {
            this.a.setText("");
            this.a.requestFocus();
            this.a.setImeVisibility(true);
        } else if (this.B) {
            if (this.y == null || !this.y.a()) {
                clearFocus();
                a(true);
            }
        }
    }

    void f() {
        a(false);
        this.a.requestFocus();
        this.a.setImeVisibility(true);
        if (this.A != null) {
            this.A.onClick(this);
        }
    }

    void g() {
        a(c());
        n();
        if (this.a.hasFocus()) {
            h();
        }
    }

    public int getImeOptions() {
        return this.a.getImeOptions();
    }

    public int getInputType() {
        return this.a.getInputType();
    }

    public int getMaxWidth() {
        return this.H;
    }

    public CharSequence getQuery() {
        return this.a.getText();
    }

    public CharSequence getQueryHint() {
        return this.E != null ? this.E : (this.h == null || this.h.getHintId() == 0) ? this.w : getContext().getText(this.h.getHintId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.s;
    }

    public android.support.v4.widget.d getSuggestionsAdapter() {
        return this.g;
    }

    void h() {
        i.a(this.a);
        i.b(this.a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.N);
        post(this.O);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.aj, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            a(this.a, this.m);
            this.n.set(this.m.left, 0, this.m.right, i5 - i3);
            if (this.l != null) {
                this.l.a(this.n, this.m);
                return;
            }
            this.l = new f(this.n, this.m, this.a);
            setTouchDelegate(this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r3.H <= 0) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    @Override // android.support.v7.widget.aj, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.c()
            if (r0 == 0) goto La
            super.onMeasure(r4, r5)
            return
        La:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L2e
            if (r0 == 0) goto L22
            if (r0 == r2) goto L1d
            goto L3e
        L1d:
            int r0 = r3.H
            if (r0 <= 0) goto L3e
            goto L32
        L22:
            int r4 = r3.H
            if (r4 <= 0) goto L29
            int r4 = r3.H
            goto L3e
        L29:
            int r4 = r3.getPreferredWidth()
            goto L3e
        L2e:
            int r0 = r3.H
            if (r0 <= 0) goto L39
        L32:
            int r0 = r3.H
        L34:
            int r4 = java.lang.Math.min(r0, r4)
            goto L3e
        L39:
            int r0 = r3.getPreferredWidth()
            goto L34
        L3e:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L50
            if (r0 == 0) goto L4b
            goto L58
        L4b:
            int r5 = r3.getPreferredHeight()
            goto L58
        L50:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L58:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.a());
        a(eVar.b);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.b = c();
        return eVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (!this.G && isFocusable()) {
            if (c()) {
                return super.requestFocus(i2, rect);
            }
            boolean requestFocus = this.a.requestFocus(i2, rect);
            if (requestFocus) {
                a(false);
            }
            return requestFocus;
        }
        return false;
    }

    public void setAppSearchData(Bundle bundle) {
        this.M = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            e();
        } else {
            f();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.B == z) {
            return;
        }
        this.B = z;
        a(z);
        o();
    }

    public void setImeOptions(int i2) {
        this.a.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.a.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.H = i2;
        requestLayout();
    }

    public void setOnCloseListener(b bVar) {
        this.y = bVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c cVar) {
        this.x = cVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.A = onClickListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.z = dVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.E = charSequence;
        o();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.F = z;
        if (this.g instanceof aq) {
            ((aq) this.g).a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.h = searchableInfo;
        if (this.h != null) {
            p();
            o();
        }
        this.I = i();
        if (this.I) {
            this.a.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.D = z;
        a(c());
    }

    public void setSuggestionsAdapter(android.support.v4.widget.d dVar) {
        this.g = dVar;
        this.a.setAdapter(this.g);
    }
}