package com.example.collectorexpress.retrofit;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;

import androidx.appcompat.app.AlertDialog;

public class MyProgressDialog extends AlertDialog {
    public MyProgressDialog(Context context) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

//    @Override
//    public void show() {
//        super.show();
//        setContentView(R.layout.dialog_progress);
//    }
}