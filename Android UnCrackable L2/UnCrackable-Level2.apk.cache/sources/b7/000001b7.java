package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class h implements android.support.v4.c.a.a {
    private static final int[] d = {1, 4, 5, 3, 2, 0};
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private a i;
    private ContextMenu.ContextMenuInfo q;
    private j y;
    private boolean z;
    private int p = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<j> w = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<o>> x = new CopyOnWriteArrayList<>();
    private ArrayList<j> j = new ArrayList<>();
    private ArrayList<j> k = new ArrayList<>();
    private boolean l = true;
    private ArrayList<j> m = new ArrayList<>();
    private ArrayList<j> n = new ArrayList<>();
    private boolean o = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(h hVar);

        boolean a(h hVar, MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(j jVar);
    }

    public h(Context context) {
        this.e = context;
        this.f = context.getResources();
        e(true);
    }

    private static int a(ArrayList<j> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private j a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new j(this, i, i2, i3, i4, charSequence, i5);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d2 = d();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (i > 0) {
                this.a = d2.getText(i);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (i2 > 0) {
                this.b = android.support.v4.a.a.a(e(), i2);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        b(false);
    }

    private void a(int i, boolean z) {
        if (i < 0 || i >= this.j.size()) {
            return;
        }
        this.j.remove(i);
        if (z) {
            b(true);
        }
    }

    private boolean a(u uVar, o oVar) {
        if (this.x.isEmpty()) {
            return false;
        }
        boolean a2 = oVar != null ? oVar.a(uVar) : false;
        Iterator<WeakReference<o>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<o> next = it.next();
            o oVar2 = next.get();
            if (oVar2 == null) {
                this.x.remove(next);
            } else if (!a2) {
                a2 = oVar2.a(uVar);
            }
        }
        return a2;
    }

    private void d(boolean z) {
        if (this.x.isEmpty()) {
            return;
        }
        g();
        Iterator<WeakReference<o>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<o> next = it.next();
            o oVar = next.get();
            if (oVar == null) {
                this.x.remove(next);
            } else {
                oVar.b(z);
            }
        }
        h();
    }

    private void e(boolean z) {
        boolean z2 = true;
        this.h = (z && this.f.getConfiguration().keyboard != 1 && this.f.getBoolean(a.b.abc_config_showMenuShortcutsWhenKeyboardPresent)) ? false : false;
    }

    private static int f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (i & 65535) | (d[i2] << 16);
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.j.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public h a(int i) {
        this.p = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    j a(int i, KeyEvent keyEvent) {
        ArrayList<j> arrayList = this.w;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean b2 = b();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = arrayList.get(i2);
            char alphabeticShortcut = b2 ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
            if ((alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) || (b2 && alphabeticShortcut == '\b' && i == 67))) {
                return jVar;
            }
        }
        return null;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int f = f(i3);
        j a2 = a(i, i2, i3, f, charSequence, this.p);
        if (this.q != null) {
            a2.a(this.q);
        }
        this.j.add(a(this.j, f), a2);
        b(true);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        return "android:menu:actionviewstates";
    }

    public void a(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((u) item.getSubMenu()).a(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        this.l = true;
        b(true);
    }

    public void a(o oVar) {
        a(oVar, this.e);
    }

    public void a(o oVar, Context context) {
        this.x.add(new WeakReference<>(oVar));
        oVar.a(context, this);
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        g();
        for (int i = 0; i < size; i++) {
            j jVar = this.j.get(i);
            if (jVar.getGroupId() == groupId && jVar.g() && jVar.isCheckable()) {
                jVar.b(jVar == menuItem);
            }
        }
        h();
    }

    void a(List<j> list, int i, KeyEvent keyEvent) {
        boolean b2 = b();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                j jVar = this.j.get(i2);
                if (jVar.hasSubMenu()) {
                    ((h) jVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = b2 ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
                if (((modifiers & 69647) == ((b2 ? jVar.getAlphabeticModifiers() : jVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b2 && alphabeticShortcut == '\b' && i == 67)) && jVar.isEnabled())) {
                    list.add(jVar);
                }
            }
        }
    }

    public final void a(boolean z) {
        if (this.v) {
            return;
        }
        this.v = true;
        Iterator<WeakReference<o>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<o> next = it.next();
            o oVar = next.get();
            if (oVar == null) {
                this.x.remove(next);
            } else {
                oVar.a(this, z);
            }
        }
        this.v = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(h hVar, MenuItem menuItem) {
        return this.i != null && this.i.a(hVar, menuItem);
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (o) null, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r1 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
        a(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        if ((r9 & 1) == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r1 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.MenuItem r7, android.support.v7.view.menu.o r8, int r9) {
        /*
            r6 = this;
            android.support.v7.view.menu.j r7 = (android.support.v7.view.menu.j) r7
            r0 = 0
            if (r7 == 0) goto L6c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Lc
            goto L6c
        Lc:
            boolean r1 = r7.b()
            android.support.v4.g.c r2 = r7.a()
            r3 = 1
            if (r2 == 0) goto L1f
            boolean r4 = r2.e()
            if (r4 == 0) goto L1f
            r4 = 1
            goto L20
        L1f:
            r4 = 0
        L20:
            boolean r5 = r7.n()
            if (r5 == 0) goto L31
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L6b
        L2d:
            r6.a(r3)
            goto L6b
        L31:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L3f
            if (r4 == 0) goto L3a
            goto L3f
        L3a:
            r7 = r9 & 1
            if (r7 != 0) goto L6b
            goto L2d
        L3f:
            r9 = r9 & 4
            if (r9 != 0) goto L46
            r6.a(r0)
        L46:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L58
            android.support.v7.view.menu.u r9 = new android.support.v7.view.menu.u
            android.content.Context r0 = r6.e()
            r9.<init>(r0, r6, r7)
            r7.a(r9)
        L58:
            android.view.SubMenu r7 = r7.getSubMenu()
            android.support.v7.view.menu.u r7 = (android.support.v7.view.menu.u) r7
            if (r4 == 0) goto L63
            r2.a(r7)
        L63:
            boolean r7 = r6.a(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L6b
            goto L2d
        L6b:
            return r1
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.h.a(android.view.MenuItem, android.support.v7.view.menu.o, int):boolean");
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.f.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        j jVar = (j) a(i, i2, i3, charSequence);
        u uVar = new u(this.e, this, jVar);
        jVar.a(uVar);
        return uVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void b(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(a());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((u) item.getSubMenu()).b(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (findItem = findItem(i2)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.o = true;
        b(true);
    }

    public void b(o oVar) {
        Iterator<WeakReference<o>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<o> next = it.next();
            o oVar2 = next.get();
            if (oVar2 == null || oVar2 == oVar) {
                this.x.remove(next);
            }
        }
    }

    public void b(boolean z) {
        if (this.r) {
            this.s = true;
            if (z) {
                this.t = true;
                return;
            }
            return;
        }
        if (z) {
            this.l = true;
            this.o = true;
        }
        d(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.g;
    }

    public int c(int i) {
        return a(i, 0);
    }

    public void c(boolean z) {
        this.z = z;
    }

    public boolean c() {
        return this.h;
    }

    public boolean c(j jVar) {
        boolean z = false;
        if (this.x.isEmpty()) {
            return false;
        }
        g();
        Iterator<WeakReference<o>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<o> next = it.next();
            o oVar = next.get();
            if (oVar == null) {
                this.x.remove(next);
            } else {
                z = oVar.a(this, jVar);
                if (z) {
                    break;
                }
            }
        }
        h();
        if (z) {
            this.y = jVar;
        }
        return z;
    }

    @Override // android.view.Menu
    public void clear() {
        if (this.y != null) {
            d(this.y);
        }
        this.j.clear();
        b(true);
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        b(false);
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    Resources d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h d(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    public boolean d(j jVar) {
        boolean z = false;
        if (!this.x.isEmpty() && this.y == jVar) {
            g();
            Iterator<WeakReference<o>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference<o> next = it.next();
                o oVar = next.get();
                if (oVar == null) {
                    this.x.remove(next);
                } else {
                    z = oVar.b(this, jVar);
                    if (z) {
                        break;
                    }
                }
            }
            h();
            if (z) {
                this.y = null;
            }
        }
        return z;
    }

    public Context e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h e(int i) {
        a(0, null, i, null, null);
        return this;
    }

    public void f() {
        if (this.i != null) {
            this.i.a(this);
        }
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.j.get(i2);
            if (jVar.getItemId() == i) {
                return jVar;
            }
            if (jVar.hasSubMenu() && (findItem = jVar.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public void g() {
        if (this.r) {
            return;
        }
        this.r = true;
        this.s = false;
        this.t = false;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.j.get(i);
    }

    public void h() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(this.t);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<j> i() {
        if (this.l) {
            this.k.clear();
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                j jVar = this.j.get(i);
                if (jVar.isVisible()) {
                    this.k.add(jVar);
                }
            }
            this.l = false;
            this.o = true;
            return this.k;
        }
        return this.k;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void j() {
        ArrayList<j> i = i();
        if (this.o) {
            Iterator<WeakReference<o>> it = this.x.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<o> next = it.next();
                o oVar = next.get();
                if (oVar == null) {
                    this.x.remove(next);
                } else {
                    z |= oVar.b();
                }
            }
            if (z) {
                this.m.clear();
                this.n.clear();
                int size = i.size();
                for (int i2 = 0; i2 < size; i2++) {
                    j jVar = i.get(i2);
                    (jVar.j() ? this.m : this.n).add(jVar);
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(i());
            }
            this.o = false;
        }
    }

    public ArrayList<j> k() {
        j();
        return this.m;
    }

    public ArrayList<j> l() {
        j();
        return this.n;
    }

    public CharSequence m() {
        return this.a;
    }

    public Drawable n() {
        return this.b;
    }

    public View o() {
        return this.c;
    }

    public h p() {
        return this;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        j a2 = a(i, keyEvent);
        boolean a3 = a2 != null ? a(a2, i2) : false;
        if ((i2 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.u;
    }

    public j r() {
        return this.y;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int c = c(i);
        if (c >= 0) {
            int size = this.j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.j.get(c).getGroupId() != i) {
                    break;
                }
                a(c, false);
                i2 = i3;
            }
            b(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        a(b(i), true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.j.get(i2);
            if (jVar.getGroupId() == i) {
                jVar.a(z2);
                jVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.j.get(i2);
            if (jVar.getGroupId() == i) {
                jVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.j.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.j.get(i2);
            if (jVar.getGroupId() == i && jVar.c(z)) {
                z2 = true;
            }
        }
        if (z2) {
            b(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.g = z;
        b(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.j.size();
    }
}