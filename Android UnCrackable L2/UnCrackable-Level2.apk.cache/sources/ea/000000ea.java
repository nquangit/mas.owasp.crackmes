package android.support.v4.g.a;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public class c {
    private final AccessibilityRecord a;

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            if (this.a == null) {
                if (cVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(cVar.a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Deprecated
    public int hashCode() {
        if (this.a == null) {
            return 0;
        }
        return this.a.hashCode();
    }
}