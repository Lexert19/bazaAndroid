package com.example.baza.listener;

import android.view.View;

import com.example.baza.R;
import com.example.baza.activity.AddPhoneActivity;

public class IsWebsiteCorrect implements View.OnFocusChangeListener {
    private AddPhoneActivity context;

    public IsWebsiteCorrect(AddPhoneActivity context) {
        this.context = context;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        String error = context.getString(R.string.websiteError);
        if(!hasFocus){
            if(context.getWebsiteEditText().getText().toString().length() == 0){
                context.getWebsiteEditText().setError(error);
            }
        }

    }
}
