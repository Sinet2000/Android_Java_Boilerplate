package com.example.understanding_android_room_java.data.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "word_table")
public final class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private final String mWordId;

    @ColumnInfo(name = "word")
    private String mWord;

    public Word(@NonNull String wordId, @NonNull String word) {
        this.mWordId = wordId;
        this.mWord = word;
    }

    public String getWord() {
        return this.mWord;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof Word
                && this.mWordId.equals(((Word) obj).mWordId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mWordId);
    }

    @Override
    protected Object clone() {
        return new Word(mWordId, mWord);
    }
}
