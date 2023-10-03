package com.example.tarea3room.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tarea3room.Dao.TaskDao;
import com.example.tarea3room.Entities.Task;

import java.util.List;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<Task>> tasks;

    public TaskRepository(Application application) {
        this.taskDao = TaskDatabase.getInstance(application.getApplicationContext()).getDb().taskDao();
        this.tasks = taskDao.getAll();
    }

    LiveData<List<Task>> getTasks(){
        return tasks;
    }

    LiveData<Task> getTask(int id){
        return taskDao.getById(id);
    }

    void insert(Task task){
        taskDao.insert(task);
    }

    void delete(Task task){
        taskDao.delete(task);
    }

    void update(Task task){
        taskDao.update(task);
    }

}
