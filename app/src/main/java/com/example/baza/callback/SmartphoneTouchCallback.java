package com.example.baza.callback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baza.SmartphoneRoomDatabase;
import com.example.baza.activity.MainActivity;
import com.example.baza.model.Smartphone;
import com.example.baza.viewHolder.SmartPhoneViewHolder;

public class SmartphoneTouchCallback extends ItemTouchHelper.SimpleCallback {
    private MainActivity context;

    public SmartphoneTouchCallback(MainActivity context, int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
        this.context = context;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        SmartPhoneViewHolder smartPhoneViewHolder = (SmartPhoneViewHolder) viewHolder;
        Smartphone smartphone = smartPhoneViewHolder.getSmartphone();
        SmartphoneRoomDatabase.databaseWriteExecutor.execute(()->{
            context.getSmartphoneViewModel().delete(smartphone);
        });
    }
}
