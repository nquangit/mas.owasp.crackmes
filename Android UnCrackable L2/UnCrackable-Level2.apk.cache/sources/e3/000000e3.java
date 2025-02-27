package android.support.v4.g;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class a implements Parcelable {
    private final Parcelable b;
    public static final a a = new a() { // from class: android.support.v4.g.a.1
    };
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.ClassLoaderCreator<a>() { // from class: android.support.v4.g.a.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.a;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    private a() {
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.b = readParcelable == null ? a : readParcelable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.b = parcelable == a ? null : parcelable;
    }

    public final Parcelable a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
    }
}