package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String RESPONSE1 = "com.example.myfirstapp.RESPONSE1";
    public static final String RESPONSE2 = "com.example.myfirstapp.RESPONSE2";
    public static final String RESPONSE3 = "com.example.myfirstapp.RESPONSE3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDatePicker(View view) {
        // TODO: open DatePicker
    }

    // send the information from activity_main to activity_response and activate activity_response
    public void sendForm(View view) {
        if (!checkForm()){
            return;
        }

        Intent intent = createIntentResponse();

        startActivity(intent);

    }

    private Intent createIntentResponse() {

        Intent intent = new Intent(this, ResponseActivity.class);

        // Creating Response 1
        EditText inputNombre = (EditText) findViewById(R.id.inputNombre);
        EditText inputApellido = (EditText) findViewById(R.id.inputApellido);

        String response1 = "Hola!, mi nombre es: " + inputNombre.getText().toString() + " " + inputApellido.getText().toString() + ".";

        // Creating Response 2
        Spinner spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        Button buttonNacimiento = (Button) findViewById(R.id.buttonNacimiento);

        String response2 = "Soy " + spinnerGenero.getSelectedItem().toString() + ", y naci en fecha " + buttonNacimiento.getText().toString() + ".";

        // Creating Response 3
        String response3 = "";
        RadioButton radioNo = (RadioButton) findViewById(R.id.radioNo);
        CheckBox java = (CheckBox) findViewById(R.id.checkJava);
        CheckBox python = (CheckBox) findViewById(R.id.checkPython);
        CheckBox JS = (CheckBox) findViewById(R.id.checkJS);
        CheckBox Go = (CheckBox) findViewById(R.id.checkGo);
        CheckBox C = (CheckBox) findViewById(R.id.checkC);
        CheckBox CSharp = (CheckBox) findViewById(R.id.checkCSharp);

        if (radioNo.isChecked()){
            response3 = "No me gusta programar.";
        }else {
            response3 = "Me gusta programar.";

            if (java.isChecked() || python.isChecked() || JS.isChecked() || Go.isChecked() || C.isChecked() || CSharp.isChecked()){
                response3 += " Mis lenguajes favoritos son:";
                if (java.isChecked()){
                    response3 += " Java,";
                }
                if (python.isChecked()){
                    response3 += " Python,";
                }
                if (JS.isChecked()){
                    response3 += " JS,";
                }
                if (Go.isChecked()){
                    response3 += " Go lang,";
                }
                if (C.isChecked()){
                    response3 += " C/C++,";
                }
                if (CSharp.isChecked()){
                    response3 += " C #,";
                }
                response3 += ".";
            }
        }

        // Add responses to intense
        intent.putExtra(RESPONSE1, response1);
        intent.putExtra(RESPONSE2, response2);
        intent.putExtra(RESPONSE3, response3);

        return intent;
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
        /*Button buttonNacimiento = (Button) findViewById(R.id.buttonNacimiento);
        if (buttonNacimiento.getText().toString().equalsIgnoreCase("Fecha de Nacimiento")){
            //TODO: add dialog for Nacimiento
            return false;
        }*/

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