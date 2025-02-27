package android.support.v4.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class c {
    private HandlerThread b;
    private Handler c;
    private final int f;
    private final int g;
    private final String h;
    private final Object a = new Object();
    private Handler.Callback e = new Handler.Callback() { // from class: android.support.v4.e.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    c.this.a();
                    return true;
                case 1:
                    c.this.b((Runnable) message.obj);
                    return true;
                default:
                    return true;
            }
        }
    };
    private int d = 0;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this.a) {
            if (this.c.hasMessages(1)) {
                return;
            }
            this.b.quit();
            this.b = null;
            this.c = null;
        }
    }

    private void a(Runnable runnable) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new HandlerThread(this.h, this.g);
                this.b.start();
                this.c = new Handler(this.b.getLooper(), this.e);
                this.d++;
            }
            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, runnable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Runnable runnable) {
        runnable.run();
        synchronized (this.a) {
            this.c.removeMessages(0);
            this.c.sendMessageDelayed(this.c.obtainMessage(0), this.f);
        }
    }

    public <T> T a(final Callable<T> callable, int i) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        a(new Runnable() { // from class: android.support.v4.e.c.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (atomicBoolean.get()) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(i);
                do {
                    try {
                        nanos = newCondition.awaitNanos(nanos);
                    } catch (InterruptedException unused) {
                    }
                    if (!atomicBoolean.get()) {
                        return (T) atomicReference.get();
                    }
                } while (nanos > 0);
                throw new InterruptedException("timeout");
            }
            return (T) atomicReference.get();
        } finally {
            reentrantLock.unlock();
        }
    }

    public <T> void a(final Callable<T> callable, final a<T> aVar) {
        final Handler handler = new Handler();
        a(new Runnable() { // from class: android.support.v4.e.c.2
            @Override // java.lang.Runnable
            public void run() {
                final Object obj;
                try {
                    obj = callable.call();
                } catch (Exception unused) {
                    obj = null;
                }
                handler.post(new Runnable() { // from class: android.support.v4.e.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(obj);
                    }
                });
            }
        });
    }
}