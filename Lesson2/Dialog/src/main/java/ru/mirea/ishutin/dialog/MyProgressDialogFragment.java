package ru.mirea.ishutin.dialog;

import android.app.ProgressDialog;
import android.content.Context;

public class MyProgressDialogFragment extends ProgressDialog {
    public MyProgressDialogFragment(Context context) {
        super(context);
    }

    public MyProgressDialogFragment(Context context, int theme) {
        super(context, theme);
    }
}
