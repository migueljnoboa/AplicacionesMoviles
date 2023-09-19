package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDatePicker(View view) {

    }

    public void sendForm(View view) {
        if (checkForm()){

            return;
        }
    }

    // Verify the all the data makes sence before sending the form
    private boolean checkForm() {
        boolean check = true;

        // Check if Nombre is Empty
        EditText inputNombre = (EditText) findViewById(R.id.inputNombre);
        if(inputNombre.getText().toString().equalsIgnoreCase("")){
            //TODO: Add dialog for Nombre
            return false;
        }

        // Check if Apellido is Empty
        EditText inputApellido = (EditText) findViewById(R.id.inputApellido);
        if(inputApellido.getText().toString().equalsIgnoreCase("")){
            //TODO: add dialog for Apellido
            return false;
        }

        // Check if Genero is at 0
        Spinner spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        if (spinnerGenero.getSelectedItemPosition() == 0){
            //TODO: add dialog for Genero
            return false;
        }

        // Check if a Date for Nacimiento has been picked or if its default
        Button buttonNacimiento = (Button) findViewById(R.id.buttonNacimiento);
        if (buttonNacimiento.getText().toString().equalsIgnoreCase("Fecha de Nacimiento")){
            //TODO: add dialog for Nacimiento
            return false;
        }

        // Check if "Le Gusta Programar" is set Right
        CheckBox java = (CheckBox) findViewById(R.id.checkJava);
        CheckBox python = (CheckBox) findViewById(R.id.checkPython);
        CheckBox JS = (CheckBox) findViewById(R.id.checkJS);
        CheckBox Go = (CheckBox) findViewById(R.id.checkGo);
        CheckBox C = (CheckBox) findViewById(R.id.checkC);
        CheckBox CSharp = (CheckBox) findViewById(R.id.checkCSharp);
        RadioButton radioNo = (RadioButton) findViewById(R.id.radioNo);
        if (radioNo.isChecked() &&
                (java.isChecked()
                || python.isChecked()
                || JS.isChecked()
                || Go.isChecked()
                || C.isChecked()
                || CSharp.isChecked())){
            // TODO: add dialog for Programar
            return false;
        }
        return true;
    }

    // Reset everything to its original values when the "Limpar" button is clicked
    public void cleanForm(View view) {

        // Clean Nombre
        EditText inputNombre = (EditText) findViewById(R.id.inputNombre);
        inputNombre.setText("");

        // Clean Apellido
        EditText inputApellido = (EditText) findViewById(R.id.inputApellido);
        inputApellido.setText("");

        // Clean Genero
        Spinner spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        spinnerGenero.setSelection(0);

        // Clean Nacimiento
        Button buttonNacimiento = (Button) findViewById(R.id.buttonNacimiento);
        buttonNacimiento.setText("Fecha de Nacimiento");

        // Clean Radio Group
        RadioButton radioSi = findViewById(R.id.radioSi);
        radioSi.setChecked(true);

        // Clean Check Boxes
        CheckBox java = (CheckBox) findViewById(R.id.checkJava);
        CheckBox python = (CheckBox) findViewById(R.id.checkPython);
        CheckBox JS = (CheckBox) findViewById(R.id.checkJS);
        CheckBox Go = (CheckBox) findViewById(R.id.checkGo);
        CheckBox C = (CheckBox) findViewById(R.id.checkC);
        CheckBox CSharp = (CheckBox) findViewById(R.id.checkCSharp);
        java.setChecked(false);
        python.setChecked(false);
        JS.setChecked(false);
        Go.setChecked(false);
        C.setChecked(false);
        CSharp.setChecked(false);

    }
}