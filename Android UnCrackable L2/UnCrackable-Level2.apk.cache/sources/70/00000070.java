package android.support.v4.app;

import android.arch.lifecycle.c;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class h extends f {
    u e;
    boolean f;
    boolean g;
    boolean j;
    int k;
    android.support.v4.f.l<String> l;
    private android.arch.lifecycle.p m;
    final Handler c = new Handler() { // from class: android.support.v4.app.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (h.this.h) {
                        h.this.a(false);
                        return;
                    }
                    return;
                case 2:
                    h.this.b();
                    h.this.d.n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    final j d = j.a(new a());
    boolean h = true;
    boolean i = true;

    /* loaded from: classes.dex */
    class a extends k<h> {
        public a() {
            super(h.this);
        }

        @Override // android.support.v4.app.k, android.support.v4.app.i
        public View a(int i) {
            return h.this.findViewById(i);
        }

        @Override // android.support.v4.app.k
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            h.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // android.support.v4.app.k, android.support.v4.app.i
        public boolean a() {
            Window window = h.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // android.support.v4.app.k
        public boolean a(g gVar) {
            return !h.this.isFinishing();
        }

        @Override // android.support.v4.app.k
        public LayoutInflater b() {
            return h.this.getLayoutInflater().cloneInContext(h.this);
        }

        @Override // android.support.v4.app.k
        public void b(g gVar) {
            h.this.a(gVar);
        }

        @Override // android.support.v4.app.k
        public void c() {
            h.this.d();
        }

        @Override // android.support.v4.app.k
        public boolean d() {
            return h.this.getWindow() != null;
        }

        @Override // android.support.v4.app.k
        public int e() {
            Window window = h.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {
        Object a;
        android.arch.lifecycle.p b;
        n c;

        b() {
        }
    }

    private static boolean a(l lVar, c.b bVar) {
        boolean z = false;
        for (g gVar : lVar.b()) {
            if (gVar != null) {
                if (gVar.a().a().a(c.b.STARTED)) {
                    gVar.U.a(bVar);
                    z = true;
                }
                l j = gVar.j();
                if (j != null) {
                    z |= a(j, bVar);
                }
            }
        }
        return z;
    }

    private void g() {
        do {
        } while (a(f(), c.b.CREATED));
    }

    @Override // android.support.v4.app.z, android.arch.lifecycle.e
    public android.arch.lifecycle.c a() {
        return super.a();
    }

    @Override // android.support.v4.app.e
    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.d.a(view, str, context, attributeSet);
    }

    public void a(g gVar) {
    }

    void a(boolean z) {
        if (this.i) {
            return;
        }
        this.i = true;
        this.j = z;
        this.c.removeMessages(1);
        e();
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    protected void b() {
        this.d.h();
    }

    public Object c() {
        return null;
    }

    @Deprecated
    public void d() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f);
        printWriter.print("mResumed=");
        printWriter.print(this.g);
        printWriter.print(" mStopped=");
        printWriter.print(this.h);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.i);
        if (this.e != null) {
            this.e.a(str2, fileDescriptor, printWriter, strArr);
        }
        this.d.a().a(str, fileDescriptor, printWriter, strArr);
    }

    void e() {
        this.d.k();
    }

    public l f() {
        return this.d.a();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.d.b();
        int i3 = i >> 16;
        if (i3 == 0) {
            a.InterfaceC0004a a2 = android.support.v4.app.a.a();
            if (a2 == null || !a2.a(this, i, i2, intent)) {
                super.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        int i4 = i3 - 1;
        String a3 = this.l.a(i4);
        this.l.c(i4);
        if (a3 == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        g a4 = this.d.a(a3);
        if (a4 != null) {
            a4.a(i & 65535, i2, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a3);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        l a2 = this.d.a();
        boolean c = a2.c();
        if (!c || Build.VERSION.SDK_INT > 25) {
            if (c || !a2.a()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d.b();
        this.d.a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.z, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.d.a((g) null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.m = bVar.b;
        }
        if (bundle != null) {
            this.d.a(bundle.getParcelable("android:support:fragments"), bVar != null ? bVar.c : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.l = new android.support.v4.f.l<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.l.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.l == null) {
            this.l = new android.support.v4.f.l<>();
            this.k = 0;
        }
        this.d.e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.d.a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.support.v4.app.e, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.support.v4.app.e, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a(false);
        if (this.m != null && !this.j) {
            this.m.a();
        }
        this.d.l();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.d.m();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            if (i != 6) {
                return false;
            }
            return this.d.b(menuItem);
        }
        return this.d.a(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.d.a(z);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.d.b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.d.b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.g = false;
        if (this.c.hasMessages(2)) {
            this.c.removeMessages(2);
            b();
        }
        this.d.i();
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.d.b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.c.removeMessages(2);
        b();
        this.d.n();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : a(view, menu) | this.d.a(menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.d.b();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String a2 = this.l.a(i3);
            this.l.c(i3);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            g a3 = this.d.a(a2);
            if (a3 != null) {
                a3.a(i & 65535, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.c.sendEmptyMessage(2);
        this.g = true;
        this.d.n();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        if (this.h) {
            a(true);
        }
        Object c = c();
        n d = this.d.d();
        if (d == null && this.m == null && c == null) {
            return null;
        }
        b bVar = new b();
        bVar.a = c;
        bVar.b = this.m;
        bVar.c = d;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.z, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        g();
        Parcelable c = this.d.c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.l.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.k);
            int[] iArr = new int[this.l.b()];
            String[] strArr = new String[this.l.b()];
            for (int i = 0; i < this.l.b(); i++) {
                iArr[i] = this.l.d(i);
                strArr[i] = this.l.e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.h = false;
        this.i = false;
        this.c.removeMessages(1);
        if (!this.f) {
            this.f = true;
            this.d.f();
        }
        this.d.b();
        this.d.n();
        this.d.g();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.d.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.h = true;
        g();
        this.c.sendEmptyMessage(1);
        this.d.j();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.b && i != -1) {
            a(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.support.v4.app.f, android.app.Activity
    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.support.v4.app.e, android.app.Activity
    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.support.v4.app.f, android.app.Activity
    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}