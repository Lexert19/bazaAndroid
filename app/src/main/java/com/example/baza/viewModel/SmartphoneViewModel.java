package com.example.baza.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.baza.model.Smartphone;
import com.example.baza.repository.SmartphoneRepository;

import java.util.List;

public class SmartphoneViewModel extends AndroidViewModel {
    private final SmartphoneRepository smartphoneRepository;
    private final LiveData<List<Smartphone>> allSmartphones;

    public SmartphoneViewModel(@NonNull Application application){
        super(application);
        smartphoneRepository = new SmartphoneRepository(application);

        allSmartphones = getAllSmartphones();
    }

    public LiveData<List<Smartphone>> getAllSmartphones(){
        return smartphoneRepository.getAllSmartphones();
    }

    public void insert(Smartphone smartphone){
        smartphoneRepository.insert(smartphone);
    }

    public void delete(Smartphone smartphone){
        smartphoneRepository.delete(smartphone);
    }

    public void update(Smartphone smartphone){
        smartphoneRepository.update(smartphone);
    }

    public  void deleteAll(){
        smartphoneRepository.deleteAll();
    }

}
