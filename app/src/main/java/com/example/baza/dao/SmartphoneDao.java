package com.example.baza.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.baza.model.Smartphone;

import java.util.List;

@Dao
public interface SmartphoneDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(Smartphone smartphone);

    @Update
    void update(Smartphone smartphone);

    @Query("SELECT * FROM smartphone")
    LiveData<List<Smartphone>> getAllSmartphones();


    @Query("DELETE FROM smartphone")
    void deleteAllElements();

    @Delete
    void delete(Smartphone smartphone);
}
