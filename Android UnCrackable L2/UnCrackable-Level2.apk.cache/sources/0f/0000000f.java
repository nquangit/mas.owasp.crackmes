package android.arch.lifecycle;

import android.arch.lifecycle.c;

/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {
    private final b[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(b[] bVarArr) {
        this.a = bVarArr;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, c.a aVar) {
        i iVar = new i();
        for (b bVar : this.a) {
            bVar.a(eVar, aVar, false, iVar);
        }
        for (b bVar2 : this.a) {
            bVar2.a(eVar, aVar, true, iVar);
        }
    }
}