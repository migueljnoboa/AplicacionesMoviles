package com.example.tarea3room.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tarea3room.Entities.Task;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository repository;
    private final LiveData<List<Task>> tasks;
    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        tasks = repository.getTasks();
    }

    public LiveData<List<Task>> getTasks(){
        return tasks;
    }

    public LiveData<Task> getTask(int id){
        return repository.getTask(id);
    }

    public void insert(Task task){
        repository.insert(task);
    }

    public void delete(Task task){
        repository.delete(task);
    }

    public void update(Task task) {
        repository.update(task);
    }
}
