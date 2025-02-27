package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.c;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: android.support.v4.app.d.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public d(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }

    public d(c cVar) {
        int size = cVar.b.size();
        this.a = new int[size * 6];
        if (!cVar.i) {
            throw new IllegalStateException("Not on back stack");
        }
        int i = 0;
        int i2 = 0;
        while (i < size) {
            c.a aVar = cVar.b.get(i);
            int i3 = i2 + 1;
            this.a[i2] = aVar.a;
            int i4 = i3 + 1;
            this.a[i3] = aVar.b != null ? aVar.b.f : -1;
            int i5 = i4 + 1;
            this.a[i4] = aVar.c;
            int i6 = i5 + 1;
            this.a[i5] = aVar.d;
            int i7 = i6 + 1;
            this.a[i6] = aVar.e;
            this.a[i7] = aVar.f;
            i++;
            i2 = i7 + 1;
        }
        this.b = cVar.g;
        this.c = cVar.h;
        this.d = cVar.k;
        this.e = cVar.m;
        this.f = cVar.n;
        this.g = cVar.o;
        this.h = cVar.p;
        this.i = cVar.q;
        this.j = cVar.r;
        this.k = cVar.s;
        this.l = cVar.t;
    }

    public c a(m mVar) {
        c cVar = new c(mVar);
        int i = 0;
        int i2 = 0;
        while (i < this.a.length) {
            c.a aVar = new c.a();
            int i3 = i + 1;
            aVar.a = this.a[i];
            if (m.a) {
                Log.v("FragmentManager", "Instantiate " + cVar + " op #" + i2 + " base fragment #" + this.a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.a[i3];
            aVar.b = i5 >= 0 ? mVar.f.get(i5) : null;
            int i6 = i4 + 1;
            aVar.c = this.a[i4];
            int i7 = i6 + 1;
            aVar.d = this.a[i6];
            int i8 = i7 + 1;
            aVar.e = this.a[i7];
            aVar.f = this.a[i8];
            cVar.c = aVar.c;
            cVar.d = aVar.d;
            cVar.e = aVar.e;
            cVar.f = aVar.f;
            cVar.a(aVar);
            i2++;
            i = i8 + 1;
        }
        cVar.g = this.b;
        cVar.h = this.c;
        cVar.k = this.d;
        cVar.m = this.e;
        cVar.i = true;
        cVar.n = this.f;
        cVar.o = this.g;
        cVar.p = this.h;
        cVar.q = this.i;
        cVar.r = this.j;
        cVar.s = this.k;
        cVar.t = this.l;
        cVar.a(1);
        return cVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l ? 1 : 0);
    }
}