package com.example.baza.listener;

import android.view.View;

import com.example.baza.R;
import com.example.baza.activity.AddPhoneActivity;

public class IsModelCorrect implements View.OnFocusChangeListener {
    private AddPhoneActivity context;

    public IsModelCorrect(AddPhoneActivity context) {
        this.context = context;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        String error = context.getString(R.string.modelError);
        if(!hasFocus){
            if(context.getModelEditText().getText().toString().length() == 0){
                context.getModelEditText().setError(error);
            }
        }

    }
}
