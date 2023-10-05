package com.example.testroom2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testroom2.Adapter.TaskListAdapter;
import com.example.testroom2.data.Task;
import com.example.testroom2.data.TaskRepository;
import com.example.testroom2.data.TaskViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskViewModel taskViewModel;

    private Button buttonAdd;

    public static final int NEW_TASK_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.taskRecyclerView);
        buttonAdd = findViewById(R.id.buttonAddTaskActivity);

        final TaskListAdapter adapter = new TaskListAdapter(new TaskListAdapter.TaskDiff(), new TaskRepository(getApplication()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        taskViewModel.getAllTasks().observe(this, tasks -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(tasks);
        });



        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTask.class);
                startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Task task = new Task(data.getStringExtra(AddTask.TEXT_TASK), false);
            taskViewModel.insert(task);
        }
    }
}