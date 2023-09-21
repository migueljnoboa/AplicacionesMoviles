package com.example.myfirstapp;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String RESPONSE1 = "com.example.myfirstapp.RESPONSE1";
    public static final String RESPONSE2 = "com.example.myfirstapp.RESPONSE2";
    public static final String RESPONSE3 = "com.example.myfirstapp.RESPONSE3";

    private EditText inputNombre;
    private EditText inputApellido;
    private Spinner spinnerGenero;
    private Button buttonNacimiento;
    private RadioButton radioSi;
    private  RadioButton radioNo;
    private CheckBox java;
    private CheckBox python;
    private CheckBox JS;
    private CheckBox Go;
    private CheckBox C;
    private CheckBox CSharp;

    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNombre = (EditText) findViewById(R.id.inputNombre);
        inputApellido = (EditText) findViewById(R.id.inputApellido);
        spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        buttonNacimiento = (Button) findViewById(R.id.buttonNacimiento);
        radioSi = findViewById(R.id.radioSi);
        radioNo = (RadioButton) findViewById(R.id.radioNo);
        java = (CheckBox) findViewById(R.id.checkJava);
        python = (CheckBox) findViewById(R.id.checkPython);
        JS = (CheckBox) findViewById(R.id.checkJS);
        Go = (CheckBox) findViewById(R.id.checkGo);
        C = (CheckBox) findViewById(R.id.checkC);
        CSharp = (CheckBox) findViewById(R.id.checkCSharp);


        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = day + "/" + month + "/" + year;
                buttonNacimiento.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);

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

        String response1 = "Hola!, mi nombre es: " + inputNombre.getText().toString() + " " + inputApellido.getText().toString() + ".";

        String response2 = "Soy " + spinnerGenero.getSelectedItem().toString() + ", y naci en fecha " + buttonNacimiento.getText().toString() + ".";

        // Creating Response 3
        String response3 = "";

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
        if(inputNombre.getText().toString().equalsIgnoreCase("")){

            Toast.makeText(this, "Nombre Invalido", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Check if Apellido is Empty
        if(inputApellido.getText().toString().equalsIgnoreCase("")){

            Toast.makeText(this, "Apellido Invalido", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Check if Genero is at 0
        if (spinnerGenero.getSelectedItemPosition() == 0){

            Toast.makeText(this, "Genero Invalido", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Check if a Date for Nacimiento has been picked or if its default
        Button buttonNacimiento = (Button) findViewById(R.id.buttonNacimiento);
        if (buttonNacimiento.getText().toString().equalsIgnoreCase(this.getString(R.string.defaultDate))){

            Toast.makeText(this, "Fecha Invalido", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Check if "Le Gusta Programar" is set Right
        if (radioNo.isChecked() &&
                (java.isChecked()
                || python.isChecked()
                || JS.isChecked()
                || Go.isChecked()
                || C.isChecked()
                || CSharp.isChecked())){

            Toast.makeText(this, "Si no te gusta programar, no puedes tener lenguajes favoritos.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // Reset everything to its original values when the "Limpar" button is clicked
    public void cleanForm(View view) {

        // Clean Nombre
        inputNombre.setText("");

        // Clean Apellido
        inputApellido.setText("");

        // Clean Genero
        spinnerGenero.setSelection(0);

        // Clean Nacimiento
        buttonNacimiento.setText("Fecha de Nacimiento");

        // Clean Radio Group
        radioSi.setChecked(true);

        // Clean Check Boxes
        java.setChecked(false);
        python.setChecked(false);
        JS.setChecked(false);
        Go.setChecked(false);
        C.setChecked(false);
        CSharp.setChecked(false);

    }

    public void openCalendar(View view) {
        datePickerDialog.show();
    }
}