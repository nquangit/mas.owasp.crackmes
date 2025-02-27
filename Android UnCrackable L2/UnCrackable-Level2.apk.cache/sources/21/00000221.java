package android.support.v7.widget;

/* loaded from: classes.dex */
class ao {
    private int a = 0;
    private int b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    public int a() {
        return this.a;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.b = i2;
        }
    }

    public void a(boolean z) {
        int i;
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (this.h) {
            if (z) {
                this.a = this.d != Integer.MIN_VALUE ? this.d : this.e;
                if (this.c != Integer.MIN_VALUE) {
                    i = this.c;
                }
            } else {
                this.a = this.c != Integer.MIN_VALUE ? this.c : this.e;
                if (this.d != Integer.MIN_VALUE) {
                    i = this.d;
                }
            }
            this.b = i;
        }
        this.a = this.e;
        i = this.f;
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public void b(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.b = i2;
        }
    }

    public int c() {
        return this.g ? this.b : this.a;
    }

    public int d() {
        return this.g ? this.a : this.b;
    }
}