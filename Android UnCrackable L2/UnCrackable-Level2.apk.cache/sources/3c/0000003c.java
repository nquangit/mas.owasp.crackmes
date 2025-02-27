package android.support.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.support.v4.b.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator<b.C0005b[]> {
        private b.C0005b[] a;

        private a() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public b.C0005b[] evaluate(float f, b.C0005b[] c0005bArr, b.C0005b[] c0005bArr2) {
            if (android.support.v4.b.b.a(c0005bArr, c0005bArr2)) {
                if (this.a == null || !android.support.v4.b.b.a(this.a, c0005bArr)) {
                    this.a = android.support.v4.b.b.a(c0005bArr);
                }
                for (int i = 0; i < c0005bArr.length; i++) {
                    this.a[i].a(c0005bArr[i], c0005bArr2[i], f);
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static int a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a2 = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.j);
        int i = 0;
        TypedValue b = android.support.v4.a.a.c.b(a2, xmlPullParser, "value", 0);
        if ((b != null) && a(b.type)) {
            i = 3;
        }
        a2.recycle();
        return i;
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z = peekValue != null;
        int i3 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        boolean z2 = peekValue2 != null;
        return ((z && a(i3)) || (z2 && a(z2 ? peekValue2.type : 0))) ? 3 : 0;
    }

    public static Animator a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : a(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i) {
        return a(context, resources, theme, i, 1.0f);
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i, float f) {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser animation = resources.getAnimation(i);
                try {
                    Animator a2 = a(context, resources, theme, animation, f);
                    if (animation != null) {
                        animation.close();
                    }
                    return a2;
                } catch (IOException e) {
                    e = e;
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                } catch (XmlPullParserException e2) {
                    e = e2;
                    Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException2.initCause(e);
                    throw notFoundException2;
                } catch (Throwable th) {
                    th = th;
                    xmlResourceParser = animation;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (XmlPullParserException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) {
        return a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.animation.Animator a(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.b.a.e.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static Keyframe a(Keyframe keyframe, float f) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    private static Keyframe a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        Keyframe ofFloat;
        TypedArray a2 = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.j);
        float a3 = android.support.v4.a.a.c.a(a2, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue b = android.support.v4.a.a.c.b(a2, xmlPullParser, "value", 0);
        boolean z = b != null;
        if (i == 4) {
            i = (z && a(b.type)) ? 3 : 0;
        }
        if (z) {
            if (i != 3) {
                switch (i) {
                    case 0:
                        ofFloat = Keyframe.ofFloat(a3, android.support.v4.a.a.c.a(a2, xmlPullParser, "value", 0, 0.0f));
                        break;
                    case 1:
                        break;
                    default:
                        ofFloat = null;
                        break;
                }
            }
            ofFloat = Keyframe.ofInt(a3, android.support.v4.a.a.c.a(a2, xmlPullParser, "value", 0, 0));
        } else {
            ofFloat = i == 0 ? Keyframe.ofFloat(a3) : Keyframe.ofInt(a3);
        }
        int c = android.support.v4.a.a.c.c(a2, xmlPullParser, "interpolator", 1, 0);
        if (c > 0) {
            ofFloat.setInterpolator(d.a(context, c));
        }
        a2.recycle();
        return ofFloat;
    }

    private static ObjectAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        int i2 = i;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i2 == 4) {
                    i2 = a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe a2 = a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i2, xmlPullParser);
                if (a2 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(a2);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), a(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, a(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i3 = 0; i3 < size; i3++) {
                Keyframe keyframe3 = keyframeArr[i3];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i3 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i4 = size - 1;
                        if (i3 == i4) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i5 = i3;
                            for (int i6 = i3 + 1; i6 < i4 && keyframeArr[i6].getFraction() < 0.0f; i6++) {
                                i5 = i6;
                            }
                            a(keyframeArr, keyframeArr[i5 + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, i5);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i2 == 3) {
                propertyValuesHolder.setEvaluator(f.a());
            }
        }
        return propertyValuesHolder;
    }

    private static PropertyValuesHolder a(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder ofFloat;
        Object[] objArr;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i4 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i5 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((z && a(i4)) || (z2 && a(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i != 2) {
            f a2 = i == 3 ? f.a() : null;
            if (z3) {
                if (z) {
                    float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                    if (z2) {
                        ofFloat = PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                    } else {
                        ofFloat = PropertyValuesHolder.ofFloat(str, dimension);
                    }
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                }
                propertyValuesHolder = ofFloat;
            } else if (z) {
                int dimension2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : a(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
                if (z2) {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2);
                }
            } else if (z2) {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
            }
            if (propertyValuesHolder == null || a2 == null) {
                return propertyValuesHolder;
            }
            propertyValuesHolder.setEvaluator(a2);
            return propertyValuesHolder;
        }
        String string = typedArray.getString(i2);
        String string2 = typedArray.getString(i3);
        b.C0005b[] b = android.support.v4.b.b.b(string);
        b.C0005b[] b2 = android.support.v4.b.b.b(string2);
        if (b == null && b2 == null) {
            return null;
        }
        if (b == null) {
            if (b2 != null) {
                return PropertyValuesHolder.ofObject(str, new a(), b2);
            }
            return null;
        }
        a aVar = new a();
        if (b2 == null) {
            objArr = new Object[]{b};
        } else if (!android.support.v4.b.b.a(b, b2)) {
            throw new InflateException(" Can't morph from " + string + " to " + string2);
        } else {
            objArr = new Object[]{b, b2};
        }
        return PropertyValuesHolder.ofObject(str, aVar, objArr);
    }

    private static ValueAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray a2 = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.g);
        TypedArray a3 = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, a2, a3, f, xmlPullParser);
        int c = android.support.v4.a.a.c.c(a2, xmlPullParser, "interpolator", 0, 0);
        if (c > 0) {
            valueAnimator.setInterpolator(d.a(context, c));
        }
        a2.recycle();
        if (a3 != null) {
            a3.recycle();
        }
        return valueAnimator;
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String a2 = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "pathData", 1);
        if (a2 == null) {
            objectAnimator.setPropertyName(android.support.v4.a.a.c.a(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String a3 = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "propertyXName", 2);
        String a4 = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "propertyYName", 3);
        if (i != 2) {
        }
        if (a3 != null || a4 != null) {
            a(android.support.v4.b.b.a(a2), objectAnimator, f * 0.5f, a3, a4);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long a2 = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "duration", 1, 300);
        long a3 = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int a4 = android.support.v4.a.a.c.a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (android.support.v4.a.a.c.a(xmlPullParser, "valueFrom") && android.support.v4.a.a.c.a(xmlPullParser, "valueTo")) {
            if (a4 == 4) {
                a4 = a(typedArray, 5, 6);
            }
            PropertyValuesHolder a5 = a(typedArray, a4, 5, 6, "");
            if (a5 != null) {
                valueAnimator.setValues(a5);
            }
        }
        valueAnimator.setDuration(a2);
        valueAnimator.setStartDelay(a3);
        valueAnimator.setRepeatCount(android.support.v4.a.a.c.a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(android.support.v4.a.a.c.a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            a(valueAnimator, typedArray2, a4, f, xmlPullParser);
        }
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        char c = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f2 = 0.0f;
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f3 = f2 / (min - 1);
        int i = 0;
        float f4 = 0.0f;
        int i2 = 0;
        while (true) {
            if (i >= min) {
                break;
            }
            pathMeasure2.getPosTan(f4, fArr3, null);
            fArr[i] = fArr3[c];
            fArr2[i] = fArr3[1];
            f4 += f3;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f4 > ((Float) arrayList.get(i3)).floatValue()) {
                f4 -= ((Float) arrayList.get(i3)).floatValue();
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
            c = 0;
        }
        PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder ofFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (ofFloat == null) {
            objectAnimator.setValues(ofFloat2);
        } else {
            objectAnimator.setValues(ofFloat2 == null ? new PropertyValuesHolder[]{ofFloat} : new PropertyValuesHolder[]{ofFloat, ofFloat2});
        }
    }

    private static void a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static boolean a(int i) {
        return i >= 28 && i <= 31;
    }

    private static PropertyValuesHolder[] a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        int i;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType == 2 && xmlPullParser.getName().equals("propertyValuesHolder")) {
                TypedArray a2 = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.i);
                String a3 = android.support.v4.a.a.c.a(a2, xmlPullParser, "propertyName", 3);
                int a4 = android.support.v4.a.a.c.a(a2, xmlPullParser, "valueType", 2, 4);
                PropertyValuesHolder a5 = a(context, resources, theme, xmlPullParser, a3, a4);
                if (a5 == null) {
                    a5 = a(a2, a4, 0, 1, a3);
                }
                if (a5 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(a5);
                }
                a2.recycle();
            }
            xmlPullParser.next();
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }
}