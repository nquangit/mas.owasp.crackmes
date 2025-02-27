package android.support.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.b.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class i extends h {
    static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private f c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends d {
        public a() {
        }

        public a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.m = android.support.v4.b.b.b(string2);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (android.support.v4.a.a.c.a(xmlPullParser, "pathData")) {
                TypedArray a = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.d);
                a(a);
                a.recycle();
            }
        }

        @Override // android.support.b.a.i.d
        public boolean a() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends d {
        int a;
        float b;
        int c;
        float d;
        int e;
        float f;
        float g;
        float h;
        float i;
        Paint.Cap j;
        Paint.Join k;
        float l;
        private int[] p;

        public b() {
            this.a = 0;
            this.b = 0.0f;
            this.c = 0;
            this.d = 1.0f;
            this.e = 0;
            this.f = 1.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = Paint.Cap.BUTT;
            this.k = Paint.Join.MITER;
            this.l = 4.0f;
        }

        public b(b bVar) {
            super(bVar);
            this.a = 0;
            this.b = 0.0f;
            this.c = 0;
            this.d = 1.0f;
            this.e = 0;
            this.f = 1.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = Paint.Cap.BUTT;
            this.k = Paint.Join.MITER;
            this.l = 4.0f;
            this.p = bVar.p;
            this.a = bVar.a;
            this.b = bVar.b;
            this.d = bVar.d;
            this.c = bVar.c;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Paint.Join a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.p = null;
            if (android.support.v4.a.a.c.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.m = android.support.v4.b.b.b(string2);
                }
                this.c = android.support.v4.a.a.c.b(typedArray, xmlPullParser, "fillColor", 1, this.c);
                this.f = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
                this.j = a(android.support.v4.a.a.c.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
                this.k = a(android.support.v4.a.a.c.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
                this.l = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
                this.a = android.support.v4.a.a.c.b(typedArray, xmlPullParser, "strokeColor", 3, this.a);
                this.d = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
                this.b = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
                this.h = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
                this.i = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
                this.g = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
                this.e = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "fillType", 13, this.e);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.c);
            a(a, xmlPullParser);
            a.recycle();
        }

        float getFillAlpha() {
            return this.f;
        }

        int getFillColor() {
            return this.c;
        }

        float getStrokeAlpha() {
            return this.d;
        }

        int getStrokeColor() {
            return this.a;
        }

        float getStrokeWidth() {
            return this.b;
        }

        float getTrimPathEnd() {
            return this.h;
        }

        float getTrimPathOffset() {
            return this.i;
        }

        float getTrimPathStart() {
            return this.g;
        }

        void setFillAlpha(float f) {
            this.f = f;
        }

        void setFillColor(int i) {
            this.c = i;
        }

        void setStrokeAlpha(float f) {
            this.d = f;
        }

        void setStrokeColor(int i) {
            this.a = i;
        }

        void setStrokeWidth(float f) {
            this.b = f;
        }

        void setTrimPathEnd(float f) {
            this.h = f;
        }

        void setTrimPathOffset(float f) {
            this.i = f;
        }

        void setTrimPathStart(float f) {
            this.g = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        final ArrayList<Object> a;
        float b;
        int c;
        private final Matrix d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private float j;
        private final Matrix k;
        private int[] l;
        private String m;

        public c() {
            this.d = new Matrix();
            this.a = new ArrayList<>();
            this.b = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = new Matrix();
            this.m = null;
        }

        public c(c cVar, android.support.v4.f.a<String, Object> aVar) {
            d aVar2;
            this.d = new Matrix();
            this.a = new ArrayList<>();
            this.b = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 1.0f;
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = new Matrix();
            this.m = null;
            this.b = cVar.b;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.l = cVar.l;
            this.m = cVar.m;
            this.c = cVar.c;
            if (this.m != null) {
                aVar.put(this.m, this);
            }
            this.k.set(cVar.k);
            ArrayList<Object> arrayList = cVar.a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof c) {
                    this.a.add(new c((c) obj, aVar));
                } else {
                    if (obj instanceof b) {
                        aVar2 = new b((b) obj);
                    } else if (!(obj instanceof a)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    } else {
                        aVar2 = new a((a) obj);
                    }
                    this.a.add(aVar2);
                    if (aVar2.n != null) {
                        aVar.put(aVar2.n, aVar2);
                    }
                }
            }
        }

        private void a() {
            this.k.reset();
            this.k.postTranslate(-this.e, -this.f);
            this.k.postScale(this.g, this.h);
            this.k.postRotate(this.b, 0.0f, 0.0f);
            this.k.postTranslate(this.i + this.e, this.j + this.f);
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.b = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "rotation", 5, this.b);
            this.e = typedArray.getFloat(1, this.e);
            this.f = typedArray.getFloat(2, this.f);
            this.g = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "scaleX", 3, this.g);
            this.h = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "scaleY", 4, this.h);
            this.i = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "translateX", 6, this.i);
            this.j = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "translateY", 7, this.j);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.b);
            a(a, xmlPullParser);
            a.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.k;
        }

        public float getPivotX() {
            return this.e;
        }

        public float getPivotY() {
            return this.f;
        }

        public float getRotation() {
            return this.b;
        }

        public float getScaleX() {
            return this.g;
        }

        public float getScaleY() {
            return this.h;
        }

        public float getTranslateX() {
            return this.i;
        }

        public float getTranslateY() {
            return this.j;
        }

        public void setPivotX(float f) {
            if (f != this.e) {
                this.e = f;
                a();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f) {
                this.f = f;
                a();
            }
        }

        public void setRotation(float f) {
            if (f != this.b) {
                this.b = f;
                a();
            }
        }

        public void setScaleX(float f) {
            if (f != this.g) {
                this.g = f;
                a();
            }
        }

        public void setScaleY(float f) {
            if (f != this.h) {
                this.h = f;
                a();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.i) {
                this.i = f;
                a();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.j) {
                this.j = f;
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        protected b.C0005b[] m;
        String n;
        int o;

        public d() {
            this.m = null;
        }

        public d(d dVar) {
            this.m = null;
            this.n = dVar.n;
            this.o = dVar.o;
            this.m = android.support.v4.b.b.a(dVar.m);
        }

        public void a(Path path) {
            path.reset();
            if (this.m != null) {
                b.C0005b.a(this.m, path);
            }
        }

        public boolean a() {
            return false;
        }

        public b.C0005b[] getPathData() {
            return this.m;
        }

        public String getPathName() {
            return this.n;
        }

        public void setPathData(b.C0005b[] c0005bArr) {
            if (android.support.v4.b.b.a(this.m, c0005bArr)) {
                android.support.v4.b.b.b(this.m, c0005bArr);
            } else {
                this.m = android.support.v4.b.b.a(c0005bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {
        private static final Matrix k = new Matrix();
        final c a;
        float b;
        float c;
        float d;
        float e;
        int f;
        String g;
        final android.support.v4.f.a<String, Object> h;
        private final Path i;
        private final Path j;
        private final Matrix l;
        private Paint m;
        private Paint n;
        private PathMeasure o;
        private int p;

        public e() {
            this.l = new Matrix();
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 255;
            this.g = null;
            this.h = new android.support.v4.f.a<>();
            this.a = new c();
            this.i = new Path();
            this.j = new Path();
        }

        public e(e eVar) {
            this.l = new Matrix();
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 255;
            this.g = null;
            this.h = new android.support.v4.f.a<>();
            this.a = new c(eVar.a, this.h);
            this.i = new Path(eVar.i);
            this.j = new Path(eVar.j);
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.p = eVar.p;
            this.f = eVar.f;
            this.g = eVar.g;
            if (eVar.g != null) {
                this.h.put(eVar.g, this);
            }
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a) / max;
            }
            return 0.0f;
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.d.set(matrix);
            cVar.d.preConcat(cVar.k);
            canvas.save();
            for (int i3 = 0; i3 < cVar.a.size(); i3++) {
                Object obj = cVar.a.get(i3);
                if (obj instanceof c) {
                    a((c) obj, cVar.d, canvas, i, i2, colorFilter);
                } else if (obj instanceof d) {
                    a(cVar, (d) obj, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        private void a(c cVar, d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.d;
            float f2 = i2 / this.e;
            float min = Math.min(f, f2);
            Matrix matrix = cVar.d;
            this.l.set(matrix);
            this.l.postScale(f, f2);
            float a = a(matrix);
            if (a == 0.0f) {
                return;
            }
            dVar.a(this.i);
            Path path = this.i;
            this.j.reset();
            if (dVar.a()) {
                this.j.addPath(path, this.l);
                canvas.clipPath(this.j);
                return;
            }
            b bVar = (b) dVar;
            if (bVar.g != 0.0f || bVar.h != 1.0f) {
                float f3 = (bVar.g + bVar.i) % 1.0f;
                float f4 = (bVar.h + bVar.i) % 1.0f;
                if (this.o == null) {
                    this.o = new PathMeasure();
                }
                this.o.setPath(this.i, false);
                float length = this.o.getLength();
                float f5 = f3 * length;
                float f6 = f4 * length;
                path.reset();
                if (f5 > f6) {
                    this.o.getSegment(f5, length, path, true);
                    this.o.getSegment(0.0f, f6, path, true);
                } else {
                    this.o.getSegment(f5, f6, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.j.addPath(path, this.l);
            if (bVar.c != 0) {
                if (this.n == null) {
                    this.n = new Paint();
                    this.n.setStyle(Paint.Style.FILL);
                    this.n.setAntiAlias(true);
                }
                Paint paint = this.n;
                paint.setColor(i.a(bVar.c, bVar.f));
                paint.setColorFilter(colorFilter);
                this.j.setFillType(bVar.e == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.j, paint);
            }
            if (bVar.a != 0) {
                if (this.m == null) {
                    this.m = new Paint();
                    this.m.setStyle(Paint.Style.STROKE);
                    this.m.setAntiAlias(true);
                }
                Paint paint2 = this.m;
                if (bVar.k != null) {
                    paint2.setStrokeJoin(bVar.k);
                }
                if (bVar.j != null) {
                    paint2.setStrokeCap(bVar.j);
                }
                paint2.setStrokeMiter(bVar.l);
                paint2.setColor(i.a(bVar.a, bVar.d));
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(bVar.b * min * a);
                canvas.drawPath(this.j, paint2);
            }
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.a, k, canvas, i, i2, colorFilter);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f extends Drawable.ConstantState {
        int a;
        e b;
        ColorStateList c;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public f() {
            this.c = null;
            this.d = i.a;
            this.b = new e();
        }

        public f(f fVar) {
            this.c = null;
            this.d = i.a;
            if (fVar != null) {
                this.a = fVar.a;
                this.b = new e(fVar.b);
                if (fVar.b.n != null) {
                    this.b.n = new Paint(fVar.b.n);
                }
                if (fVar.b.m != null) {
                    this.b.m = new Paint(fVar.b.m);
                }
                this.c = fVar.c;
                this.d = fVar.d;
                this.e = fVar.e;
            }
        }

        public Paint a(ColorFilter colorFilter) {
            if (a() || colorFilter != null) {
                if (this.l == null) {
                    this.l = new Paint();
                    this.l.setFilterBitmap(true);
                }
                this.l.setAlpha(this.b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public void a(int i, int i2) {
            this.f.eraseColor(0);
            this.b.a(new Canvas(this.f), i, i2, (ColorFilter) null);
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.b.getRootAlpha() < 255;
        }

        public void b(int i, int i2) {
            if (this.f == null || !c(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean b() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
        }

        public void c() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public boolean c(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }
    }

    /* loaded from: classes.dex */
    private static class g extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public g(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.b = (VectorDrawable) this.a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.b = (VectorDrawable) this.a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.b = (VectorDrawable) this.a.newDrawable(resources, theme);
            return iVar;
        }
    }

    i() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = new f();
    }

    i(f fVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.c = fVar;
        this.d = a(this.d, fVar.c, fVar.d);
    }

    static int a(int i, float f2) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f2)) << 24);
    }

    private static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static i a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.b = android.support.v4.a.a.b.a(resources, i, theme);
            iVar.h = new g(iVar.b.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        f fVar = this.c;
        e eVar = fVar.b;
        fVar.d = a(android.support.v4.a.a.c.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            fVar.c = colorStateList;
        }
        fVar.e = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "autoMirrored", 5, fVar.e);
        eVar.d = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "viewportWidth", 7, eVar.d);
        eVar.e = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "viewportHeight", 8, eVar.e);
        if (eVar.d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.b = typedArray.getDimension(3, eVar.b);
            eVar.c = typedArray.getDimension(2, eVar.c);
            if (eVar.b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.c <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.setAlpha(android.support.v4.a.a.c.a(typedArray, xmlPullParser, "alpha", 4, eVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    eVar.g = string;
                    eVar.h.put(string, eVar);
                }
            }
        }
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && android.support.v4.b.a.a.g(this) == 1;
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i;
        int i2;
        f fVar = this.c;
        e eVar = fVar.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(eVar.a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.a.add(bVar);
                    if (bVar.getPathName() != null) {
                        eVar.h.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    i = fVar.a;
                    i2 = bVar.o;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.a.add(aVar);
                    if (aVar.getPathName() != null) {
                        eVar.h.put(aVar.getPathName(), aVar);
                    }
                    i = fVar.a;
                    i2 = aVar.o;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.a.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        eVar.h.put(cVar2.getGroupName(), cVar2);
                    }
                    i = fVar.a;
                    i2 = cVar2.c;
                }
                fVar.a = i2 | i;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.c.b.h.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.g = z;
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.b != null) {
            android.support.v4.b.a.a.d(this.b);
            return false;
        }
        return false;
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() <= 0 || this.k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.e == null ? this.d : this.e;
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float abs = Math.abs(this.i[0]);
        float abs2 = Math.abs(this.i[4]);
        float abs3 = Math.abs(this.i[1]);
        float abs4 = Math.abs(this.i[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.k.width() * abs));
        int min2 = Math.min(2048, (int) (this.k.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.k.left, this.k.top);
        if (a()) {
            canvas.translate(this.k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.c.b(min, min2);
        if (!this.g) {
            this.c.a(min, min2);
        } else if (!this.c.b()) {
            this.c.a(min, min2);
            this.c.c();
        }
        this.c.a(canvas, colorFilter, this.k);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b != null ? android.support.v4.b.a.a.c(this.b) : this.c.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.b == null || Build.VERSION.SDK_INT < 24) {
            this.c.a = getChangingConfigurations();
            return this.c;
        }
        return new g(this.b.getConstantState());
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b != null ? this.b.getIntrinsicHeight() : (int) this.c.b.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b != null ? this.b.getIntrinsicWidth() : (int) this.c.b.b;
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.b != null) {
            return this.b.getOpacity();
        }
        return -3;
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.b != null) {
            this.b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.c;
        fVar.b = new e();
        TypedArray a2 = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.a);
        a(a2, xmlPullParser);
        a2.recycle();
        fVar.a = getChangingConfigurations();
        fVar.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.d = a(this.d, fVar.c, fVar.d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.b != null) {
            this.b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.b != null ? android.support.v4.b.a.a.b(this.b) : this.c.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.b != null ? this.b.isStateful() : super.isStateful() || !(this.c == null || this.c.c == null || !this.c.c.isStateful());
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.c = new f(this.c);
            this.f = true;
        }
        return this;
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        f fVar = this.c;
        if (fVar.c == null || fVar.d == null) {
            return false;
        }
        this.d = a(this.d, fVar.c, fVar.d);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.b != null) {
            this.b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else if (this.c.b.getRootAlpha() != i) {
            this.c.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, z);
        } else {
            this.c.e = z;
        }
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.b
    public void setTint(int i) {
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, colorStateList);
            return;
        }
        f fVar = this.c;
        if (fVar.c != colorStateList) {
            fVar.c = colorStateList;
            this.d = a(this.d, colorStateList, fVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, mode);
            return;
        }
        f fVar = this.c;
        if (fVar.d != mode) {
            fVar.d = mode;
            this.d = a(this.d, fVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.b != null ? this.b.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.b != null) {
            this.b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}