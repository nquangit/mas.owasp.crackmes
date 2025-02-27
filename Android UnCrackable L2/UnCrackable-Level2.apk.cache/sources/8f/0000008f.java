package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final t b;
    private static final t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        public g a;
        public boolean b;
        public c c;
        public g d;
        public boolean e;
        public c f;

        a() {
        }
    }

    static {
        b = Build.VERSION.SDK_INT >= 21 ? new s() : null;
        c = a();
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar == null) {
            a aVar2 = new a();
            sparseArray.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private static t a() {
        try {
            return (t) Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static t a(g gVar, g gVar2) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null) {
            Object w = gVar.w();
            if (w != null) {
                arrayList.add(w);
            }
            Object v = gVar.v();
            if (v != null) {
                arrayList.add(v);
            }
            Object z = gVar.z();
            if (z != null) {
                arrayList.add(z);
            }
        }
        if (gVar2 != null) {
            Object u = gVar2.u();
            if (u != null) {
                arrayList.add(u);
            }
            Object x = gVar2.x();
            if (x != null) {
                arrayList.add(x);
            }
            Object y = gVar2.y();
            if (y != null) {
                arrayList.add(y);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (b == null || !a(b, arrayList)) {
            if (c == null || !a(c, arrayList)) {
                if (b == null && c == null) {
                    return null;
                }
                throw new IllegalArgumentException("Invalid Transition types");
            }
            return c;
        }
        return b;
    }

    private static android.support.v4.f.a<String, String> a(int i, ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        android.support.v4.f.a<String, String> aVar = new android.support.v4.f.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            c cVar = arrayList.get(i4);
            if (cVar.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (cVar.r != null) {
                    int size = cVar.r.size();
                    if (booleanValue) {
                        arrayList3 = cVar.r;
                        arrayList4 = cVar.s;
                    } else {
                        ArrayList<String> arrayList5 = cVar.r;
                        arrayList3 = cVar.s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static Object a(t tVar, g gVar, g gVar2, boolean z) {
        if (gVar == null || gVar2 == null) {
            return null;
        }
        return tVar.c(tVar.b(z ? gVar2.z() : gVar.y()));
    }

    private static Object a(t tVar, g gVar, boolean z) {
        if (gVar == null) {
            return null;
        }
        return tVar.b(z ? gVar.x() : gVar.u());
    }

    private static Object a(final t tVar, ViewGroup viewGroup, View view, android.support.v4.f.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final View view2;
        final Rect rect;
        final g gVar = aVar2.a;
        final g gVar2 = aVar2.d;
        if (gVar != null) {
            gVar.k().setVisibility(0);
        }
        if (gVar == null || gVar2 == null) {
            return null;
        }
        final boolean z = aVar2.b;
        Object a2 = aVar.isEmpty() ? null : a(tVar, gVar, gVar2, z);
        android.support.v4.f.a<String, View> b2 = b(tVar, aVar, a2, aVar2);
        final android.support.v4.f.a<String, View> c2 = c(tVar, aVar, a2, aVar2);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (c2 != null) {
                c2.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, aVar.keySet());
            a(arrayList2, c2, aVar.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        b(gVar, gVar2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            tVar.a(obj3, view, arrayList);
            a(tVar, obj3, obj2, b2, aVar2.e, aVar2.f);
            Rect rect2 = new Rect();
            View b3 = b(c2, aVar2, obj, z);
            if (b3 != null) {
                tVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = b3;
        } else {
            view2 = null;
            rect = null;
        }
        w.a(viewGroup, new Runnable() { // from class: android.support.v4.app.r.3
            @Override // java.lang.Runnable
            public void run() {
                r.b(g.this, gVar2, z, (android.support.v4.f.a<String, View>) c2, false);
                if (view2 != null) {
                    tVar.a(view2, rect);
                }
            }
        });
        return obj3;
    }

    private static Object a(t tVar, Object obj, Object obj2, Object obj3, g gVar, boolean z) {
        return (obj == null || obj2 == null || gVar == null) ? true : z ? gVar.B() : gVar.A() ? tVar.a(obj2, obj, obj3) : tVar.b(obj2, obj, obj3);
    }

    private static String a(android.support.v4.f.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
        if (r10.l != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006b, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0087, code lost:
        if (r10.B == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0089, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.support.v4.app.c r15, android.support.v4.app.c.a r16, android.util.SparseArray<android.support.v4.app.r.a> r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.r.a(android.support.v4.app.c, android.support.v4.app.c$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void a(c cVar, SparseArray<a> sparseArray, boolean z) {
        int size = cVar.b.size();
        for (int i = 0; i < size; i++) {
            a(cVar, cVar.b.get(i), sparseArray, false, z);
        }
    }

    private static void a(m mVar, int i, a aVar, View view, android.support.v4.f.a<String, String> aVar2) {
        g gVar;
        g gVar2;
        t a2;
        Object obj;
        ViewGroup viewGroup = mVar.n.a() ? (ViewGroup) mVar.n.a(i) : null;
        if (viewGroup == null || (a2 = a((gVar2 = aVar.d), (gVar = aVar.a))) == null) {
            return;
        }
        boolean z = aVar.b;
        boolean z2 = aVar.e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, gVar, z);
        Object b2 = b(a2, gVar2, z2);
        Object a4 = a(a2, viewGroup, view, aVar2, aVar, arrayList2, arrayList, a3, b2);
        if (a3 == null && a4 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> b3 = b(a2, obj, gVar2, arrayList2, view);
        ArrayList<View> b4 = b(a2, a3, gVar, arrayList, view);
        b(b4, 4);
        Object a5 = a(a2, a3, obj, a4, gVar, z);
        if (a5 != null) {
            a(a2, obj, gVar2, b3);
            ArrayList<String> a6 = a2.a(arrayList);
            a2.a(a5, a3, b4, obj, b3, a4, arrayList);
            a2.a(viewGroup, a5);
            a2.a(viewGroup, arrayList2, arrayList, a6, aVar2);
            b(b4, 0);
            a2.a(a4, arrayList2, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(m mVar, ArrayList<c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (mVar.l < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            c cVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b(cVar, sparseArray, z);
            } else {
                a(cVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(mVar.m.g());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                android.support.v4.f.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                a aVar = (a) sparseArray.valueAt(i4);
                if (z) {
                    a(mVar, keyAt, aVar, view, a2);
                } else {
                    b(mVar, keyAt, aVar, view, a2);
                }
            }
        }
    }

    private static void a(final t tVar, ViewGroup viewGroup, final g gVar, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        w.a(viewGroup, new Runnable() { // from class: android.support.v4.app.r.2
            @Override // java.lang.Runnable
            public void run() {
                if (obj != null) {
                    tVar.c(obj, view);
                    arrayList2.addAll(r.b(tVar, obj, gVar, arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        tVar.b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static void a(t tVar, Object obj, g gVar, final ArrayList<View> arrayList) {
        if (gVar != null && obj != null && gVar.l && gVar.B && gVar.Q) {
            gVar.f(true);
            tVar.b(obj, gVar.k(), arrayList);
            w.a(gVar.I, new Runnable() { // from class: android.support.v4.app.r.1
                @Override // java.lang.Runnable
                public void run() {
                    r.b(arrayList, 4);
                }
            });
        }
    }

    private static void a(t tVar, Object obj, Object obj2, android.support.v4.f.a<String, View> aVar, boolean z, c cVar) {
        if (cVar.r == null || cVar.r.isEmpty()) {
            return;
        }
        View view = aVar.get((z ? cVar.s : cVar.r).get(0));
        tVar.a(obj, view);
        if (obj2 != null) {
            tVar.a(obj2, view);
        }
    }

    private static void a(android.support.v4.f.a<String, String> aVar, android.support.v4.f.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, android.support.v4.f.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (collection.contains(android.support.v4.g.p.e(c2))) {
                arrayList.add(c2);
            }
        }
    }

    private static boolean a(t tVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!tVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static android.support.v4.f.a<String, View> b(t tVar, android.support.v4.f.a<String, String> aVar, Object obj, a aVar2) {
        x S;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        g gVar = aVar2.d;
        android.support.v4.f.a<String, View> aVar3 = new android.support.v4.f.a<>();
        tVar.a((Map<String, View>) aVar3, gVar.k());
        c cVar = aVar2.f;
        if (aVar2.e) {
            S = gVar.R();
            arrayList = cVar.s;
        } else {
            S = gVar.S();
            arrayList = cVar.r;
        }
        aVar3.a((Collection<?>) arrayList);
        if (S != null) {
            S.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(android.support.v4.g.p.e(view))) {
                    aVar.put(android.support.v4.g.p.e(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a((Collection<?>) aVar3.keySet());
        }
        return aVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static View b(android.support.v4.f.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        c cVar = aVar2.c;
        if (obj == null || aVar == null || cVar.r == null || cVar.r.isEmpty()) {
            return null;
        }
        return aVar.get((z ? cVar.r : cVar.s).get(0));
    }

    private static Object b(t tVar, g gVar, boolean z) {
        if (gVar == null) {
            return null;
        }
        return tVar.b(z ? gVar.v() : gVar.w());
    }

    private static Object b(final t tVar, ViewGroup viewGroup, final View view, final android.support.v4.f.a<String, String> aVar, final a aVar2, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object a2;
        android.support.v4.f.a<String, String> aVar3;
        Object obj3;
        Rect rect;
        final g gVar = aVar2.a;
        final g gVar2 = aVar2.d;
        if (gVar == null || gVar2 == null) {
            return null;
        }
        final boolean z = aVar2.b;
        if (aVar.isEmpty()) {
            aVar3 = aVar;
            a2 = null;
        } else {
            a2 = a(tVar, gVar, gVar2, z);
            aVar3 = aVar;
        }
        android.support.v4.f.a<String, View> b2 = b(tVar, aVar3, a2, aVar2);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b2.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        b(gVar, gVar2, z, b2, true);
        if (obj3 != null) {
            rect = new Rect();
            tVar.a(obj3, view, arrayList);
            a(tVar, obj3, obj2, b2, aVar2.e, aVar2.f);
            if (obj != null) {
                tVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        w.a(viewGroup, new Runnable() { // from class: android.support.v4.app.r.4
            @Override // java.lang.Runnable
            public void run() {
                android.support.v4.f.a c2 = r.c(t.this, aVar, obj4, aVar2);
                if (c2 != null) {
                    arrayList2.addAll(c2.values());
                    arrayList2.add(view);
                }
                r.b(gVar, gVar2, z, (android.support.v4.f.a<String, View>) c2, false);
                if (obj4 != null) {
                    t.this.a(obj4, arrayList, arrayList2);
                    View b3 = r.b(c2, aVar2, obj, z);
                    if (b3 != null) {
                        t.this.a(b3, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<View> b(t tVar, Object obj, g gVar, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View k = gVar.k();
            if (k != null) {
                tVar.a(arrayList2, k);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            tVar.a(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    public static void b(c cVar, SparseArray<a> sparseArray, boolean z) {
        if (cVar.a.n.a()) {
            for (int size = cVar.b.size() - 1; size >= 0; size--) {
                a(cVar, cVar.b.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(g gVar, g gVar2, boolean z, android.support.v4.f.a<String, View> aVar, boolean z2) {
        x R = z ? gVar2.R() : gVar.R();
        if (R != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
            }
            if (z2) {
                R.a(arrayList2, arrayList, null);
            } else {
                R.b(arrayList2, arrayList, null);
            }
        }
    }

    private static void b(m mVar, int i, a aVar, View view, android.support.v4.f.a<String, String> aVar2) {
        g gVar;
        g gVar2;
        t a2;
        Object obj;
        ViewGroup viewGroup = mVar.n.a() ? (ViewGroup) mVar.n.a(i) : null;
        if (viewGroup == null || (a2 = a((gVar2 = aVar.d), (gVar = aVar.a))) == null) {
            return;
        }
        boolean z = aVar.b;
        boolean z2 = aVar.e;
        Object a3 = a(a2, gVar, z);
        Object b2 = b(a2, gVar2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object b3 = b(a2, viewGroup, view, aVar2, aVar, arrayList, arrayList2, a3, b2);
        if (a3 == null && b3 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> b4 = b(a2, obj, gVar2, arrayList, view);
        Object obj2 = (b4 == null || b4.isEmpty()) ? null : obj;
        a2.b(a3, view);
        Object a4 = a(a2, a3, obj2, b3, gVar, aVar.b);
        if (a4 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            a2.a(a4, a3, arrayList3, obj2, b4, b3, arrayList2);
            a(a2, viewGroup, gVar, view, arrayList2, a3, arrayList3, obj2, b4);
            a2.a((View) viewGroup, arrayList2, (Map<String, String>) aVar2);
            a2.a(viewGroup, a4);
            a2.a(viewGroup, arrayList2, (Map<String, String>) aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.support.v4.f.a<String, View> c(t tVar, android.support.v4.f.a<String, String> aVar, Object obj, a aVar2) {
        x R;
        ArrayList<String> arrayList;
        String a2;
        g gVar = aVar2.a;
        View k = gVar.k();
        if (aVar.isEmpty() || obj == null || k == null) {
            aVar.clear();
            return null;
        }
        android.support.v4.f.a<String, View> aVar3 = new android.support.v4.f.a<>();
        tVar.a((Map<String, View>) aVar3, k);
        c cVar = aVar2.c;
        if (aVar2.b) {
            R = gVar.S();
            arrayList = cVar.r;
        } else {
            R = gVar.R();
            arrayList = cVar.s;
        }
        if (arrayList != null) {
            aVar3.a((Collection<?>) arrayList);
            aVar3.a((Collection<?>) aVar.values());
        }
        if (R != null) {
            R.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(android.support.v4.g.p.e(view)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, android.support.v4.g.p.e(view));
                }
            }
        } else {
            a(aVar, aVar3);
        }
        return aVar3;
    }
}