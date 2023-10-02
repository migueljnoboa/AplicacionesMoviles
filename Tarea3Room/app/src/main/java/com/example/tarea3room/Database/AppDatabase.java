package com.example.tarea3room.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tarea3room.Dao.TaskDao;
import com.example.tarea3room.Entities.Task;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
