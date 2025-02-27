package android.support.v7.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.support.v7.a.a;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f implements o, AdapterView.OnItemClickListener {
    Context a;
    LayoutInflater b;
    h c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private o.a i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private int b = -1;

        public a() {
            a();
        }

        @Override // android.widget.Adapter
        /* renamed from: a */
        public j getItem(int i) {
            ArrayList<j> l = f.this.c.l();
            int i2 = i + f.this.e;
            if (this.b >= 0 && i2 >= this.b) {
                i2++;
            }
            return l.get(i2);
        }

        void a() {
            j r = f.this.c.r();
            if (r != null) {
                ArrayList<j> l = f.this.c.l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (l.get(i) == r) {
                        this.b = i;
                        return;
                    }
                }
            }
            this.b = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = f.this.c.l().size() - f.this.e;
            return this.b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = f.this.b.inflate(f.this.g, viewGroup, false);
            }
            ((p.a) view).a(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public f(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    public f(Context context, int i) {
        this(i, 0);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    public p a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.d.setAdapter((ListAdapter) this.h);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (r2.b == null) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // android.support.v7.view.menu.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r3, android.support.v7.view.menu.h r4) {
        /*
            r2 = this;
            int r0 = r2.f
            if (r0 == 0) goto L16
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.f
            r0.<init>(r3, r1)
            r2.a = r0
        Ld:
            android.content.Context r3 = r2.a
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r2.b = r3
            goto L21
        L16:
            android.content.Context r0 = r2.a
            if (r0 == 0) goto L21
            r2.a = r3
            android.view.LayoutInflater r3 = r2.b
            if (r3 != 0) goto L21
            goto Ld
        L21:
            r2.c = r4
            android.support.v7.view.menu.f$a r3 = r2.h
            if (r3 == 0) goto L2c
            android.support.v7.view.menu.f$a r3 = r2.h
            r3.notifyDataSetChanged()
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.f.a(android.content.Context, android.support.v7.view.menu.h):void");
    }

    @Override // android.support.v7.view.menu.o
    public void a(h hVar, boolean z) {
        if (this.i != null) {
            this.i.a(hVar, z);
        }
    }

    @Override // android.support.v7.view.menu.o
    public void a(o.a aVar) {
        this.i = aVar;
    }

    @Override // android.support.v7.view.menu.o
    public boolean a(h hVar, j jVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public boolean a(u uVar) {
        if (uVar.hasVisibleItems()) {
            new i(uVar).a((IBinder) null);
            if (this.i != null) {
                this.i.a(uVar);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public void b(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.o
    public boolean b() {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public boolean b(h hVar, j jVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.h.getItem(i), this, 0);
    }
}