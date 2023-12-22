package com.example.baza.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baza.R;
import com.example.baza.SmartphoneRoomDatabase;
import com.example.baza.activity.MainActivity;
import com.example.baza.adapter.SmartphoneListAdapter;
import com.example.baza.listener.StartAddPhoneActivity;
import com.example.baza.listener.StartEditPhoneActivity;
import com.example.baza.model.Smartphone;

public class SmartPhoneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView producer;
    private TextView model;
    private TextView version;
    private TextView website;
    private View itemView;
    private MainActivity context;
    private Smartphone smartphone;
    private SmartphoneListAdapter.OnItemClickListener onItemClickListener;
    public SmartPhoneViewHolder(@NonNull View itemView, SmartphoneListAdapter.OnItemClickListener clickListener) {
        super(itemView);

        this.onItemClickListener = clickListener;
        this.itemView = itemView;
        context = (MainActivity) itemView.getContext();
        findViews();
    }

    private void findViews(){
        producer = itemView.findViewById(R.id.producer);
        model = itemView.findViewById(R.id.model);
        version = itemView.findViewById(R.id.version);
        website = itemView.findViewById(R.id.website);
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onItemClickListener(smartphone);
    }

    /*private void setListeners(){
        StartEditPhoneActivity startEditPhoneActivity = new StartEditPhoneActivity(context, smartphone);
        itemView.setOnClickListener(startEditPhoneActivity);
    }*/

    public void setSmartphone(Smartphone smartphone){
        this.smartphone = smartphone;
        setModel(smartphone.getModel());
        setVersion(smartphone.getVersion());
        setProducer(smartphone.getProducer());
        setWebsite(smartphone.getWebsiteAddress());

        //setListeners();
    }

    public void setProducer(String value){
        producer.setText(value);
    }

    public void setVersion(String value){
        version.setText(value);
    }

    public void setModel(String value){
        model.setText(value);
    }

    public void setWebsite(String value){
        website.setText(value);
    }


    public String getModel(){
        return model.getText().toString();
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }


}
