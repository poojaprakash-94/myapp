package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

import com.example.myapp.utils.CountryToPhonePrefix;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    String country;
    int countryPos;
    Spinner spinnerCountryName;
    EditText editTextPhone, editPhoneId;
    CountryToPhonePrefix countryToPhonePrefix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Button Continue = findViewById(R.id.b1);
        editPhoneId = findViewById(R.id.editPhoneId);
        String phoneid = editPhoneId.getText().toString();
        editTextPhone = findViewById(R.id.editPhone1);
        String phonenumber = editTextPhone.getText().toString();
        String val = phoneid + phonenumber;
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phonenumber.trim().isEmpty()) {
                    editTextPhone.setError("Enter Phone No");
                } else {
                    Intent i = new Intent(Login.this, otp.class);
                    i.putExtra("phone", val.trim());
                    startActivity(i);
                    finish();
                }
            }
        });
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView textView = (TextView) findViewById(R.id.text1);
        spinnerCountryName = findViewById(R.id.spinnerCountry);
        editTextPhone = findViewById(R.id.editPhone1);
        editPhoneId = findViewById(R.id.editPhoneId);
        Button b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), otp.class);
                startActivity(in);
            }
        });
        countryToPhonePrefix = new CountryToPhonePrefix();

        ArrayList<CountryToPhonePrefix> list = (ArrayList<CountryToPhonePrefix>) countryToPhonePrefix.getAll();
        ArrayAdapter<CountryToPhonePrefix> adapter =
                new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCountryName.setAdapter(adapter);

        spinnerCountryName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country = spinnerCountryName.getSelectedItem().toString();
                countryPos = spinnerCountryName.getSelectedItemPosition();

                CountryToPhonePrefix categories = (CountryToPhonePrefix) parent.getItemAtPosition(position);
                editPhoneId.setText("+" + categories.getPrefix());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        textView.setClickable(true);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                alertDialog.setTitle("We will be Verifying the phone number:");
                alertDialog.setMessage("Is this OK,or would you like to edit the number?");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "EDIT",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                Button btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#0099FF"));
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#0099FF"));

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();
                layoutParams.weight = 10;
                btnPositive.setLayoutParams(layoutParams);
                btnNegative.setLayoutParams(layoutParams);
            }
        });


    }

    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);

        }
        return true;
    }

}




