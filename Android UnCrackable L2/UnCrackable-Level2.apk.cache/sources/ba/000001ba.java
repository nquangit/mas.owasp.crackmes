package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.v7.a.a;
import android.support.v7.app.b;
import android.support.v7.view.menu.o;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes.dex */
class i implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, o.a {
    f a;
    private h b;
    private android.support.v7.app.b c;
    private o.a d;

    public i(h hVar) {
        this.b = hVar;
    }

    public void a() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    public void a(IBinder iBinder) {
        h hVar = this.b;
        b.a aVar = new b.a(hVar.e());
        this.a = new f(aVar.a(), a.g.abc_list_menu_item_layout);
        this.a.a(this);
        this.b.a(this.a);
        aVar.a(this.a.a(), this);
        View o = hVar.o();
        if (o != null) {
            aVar.a(o);
        } else {
            aVar.a(hVar.n()).a(hVar.m());
        }
        aVar.a(this);
        this.c = aVar.b();
        this.c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    @Override // android.support.v7.view.menu.o.a
    public void a(h hVar, boolean z) {
        if (z || hVar == this.b) {
            a();
        }
        if (this.d != null) {
            this.d.a(hVar, z);
        }
    }

    @Override // android.support.v7.view.menu.o.a
    public boolean a(h hVar) {
        if (this.d != null) {
            return this.d.a(hVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a((j) this.a.a().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.a.a(this.b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.b.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.b.performShortcut(i, keyEvent, 0);
    }
}