package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class j {
    private final k<?> a;

    private j(k<?> kVar) {
        this.a = kVar;
    }

    public static j a(k<?> kVar) {
        return new j(kVar);
    }

    public g a(String str) {
        return this.a.d.b(str);
    }

    public l a() {
        return this.a.i();
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.d.onCreateView(view, str, context, attributeSet);
    }

    public void a(Configuration configuration) {
        this.a.d.a(configuration);
    }

    public void a(Parcelable parcelable, n nVar) {
        this.a.d.a(parcelable, nVar);
    }

    public void a(g gVar) {
        this.a.d.a(this.a, this.a, gVar);
    }

    public void a(boolean z) {
        this.a.d.a(z);
    }

    public boolean a(Menu menu) {
        return this.a.d.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.d.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.d.a(menuItem);
    }

    public void b() {
        this.a.d.k();
    }

    public void b(Menu menu) {
        this.a.d.b(menu);
    }

    public void b(boolean z) {
        this.a.d.b(z);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.d.b(menuItem);
    }

    public Parcelable c() {
        return this.a.d.j();
    }

    public n d() {
        return this.a.d.h();
    }

    public void e() {
        this.a.d.l();
    }

    public void f() {
        this.a.d.m();
    }

    public void g() {
        this.a.d.n();
    }

    public void h() {
        this.a.d.o();
    }

    public void i() {
        this.a.d.p();
    }

    public void j() {
        this.a.d.q();
    }

    public void k() {
        this.a.d.r();
    }

    public void l() {
        this.a.d.t();
    }

    public void m() {
        this.a.d.u();
    }

    public boolean n() {
        return this.a.d.e();
    }
}