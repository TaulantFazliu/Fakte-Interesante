package com.tickks.data;

import androidx.room.*;

import java.util.List;

@Dao
public interface FactDao {

    @Query("SELECT * FROM fact")
    List<Fact> getFacts();

    @Insert
    void saveFact(Fact fact);

    @Insert
    void saveAllFact(List<Fact> facts);

    @Update
    void updateFact(Fact fact);

    @Delete
    void deleteFact(Fact fact);
}

