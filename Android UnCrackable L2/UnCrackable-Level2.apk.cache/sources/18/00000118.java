package android.support.v4.g;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class r {
    static final c a;

    /* loaded from: classes.dex */
    static class a extends c {
        a() {
        }
    }

    /* loaded from: classes.dex */
    static class b extends a {
        b() {
        }

        @Override // android.support.v4.g.r.c
        public void a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
            }
        }

        @Override // android.support.v4.g.r.c
        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
            }
        }

        @Override // android.support.v4.g.r.c
        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
            }
        }

        @Override // android.support.v4.g.r.c
        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        }

        @Override // android.support.v4.g.r.c
        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        }

        @Override // android.support.v4.g.r.c
        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
                return false;
            }
        }

        @Override // android.support.v4.g.r.c
        public void b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
            }
        }
    }

    /* loaded from: classes.dex */
    static class c {
        c() {
        }

        public void a(ViewParent viewParent, View view) {
            if (viewParent instanceof k) {
                ((k) viewParent).onStopNestedScroll(view);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof k) {
                ((k) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof k) {
                ((k) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof k) {
                return ((k) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof k) {
                return ((k) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof k) {
                return ((k) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof k) {
                ((k) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    static {
        a = Build.VERSION.SDK_INT >= 21 ? new b() : Build.VERSION.SDK_INT >= 19 ? new a() : new c();
    }

    public static void a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof l) {
            ((l) viewParent).a(view, i);
        } else if (i == 0) {
            a.a(viewParent, view);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof l) {
            ((l) viewParent).a(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            a.a(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof l) {
            ((l) viewParent).a(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            a.a(viewParent, view, i, i2, iArr);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        return a.a(viewParent, view, f, f2);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return a.a(viewParent, view, f, f2, z);
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof l) {
            return ((l) viewParent).a(view, view2, i, i2);
        }
        if (i2 == 0) {
            return a.a(viewParent, view, view2, i);
        }
        return false;
    }

    public static void b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof l) {
            ((l) viewParent).b(view, view2, i, i2);
        } else if (i2 == 0) {
            a.b(viewParent, view, view2, i);
        }
    }
}