package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements o {
    protected Context a;
    protected Context b;
    protected h c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected p f;
    private o.a g;
    private int h;
    private int i;
    private int j;

    public b(Context context, int i, int i2) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    public o.a a() {
        return this.g;
    }

    public p a(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (p) this.d.inflate(this.h, viewGroup, false);
            this.f.a(this.c);
            b(true);
        }
        return this.f;
    }

    public View a(j jVar, View view, ViewGroup viewGroup) {
        p.a b = view instanceof p.a ? (p.a) view : b(viewGroup);
        a(jVar, b);
        return (View) b;
    }

    public void a(int i) {
        this.j = i;
    }

    @Override // android.support.v7.view.menu.o
    public void a(Context context, h hVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = hVar;
    }

    @Override // android.support.v7.view.menu.o
    public void a(h hVar, boolean z) {
        if (this.g != null) {
            this.g.a(hVar, z);
        }
    }

    public abstract void a(j jVar, p.a aVar);

    @Override // android.support.v7.view.menu.o
    public void a(o.a aVar) {
        this.g = aVar;
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i);
    }

    public boolean a(int i, j jVar) {
        return true;
    }

    @Override // android.support.v7.view.menu.o
    public boolean a(h hVar, j jVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public boolean a(u uVar) {
        if (this.g != null) {
            return this.g.a(uVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public p.a b(ViewGroup viewGroup) {
        return (p.a) this.d.inflate(this.i, viewGroup, false);
    }

    @Override // android.support.v7.view.menu.o
    public void b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return;
        }
        int i = 0;
        if (this.c != null) {
            this.c.j();
            ArrayList<j> i2 = this.c.i();
            int size = i2.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                j jVar = i2.get(i4);
                if (a(i3, jVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    j itemData = childAt instanceof p.a ? ((p.a) childAt).getItemData() : null;
                    View a = a(jVar, childAt, viewGroup);
                    if (jVar != itemData) {
                        a.setPressed(false);
                        a.jumpDrawablesToCurrentState();
                    }
                    if (a != childAt) {
                        a(a, i3);
                    }
                    i3++;
                }
            }
            i = i3;
        }
        while (i < viewGroup.getChildCount()) {
            if (!a(viewGroup, i)) {
                i++;
            }
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
}