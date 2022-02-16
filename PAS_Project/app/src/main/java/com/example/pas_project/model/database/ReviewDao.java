package com.example.pas_project.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pas_project.model.Review;

import java.util.List;

@Dao
public interface ReviewDao {

    @Query("SELECT * FROM Review WHERE gameId = :gameId")
    LiveData<Review> getReview(long gameId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addReview(List<Review> commentList);
}
