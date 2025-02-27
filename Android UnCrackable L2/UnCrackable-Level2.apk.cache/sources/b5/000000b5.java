package android.support.v4.b;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;

/* loaded from: classes.dex */
class d extends g {
    private File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // android.support.v4.b.g, android.support.v4.b.c.a
    public android.graphics.Typeface a(android.content.Context r5, android.os.CancellationSignal r6, android.support.v4.e.b.C0006b[] r7, int r8) {
        /*
            r4 = this;
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L6
            return r1
        L6:
            android.support.v4.e.b$b r7 = r4.a(r7, r8)
            android.content.ContentResolver r8 = r5.getContentResolver()
            android.net.Uri r7 = r7.a()     // Catch: java.io.IOException -> L77
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r6 = r8.openFileDescriptor(r7, r0, r6)     // Catch: java.io.IOException -> L77
            java.io.File r7 = r4.a(r6)     // Catch: java.lang.Throwable -> L60
            if (r7 == 0) goto L2f
            boolean r8 = r7.canRead()     // Catch: java.lang.Throwable -> L60
            if (r8 != 0) goto L25
            goto L2f
        L25:
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromFile(r7)     // Catch: java.lang.Throwable -> L60
            if (r6 == 0) goto L2e
            r6.close()     // Catch: java.io.IOException -> L77
        L2e:
            return r5
        L2f:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L60
            java.io.FileDescriptor r8 = r6.getFileDescriptor()     // Catch: java.lang.Throwable -> L60
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L60
            android.graphics.Typeface r5 = super.a(r5, r7)     // Catch: java.lang.Throwable -> L48
            r7.close()     // Catch: java.lang.Throwable -> L60
            if (r6 == 0) goto L44
            r6.close()     // Catch: java.io.IOException -> L77
        L44:
            return r5
        L45:
            r5 = move-exception
            r8 = r1
            goto L4e
        L48:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L4a
        L4a:
            r8 = move-exception
            r3 = r8
            r8 = r5
            r5 = r3
        L4e:
            if (r8 == 0) goto L59
            r7.close()     // Catch: java.lang.Throwable -> L54
            goto L5c
        L54:
            r7 = move-exception
            r8.addSuppressed(r7)     // Catch: java.lang.Throwable -> L60
            goto L5c
        L59:
            r7.close()     // Catch: java.lang.Throwable -> L60
        L5c:
            throw r5     // Catch: java.lang.Throwable -> L60
        L5d:
            r5 = move-exception
            r7 = r1
            goto L66
        L60:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L62
        L62:
            r7 = move-exception
            r3 = r7
            r7 = r5
            r5 = r3
        L66:
            if (r6 == 0) goto L76
            if (r7 == 0) goto L73
            r6.close()     // Catch: java.lang.Throwable -> L6e
            goto L76
        L6e:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch: java.io.IOException -> L77
            goto L76
        L73:
            r6.close()     // Catch: java.io.IOException -> L77
        L76:
            throw r5     // Catch: java.io.IOException -> L77
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.d.a(android.content.Context, android.os.CancellationSignal, android.support.v4.e.b$b[], int):android.graphics.Typeface");
    }
}