package com.example.understanding_android_room_java.utilities;

import android.content.Context;

import com.example.understanding_android_room_java.data.AppDatabase;
import com.example.understanding_android_room_java.data.repository.WordRepository;
import com.example.understanding_android_room_java.viewmodels.factories.WordListViewModelFactory;

public class InjectorUtils {
    private static WordRepository getWordRepository(Context context) {
        return WordRepository.getInstance(AppDatabase.getInstance(context.getApplicationContext()).getWordDao());
    }

    public static WordListViewModelFactory provideWordListViewModelFactory(Context context) {
        return new WordListViewModelFactory(getWordRepository(context));
    }
}
