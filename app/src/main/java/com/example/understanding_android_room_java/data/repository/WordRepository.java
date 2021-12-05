package com.example.understanding_android_room_java.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.understanding_android_room_java.data.AppDatabase;
import com.example.understanding_android_room_java.data.dao.WordDao;
import com.example.understanding_android_room_java.data.models.Word;

import java.util.List;

public class WordRepository {
    private static WordRepository instance;
    private WordDao wordDao;

    private WordRepository(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    public static WordRepository getInstance(WordDao wordDao) {
        if (instance == null) {
            synchronized (WordRepository.class) {
                if (instance == null) {
                    instance = new WordRepository(wordDao);
                }
            }
        }
        return instance;
    }

    public LiveData<Word> getWord(String wordId) {
        return this.wordDao.getWord(wordId);
    }

    public LiveData<List<Word>> getWords() {
        return this.wordDao.getAlphabetizedWords();
    }

    public void insert(Word word) {
        A
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
}
