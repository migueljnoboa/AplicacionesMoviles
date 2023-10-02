package com.example.tarea3room.Database;

import android.content.Context;

import androidx.room.Room;

import com.example.tarea3room.Dao.TaskDao;

public class TaskDatabase {

    private static TaskDatabase taskDatabase = null;
    private AppDatabase db = null;

    private TaskDatabase(Context context){
        db = Room.databaseBuilder(context, AppDatabase.class, "Task-Database").build();
    }

    public static TaskDatabase getInstance(Context context){
        if (taskDatabase == null){
            taskDatabase = new TaskDatabase(context);
        }
        return taskDatabase;
    }

    public AppDatabase getDb() {
        return db;
    }
}
