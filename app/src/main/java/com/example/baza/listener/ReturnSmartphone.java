package com.example.baza.listener;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.baza.model.Smartphone;
import com.example.baza.activity.AddPhoneActivity;

public class ReturnSmartphone implements View.OnClickListener {
    private AddPhoneActivity activity;
    private Smartphone smartphone;

    public ReturnSmartphone(AddPhoneActivity activity, Smartphone smartphone) {
        this.activity = activity;
        this.smartphone = smartphone;
    }

    public ReturnSmartphone(AddPhoneActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        if(!areDataCorrect())
            return;

        Bundle bundle = new Bundle();
        if(smartphone == null)
            smartphone = new Smartphone();
        smartphone.setProducer(activity.getProducerEditText().getText().toString());
        smartphone.setModel(activity.getModelEditText().getText().toString());
        smartphone.setVersion(activity.getVersionEditText().getText().toString());
        smartphone.setWebsiteAddress(activity.getWebsiteEditText().getText().toString());

        bundle.putParcelable("returnedSmartphone", smartphone);

        Intent intent = new Intent();
        intent.putExtras(bundle);
        activity.setResult(RESULT_OK, intent);
        activity.finish();
    }

    private boolean areDataCorrect(){
        if(activity.getProducerEditText().getText().toString().length() == 0)
            return false;
        if(activity.getModelEditText().getText().toString().length() == 0)
            return false;
        if(activity.getVersionEditText().getText().toString().length() == 0)
            return false;
        if(activity.getWebsiteEditText().getText().toString().length() == 0)
            return false;
        return true;
    }
}
