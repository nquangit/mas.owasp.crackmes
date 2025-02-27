package android.support.v7.widget;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class ay {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            az.a(view, charSequence);
        }
    }
}