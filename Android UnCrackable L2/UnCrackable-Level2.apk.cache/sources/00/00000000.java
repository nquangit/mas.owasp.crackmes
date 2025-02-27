package android.arch.a.a;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a extends c {
    private static volatile a a;
    private static final Executor d = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    };
    private static final Executor e = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    };
    private c c = new b();
    private c b = this.c;

    private a() {
    }

    public static a a() {
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
        }
        return a;
    }

    @Override // android.arch.a.a.c
    public void a(Runnable runnable) {
        this.b.a(runnable);
    }

    @Override // android.arch.a.a.c
    public void b(Runnable runnable) {
        this.b.b(runnable);
    }

    @Override // android.arch.a.a.c
    public boolean b() {
        return this.b.b();
    }
}