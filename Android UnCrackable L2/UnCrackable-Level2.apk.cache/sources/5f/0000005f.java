package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class aa implements Iterable<Intent> {
    private static final c a;
    private final ArrayList<Intent> b = new ArrayList<>();
    private final Context c;

    /* loaded from: classes.dex */
    public interface a {
        Intent a_();
    }

    /* loaded from: classes.dex */
    static class b extends c {
        b() {
        }
    }

    /* loaded from: classes.dex */
    static class c {
        c() {
        }
    }

    static {
        a = Build.VERSION.SDK_INT >= 16 ? new b() : new c();
    }

    private aa(Context context) {
        this.c = context;
    }

    public static aa a(Context context) {
        return new aa(context);
    }

    public aa a(Activity activity) {
        Intent a_ = activity instanceof a ? ((a) activity).a_() : null;
        if (a_ == null) {
            a_ = v.a(activity);
        }
        if (a_ != null) {
            ComponentName component = a_.getComponent();
            if (component == null) {
                component = a_.resolveActivity(this.c.getPackageManager());
            }
            a(component);
            a(a_);
        }
        return this;
    }

    public aa a(ComponentName componentName) {
        int size = this.b.size();
        try {
            Context context = this.c;
            while (true) {
                Intent a2 = v.a(context, componentName);
                if (a2 == null) {
                    return this;
                }
                this.b.add(size, a2);
                context = this.c;
                componentName = a2.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public aa a(Intent intent) {
        this.b.add(intent);
        return this;
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (android.support.v4.a.a.a(this.c, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.c.startActivity(intent);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.b.iterator();
    }
}