package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.i;
import android.support.v7.app.j;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends i {

    /* loaded from: classes.dex */
    class a extends i.a {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            j.d a = g.this.a(0, true);
            if (a != null && a.j != null) {
                menu = a.j;
            }
            super.onProvideKeyboardShortcuts(list, menu, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    @Override // android.support.v7.app.i, android.support.v7.app.h, android.support.v7.app.f
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }
}