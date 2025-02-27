package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.a.a;
import android.support.v7.view.menu.o;
import android.support.v7.widget.al;
import android.support.v7.widget.am;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends m implements o, View.OnKeyListener, PopupWindow.OnDismissListener {
    final Handler a;
    View c;
    boolean d;
    private final Context e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private View p;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean w;
    private o.a x;
    private ViewTreeObserver y;
    private PopupWindow.OnDismissListener z;
    private final List<h> j = new ArrayList();
    final List<a> b = new ArrayList();
    private final ViewTreeObserver.OnGlobalLayoutListener k = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.e.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!e.this.d() || e.this.b.size() <= 0 || e.this.b.get(0).a.g()) {
                return;
            }
            View view = e.this.c;
            if (view == null || !view.isShown()) {
                e.this.c();
                return;
            }
            for (a aVar : e.this.b) {
                aVar.a.a();
            }
        }
    };
    private final View.OnAttachStateChangeListener l = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.e.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (e.this.y != null) {
                if (!e.this.y.isAlive()) {
                    e.this.y = view.getViewTreeObserver();
                }
                e.this.y.removeGlobalOnLayoutListener(e.this.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final al m = new al() { // from class: android.support.v7.view.menu.e.3
        @Override // android.support.v7.widget.al
        public void a(h hVar, MenuItem menuItem) {
            e.this.a.removeCallbacksAndMessages(hVar);
        }

        @Override // android.support.v7.widget.al
        public void b(final h hVar, final MenuItem menuItem) {
            e.this.a.removeCallbacksAndMessages(null);
            int size = e.this.b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (hVar == e.this.b.get(i).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            final a aVar = i2 < e.this.b.size() ? e.this.b.get(i2) : null;
            e.this.a.postAtTime(new Runnable() { // from class: android.support.v7.view.menu.e.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        e.this.d = true;
                        aVar.b.a(false);
                        e.this.d = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        hVar.a(menuItem, 4);
                    }
                }
            }, hVar, SystemClock.uptimeMillis() + 200);
        }
    };
    private int n = 0;
    private int o = 0;
    private boolean v = false;
    private int q = i();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public final am a;
        public final h b;
        public final int c;

        public a(am amVar, h hVar, int i) {
            this.a = amVar;
            this.b = hVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.e();
        }
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.e = context;
        this.p = view;
        this.g = i;
        this.h = i2;
        this.i = z;
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    private MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, h hVar) {
        g gVar;
        int i;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.b, hVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            i = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (a2 == gVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private void c(h hVar) {
        a aVar;
        View view;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.e);
        g gVar = new g(hVar, from, this.i);
        if (!d() && this.v) {
            gVar.a(true);
        } else if (d()) {
            gVar.a(m.b(hVar));
        }
        int a2 = a(gVar, null, this.e, this.f);
        am h = h();
        h.a((ListAdapter) gVar);
        h.g(a2);
        h.e(this.o);
        if (this.b.size() > 0) {
            aVar = this.b.get(this.b.size() - 1);
            view = a(aVar, hVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            h.c(false);
            h.a((Object) null);
            int d = d(a2);
            boolean z = d == 1;
            this.q = d;
            if (Build.VERSION.SDK_INT >= 26) {
                h.b(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) == 5) {
                if (!z) {
                    a2 = view.getWidth();
                    i3 = i - a2;
                }
                i3 = i + a2;
            } else {
                if (z) {
                    a2 = view.getWidth();
                    i3 = i + a2;
                }
                i3 = i - a2;
            }
            h.c(i3);
            h.b(true);
            h.d(i2);
        } else {
            if (this.r) {
                h.c(this.t);
            }
            if (this.s) {
                h.d(this.u);
            }
            h.a(g());
        }
        this.b.add(new a(h, hVar, this.q));
        h.a();
        ListView e = h.e();
        e.setOnKeyListener(this);
        if (aVar == null && this.w && hVar.m() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) e, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(hVar.m());
            e.addHeaderView(frameLayout, null, false);
            h.a();
        }
    }

    private int d(int i) {
        ListView a2 = this.b.get(this.b.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.c.getWindowVisibleDisplayFrame(rect);
        return this.q == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private int d(h hVar) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (hVar == this.b.get(i).b) {
                return i;
            }
        }
        return -1;
    }

    private am h() {
        am amVar = new am(this.e, null, this.g, this.h);
        amVar.a(this.m);
        amVar.a((AdapterView.OnItemClickListener) this);
        amVar.a((PopupWindow.OnDismissListener) this);
        amVar.b(this.p);
        amVar.e(this.o);
        amVar.a(true);
        amVar.h(2);
        return amVar;
    }

    private int i() {
        return android.support.v4.g.p.b(this.p) == 1 ? 0 : 1;
    }

    @Override // android.support.v7.view.menu.s
    public void a() {
        if (d()) {
            return;
        }
        for (h hVar : this.j) {
            c(hVar);
        }
        this.j.clear();
        this.c = this.p;
        if (this.c != null) {
            boolean z = this.y == null;
            this.y = this.c.getViewTreeObserver();
            if (z) {
                this.y.addOnGlobalLayoutListener(this.k);
            }
            this.c.addOnAttachStateChangeListener(this.l);
        }
    }

    @Override // android.support.v7.view.menu.m
    public void a(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = android.support.v4.g.d.a(i, android.support.v4.g.p.b(this.p));
        }
    }

    @Override // android.support.v7.view.menu.m
    public void a(h hVar) {
        hVar.a(this, this.e);
        if (d()) {
            c(hVar);
        } else {
            this.j.add(hVar);
        }
    }

    @Override // android.support.v7.view.menu.o
    public void a(h hVar, boolean z) {
        int d = d(hVar);
        if (d < 0) {
            return;
        }
        int i = d + 1;
        if (i < this.b.size()) {
            this.b.get(i).b.a(false);
        }
        a remove = this.b.remove(d);
        remove.b.b(this);
        if (this.d) {
            remove.a.b((Object) null);
            remove.a.b(0);
        }
        remove.a.c();
        int size = this.b.size();
        this.q = size > 0 ? this.b.get(size - 1).c : i();
        if (size != 0) {
            if (z) {
                this.b.get(0).b.a(false);
                return;
            }
            return;
        }
        c();
        if (this.x != null) {
            this.x.a(hVar, true);
        }
        if (this.y != null) {
            if (this.y.isAlive()) {
                this.y.removeGlobalOnLayoutListener(this.k);
            }
            this.y = null;
        }
        this.c.removeOnAttachStateChangeListener(this.l);
        this.z.onDismiss();
    }

    @Override // android.support.v7.view.menu.o
    public void a(o.a aVar) {
        this.x = aVar;
    }

    @Override // android.support.v7.view.menu.m
    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = android.support.v4.g.d.a(this.n, android.support.v4.g.p.b(this.p));
        }
    }

    @Override // android.support.v7.view.menu.m
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    @Override // android.support.v7.view.menu.m
    public void a(boolean z) {
        this.v = z;
    }

    @Override // android.support.v7.view.menu.o
    public boolean a(u uVar) {
        for (a aVar : this.b) {
            if (uVar == aVar.b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (uVar.hasVisibleItems()) {
            a((h) uVar);
            if (this.x != null) {
                this.x.a(uVar);
            }
            return true;
        }
        return false;
    }

    @Override // android.support.v7.view.menu.m
    public void b(int i) {
        this.r = true;
        this.t = i;
    }

    @Override // android.support.v7.view.menu.o
    public void b(boolean z) {
        for (a aVar : this.b) {
            a(aVar.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.o
    public boolean b() {
        return false;
    }

    @Override // android.support.v7.view.menu.s
    public void c() {
        int size = this.b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.b.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.a.d()) {
                    aVar.a.c();
                }
            }
        }
    }

    @Override // android.support.v7.view.menu.m
    public void c(int i) {
        this.s = true;
        this.u = i;
    }

    @Override // android.support.v7.view.menu.m
    public void c(boolean z) {
        this.w = z;
    }

    @Override // android.support.v7.view.menu.s
    public boolean d() {
        return this.b.size() > 0 && this.b.get(0).a.d();
    }

    @Override // android.support.v7.view.menu.s
    public ListView e() {
        if (this.b.isEmpty()) {
            return null;
        }
        return this.b.get(this.b.size() - 1).a();
    }

    @Override // android.support.v7.view.menu.m
    protected boolean f() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.b.get(i);
            if (!aVar.a.d()) {
                break;
            }
            i++;
        }
        if (aVar != null) {
            aVar.b.a(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            c();
            return true;
        }
        return false;
    }
}