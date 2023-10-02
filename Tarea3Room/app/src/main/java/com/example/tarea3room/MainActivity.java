package com.example.tarea3room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;

import android.os.Bundle;

import com.example.tarea3room.Dao.TaskDao;
import com.example.tarea3room.Database.AppDatabase;
import com.example.tarea3room.Database.TaskDatabase;

public class MainActivity extends AppCompatActivity {

    private TaskDao taskDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AppDatabase db = TaskDatabase.getInstance(getApplicationContext()).getDb();
        //taskDao = db.taskDao();
    }
}