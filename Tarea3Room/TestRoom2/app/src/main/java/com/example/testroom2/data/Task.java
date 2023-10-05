package com.example.testroom2.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "complete")
    private boolean complete;

    public Task(@NonNull String text, boolean complete) {
        this.text = text;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
