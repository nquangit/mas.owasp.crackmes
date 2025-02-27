package android.support.b.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class c extends h implements android.support.b.a.b {
    final Drawable.Callback a;
    private a c;
    private Context d;
    private ArgbEvaluator e;
    private Animator.AnimatorListener f;
    private ArrayList<Object> g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Drawable.ConstantState {
        int a;
        i b;
        AnimatorSet c;
        android.support.v4.f.a<Animator, String> d;
        private ArrayList<Animator> e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.a = aVar.a;
                if (aVar.b != null) {
                    Drawable.ConstantState constantState = aVar.b.getConstantState();
                    this.b = (i) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    this.b = (i) this.b.mutate();
                    this.b.setCallback(callback);
                    this.b.setBounds(aVar.b.getBounds());
                    this.b.a(false);
                }
                if (aVar.e != null) {
                    int size = aVar.e.size();
                    this.e = new ArrayList<>(size);
                    this.d = new android.support.v4.f.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.e.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.d.get(animator);
                        clone.setTarget(this.b.a(str));
                        this.e.add(clone);
                        this.d.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.e);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* loaded from: classes.dex */
    private static class b extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public b(Drawable.ConstantState constantState) {
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
            c cVar = new c();
            cVar.b = this.a.newDrawable();
            cVar.b.setCallback(cVar.a);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            cVar.b = this.a.newDrawable(resources);
            cVar.b.setCallback(cVar.a);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            cVar.b = this.a.newDrawable(resources, theme);
            cVar.b.setCallback(cVar.a);
            return cVar;
        }
    }

    c() {
        this(null, null, null);
    }

    private c(Context context) {
        this(context, null, null);
    }

    private c(Context context, a aVar, Resources resources) {
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = new Drawable.Callback() { // from class: android.support.b.a.c.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                c.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.d = context;
        if (aVar != null) {
            this.c = aVar;
        } else {
            this.c = new a(context, aVar, this.a, resources);
        }
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.e == null) {
                    this.e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.e);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.c.b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.c.e == null) {
            this.c.e = new ArrayList();
            this.c.d = new android.support.v4.f.a<>();
        }
        this.c.e.add(animator);
        this.c.d.put(animator, str);
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.b != null) {
            return android.support.v4.b.a.a.d(this.b);
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
        this.c.b.draw(canvas);
        if (this.c.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b != null ? android.support.v4.b.a.a.c(this.b) : this.c.b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.c.a;
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.b.getConstantState());
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b != null ? this.b.getIntrinsicHeight() : this.c.b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b != null ? this.b.getIntrinsicWidth() : this.c.b.getIntrinsicWidth();
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
        return this.b != null ? this.b.getOpacity() : this.c.b.getOpacity();
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
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = android.support.v4.a.a.c.a(resources, theme, attributeSet, android.support.b.a.a.e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a2 = i.a(resources, resourceId, theme);
                        a2.a(false);
                        a2.setCallback(this.a);
                        if (this.c.b != null) {
                            this.c.b.setCallback(null);
                        }
                        this.c.b = a2;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, android.support.b.a.a.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.d == null) {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        a(string, e.a(this.d, resourceId2));
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.c.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.b != null ? android.support.v4.b.a.a.b(this.b) : this.c.b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b != null ? ((AnimatedVectorDrawable) this.b).isRunning() : this.c.c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.b != null ? this.b.isStateful() : this.c.b.isStateful();
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        }
        return this;
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        } else {
            this.c.b.setBounds(rect);
        }
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.b != null ? this.b.setLevel(i) : this.c.b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.b != null ? this.b.setState(iArr) : this.c.b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else {
            this.c.b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, z);
        } else {
            this.c.b.setAutoMirrored(z);
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
        } else {
            this.c.b.setColorFilter(colorFilter);
        }
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // android.support.b.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
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
            this.c.b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, colorStateList);
        } else {
            this.c.b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.b != null) {
            android.support.v4.b.a.a.a(this.b, mode);
        } else {
            this.c.b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        this.c.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).start();
        } else if (this.c.c.isStarted()) {
        } else {
            this.c.c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).stop();
        } else {
            this.c.c.end();
        }
    }
}