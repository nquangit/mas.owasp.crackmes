package android.arch.lifecycle;

import java.util.HashMap;

/* loaded from: classes.dex */
public class p {
    private final HashMap<String, n> a = new HashMap<>();

    public final void a() {
        for (n nVar : this.a.values()) {
            nVar.a();
        }
        this.a.clear();
    }
}