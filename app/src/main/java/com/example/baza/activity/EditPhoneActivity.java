package com.example.baza.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.baza.R;
import com.example.baza.listener.ReturnSmartphone;
import com.example.baza.model.Smartphone;

public class EditPhoneActivity extends AddPhoneActivity{
    public static final int REQUEST_CODE = 2;
    private Smartphone smartphone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        smartphone = getIntent().getExtras().getParcelable("editedSmartphone");

        changeListeners();
        setTexts();
    }

    private void changeListeners(){
        ReturnSmartphone returnSmartphone = new ReturnSmartphone(this, smartphone);
        saveButton.setOnClickListener(returnSmartphone);
    }

    private void setTexts(){
        saveButton.setText(R.string.edit_button);

        producerEditText.setText(smartphone.getProducer());
        modelEditText.setText(smartphone.getModel());
        versionEditText.setText(smartphone.getVersion());
        websiteEditText.setText(smartphone.getWebsiteAddress());
    }


}
