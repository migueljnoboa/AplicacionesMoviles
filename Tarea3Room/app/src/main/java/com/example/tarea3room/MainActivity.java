package com.example.tarea3room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.tarea3room.Adapter.TaskAdapterList;
import com.example.tarea3room.Dao.TaskDao;
import com.example.tarea3room.Database.AppDatabase;
import com.example.tarea3room.Database.TaskDatabase;

public class MainActivity extends AppCompatActivity {

    private TaskDao taskDao;
    private Button btnAddTask;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = TaskDatabase.getInstance(getApplicationContext()).getDb();
        btnAddTask = findViewById(R.id.addTaskBtn);
        listView = findViewById(R.id.listView);

        //TODO: Apply Live Data

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, IngresarTarea.class);
                startActivity(i);
            }
        });
    }
}