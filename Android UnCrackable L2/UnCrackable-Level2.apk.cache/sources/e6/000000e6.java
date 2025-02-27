package android.support.v4.g.a;

import android.graphics.Rect;
import android.os.Build;
import android.support.v7.a.a;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public class a {
    public int a = -1;
    private final AccessibilityNodeInfo b;

    private a(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.b = accessibilityNodeInfo;
    }

    public static a a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new a(accessibilityNodeInfo);
    }

    private static String b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case a.j.AppCompatTheme_activityChooserViewStyle /* 32 */:
                return "ACTION_LONG_CLICK";
            case a.j.AppCompatTheme_dropdownListPreferredItemHeight /* 64 */:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public AccessibilityNodeInfo a() {
        return this.b;
    }

    public void a(int i) {
        this.b.addAction(i);
    }

    public void a(Rect rect) {
        this.b.getBoundsInParent(rect);
    }

    public void a(CharSequence charSequence) {
        this.b.setClassName(charSequence);
    }

    public void a(boolean z) {
        this.b.setScrollable(z);
    }

    public int b() {
        return this.b.getActions();
    }

    public void b(Rect rect) {
        this.b.getBoundsInScreen(rect);
    }

    public boolean c() {
        return this.b.isCheckable();
    }

    public boolean d() {
        return this.b.isChecked();
    }

    public boolean e() {
        return this.b.isFocusable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.b == null) {
                if (aVar.b != null) {
                    return false;
                }
            } else if (!this.b.equals(aVar.b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.b.isFocused();
    }

    public boolean g() {
        return this.b.isSelected();
    }

    public boolean h() {
        return this.b.isClickable();
    }

    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }

    public boolean i() {
        return this.b.isLongClickable();
    }

    public boolean j() {
        return this.b.isEnabled();
    }

    public boolean k() {
        return this.b.isPassword();
    }

    public boolean l() {
        return this.b.isScrollable();
    }

    public CharSequence m() {
        return this.b.getPackageName();
    }

    public CharSequence n() {
        return this.b.getClassName();
    }

    public CharSequence o() {
        return this.b.getText();
    }

    public CharSequence p() {
        return this.b.getContentDescription();
    }

    public String q() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.b.getViewIdResourceName();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(m());
        sb.append("; className: ");
        sb.append(n());
        sb.append("; text: ");
        sb.append(o());
        sb.append("; contentDescription: ");
        sb.append(p());
        sb.append("; viewId: ");
        sb.append(q());
        sb.append("; checkable: ");
        sb.append(c());
        sb.append("; checked: ");
        sb.append(d());
        sb.append("; focusable: ");
        sb.append(e());
        sb.append("; focused: ");
        sb.append(f());
        sb.append("; selected: ");
        sb.append(g());
        sb.append("; clickable: ");
        sb.append(h());
        sb.append("; longClickable: ");
        sb.append(i());
        sb.append("; enabled: ");
        sb.append(j());
        sb.append("; password: ");
        sb.append(k());
        sb.append("; scrollable: " + l());
        sb.append("; [");
        int b = b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ (-1);
            sb.append(b(numberOfTrailingZeros));
            if (b != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}