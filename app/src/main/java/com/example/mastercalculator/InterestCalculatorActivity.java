package com.example.mastercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class InterestCalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editTextAmount;
    private EditText editTextRate;
    private EditText editTextTime;
    private TextView textViewAmount;
    private Spinner spinnerTime;


    String[] time = {"Year", "Month"};


    int position = 0;
    private View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_caluclator);
        initBinding();

        spinnerTime.setOnItemSelectedListener(this);
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                time);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spinnerTime.setAdapter(ad);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

    }

    private void initBinding() {
        editTextAmount = findViewById(R.id.editTextPrincipal);
        editTextRate = findViewById(R.id.editTextRate);
        editTextTime = findViewById(R.id.editTextTime);
        textViewAmount = findViewById(R.id.textViewAmount);
        spinnerTime = findViewById(R.id.spinnerTime);
        back = findViewById(R.id.back);
    }

    public void calculateInterest(View view) {
        String amount = editTextAmount.getText().toString();
        String rate = editTextRate.getText().toString();
        String time = editTextTime.getText().toString();

        if (TextUtils.isEmpty(amount)) {
            editTextAmount.setError("Enter principal amount");
        } else if (TextUtils.isEmpty(time)) {
            editTextTime.setError("Enter the time");
        } else if (TextUtils.isEmpty(rate)) {
            editTextRate.setError("Enter rate");
        } else {
            float p = Float.parseFloat(amount);
            float r = Float.parseFloat(rate) / (12 * 100);
            int t;
            if (position == 0) {
                t = Integer.parseInt(time) * 12;
            } else {
                t = Integer.parseInt(time);
            }

            double totalAmount = p * (1 + r * t);
            double interestedAmount = totalAmount - p;
            textViewAmount.setText(String.valueOf(interestedAmount));
        }





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.position = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}