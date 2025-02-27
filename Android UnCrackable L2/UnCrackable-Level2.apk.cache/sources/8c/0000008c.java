package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new Parcelable.Creator<p>() { // from class: android.support.v4.app.p.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public p createFromParcel(Parcel parcel) {
            return new p(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public p[] newArray(int i) {
            return new p[i];
        }
    };
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    g l;

    p(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(g gVar) {
        this.a = gVar.getClass().getName();
        this.b = gVar.f;
        this.c = gVar.n;
        this.d = gVar.y;
        this.e = gVar.z;
        this.f = gVar.A;
        this.g = gVar.D;
        this.h = gVar.C;
        this.i = gVar.h;
        this.j = gVar.B;
    }

    public g a(k kVar, i iVar, g gVar, n nVar, android.arch.lifecycle.p pVar) {
        if (this.l == null) {
            Context g = kVar.g();
            if (this.i != null) {
                this.i.setClassLoader(g.getClassLoader());
            }
            this.l = iVar != null ? iVar.a(g, this.a, this.i) : g.a(g, this.a, this.i);
            if (this.k != null) {
                this.k.setClassLoader(g.getClassLoader());
                this.l.c = this.k;
            }
            this.l.a(this.b, gVar);
            this.l.n = this.c;
            this.l.p = true;
            this.l.y = this.d;
            this.l.z = this.e;
            this.l.A = this.f;
            this.l.D = this.g;
            this.l.C = this.h;
            this.l.B = this.j;
            this.l.s = kVar.d;
            if (m.a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        this.l.v = nVar;
        this.l.w = pVar;
        return this.l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }
}