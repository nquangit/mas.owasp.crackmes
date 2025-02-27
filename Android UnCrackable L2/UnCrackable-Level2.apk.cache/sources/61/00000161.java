package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.a.a;
import android.support.v7.widget.ab;
import android.support.v7.widget.at;
import android.support.v7.widget.q;
import android.support.v7.widget.r;
import android.support.v7.widget.u;
import android.support.v7.widget.v;
import android.support.v7.widget.w;
import android.support.v7.widget.y;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes.dex */
public class AppCompatViewInflater {
    private static final Class<?>[] a = {Context.class, AttributeSet.class};
    private static final int[] b = {16843375};
    private static final String[] c = {"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> d = new android.support.v4.f.a();
    private final Object[] e = new Object[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        private final View a;
        private final String b;
        private Method c;
        private Context d;

        public a(View view, String str) {
            this.a = view;
            this.b = str;
        }

        private void a(Context context, String str) {
            int id;
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.b, View.class)) != null) {
                        this.c = method;
                        this.d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            if (this.a.getId() == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.a.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.c == null) {
                a(this.a.getContext(), this.b);
            }
            try {
                this.c.invoke(this.d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    private static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(a.j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(a.j.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof android.support.v7.view.d) && ((android.support.v7.view.d) context).a() == resourceId) ? context : new android.support.v7.view.d(context, resourceId) : context;
    }

    private View a(Context context, String str, String str2) {
        String str3;
        Constructor<? extends View> constructor = d.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(a);
                d.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.e);
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || android.support.v4.g.p.n(view)) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
                String string = obtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    private View b(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.e[0] = context;
            this.e[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (int i = 0; i < c.length; i++) {
                    View a2 = a(context, str, c[i]);
                    if (a2 != null) {
                        return a2;
                    }
                }
                return null;
            }
            return a(context, str, (String) null);
        } catch (Exception unused) {
            return null;
        } finally {
            this.e[0] = null;
            this.e[1] = null;
        }
    }

    protected ab a(Context context, AttributeSet attributeSet) {
        return new ab(context, attributeSet);
    }

    protected View a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View a2;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = at.a(context2);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                a2 = a(context2, attributeSet);
                a(a2, str);
                break;
            case 1:
                a2 = b(context2, attributeSet);
                a(a2, str);
                break;
            case 2:
                a2 = c(context2, attributeSet);
                a(a2, str);
                break;
            case 3:
                a2 = d(context2, attributeSet);
                a(a2, str);
                break;
            case 4:
                a2 = e(context2, attributeSet);
                a(a2, str);
                break;
            case 5:
                a2 = f(context2, attributeSet);
                a(a2, str);
                break;
            case 6:
                a2 = g(context2, attributeSet);
                a(a2, str);
                break;
            case 7:
                a2 = h(context2, attributeSet);
                a(a2, str);
                break;
            case '\b':
                a2 = i(context2, attributeSet);
                a(a2, str);
                break;
            case '\t':
                a2 = j(context2, attributeSet);
                a(a2, str);
                break;
            case '\n':
                a2 = k(context2, attributeSet);
                a(a2, str);
                break;
            case 11:
                a2 = l(context2, attributeSet);
                a(a2, str);
                break;
            case '\f':
                a2 = m(context2, attributeSet);
                a(a2, str);
                break;
            default:
                a2 = a(context2, str, attributeSet);
                break;
        }
        if (a2 == null && context != context2) {
            a2 = b(context2, str, attributeSet);
        }
        if (a2 != null) {
            a(a2, attributeSet);
        }
        return a2;
    }

    protected q b(Context context, AttributeSet attributeSet) {
        return new q(context, attributeSet);
    }

    protected android.support.v7.widget.h c(Context context, AttributeSet attributeSet) {
        return new android.support.v7.widget.h(context, attributeSet);
    }

    protected android.support.v7.widget.m d(Context context, AttributeSet attributeSet) {
        return new android.support.v7.widget.m(context, attributeSet);
    }

    protected y e(Context context, AttributeSet attributeSet) {
        return new y(context, attributeSet);
    }

    protected android.support.v7.widget.o f(Context context, AttributeSet attributeSet) {
        return new android.support.v7.widget.o(context, attributeSet);
    }

    protected android.support.v7.widget.i g(Context context, AttributeSet attributeSet) {
        return new android.support.v7.widget.i(context, attributeSet);
    }

    protected u h(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    protected android.support.v7.widget.j i(Context context, AttributeSet attributeSet) {
        return new android.support.v7.widget.j(context, attributeSet);
    }

    protected android.support.v7.widget.f j(Context context, AttributeSet attributeSet) {
        return new android.support.v7.widget.f(context, attributeSet);
    }

    protected r k(Context context, AttributeSet attributeSet) {
        return new r(context, attributeSet);
    }

    protected v l(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    protected w m(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }
}