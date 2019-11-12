package com.example.homeworktask3;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CatDAO {

    @Query("SELECT * FROM cat)
    List<Cat> getAll();

    @Query("SELECT * FROM cat WHERE id = :id")
    Cat findCatById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Cat> cats);
}
