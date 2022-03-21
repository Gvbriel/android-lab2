package com.example.lab2android;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText input_imie;
    EditText input_nazwisko;
    EditText input_oceny;
    Button button_oceny;
    TextView text_podane;

    boolean validatedName = false;
    boolean validatedSurname = false;
    boolean validatedOceny = false;

    void check(){
        if(validatedName && validatedSurname && validatedOceny){
            button_oceny.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        input_imie = findViewById(R.id.input_imie);
        input_nazwisko = findViewById(R.id.input_nazwisko);
        input_oceny = findViewById(R.id.input_oceny);

        outState.putString("imie",input_imie.getText().toString());
        outState.putString("nazwisko",input_nazwisko.getText().toString());
        outState.putString("oceny",input_oceny.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        input_imie = findViewById(R.id.input_imie);
        input_nazwisko = findViewById(R.id.input_nazwisko);
        input_oceny = findViewById(R.id.input_oceny);
        input_imie.setText(savedInstanceState.getString("imie"));
        input_nazwisko.setText(savedInstanceState.getString("nazwisko"));
        input_oceny.setText(savedInstanceState.getString("oceny"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        input_imie = findViewById(R.id.input_imie);
        input_nazwisko = findViewById(R.id.input_nazwisko);
        input_oceny = findViewById(R.id.input_oceny);
        button_oceny = findViewById(R.id.button_oceny);
        text_podane = findViewById(R.id.text_podane);

        button_oceny.setVisibility(View.GONE);

        input_oceny.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty()){
//                    int input = Integer.parseInt(editable.toString());
                    if(Integer.parseInt(editable.toString()) <= 5 || Integer.parseInt(editable.toString()) >= 15){
                        input_oceny.setError("Liczba musi byc miedzy 5 a 15!");
                    }else{
                        validatedOceny = true;
                        check();
                    }
                }
            }
        });

        input_imie.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                    input_imie.setError("Pole nie moze byc puste!");
                }else{
                    validatedName = true;
                    check();
                }
            }
        });

        input_nazwisko.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                    input_nazwisko.setError("Pole nie moze byc puste!");
                }else{
                    validatedSurname = true;
                    check();
                }
            }
        });


    }
}