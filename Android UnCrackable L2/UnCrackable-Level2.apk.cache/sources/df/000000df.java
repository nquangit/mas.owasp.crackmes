package android.support.v4.f;

/* loaded from: classes.dex */
public class i<F, S> {
    public final F a;
    public final S b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            return a(iVar.a, this.a) && a(iVar.b, this.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a == null ? 0 : this.a.hashCode()) ^ (this.b != null ? this.b.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.b) + "}";
    }
}