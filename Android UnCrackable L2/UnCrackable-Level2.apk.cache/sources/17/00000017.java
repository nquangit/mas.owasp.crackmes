package android.arch.lifecycle;

import android.arch.lifecycle.a;
import android.arch.lifecycle.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    private final Object a;
    private final a.C0001a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = a.a.b(this.a.getClass());
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, c.a aVar) {
        this.b.a(eVar, aVar, this.a);
    }
}