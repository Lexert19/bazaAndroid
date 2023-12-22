package com.example.baza.listener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.baza.activity.AddPhoneActivity;
import com.example.baza.activity.EditPhoneActivity;
import com.example.baza.activity.MainActivity;
import com.example.baza.model.Smartphone;

public class StartEditPhoneActivity implements View.OnClickListener {
    private MainActivity context;
    private Smartphone smartphone;

    public StartEditPhoneActivity(MainActivity context, Smartphone smartphone) {
        this.context = context;
        this.smartphone = smartphone;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, EditPhoneActivity.class);
        Bundle bundle = new Bundle();

        bundle.putParcelable("editedSmartphone", smartphone);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, EditPhoneActivity.REQUEST_CODE);
    }
}
