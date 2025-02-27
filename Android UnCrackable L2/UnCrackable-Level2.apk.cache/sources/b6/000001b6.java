package android.support.v7.view.menu;

import android.support.v7.a.a;
import android.support.v7.view.menu.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class g extends BaseAdapter {
    static final int a = a.g.abc_popup_menu_item_layout;
    h b;
    private int c = -1;
    private boolean d;
    private final boolean e;
    private final LayoutInflater f;

    public g(h hVar, LayoutInflater layoutInflater, boolean z) {
        this.e = z;
        this.f = layoutInflater;
        this.b = hVar;
        b();
    }

    public h a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public j getItem(int i) {
        ArrayList<j> l = this.e ? this.b.l() : this.b.i();
        if (this.c >= 0 && i >= this.c) {
            i++;
        }
        return l.get(i);
    }

    public void a(boolean z) {
        this.d = z;
    }

    void b() {
        j r = this.b.r();
        if (r != null) {
            ArrayList<j> l = this.b.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (l.get(i) == r) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<j> l = this.e ? this.b.l() : this.b.i();
        return this.c < 0 ? l.size() : l.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f.inflate(a, viewGroup, false);
        }
        p.a aVar = (p.a) view;
        if (this.d) {
            ((ListMenuItemView) view).setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}