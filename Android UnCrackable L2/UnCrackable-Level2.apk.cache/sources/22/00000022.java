package android.arch.lifecycle;

import android.arch.lifecycle.c;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class f extends c {
    private final WeakReference<e> c;
    private android.arch.a.b.a<d, a> a = new android.arch.a.b.a<>();
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<c.b> g = new ArrayList<>();
    private c.b b = c.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        c.b a;
        GenericLifecycleObserver b;

        a(d dVar, c.b bVar) {
            this.b = h.a(dVar);
            this.a = bVar;
        }

        void a(e eVar, c.a aVar) {
            c.b b = f.b(aVar);
            this.a = f.a(this.a, b);
            this.b.a(eVar, aVar);
            this.a = b;
        }
    }

    public f(e eVar) {
        this.c = new WeakReference<>(eVar);
    }

    static c.b a(c.b bVar, c.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(e eVar) {
        android.arch.a.b.b<d, a>.d c = this.a.c();
        while (c.hasNext() && !this.f) {
            Map.Entry next = c.next();
            a aVar = (a) next.getValue();
            while (aVar.a.compareTo(this.b) < 0 && !this.f && this.a.c(next.getKey())) {
                c(aVar.a);
                aVar.a(eVar, e(aVar.a));
                c();
            }
        }
    }

    static c.b b(c.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return c.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return c.b.STARTED;
            case ON_RESUME:
                return c.b.RESUMED;
            case ON_DESTROY:
                return c.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private void b(c.b bVar) {
        if (this.b == bVar) {
            return;
        }
        this.b = bVar;
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        d();
        this.e = false;
    }

    private void b(e eVar) {
        Iterator<Map.Entry<d, a>> b = this.a.b();
        while (b.hasNext() && !this.f) {
            Map.Entry<d, a> next = b.next();
            a value = next.getValue();
            while (value.a.compareTo(this.b) > 0 && !this.f && this.a.c(next.getKey())) {
                c.a d = d(value.a);
                c(b(d));
                value.a(eVar, d);
                c();
            }
        }
    }

    private boolean b() {
        if (this.a.a() == 0) {
            return true;
        }
        c.b bVar = this.a.d().getValue().a;
        c.b bVar2 = this.a.e().getValue().a;
        return bVar == bVar2 && this.b == bVar2;
    }

    private c.b c(d dVar) {
        Map.Entry<d, a> d = this.a.d(dVar);
        return a(a(this.b, d != null ? d.getValue().a : null), this.g.isEmpty() ? null : this.g.get(this.g.size() - 1));
    }

    private void c() {
        this.g.remove(this.g.size() - 1);
    }

    private void c(c.b bVar) {
        this.g.add(bVar);
    }

    private static c.a d(c.b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return c.a.ON_DESTROY;
            case STARTED:
                return c.a.ON_STOP;
            case RESUMED:
                return c.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void d() {
        e eVar = this.c.get();
        if (eVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.b.compareTo(this.a.d().getValue().a) < 0) {
                b(eVar);
            }
            Map.Entry<d, a> e = this.a.e();
            if (!this.f && e != null && this.b.compareTo(e.getValue().a) > 0) {
                a(eVar);
            }
        }
        this.f = false;
    }

    private static c.a e(c.b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return c.a.ON_CREATE;
            case CREATED:
                return c.a.ON_START;
            case STARTED:
                return c.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    @Override // android.arch.lifecycle.c
    public c.b a() {
        return this.b;
    }

    public void a(c.a aVar) {
        b(b(aVar));
    }

    public void a(c.b bVar) {
        b(bVar);
    }

    @Override // android.arch.lifecycle.c
    public void a(d dVar) {
        e eVar;
        a aVar = new a(dVar, this.b == c.b.DESTROYED ? c.b.DESTROYED : c.b.INITIALIZED);
        if (this.a.a(dVar, aVar) == null && (eVar = this.c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            c.b c = c(dVar);
            this.d++;
            while (aVar.a.compareTo(c) < 0 && this.a.c(dVar)) {
                c(aVar.a);
                aVar.a(eVar, e(aVar.a));
                c();
                c = c(dVar);
            }
            if (!z) {
                d();
            }
            this.d--;
        }
    }

    @Override // android.arch.lifecycle.c
    public void b(d dVar) {
        this.a.b(dVar);
    }
}