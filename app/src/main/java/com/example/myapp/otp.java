package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class otp extends AppCompatActivity {
    int randdonnumber;
    String  Val;
    Button verifyotp;
    EditText et1,et2,et3,et4,et5,et6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et1 = findViewById(R.id.et1);
        et2= findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5=findViewById(R.id.et5);
        et6=findViewById(R.id.et6);
        EditText[] edit = {et1, et2, et3, et4,et5,et6};

        et1.addTextChangedListener(new GenericTextWatcher(et1, edit));
        et2.addTextChangedListener(new GenericTextWatcher(et2, edit));
        et3.addTextChangedListener(new GenericTextWatcher(et3, edit));
        et4.addTextChangedListener(new GenericTextWatcher(et4, edit));
        et5.addTextChangedListener(new GenericTextWatcher(et5, edit));
        et6.addTextChangedListener(new GenericTextWatcher(et6, edit));


    }
}