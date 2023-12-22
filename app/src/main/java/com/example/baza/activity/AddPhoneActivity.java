package com.example.baza.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.baza.R;
import com.example.baza.listener.CancelActivity;
import com.example.baza.listener.IsModelCorrect;
import com.example.baza.listener.IsProducerCorrect;
import com.example.baza.listener.IsVersionCorrect;
import com.example.baza.listener.IsWebsiteCorrect;
import com.example.baza.listener.OpenWebsite;
import com.example.baza.listener.ReturnSmartphone;
import com.example.baza.model.Smartphone;

public class AddPhoneActivity extends Activity {
    public static final int REQUEST_CODE = 1;

    protected EditText producerEditText;
    protected EditText modelEditText;
    protected EditText versionEditText;
    protected EditText websiteEditText;

    protected Button websiteButton;
    protected Button cancelButton;
    protected Button saveButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_phone_activity);

        findViews();
        setListeners();
    }

    private void findViews(){
        producerEditText = findViewById(R.id.producerEditText);
        versionEditText = findViewById(R.id.versionEditText);
        websiteEditText = findViewById(R.id.websiteEditText);
        modelEditText = findViewById(R.id.modelEditText);

        websiteButton = findViewById(R.id.websiteButton);
        cancelButton = findViewById(R.id.cancelButton);
        saveButton = findViewById(R.id.saveButton);
    }

    protected void setListeners(){
        CancelActivity cancelActivity = new CancelActivity(this);
        cancelButton.setOnClickListener(cancelActivity);

        OpenWebsite openWebsite = new OpenWebsite(this);
        websiteButton.setOnClickListener(openWebsite);

        ReturnSmartphone returnSmartphone = new ReturnSmartphone(this);
        saveButton.setOnClickListener(returnSmartphone);

        setErrorListeners();
    }

    protected void setErrorListeners(){
        IsProducerCorrect isProducerCorrect = new IsProducerCorrect(this);
        producerEditText.setOnFocusChangeListener(isProducerCorrect);

        IsVersionCorrect isVersionCorrect = new IsVersionCorrect(this);
        versionEditText.setOnFocusChangeListener(isVersionCorrect);

        IsModelCorrect isModelCorrect = new IsModelCorrect(this);
        modelEditText.setOnFocusChangeListener(isModelCorrect);

        IsWebsiteCorrect isWebsiteCorrect = new IsWebsiteCorrect(this);
        websiteEditText.setOnFocusChangeListener(isWebsiteCorrect);
    }

   /* protected void changeMode(){
        if(mode.equals("edit")){
            saveButton.setText(R.string.edit_button);
            ReturnSmartphone returnSmartphone = new ReturnSmartphone(this, "edit");
            saveButton.setOnClickListener(returnSmartphone);

            Smartphone smartphone = getIntent().getExtras().getParcelable("editedSmartphone");

            producerEditText.setText(smartphone.getProducer());
            modelEditText.setText(smartphone.getModel());
            versionEditText.setText(smartphone.getVersion());
            websiteEditText.setText(smartphone.getWebsiteAddress());
        }
    }*/


    public EditText getProducerEditText() {
        return producerEditText;
    }

    public EditText getModelEditText() {
        return modelEditText;
    }

    public EditText getVersionEditText() {
        return versionEditText;
    }

    public EditText getWebsiteEditText() {
        return websiteEditText;
    }
}
