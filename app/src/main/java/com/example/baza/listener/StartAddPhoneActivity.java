package com.example.baza.listener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.baza.activity.AddPhoneActivity;
import com.example.baza.activity.MainActivity;
import com.example.baza.model.Smartphone;

public class StartAddPhoneActivity implements View.OnClickListener {
    private MainActivity context;

    public StartAddPhoneActivity(MainActivity context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, AddPhoneActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivityForResult(intent, AddPhoneActivity.REQUEST_CODE);
    }
}
