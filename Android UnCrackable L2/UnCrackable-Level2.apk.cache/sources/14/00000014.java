package android.arch.lifecycle;

import android.arch.lifecycle.c;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    private static final Object a = new Object();
    private android.arch.a.b.b<k<T>, LiveData<T>.a> b;
    private int c;
    private volatile Object d;
    private int e;
    private boolean f;
    private boolean g;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.a implements GenericLifecycleObserver {
        final e a;

        LifecycleBoundObserver(e eVar, k<T> kVar) {
            super(kVar);
            this.a = eVar;
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        public void a(e eVar, c.a aVar) {
            if (this.a.a().a() == c.b.DESTROYED) {
                LiveData.this.a(this.c);
            } else {
                a(a());
            }
        }

        @Override // android.arch.lifecycle.LiveData.a
        boolean a() {
            return this.a.a().a().a(c.b.STARTED);
        }

        @Override // android.arch.lifecycle.LiveData.a
        boolean a(e eVar) {
            return this.a == eVar;
        }

        @Override // android.arch.lifecycle.LiveData.a
        void b() {
            this.a.a().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a {
        final k<T> c;
        boolean d;
        int e = -1;

        a(k<T> kVar) {
            this.c = kVar;
        }

        void a(boolean z) {
            if (z == this.d) {
                return;
            }
            this.d = z;
            boolean z2 = LiveData.this.c == 0;
            LiveData.this.c += this.d ? 1 : -1;
            if (z2 && this.d) {
                LiveData.this.b();
            }
            if (LiveData.this.c == 0 && !this.d) {
                LiveData.this.c();
            }
            if (this.d) {
                LiveData.this.b(this);
            }
        }

        abstract boolean a();

        boolean a(e eVar) {
            return false;
        }

        void b() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(LiveData<T>.a aVar) {
        if (aVar.d) {
            if (!aVar.a()) {
                aVar.a(false);
            } else if (aVar.e >= this.e) {
            } else {
                aVar.e = this.e;
                aVar.c.a(this.d);
            }
        }
    }

    private static void a(String str) {
        if (android.arch.a.a.a.a().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LiveData<T>.a aVar) {
        if (this.f) {
            this.g = true;
            return;
        }
        this.f = true;
        do {
            this.g = false;
            if (aVar == null) {
                android.arch.a.b.b<k<T>, LiveData<T>.a>.d c = this.b.c();
                while (c.hasNext()) {
                    a((a) c.next().getValue());
                    if (this.g) {
                        break;
                    }
                }
            } else {
                a(aVar);
                aVar = null;
            }
        } while (this.g);
        this.f = false;
    }

    public T a() {
        T t = (T) this.d;
        if (t != a) {
            return t;
        }
        return null;
    }

    public void a(e eVar, k<T> kVar) {
        if (eVar.a().a() == c.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(eVar, kVar);
        LiveData<T>.a a2 = this.b.a(kVar, lifecycleBoundObserver);
        if (a2 != null && !a2.a(eVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (a2 != null) {
            return;
        }
        eVar.a().a(lifecycleBoundObserver);
    }

    public void a(k<T> kVar) {
        a("removeObserver");
        LiveData<T>.a b = this.b.b(kVar);
        if (b == null) {
            return;
        }
        b.b();
        b.a(false);
    }

    protected void b() {
    }

    protected void c() {
    }

    public boolean d() {
        return this.c > 0;
    }
}