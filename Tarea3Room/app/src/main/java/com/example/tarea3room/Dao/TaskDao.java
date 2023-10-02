package com.example.tarea3room.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tarea3room.Entities.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("Select * FROM task")
    List<Task> getAll();

    @Query("Select * FROM task WHERE id = :id")
    Task getById(int id);

    @Insert
    void insert(Task task);

    @Delete
    void delete(Task task);

    @Update
    void update(Task task);

}
