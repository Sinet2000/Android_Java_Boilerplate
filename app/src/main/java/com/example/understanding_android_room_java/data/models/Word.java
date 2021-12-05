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
    @ColumnInfo(name = "word")
    private String mWord;

    public Word( @NonNull String word) {
        this.mWord = word;
    }

    public String getWord() {
        return this.mWord;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof Word
                && this.mWord.equals(((Word) obj).mWord);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mWord);
    }

    @Override
    protected Object clone() {
        return new Word(mWord);
    }
}
