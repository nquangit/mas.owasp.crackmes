package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.g.c;
import android.support.v7.view.menu.k;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends k {

    /* loaded from: classes.dex */
    class a extends k.a implements ActionProvider.VisibilityListener {
        c.b c;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // android.support.v4.g.c
        public View a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        @Override // android.support.v4.g.c
        public void a(c.b bVar) {
            this.c = bVar;
            this.a.setVisibilityListener(bVar != null ? this : null);
        }

        @Override // android.support.v4.g.c
        public boolean b() {
            return this.a.overridesItemVisibility();
        }

        @Override // android.support.v4.g.c
        public boolean c() {
            return this.a.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.c != null) {
                this.c.a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, android.support.v4.c.a.b bVar) {
        super(context, bVar);
    }

    @Override // android.support.v7.view.menu.k
    k.a a(ActionProvider actionProvider) {
        return new a(this.a, actionProvider);
    }
}