package android.support.v4.e;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.a.a.b;
import android.support.v4.b.h;
import android.support.v4.e.c;
import android.support.v4.f.g;
import android.support.v4.f.j;
import android.support.v4.f.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class b {
    private static final g<String, Typeface> a = new g<>(16);
    private static final android.support.v4.e.c b = new android.support.v4.e.c("fonts", 10, 10000);
    private static final Object c = new Object();
    private static final k<String, ArrayList<c.a<c>>> d = new k<>();
    private static final Comparator<byte[]> e = new Comparator<byte[]>() { // from class: android.support.v4.e.b.4
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length == bArr2.length) {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            i = bArr.length;
            i2 = bArr2.length;
            return i - i2;
        }
    };

    /* loaded from: classes.dex */
    public static class a {
        private final int a;
        private final C0006b[] b;

        public a(int i, C0006b[] c0006bArr) {
            this.a = i;
            this.b = c0006bArr;
        }

        public int a() {
            return this.a;
        }

        public C0006b[] b() {
            return this.b;
        }
    }

    /* renamed from: android.support.v4.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public C0006b(Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) j.a(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public Uri a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        final Typeface a;
        final int b;

        c(Typeface typeface, int i) {
            this.a = typeface;
            this.b = i;
        }
    }

    public static ProviderInfo a(PackageManager packageManager, android.support.v4.e.a aVar, Resources resources) {
        String a2 = aVar.a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + a2);
        } else if (!resolveContentProvider.packageName.equals(aVar.b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + a2 + ", but package was not " + aVar.b());
        } else {
            List<byte[]> a3 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a3, e);
            List<List<byte[]>> a4 = a(aVar, resources);
            for (int i = 0; i < a4.size(); i++) {
                ArrayList arrayList = new ArrayList(a4.get(i));
                Collections.sort(arrayList, e);
                if (a(a3, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        }
    }

    public static Typeface a(final Context context, final android.support.v4.e.a aVar, final b.a aVar2, final Handler handler, boolean z, int i, final int i2) {
        final String str = aVar.f() + "-" + i2;
        Typeface a2 = a.a((g<String, Typeface>) str);
        if (a2 != null) {
            if (aVar2 != null) {
                aVar2.a(a2);
            }
            return a2;
        } else if (z && i == -1) {
            c b2 = b(context, aVar, i2);
            if (aVar2 != null) {
                if (b2.b == 0) {
                    aVar2.a(b2.a, handler);
                } else {
                    aVar2.a(b2.b, handler);
                }
            }
            return b2.a;
        } else {
            Callable<c> callable = new Callable<c>() { // from class: android.support.v4.e.b.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public c call() {
                    c b3 = b.b(context, aVar, i2);
                    if (b3.a != null) {
                        b.a.a(str, b3.a);
                    }
                    return b3;
                }
            };
            if (z) {
                try {
                    return ((c) b.a(callable, i)).a;
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            c.a<c> aVar3 = aVar2 == null ? null : new c.a<c>() { // from class: android.support.v4.e.b.2
                @Override // android.support.v4.e.c.a
                public void a(c cVar) {
                    if (cVar == null) {
                        b.a.this.a(1, handler);
                    } else if (cVar.b == 0) {
                        b.a.this.a(cVar.a, handler);
                    } else {
                        b.a.this.a(cVar.b, handler);
                    }
                }
            };
            synchronized (c) {
                if (d.containsKey(str)) {
                    if (aVar3 != null) {
                        d.get(str).add(aVar3);
                    }
                    return null;
                }
                if (aVar3 != null) {
                    ArrayList<c.a<c>> arrayList = new ArrayList<>();
                    arrayList.add(aVar3);
                    d.put(str, arrayList);
                }
                b.a(callable, new c.a<c>() { // from class: android.support.v4.e.b.3
                    @Override // android.support.v4.e.c.a
                    public void a(c cVar) {
                        synchronized (b.c) {
                            ArrayList arrayList2 = (ArrayList) b.d.get(str);
                            if (arrayList2 == null) {
                                return;
                            }
                            b.d.remove(str);
                            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                                ((c.a) arrayList2.get(i3)).a(cVar);
                            }
                        }
                    }
                });
                return null;
            }
        }
    }

    public static a a(Context context, CancellationSignal cancellationSignal, android.support.v4.e.a aVar) {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        return a2 == null ? new a(1, null) : new a(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    private static List<List<byte[]>> a(android.support.v4.e.a aVar, Resources resources) {
        return aVar.d() != null ? aVar.d() : android.support.v4.a.a.a.a(resources, aVar.e());
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static Map<Uri, ByteBuffer> a(Context context, C0006b[] c0006bArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0006b c0006b : c0006bArr) {
            if (c0006b.e() == 0) {
                Uri a2 = c0006b.a();
                if (!hashMap.containsKey(a2)) {
                    hashMap.put(a2, h.a(context, cancellationSignal, a2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static C0006b[] a(Context context, android.support.v4.e.a aVar, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            cursor = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null, cancellationSignal) : context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    arrayList2.add(new C0006b(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (C0006b[]) arrayList.toArray(new C0006b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c b(Context context, android.support.v4.e.a aVar, int i) {
        try {
            a a2 = a(context, (CancellationSignal) null, aVar);
            if (a2.a() != 0) {
                return new c(null, a2.a() == 1 ? -2 : -3);
            }
            Typeface a3 = android.support.v4.b.c.a(context, null, a2.b(), i);
            return new c(a3, a3 != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c(null, -1);
        }
    }
}