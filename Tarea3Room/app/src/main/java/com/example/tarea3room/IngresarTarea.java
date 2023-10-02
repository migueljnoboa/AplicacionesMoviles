package com.example.tarea3room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tarea3room.Dao.TaskDao;
import com.example.tarea3room.Database.AppDatabase;
import com.example.tarea3room.Database.TaskDatabase;

public class IngresarTarea extends AppCompatActivity {

    private Button btnReturn;
    private Button btnSave;
    private TaskDao taskDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_tarea);

        taskDao = TaskDatabase.getInstance(getApplicationContext()).getDb().taskDao();
        btnReturn = findViewById(R.id.btnReturn);
        btnSave = findViewById(R.id.btnSave);

    }


    // BUTTON SAVE: then return to Main
    public void saveTaskMain(View view) {

        //TODO: Add new task

        startActivity(new Intent(IngresarTarea.this, MainActivity.class));
    }

    // BUTTON RETURN: return to Main
    public void returnMain(View view) {

        startActivity(new Intent(IngresarTarea.this, MainActivity.class));
    }
}