package com.example.baza.listener;

import static android.app.Activity.RESULT_CANCELED;

import android.view.View;

import com.example.baza.activity.AddPhoneActivity;

public class CancelActivity implements View.OnClickListener {
    private AddPhoneActivity activity;

    public CancelActivity(AddPhoneActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        activity.setResult(RESULT_CANCELED);
        activity.finish();
    }
}
