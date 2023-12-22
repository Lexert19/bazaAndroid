package com.example.baza.listener;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.example.baza.activity.AddPhoneActivity;

public class OpenWebsite implements View.OnClickListener {
    private AddPhoneActivity context;

    public OpenWebsite(AddPhoneActivity context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        String url = context.getWebsiteEditText().getText().toString();
        if(!url.startsWith("https://") || !url.startsWith("http://"))
            url = "https://" + url;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);

    }
}
