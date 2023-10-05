package com.example.testroom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.testroom2.data.Task;

public class AddTask extends AppCompatActivity {

    EditText editText;
    Button buttonAdd;
    Button buttonRegresar;

    static String TEXT_TASK = "TEXT_TASK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editText = findViewById(R.id.editTextAddTask);
        buttonAdd = findViewById(R.id.buttonAgregar);
        buttonRegresar = findViewById(R.id.buttonRegresar);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editText.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                }else{
                    String text = editText.getText().toString();
                    replyIntent.putExtra(TEXT_TASK, text);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                setResult(RESULT_CANCELED, replyIntent);
                finish();
            }
        });

    }


}