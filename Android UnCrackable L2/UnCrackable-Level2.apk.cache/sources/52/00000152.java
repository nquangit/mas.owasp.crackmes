package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a;
import android.support.v7.widget.aj;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    private int A;
    private CharSequence C;
    private Drawable D;
    private CharSequence E;
    private Drawable F;
    private CharSequence G;
    private Drawable H;
    private Drawable J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private View N;
    private int O;
    private int P;
    private boolean Q;
    final k a;
    ListView b;
    Button c;
    Message d;
    Button e;
    Message f;
    Button g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int l;
    int m;
    int n;
    int o;
    Handler p;
    private final Context q;
    private final Window r;
    private final int s;
    private CharSequence t;
    private CharSequence u;
    private View v;
    private int w;
    private int x;
    private int y;
    private int z;
    private boolean B = false;
    private int I = 0;
    int k = -1;
    private int R = 0;
    private final View.OnClickListener S = new View.OnClickListener() { // from class: android.support.v7.app.AlertController.1
        /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                android.support.v7.app.AlertController r0 = android.support.v7.app.AlertController.this
                android.widget.Button r0 = r0.c
                if (r3 != r0) goto L15
                android.support.v7.app.AlertController r0 = android.support.v7.app.AlertController.this
                android.os.Message r0 = r0.d
                if (r0 == 0) goto L15
                android.support.v7.app.AlertController r3 = android.support.v7.app.AlertController.this
                android.os.Message r3 = r3.d
            L10:
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L38
            L15:
                android.support.v7.app.AlertController r0 = android.support.v7.app.AlertController.this
                android.widget.Button r0 = r0.e
                if (r3 != r0) goto L26
                android.support.v7.app.AlertController r0 = android.support.v7.app.AlertController.this
                android.os.Message r0 = r0.f
                if (r0 == 0) goto L26
                android.support.v7.app.AlertController r3 = android.support.v7.app.AlertController.this
                android.os.Message r3 = r3.f
                goto L10
            L26:
                android.support.v7.app.AlertController r0 = android.support.v7.app.AlertController.this
                android.widget.Button r0 = r0.g
                if (r3 != r0) goto L37
                android.support.v7.app.AlertController r3 = android.support.v7.app.AlertController.this
                android.os.Message r3 = r3.h
                if (r3 == 0) goto L37
                android.support.v7.app.AlertController r3 = android.support.v7.app.AlertController.this
                android.os.Message r3 = r3.h
                goto L10
            L37:
                r3 = 0
            L38:
                if (r3 == 0) goto L3d
                r3.sendToTarget()
            L3d:
                android.support.v7.app.AlertController r3 = android.support.v7.app.AlertController.this
                android.os.Handler r3 = r3.p
                r0 = 1
                android.support.v7.app.AlertController r1 = android.support.v7.app.AlertController.this
                android.support.v7.app.k r1 = r1.a
                android.os.Message r3 = r3.obtainMessage(r0, r1)
                r3.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AlertController.AnonymousClass1.onClick(android.view.View):void");
        }
    };

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {
        private final int a;
        private final int b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.RecycleListView);
            this.b = obtainStyledAttributes.getDimensionPixelOffset(a.j.RecycleListView_paddingBottomNoButtons, -1);
            this.a = obtainStyledAttributes.getDimensionPixelOffset(a.j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.a, getPaddingRight(), z2 ? getPaddingBottom() : this.b);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public InterfaceC0012a O;
        public final Context a;
        public final LayoutInflater b;
        public Drawable d;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;
        public int c = 0;
        public int e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;
        public boolean r = true;

        /* renamed from: android.support.v7.app.AlertController$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0012a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.a = context;
            this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void b(final android.support.v7.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.b
                int r1 = r11.l
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                android.support.v7.app.AlertController$RecycleListView r0 = (android.support.v7.app.AlertController.RecycleListView) r0
                boolean r1 = r10.G
                r8 = 1
                if (r1 == 0) goto L35
                android.database.Cursor r1 = r10.K
                if (r1 != 0) goto L26
                android.support.v7.app.AlertController$a$1 r9 = new android.support.v7.app.AlertController$a$1
                android.content.Context r3 = r10.a
                int r4 = r11.m
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6)
                goto L6e
            L26:
                android.support.v7.app.AlertController$a$2 r9 = new android.support.v7.app.AlertController$a$2
                android.content.Context r3 = r10.a
                android.database.Cursor r4 = r10.K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5)
                goto L6e
            L35:
                boolean r1 = r10.H
                if (r1 == 0) goto L3d
                int r1 = r11.n
            L3b:
                r4 = r1
                goto L40
            L3d:
                int r1 = r11.o
                goto L3b
            L40:
                android.database.Cursor r1 = r10.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L5e
                android.widget.SimpleCursorAdapter r1 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.a
                android.database.Cursor r5 = r10.K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r7 = r10.L
                r9 = 0
                r6[r9] = r7
                int[] r7 = new int[r8]
                r7[r9] = r2
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                r9 = r1
                goto L6e
            L5e:
                android.widget.ListAdapter r1 = r10.w
                if (r1 == 0) goto L65
                android.widget.ListAdapter r9 = r10.w
                goto L6e
            L65:
                android.support.v7.app.AlertController$c r9 = new android.support.v7.app.AlertController$c
                android.content.Context r1 = r10.a
                java.lang.CharSequence[] r3 = r10.v
                r9.<init>(r1, r4, r2, r3)
            L6e:
                android.support.v7.app.AlertController$a$a r1 = r10.O
                if (r1 == 0) goto L77
                android.support.v7.app.AlertController$a$a r1 = r10.O
                r1.a(r0)
            L77:
                r11.j = r9
                int r1 = r10.I
                r11.k = r1
                android.content.DialogInterface$OnClickListener r1 = r10.x
                if (r1 == 0) goto L8a
                android.support.v7.app.AlertController$a$3 r1 = new android.support.v7.app.AlertController$a$3
                r1.<init>()
            L86:
                r0.setOnItemClickListener(r1)
                goto L94
            L8a:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.J
                if (r1 == 0) goto L94
                android.support.v7.app.AlertController$a$4 r1 = new android.support.v7.app.AlertController$a$4
                r1.<init>()
                goto L86
            L94:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.N
                if (r1 == 0) goto L9d
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.N
                r0.setOnItemSelectedListener(r1)
            L9d:
                boolean r1 = r10.H
                if (r1 == 0) goto La5
                r0.setChoiceMode(r8)
                goto Lad
            La5:
                boolean r1 = r10.G
                if (r1 == 0) goto Lad
                r1 = 2
                r0.setChoiceMode(r1)
            Lad:
                r11.b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AlertController.a.b(android.support.v7.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            if (this.g != null) {
                alertController.b(this.g);
            } else {
                if (this.f != null) {
                    alertController.a(this.f);
                }
                if (this.d != null) {
                    alertController.a(this.d);
                }
                if (this.c != 0) {
                    alertController.b(this.c);
                }
                if (this.e != 0) {
                    alertController.b(alertController.c(this.e));
                }
            }
            if (this.h != null) {
                alertController.b(this.h);
            }
            if (this.i != null || this.j != null) {
                alertController.a(-1, this.i, this.k, (Message) null, this.j);
            }
            if (this.l != null || this.m != null) {
                alertController.a(-2, this.l, this.n, (Message) null, this.m);
            }
            if (this.o != null || this.p != null) {
                alertController.a(-3, this.o, this.q, (Message) null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            if (this.z == null) {
                if (this.y != 0) {
                    alertController.a(this.y);
                }
            } else if (this.E) {
                alertController.a(this.z, this.A, this.B, this.C, this.D);
            } else {
                alertController.c(this.z);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class b extends Handler {
        private WeakReference<DialogInterface> a;

        public b(DialogInterface dialogInterface) {
            this.a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
                return;
            }
            switch (i) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick(this.a.get(), message.what);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, k kVar, Window window) {
        this.q = context;
        this.a = kVar;
        this.r = window;
        this.p = new b(kVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, a.j.AlertDialog, a.C0011a.alertDialogStyle, 0);
        this.O = obtainStyledAttributes.getResourceId(a.j.AlertDialog_android_layout, 0);
        this.P = obtainStyledAttributes.getResourceId(a.j.AlertDialog_buttonPanelSideLayout, 0);
        this.l = obtainStyledAttributes.getResourceId(a.j.AlertDialog_listLayout, 0);
        this.m = obtainStyledAttributes.getResourceId(a.j.AlertDialog_multiChoiceItemLayout, 0);
        this.n = obtainStyledAttributes.getResourceId(a.j.AlertDialog_singleChoiceItemLayout, 0);
        this.o = obtainStyledAttributes.getResourceId(a.j.AlertDialog_listItemLayout, 0);
        this.Q = obtainStyledAttributes.getBoolean(a.j.AlertDialog_showTitle, true);
        this.s = obtainStyledAttributes.getDimensionPixelSize(a.j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        kVar.a(1);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private void a(ViewGroup viewGroup) {
        View inflate = this.v != null ? this.v : this.w != 0 ? LayoutInflater.from(this.q).inflate(this.w, viewGroup, false) : null;
        boolean z = inflate != null;
        if (!z || !a(inflate)) {
            this.r.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.r.findViewById(a.f.custom);
        frameLayout.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.B) {
            frameLayout.setPadding(this.x, this.y, this.z, this.A);
        }
        if (this.b != null) {
            ((aj.a) viewGroup.getLayoutParams()).g = 0.0f;
        }
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.r.findViewById(a.f.scrollIndicatorUp);
        View findViewById2 = this.r.findViewById(a.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            android.support.v4.g.p.a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById == null && view2 == null) {
            return;
        }
        if (this.u != null) {
            this.i.setOnScrollChangeListener(new NestedScrollView.b() { // from class: android.support.v7.app.AlertController.2
                @Override // android.support.v4.widget.NestedScrollView.b
                public void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                    AlertController.a(nestedScrollView, findViewById, view2);
                }
            });
            this.i.post(new Runnable() { // from class: android.support.v7.app.AlertController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.a(AlertController.this.i, findViewById, view2);
                }
            });
        } else if (this.b != null) {
            this.b.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: android.support.v7.app.AlertController.4
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                    AlertController.a(absListView, findViewById, view2);
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i3) {
                }
            });
            this.b.post(new Runnable() { // from class: android.support.v7.app.AlertController.5
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.a(AlertController.this.b, findViewById, view2);
                }
            });
        } else {
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
        }
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0011a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (a(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private int b() {
        if (this.P != 0 && this.R == 1) {
            return this.P;
        }
        return this.O;
    }

    private void b(ViewGroup viewGroup) {
        if (this.N != null) {
            viewGroup.addView(this.N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.r.findViewById(a.f.title_template).setVisibility(8);
            return;
        }
        this.K = (ImageView) this.r.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.t)) || !this.Q) {
            this.r.findViewById(a.f.title_template).setVisibility(8);
            this.K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.L = (TextView) this.r.findViewById(a.f.alertTitle);
        this.L.setText(this.t);
        if (this.I != 0) {
            this.K.setImageResource(this.I);
        } else if (this.J != null) {
            this.K.setImageDrawable(this.J);
        } else {
            this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
            this.K.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        View findViewById;
        View findViewById2;
        View findViewById3 = this.r.findViewById(a.f.parentPanel);
        View findViewById4 = findViewById3.findViewById(a.f.topPanel);
        View findViewById5 = findViewById3.findViewById(a.f.contentPanel);
        View findViewById6 = findViewById3.findViewById(a.f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(a.f.customPanel);
        a(viewGroup);
        View findViewById7 = viewGroup.findViewById(a.f.topPanel);
        View findViewById8 = viewGroup.findViewById(a.f.contentPanel);
        View findViewById9 = viewGroup.findViewById(a.f.buttonPanel);
        ViewGroup a2 = a(findViewById7, findViewById4);
        ViewGroup a3 = a(findViewById8, findViewById5);
        ViewGroup a4 = a(findViewById9, findViewById6);
        c(a3);
        d(a4);
        b(a2);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a2 == null || a2.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!z3 && a3 != null && (findViewById2 = a3.findViewById(a.f.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            if (this.i != null) {
                this.i.setClipToPadding(true);
            }
            View view = null;
            if (this.u != null || this.b != null) {
                view = a2.findViewById(a.f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (a3 != null && (findViewById = a3.findViewById(a.f.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        if (this.b instanceof RecycleListView) {
            ((RecycleListView) this.b).a(z2, z3);
        }
        if (!z) {
            View view2 = this.b != null ? this.b : this.i;
            if (view2 != null) {
                a(a3, view2, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView = this.b;
        if (listView == null || this.j == null) {
            return;
        }
        listView.setAdapter(this.j);
        int i = this.k;
        if (i > -1) {
            listView.setItemChecked(i, true);
            listView.setSelection(i);
        }
    }

    private void c(ViewGroup viewGroup) {
        this.i = (NestedScrollView) this.r.findViewById(a.f.scrollView);
        this.i.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        this.M = (TextView) viewGroup.findViewById(16908299);
        if (this.M == null) {
            return;
        }
        if (this.u != null) {
            this.M.setText(this.u);
            return;
        }
        this.M.setVisibility(8);
        this.i.removeView(this.M);
        if (this.b == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.i);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.b, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void d(ViewGroup viewGroup) {
        boolean z;
        Button button;
        this.c = (Button) viewGroup.findViewById(16908313);
        this.c.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.C) && this.D == null) {
            this.c.setVisibility(8);
            z = false;
        } else {
            this.c.setText(this.C);
            if (this.D != null) {
                this.D.setBounds(0, 0, this.s, this.s);
                this.c.setCompoundDrawables(this.D, null, null, null);
            }
            this.c.setVisibility(0);
            z = true;
        }
        this.e = (Button) viewGroup.findViewById(16908314);
        this.e.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.E) && this.F == null) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(this.E);
            if (this.F != null) {
                this.F.setBounds(0, 0, this.s, this.s);
                this.e.setCompoundDrawables(this.F, null, null, null);
            }
            this.e.setVisibility(0);
            z |= true;
        }
        this.g = (Button) viewGroup.findViewById(16908315);
        this.g.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.G) && this.H == null) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(this.G);
            if (this.D != null) {
                this.D.setBounds(0, 0, this.s, this.s);
                this.c.setCompoundDrawables(this.D, null, null, null);
            }
            this.g.setVisibility(0);
            z |= true;
        }
        if (a(this.q)) {
            if (z) {
                button = this.c;
            } else if (z) {
                button = this.e;
            } else if (z) {
                button = this.g;
            }
            a(button);
        }
        if (z) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void a() {
        this.a.setContentView(b());
        c();
    }

    public void a(int i) {
        this.v = null;
        this.w = i;
        this.B = false;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.G = charSequence;
                this.h = message;
                this.H = drawable;
                return;
            case -2:
                this.E = charSequence;
                this.f = message;
                this.F = drawable;
                return;
            case -1:
                this.C = charSequence;
                this.d = message;
                this.D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.J = drawable;
        this.I = 0;
        if (this.K != null) {
            if (drawable == null) {
                this.K.setVisibility(8);
                return;
            }
            this.K.setVisibility(0);
            this.K.setImageDrawable(drawable);
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.v = view;
        this.w = 0;
        this.B = true;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.A = i4;
    }

    public void a(CharSequence charSequence) {
        this.t = charSequence;
        if (this.L != null) {
            this.L.setText(charSequence);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public void b(int i) {
        this.J = null;
        this.I = i;
        if (this.K != null) {
            if (i == 0) {
                this.K.setVisibility(8);
                return;
            }
            this.K.setVisibility(0);
            this.K.setImageResource(this.I);
        }
    }

    public void b(View view) {
        this.N = view;
    }

    public void b(CharSequence charSequence) {
        this.u = charSequence;
        if (this.M != null) {
            this.M.setText(charSequence);
        }
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(View view) {
        this.v = view;
        this.w = 0;
        this.B = false;
    }
}