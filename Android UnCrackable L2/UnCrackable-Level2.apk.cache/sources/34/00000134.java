package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;

/* loaded from: classes.dex */
class e extends Filter {
    a a;

    /* loaded from: classes.dex */
    interface a {
        Cursor a();

        Cursor a(CharSequence charSequence);

        void a(Cursor cursor);

        CharSequence c(Cursor cursor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.a.c((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor a2 = this.a.a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (a2 != null) {
            filterResults.count = a2.getCount();
        } else {
            filterResults.count = 0;
            a2 = null;
        }
        filterResults.values = a2;
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor a2 = this.a.a();
        if (filterResults.values == null || filterResults.values == a2) {
            return;
        }
        this.a.a((Cursor) filterResults.values);
    }
}