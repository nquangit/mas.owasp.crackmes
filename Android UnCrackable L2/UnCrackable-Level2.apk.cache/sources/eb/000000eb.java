package android.support.v4.g;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* loaded from: classes.dex */
public class b {
    private static final C0008b b;
    private static final View.AccessibilityDelegate c;
    final View.AccessibilityDelegate a = b.a(this);

    /* loaded from: classes.dex */
    static class a extends C0008b {
        a() {
        }

        @Override // android.support.v4.g.b.C0008b
        public android.support.v4.g.a.b a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new android.support.v4.g.a.b(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // android.support.v4.g.b.C0008b
        public View.AccessibilityDelegate a(final b bVar) {
            return new View.AccessibilityDelegate() { // from class: android.support.v4.g.b.a.1
                @Override // android.view.View.AccessibilityDelegate
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.b(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    android.support.v4.g.a.b a = bVar.a(view);
                    if (a != null) {
                        return (AccessibilityNodeProvider) a.a();
                    }
                    return null;
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.d(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    bVar.a(view, android.support.v4.g.a.a.a(accessibilityNodeInfo));
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.c(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return bVar.a(view, i, bundle);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View view, int i) {
                    bVar.a(view, i);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.a(view, accessibilityEvent);
                }
            };
        }

        @Override // android.support.v4.g.b.C0008b
        public boolean a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008b {
        C0008b() {
        }

        public android.support.v4.g.a.b a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        public View.AccessibilityDelegate a(final b bVar) {
            return new View.AccessibilityDelegate() { // from class: android.support.v4.g.b.b.1
                @Override // android.view.View.AccessibilityDelegate
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.b(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.d(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    bVar.a(view, android.support.v4.g.a.a.a(accessibilityNodeInfo));
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.c(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View view, int i) {
                    bVar.a(view, i);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.a(view, accessibilityEvent);
                }
            };
        }

        public boolean a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static {
        b = Build.VERSION.SDK_INT >= 16 ? new a() : new C0008b();
        c = new View.AccessibilityDelegate();
    }

    public android.support.v4.g.a.b a(View view) {
        return b.a(c, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        return this.a;
    }

    public void a(View view, int i) {
        c.sendAccessibilityEvent(view, i);
    }

    public void a(View view, android.support.v4.g.a.a aVar) {
        c.onInitializeAccessibilityNodeInfo(view, aVar.a());
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        c.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return b.a(c, view, i, bundle);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return c.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return c.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        c.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        c.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
}