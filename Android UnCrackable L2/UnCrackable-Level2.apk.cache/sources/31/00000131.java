package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.e;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* loaded from: classes.dex */
public abstract class d extends BaseAdapter implements e.a, Filterable {
    protected boolean a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected a f;
    protected DataSetObserver g;
    protected e h;
    protected FilterQueryProvider i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            d.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            d.this.a = true;
            d.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            d.this.a = false;
            d.this.notifyDataSetInvalidated();
        }
    }

    public d(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    @Override // android.support.v4.widget.e.a
    public Cursor a() {
        return this.c;
    }

    @Override // android.support.v4.widget.e.a
    public Cursor a(CharSequence charSequence) {
        return this.i != null ? this.i.runQuery(charSequence) : this.c;
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    void a(Context context, Cursor cursor, int i) {
        b bVar;
        if ((i & 1) == 1) {
            i |= 2;
            this.b = true;
        } else {
            this.b = false;
        }
        boolean z = cursor != null;
        this.c = cursor;
        this.a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f = new a();
            bVar = new b();
        } else {
            bVar = null;
            this.f = null;
        }
        this.g = bVar;
        if (z) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
        }
    }

    @Override // android.support.v4.widget.e.a
    public void a(Cursor cursor) {
        Cursor b2 = b(cursor);
        if (b2 != null) {
            b2.close();
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public Cursor b(Cursor cursor) {
        if (cursor == this.c) {
            return null;
        }
        Cursor cursor2 = this.c;
        if (cursor2 != null) {
            if (this.f != null) {
                cursor2.unregisterContentObserver(this.f);
            }
            if (this.g != null) {
                cursor2.unregisterDataSetObserver(this.g);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.a = true;
            notifyDataSetChanged();
        } else {
            this.e = -1;
            this.a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    protected void b() {
        if (!this.b || this.c == null || this.c.isClosed()) {
            return;
        }
        this.a = this.c.requery();
    }

    @Override // android.support.v4.widget.e.a
    public CharSequence c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.a || this.c == null) {
            return 0;
        }
        return this.c.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.a) {
            this.c.moveToPosition(i);
            if (view == null) {
                view = b(this.d, this.c, viewGroup);
            }
            a(view, this.d, this.c);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.h == null) {
            this.h = new e(this);
        }
        return this.h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.a || this.c == null) {
            return null;
        }
        this.c.moveToPosition(i);
        return this.c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.a && this.c != null && this.c.moveToPosition(i)) {
            return this.c.getLong(this.e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.a) {
            if (this.c.moveToPosition(i)) {
                if (view == null) {
                    view = a(this.d, this.c, viewGroup);
                }
                a(view, this.d, this.c);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}