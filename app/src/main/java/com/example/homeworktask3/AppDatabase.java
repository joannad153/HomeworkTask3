package com.example.homeworktask3;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Cat.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CatDAO catDao();

    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "catDb")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
