package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class bb extends Resources {
    private final WeakReference<Context> a;

    public bb(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = new WeakReference<>(context);
    }

    public static boolean a() {
        return android.support.v7.app.e.k() && Build.VERSION.SDK_INT <= 20;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable a(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.a.get();
        return context != null ? l.a().a(context, this, i) : super.getDrawable(i);
    }
}