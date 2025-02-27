package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes.dex */
public class w extends SeekBar {
    private final x a;

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0011a.seekBarStyle);
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new x(this);
        this.a.a(attributeSet, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.c();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.a.b();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.a(canvas);
    }
}