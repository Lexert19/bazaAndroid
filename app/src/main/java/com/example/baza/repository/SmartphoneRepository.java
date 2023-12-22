package com.example.baza.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.baza.model.Smartphone;
import com.example.baza.dao.SmartphoneDao;
import com.example.baza.SmartphoneRoomDatabase;

import java.util.List;

public class SmartphoneRepository {
    private SmartphoneDao smartphoneDao;
    private LiveData<List<Smartphone>> allElements;

    public SmartphoneRepository(Application application){
        SmartphoneRoomDatabase smartphoneRoomDatabase = SmartphoneRoomDatabase.getDatabase(application);
        smartphoneDao = smartphoneRoomDatabase.smartphoneDao();
        allElements = getAllSmartphones();

    }
    public LiveData<List<Smartphone>> getAllSmartphones(){
        return smartphoneDao.getAllSmartphones();
    }

    public void insert(Smartphone smartphone){
        smartphoneDao.insert(smartphone);
    }

    public void update(Smartphone smartphone){
        smartphoneDao.update(smartphone);
    }

    public void deleteAll(){
        SmartphoneRoomDatabase.databaseWriteExecutor.execute(()->{
            smartphoneDao.deleteAllElements();
        });
    }


    public void delete(Smartphone smartphone) {
        smartphoneDao.delete(smartphone);
    }
}
