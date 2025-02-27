package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.c;
import android.os.Bundle;

/* loaded from: classes.dex */
public class z extends Activity implements android.arch.lifecycle.e {
    private android.support.v4.f.k<Class<? extends Object>, Object> a = new android.support.v4.f.k<>();
    private android.arch.lifecycle.f b = new android.arch.lifecycle.f(this);

    public android.arch.lifecycle.c a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        android.arch.lifecycle.m.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.b.a(c.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}