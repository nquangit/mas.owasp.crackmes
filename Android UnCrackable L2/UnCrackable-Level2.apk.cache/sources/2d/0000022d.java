package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class av extends an {
    private final WeakReference<Context> a;

    public av(Context context, Resources resources) {
        super(resources);
        this.a = new WeakReference<>(context);
    }

    @Override // android.support.v7.widget.an, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.a.get();
        if (drawable != null && context != null) {
            l.a();
            l.a(context, i, drawable);
        }
        return drawable;
    }
}