package android.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class c extends b {
    public c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable;
        if (this.a.d) {
            if (this.a.c == null) {
                return;
            }
            drawable = this.a.c;
        } else if (this.a.a == null) {
            return;
        } else {
            drawable = this.a.a;
        }
        drawable.getOutline(outline);
    }
}