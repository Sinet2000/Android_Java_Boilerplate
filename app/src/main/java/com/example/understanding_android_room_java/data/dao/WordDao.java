package com.example.understanding_android_room_java.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.understanding_android_room_java.data.models.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Word> words);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    @Query("SELECT * FROM word_table WHERE word = :word")
    LiveData<Word> getWord(String word);
}
