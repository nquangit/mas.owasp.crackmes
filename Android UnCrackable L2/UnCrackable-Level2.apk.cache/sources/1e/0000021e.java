package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.ListMenuItemView;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class am extends ak implements al {
    private static Method a;
    private al b;

    /* loaded from: classes.dex */
    public static class a extends ag {
        final int a;
        final int b;
        private al c;
        private MenuItem d;

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.a = 22;
                this.b = 21;
                return;
            }
            this.a = 21;
            this.b = 22;
        }

        @Override // android.support.v7.widget.ag
        public /* bridge */ /* synthetic */ int a(int i, int i2, int i3, int i4, int i5) {
            return super.a(i, i2, i3, i4, i5);
        }

        @Override // android.support.v7.widget.ag
        public /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i) {
            return super.a(motionEvent, i);
        }

        @Override // android.support.v7.widget.ag, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // android.support.v7.widget.ag, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // android.support.v7.widget.ag, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // android.support.v7.widget.ag, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // android.support.v7.widget.ag, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            int pointToPosition;
            int i2;
            if (this.c != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                }
                android.support.v7.view.menu.g gVar = (android.support.v7.view.menu.g) adapter;
                android.support.v7.view.menu.j jVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < gVar.getCount()) {
                    jVar = gVar.getItem(i2);
                }
                MenuItem menuItem = this.d;
                if (menuItem != jVar) {
                    android.support.v7.view.menu.h a = gVar.a();
                    if (menuItem != null) {
                        this.c.a(a, menuItem);
                    }
                    this.d = jVar;
                    if (jVar != null) {
                        this.c.b(a, jVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.a) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.b) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((android.support.v7.view.menu.g) getAdapter()).a().a(false);
                return true;
            }
        }

        @Override // android.support.v7.widget.ag, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(al alVar) {
            this.c = alVar;
        }

        @Override // android.support.v7.widget.ag, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public am(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.v7.widget.ak
    ag a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    @Override // android.support.v7.widget.al
    public void a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
        if (this.b != null) {
            this.b.a(hVar, menuItem);
        }
    }

    public void a(al alVar) {
        this.b = alVar;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition) obj);
        }
    }

    @Override // android.support.v7.widget.al
    public void b(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
        if (this.b != null) {
            this.b.b(hVar, menuItem);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition) obj);
        }
    }

    public void c(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.g, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }
}