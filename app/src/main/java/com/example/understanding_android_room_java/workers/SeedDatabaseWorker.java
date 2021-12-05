package com.example.understanding_android_room_java.workers;

import android.content.Context;
import android.util.Log;

import com.example.understanding_android_room_java.data.AppDatabase;
import com.example.understanding_android_room_java.data.models.Word;
import com.google.gson.stream.JsonReader;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.understanding_android_room_java.utilities.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class SeedDatabaseWorker  extends Worker {

    private static  final String TAG = SeedDatabaseWorker.class.getSimpleName();
    /**
     * @param appContext The application {@link Context}
     * @param workerParams Parameters to setup the initial state of this worker
     */
    public SeedDatabaseWorker(@NonNull Context appContext, @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            InputStream input = getApplicationContext().getAssets().open(Constants.WORD_DATA_FILENAME);
            JsonReader reader = new JsonReader(new InputStreamReader(input));
            Type wordType = new TypeToken<List<Word>>(){}.getType();
            List<Word> wordList = new Gson().fromJson(reader, wordType);
            input.close();

            AppDatabase database = AppDatabase.getInstance(getApplicationContext());
            database.getWordDao().insertAll(wordList);

            return Result.success();
        } catch (IOException e) {
            Log.e(TAG, "Error seeding database", e);
            return Result.failure();
        }

    }
}
