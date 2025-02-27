package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.d;

/* loaded from: classes.dex */
class e extends d {

    /* loaded from: classes.dex */
    private static class a extends d.a {
        a(d.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.b.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Drawable drawable) {
        super(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d.a aVar, Resources resources) {
        super(aVar, resources);
    }

    @Override // android.support.v4.b.a.d
    d.a b() {
        return new a(this.b, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }
}