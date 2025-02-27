package android.support.v4.g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* loaded from: classes.dex */
public final class g {
    static final c a;

    /* loaded from: classes.dex */
    static class a extends b {
        a() {
        }

        @Override // android.support.v4.g.g.b, android.support.v4.g.g.c
        public void a(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        @Override // android.support.v4.g.g.b, android.support.v4.g.g.c
        public void a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        @Override // android.support.v4.g.g.b, android.support.v4.g.g.c
        public void a(MenuItem menuItem, PorterDuff.Mode mode) {
            menuItem.setIconTintMode(mode);
        }

        @Override // android.support.v4.g.g.b, android.support.v4.g.g.c
        public void a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        @Override // android.support.v4.g.g.b, android.support.v4.g.g.c
        public void b(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        @Override // android.support.v4.g.g.b, android.support.v4.g.g.c
        public void b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }
    }

    /* loaded from: classes.dex */
    static class b implements c {
        b() {
        }

        @Override // android.support.v4.g.g.c
        public void a(MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.g.g.c
        public void a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        @Override // android.support.v4.g.g.c
        public void a(MenuItem menuItem, PorterDuff.Mode mode) {
        }

        @Override // android.support.v4.g.g.c
        public void a(MenuItem menuItem, CharSequence charSequence) {
        }

        @Override // android.support.v4.g.g.c
        public void b(MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.g.g.c
        public void b(MenuItem menuItem, CharSequence charSequence) {
        }
    }

    /* loaded from: classes.dex */
    interface c {
        void a(MenuItem menuItem, char c, int i);

        void a(MenuItem menuItem, ColorStateList colorStateList);

        void a(MenuItem menuItem, PorterDuff.Mode mode);

        void a(MenuItem menuItem, CharSequence charSequence);

        void b(MenuItem menuItem, char c, int i);

        void b(MenuItem menuItem, CharSequence charSequence);
    }

    static {
        a = Build.VERSION.SDK_INT >= 26 ? new a() : new b();
    }

    public static MenuItem a(MenuItem menuItem, android.support.v4.g.c cVar) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            return ((android.support.v4.c.a.b) menuItem).a(cVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void a(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            ((android.support.v4.c.a.b) menuItem).setNumericShortcut(c2, i);
        } else {
            a.b(menuItem, c2, i);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            ((android.support.v4.c.a.b) menuItem).setIconTintList(colorStateList);
        } else {
            a.a(menuItem, colorStateList);
        }
    }

    public static void a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            ((android.support.v4.c.a.b) menuItem).setIconTintMode(mode);
        } else {
            a.a(menuItem, mode);
        }
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            ((android.support.v4.c.a.b) menuItem).a(charSequence);
        } else {
            a.a(menuItem, charSequence);
        }
    }

    public static void b(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            ((android.support.v4.c.a.b) menuItem).setAlphabeticShortcut(c2, i);
        } else {
            a.a(menuItem, c2, i);
        }
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof android.support.v4.c.a.b) {
            ((android.support.v4.c.a.b) menuItem).b(charSequence);
        } else {
            a.b(menuItem, charSequence);
        }
    }
}