package com.example.understanding_android_room_java.viewmodels.factories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.understanding_android_room_java.data.repository.WordRepository;
import com.example.understanding_android_room_java.viewmodels.WordListViewModel;

public class WordListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private WordRepository wordRepository;

    public WordListViewModelFactory(@NonNull WordRepository wordRepository) {
        super();
        this.wordRepository = wordRepository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new WordListViewModel(wordRepository);
    }
}
