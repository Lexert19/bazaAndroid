package com.example.baza;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.baza.dao.SmartphoneDao;
import com.example.baza.model.Smartphone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Smartphone.class}, version = 1, exportSchema = false)
public abstract class SmartphoneRoomDatabase extends RoomDatabase {
    public abstract SmartphoneDao smartphoneDao();
    private static volatile SmartphoneRoomDatabase INSTANCE;


    public static SmartphoneRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
             synchronized (SmartphoneRoomDatabase.class){
                 if(INSTANCE == null){
                     INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                             SmartphoneRoomDatabase.class, "smartphone_database")
                             .addCallback(sRoomDatabaseCallback)
                             .fallbackToDestructiveMigration()
                             .build();
                 }
             }
        }
        return INSTANCE;
    }

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(()->{
                SmartphoneDao dao = INSTANCE.smartphoneDao();

                Smartphone smartphone = new Smartphone();
                smartphone.setModel("pixel_69");
                smartphone.setProducer("alphabet");
                smartphone.setVersion("69.0");
                smartphone.setWebsiteAddress("google.com");
                dao.insert(smartphone);

                Smartphone sm = new Smartphone();
                sm.setModel("pixel_70");
                sm.setProducer("alphabet");
                sm.setVersion("69.0");
                sm.setWebsiteAddress("google.com");
                dao.insert(sm);
            });

        }
    };
    @Override
    public void clearAllTables() {

    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return null;
    }
}
