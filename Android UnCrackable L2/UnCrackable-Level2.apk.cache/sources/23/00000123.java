package android.support.v4.g;

import android.os.Build;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class w {
    private final Object a;

    private w(Object obj) {
        this.a = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new w(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(w wVar) {
        if (wVar == null) {
            return null;
        }
        return wVar.a;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public w a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new w(((WindowInsets) this.a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        w wVar = (w) obj;
        return this.a == null ? wVar.a == null : this.a.equals(wVar.a);
    }

    public int hashCode() {
        if (this.a == null) {
            return 0;
        }
        return this.a.hashCode();
    }
}