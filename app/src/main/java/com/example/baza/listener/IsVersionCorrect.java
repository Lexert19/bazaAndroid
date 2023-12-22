package com.example.baza.listener;

import android.view.View;

import com.example.baza.R;
import com.example.baza.activity.AddPhoneActivity;

public class IsVersionCorrect implements View.OnFocusChangeListener {
    private AddPhoneActivity context;

    public IsVersionCorrect(AddPhoneActivity context) {
        this.context = context;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        String error = context.getString(R.string.versionError);
        if(!hasFocus){
            if(context.getVersionEditText().getText().toString().length() == 0){
                context.getVersionEditText().setError(error);
            }
        }

    }
}
