package android.support.v4.f;

/* loaded from: classes.dex */
public class f<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private long[] c;
    private Object[] d;
    private int e;

    public f() {
        this(10);
    }

    public f(int i) {
        Object[] objArr;
        this.b = false;
        if (i == 0) {
            this.c = c.b;
            objArr = c.c;
        } else {
            int b = c.b(i);
            this.c = new long[b];
            objArr = new Object[b];
        }
        this.d = objArr;
        this.e = 0;
    }

    private void d() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public long a(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    /* renamed from: a */
    public f<E> clone() {
        try {
            f<E> fVar = (f) super.clone();
            try {
                fVar.c = (long[]) this.c.clone();
                fVar.d = (Object[]) this.d.clone();
                return fVar;
            } catch (CloneNotSupportedException unused) {
                return fVar;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public E a(long j) {
        return a(j, null);
    }

    public E a(long j, E e) {
        int a2 = c.a(this.c, this.e, j);
        return (a2 < 0 || this.d[a2] == a) ? e : (E) this.d[a2];
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public E b(int i) {
        if (this.b) {
            d();
        }
        return (E) this.d[i];
    }

    public void b(long j) {
        int a2 = c.a(this.c, this.e, j);
        if (a2 < 0 || this.d[a2] == a) {
            return;
        }
        this.d[a2] = a;
        this.b = true;
    }

    public void b(long j, E e) {
        int a2 = c.a(this.c, this.e, j);
        if (a2 >= 0) {
            this.d[a2] = e;
            return;
        }
        int i = a2 ^ (-1);
        if (i < this.e && this.d[i] == a) {
            this.c[i] = j;
            this.d[i] = e;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            d();
            i = c.a(this.c, this.e, j) ^ (-1);
        }
        if (this.e >= this.c.length) {
            int b = c.b(this.e + 1);
            long[] jArr = new long[b];
            Object[] objArr = new Object[b];
            System.arraycopy(this.c, 0, jArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = jArr;
            this.d = objArr;
        }
        if (this.e - i != 0) {
            int i2 = i + 1;
            System.arraycopy(this.c, i, this.c, i2, this.e - i);
            System.arraycopy(this.d, i, this.d, i2, this.e - i);
        }
        this.c[i] = j;
        this.d[i] = e;
        this.e++;
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a(i));
            sb.append('=');
            E b = b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}