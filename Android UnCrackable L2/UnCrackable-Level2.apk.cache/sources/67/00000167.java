package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.app.AlertController;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

/* loaded from: classes.dex */
public class b extends k implements DialogInterface {
    final AlertController a;

    /* loaded from: classes.dex */
    public static class a {
        private final AlertController.a a;
        private final int b;

        public a(Context context) {
            this(context, b.a(context, 0));
        }

        public a(Context context, int i) {
            this.a = new AlertController.a(new ContextThemeWrapper(context, b.a(context, i)));
            this.b = i;
        }

        public Context a() {
            return this.a.a;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public a a(Drawable drawable) {
            this.a.d = drawable;
            return this;
        }

        public a a(View view) {
            this.a.g = view;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.a.w = listAdapter;
            this.a.x = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public b b() {
            b bVar = new b(this.a.a, this.b);
            this.a.a(bVar.a);
            bVar.setCancelable(this.a.r);
            if (this.a.r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.a.s);
            bVar.setOnDismissListener(this.a.t);
            if (this.a.u != null) {
                bVar.setOnKeyListener(this.a.u);
            }
            return bVar;
        }
    }

    protected b(Context context, int i) {
        super(context, a(context, i));
        this.a = new AlertController(getContext(), this, getWindow());
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0011a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.a.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.a.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.support.v7.app.k, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }
}