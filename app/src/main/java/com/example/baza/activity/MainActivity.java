package com.example.baza.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.baza.R;
import com.example.baza.callback.SmartphoneTouchCallback;
import com.example.baza.model.Smartphone;
import com.example.baza.adapter.SmartphoneListAdapter;
import com.example.baza.SmartphoneRoomDatabase;
import com.example.baza.viewHolder.SmartPhoneViewHolder;
import com.example.baza.viewModel.SmartphoneViewModel;
import com.example.baza.listener.StartAddPhoneActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements SmartphoneListAdapter.OnItemClickListener{

    private SmartphoneViewModel smartphoneViewModel;
    private SmartphoneListAdapter smartphoneListAdapter;
    private RecyclerView smartphoneRecyclerView;
    private FloatingActionButton addSmartphoneButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
        createSmartphoneRecyclerView();
        getSmartphones();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == AddPhoneActivity.REQUEST_CODE){
            if (resultCode == RESULT_OK){
                addSmartphoneToDatabase(data);
            }
        }else if(requestCode == EditPhoneActivity.REQUEST_CODE){
            if(resultCode == RESULT_OK){
                updateSmartphoneInDatabase(data);
            }
        }
    }

    private void addSmartphoneToDatabase(Intent data){
        Bundle bundle = data.getExtras();
        Smartphone smartphone = bundle.getParcelable("returnedSmartphone");

        SmartphoneRoomDatabase.databaseWriteExecutor.execute(()->{
            try{
                smartphoneViewModel.insert(smartphone);
            }catch (SQLiteConstraintException e){

            }catch (Exception e){

            }

        });
    }

    private void updateSmartphoneInDatabase(Intent data){
        Bundle bundle = data.getExtras();
        Smartphone smartphone = bundle.getParcelable("returnedSmartphone");

        SmartphoneRoomDatabase.databaseWriteExecutor.execute(()->{
            smartphoneViewModel.update(smartphone);
        });
    }

    private void findViews(){
        smartphoneRecyclerView = findViewById(R.id.smartphoneRecyclerView);
        addSmartphoneButton = findViewById(R.id.addSmartphoneButton);
    }

    private void setListeners(){
        StartAddPhoneActivity startAddPhoneActivity = new StartAddPhoneActivity(this);
        addSmartphoneButton.setOnClickListener(startAddPhoneActivity);
    }

    private void createSmartphoneRecyclerView(){

        SmartphoneTouchCallback callback = new SmartphoneTouchCallback(this,0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);

        smartphoneListAdapter = new SmartphoneListAdapter(this);
        smartphoneRecyclerView.setAdapter(smartphoneListAdapter);

        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(smartphoneRecyclerView);

        smartphoneRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        smartphoneViewModel = new ViewModelProvider(this).get(SmartphoneViewModel.class);
    }
    private void getSmartphones(){
        smartphoneViewModel.getAllSmartphones().observe(this, smartphones -> {
            smartphoneListAdapter.setSmartphoneList(smartphones);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.delete_all_option){
            smartphoneViewModel.deleteAll();
            return true;
        }else {
            return  super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClickListener(Smartphone smartphone) {
        Intent intent = new Intent(this, EditPhoneActivity.class);
        Bundle bundle = new Bundle();

        bundle.putParcelable("editedSmartphone", smartphone);
        intent.putExtras(bundle);
        startActivityForResult(intent, EditPhoneActivity.REQUEST_CODE);
    }

    public SmartphoneViewModel getSmartphoneViewModel() {
        return smartphoneViewModel;
    }
}