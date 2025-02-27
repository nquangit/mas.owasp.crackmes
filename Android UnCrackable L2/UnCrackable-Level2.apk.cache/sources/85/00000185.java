package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.view.b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class k extends Dialog implements d {
    private e a;

    public k(Context context, int i) {
        super(context, a(context, i));
        a().a((Bundle) null);
        a().i();
    }

    private static int a(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(a.C0011a.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    public e a() {
        if (this.a == null) {
            this.a = e.a(this, this);
        }
        return this.a;
    }

    @Override // android.support.v7.app.d
    public android.support.v7.view.b a(b.a aVar) {
        return null;
    }

    @Override // android.support.v7.app.d
    public void a(android.support.v7.view.b bVar) {
    }

    public boolean a(int i) {
        return a().c(i);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    @Override // android.support.v7.app.d
    public void b(android.support.v7.view.b bVar) {
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) a().a(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().h();
        super.onCreate(bundle);
        a().a(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().d();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().b(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }
}