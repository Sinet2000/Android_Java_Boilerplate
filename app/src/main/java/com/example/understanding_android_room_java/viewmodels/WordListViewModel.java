package com.example.understanding_android_room_java.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.understanding_android_room_java.data.models.Word;
import com.example.understanding_android_room_java.data.repository.WordRepository;

import java.util.List;

public class WordListViewModel extends ViewModel {

    private WordRepository wordRepository;

    public LiveData<List<Word>> words;

    public WordListViewModel(@NonNull WordRepository wordRepository) {
        super();
        this.wordRepository = wordRepository;
        this.words = this.wordRepository.getWords();
    }

    public void insert(Word word) {
        wordRepository.insert(word);
    }
}
