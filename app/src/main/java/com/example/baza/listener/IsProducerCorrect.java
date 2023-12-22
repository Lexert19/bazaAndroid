package com.example.baza.listener;

import android.view.View;

import com.example.baza.R;
import com.example.baza.activity.AddPhoneActivity;

public class IsProducerCorrect implements View.OnFocusChangeListener {
    private AddPhoneActivity context;

    public IsProducerCorrect(AddPhoneActivity context) {
        this.context = context;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        String error = context.getString(R.string.producerError);
        if(!hasFocus){
            if(context.getProducerEditText().getText().toString().length() == 0){
                context.getProducerEditText().setError(error);
            }
        }

    }
}
