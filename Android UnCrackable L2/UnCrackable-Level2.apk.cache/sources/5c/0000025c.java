package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
class t {
    private static final int[] a = {16843067, 16843068};
    private final ProgressBar b;
    private Bitmap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ProgressBar progressBar) {
        this.b = progressBar;
    }

    private Drawable a(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; i++) {
                Drawable a2 = a(animationDrawable.getFrame(i), true);
                a2.setLevel(10000);
                animationDrawable2.addFrame(a2, animationDrawable.getDuration(i));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    private Drawable a(Drawable drawable, boolean z) {
        if (drawable instanceof android.support.v4.b.a.c) {
            android.support.v4.b.a.c cVar = (android.support.v4.b.a.c) drawable;
            Drawable a2 = cVar.a();
            if (a2 != null) {
                cVar.a(a(a2, z));
                return drawable;
            }
            return drawable;
        } else if (!(drawable instanceof LayerDrawable)) {
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.c == null) {
                    this.c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(b());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
            return drawable;
        } else {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        }
    }

    private Shape b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        aw a2 = aw.a(this.b.getContext(), attributeSet, a, i, 0);
        Drawable b = a2.b(0);
        if (b != null) {
            this.b.setIndeterminateDrawable(a(b));
        }
        Drawable b2 = a2.b(1);
        if (b2 != null) {
            this.b.setProgressDrawable(a(b2, false));
        }
        a2.a();
    }
}