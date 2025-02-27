package sg.vantagepoint.uncrackable2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.os.SystemClock;
import android.support.v7.app.c;
import android.view.View;
import android.widget.EditText;
import owasp.mstg.uncrackable2.R;
import sg.vantagepoint.a.a;
import sg.vantagepoint.a.b;

/* loaded from: classes.dex */
public class MainActivity extends c {
    private CodeCheck m;

    static {
        System.loadLibrary("foo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setTitle(str);
        create.setMessage("This is unacceptable. The app is now going to exit.");
        create.setButton(-3, "OK", new DialogInterface.OnClickListener() { // from class: sg.vantagepoint.uncrackable2.MainActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        create.setCancelable(false);
        create.show();
    }

    private native void init();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v4, types: [sg.vantagepoint.uncrackable2.MainActivity$2] */
    @Override // android.support.v7.app.c, android.support.v4.app.h, android.support.v4.app.z, android.app.Activity
    public void onCreate(Bundle bundle) {
        init();
        if (b.a() || b.b() || b.c()) {
            a("Root detected!");
        }
        if (a.a(getApplicationContext())) {
            a("App is debuggable!");
        }
        new AsyncTask<Void, String, String>() { // from class: sg.vantagepoint.uncrackable2.MainActivity.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public String doInBackground(Void... voidArr) {
                while (!Debug.isDebuggerConnected()) {
                    SystemClock.sleep(100L);
                }
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(String str) {
                MainActivity.this.a("Debugger detected!");
            }
        }.execute(null, null, null);
        this.m = new CodeCheck();
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
    }

    public void verify(View view) {
        String str;
        String obj = ((EditText) findViewById(R.id.edit_text)).getText().toString();
        AlertDialog create = new AlertDialog.Builder(this).create();
        if (this.m.a(obj)) {
            create.setTitle("Success!");
            str = "This is the correct secret.";
        } else {
            create.setTitle("Nope...");
            str = "That's not it. Try again.";
        }
        create.setMessage(str);
        create.setButton(-3, "OK", new DialogInterface.OnClickListener() { // from class: sg.vantagepoint.uncrackable2.MainActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        create.show();
    }
}