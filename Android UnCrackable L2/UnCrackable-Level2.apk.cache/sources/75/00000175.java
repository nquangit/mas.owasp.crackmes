package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.h;
import android.view.ActionMode;
import android.view.Window;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends h {
    private final UiModeManager t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends h.a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.app.h.a, android.support.v7.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // android.support.v7.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (i.this.o() && i == 0) ? a(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, Window window, d dVar) {
        super(context, window, dVar);
        this.t = (UiModeManager) context.getSystemService("uimode");
    }

    @Override // android.support.v7.app.h, android.support.v7.app.f
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.h
    public int d(int i) {
        if (i == 0 && this.t.getNightMode() == 0) {
            return -1;
        }
        return super.d(i);
    }
}