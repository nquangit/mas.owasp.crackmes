package android.support.v4.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public class h {
    public static File a(Context context) {
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(context.getCacheDir(), str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static ByteBuffer a(Context context, Resources resources, int i) {
        File a = a(context);
        if (a == null) {
            return null;
        }
        try {
            if (a(a, resources, i)) {
                return a(a);
            }
            return null;
        } finally {
            a.delete();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.nio.ByteBuffer a(android.content.Context r8, android.os.CancellationSignal r9, android.net.Uri r10) {
        /*
            android.content.ContentResolver r8 = r8.getContentResolver()
            r0 = 0
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r8 = r8.openFileDescriptor(r10, r1, r9)     // Catch: java.io.IOException -> L67
            if (r8 != 0) goto L13
            if (r8 == 0) goto L12
            r8.close()     // Catch: java.io.IOException -> L67
        L12:
            return r0
        L13:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L50
            java.io.FileDescriptor r10 = r8.getFileDescriptor()     // Catch: java.lang.Throwable -> L50
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L50
            java.nio.channels.FileChannel r1 = r9.getChannel()     // Catch: java.lang.Throwable -> L38
            long r5 = r1.size()     // Catch: java.lang.Throwable -> L38
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L38
            r3 = 0
            java.nio.MappedByteBuffer r10 = r1.map(r2, r3, r5)     // Catch: java.lang.Throwable -> L38
            r9.close()     // Catch: java.lang.Throwable -> L50
            if (r8 == 0) goto L34
            r8.close()     // Catch: java.io.IOException -> L67
        L34:
            return r10
        L35:
            r10 = move-exception
            r1 = r0
            goto L3e
        L38:
            r10 = move-exception
            throw r10     // Catch: java.lang.Throwable -> L3a
        L3a:
            r1 = move-exception
            r7 = r1
            r1 = r10
            r10 = r7
        L3e:
            if (r1 == 0) goto L49
            r9.close()     // Catch: java.lang.Throwable -> L44
            goto L4c
        L44:
            r9 = move-exception
            r1.addSuppressed(r9)     // Catch: java.lang.Throwable -> L50
            goto L4c
        L49:
            r9.close()     // Catch: java.lang.Throwable -> L50
        L4c:
            throw r10     // Catch: java.lang.Throwable -> L50
        L4d:
            r9 = move-exception
            r10 = r0
            goto L56
        L50:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> L52
        L52:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L56:
            if (r8 == 0) goto L66
            if (r10 == 0) goto L63
            r8.close()     // Catch: java.lang.Throwable -> L5e
            goto L66
        L5e:
            r8 = move-exception
            r10.addSuppressed(r8)     // Catch: java.io.IOException -> L67
            goto L66
        L63:
            r8.close()     // Catch: java.io.IOException -> L67
        L66:
            throw r9     // Catch: java.io.IOException -> L67
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.h.a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    private static ByteBuffer a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
            fileInputStream.close();
            return map;
        } catch (IOException unused) {
            return null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean a(File file, Resources resources, int i) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            boolean a = a(file, inputStream);
            a(inputStream);
            return a;
        } catch (Throwable th2) {
            th = th2;
            a(inputStream);
            throw th;
        }
    }

    public static boolean a(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            a(fileOutputStream2);
                            return true;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    a(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}