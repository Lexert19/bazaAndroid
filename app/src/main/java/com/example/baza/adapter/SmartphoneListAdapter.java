package com.example.baza.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baza.R;
import com.example.baza.activity.MainActivity;
import com.example.baza.viewHolder.SmartPhoneViewHolder;
import com.example.baza.model.Smartphone;

import java.util.List;

public class SmartphoneListAdapter extends RecyclerView.Adapter<SmartPhoneViewHolder> {
    private List<Smartphone> smartphoneList;
    private LayoutInflater layoutInflater;

    public interface OnItemClickListener{
        void onItemClickListener(Smartphone smartphone);
    }

    private OnItemClickListener onItemClickListener;
    public SmartphoneListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        try{
            this.onItemClickListener = (MainActivity) context;
        }catch (ClassCastException e){

        }
        smartphoneList = null;
    }

    public void setSmartphoneList(List<Smartphone> smartphoneList) {
        this.smartphoneList = smartphoneList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SmartPhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.smartphone_row, null);
        return new SmartPhoneViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SmartPhoneViewHolder holder, int position) {
        holder.setSmartphone(smartphoneList.get(position));

    }

    @Override
    public int getItemCount() {
        if(smartphoneList != null)
            return smartphoneList.size();
        return 0;
    }
}
