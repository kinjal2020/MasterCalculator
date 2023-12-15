package com.example.mastercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class EMICalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private EditText editTextAmount;
    private EditText editTextRate;
    private EditText editTextTime;
    private TextView textViewInterestAmount;
    private TextView textViewTotalInterest;
    private TextView textViewTotalPayableAmount;
    private Spinner spinnerTime;

    ImageView backArrow;

    String[] time = {"Year", "Month"};
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emicalculator);
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


        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    private void initBinding() {
        editTextAmount = findViewById(R.id.editTextLoan);
        editTextRate = findViewById(R.id.editTextInterestRate);
        editTextTime = findViewById(R.id.edTTimePeriod);
        textViewInterestAmount = findViewById(R.id.textViewInterestAmount);
        textViewTotalInterest = findViewById(R.id.textViewTotalInterest);
        textViewTotalPayableAmount = findViewById(R.id.textViewTotalPayableAmount);
        backArrow=findViewById(R.id.backArrow);
        spinnerTime = findViewById(R.id.sTime);
    }


    public void calculateEMI(View view) {
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
            float p=Float.parseFloat(amount);
            float r=Float.parseFloat(rate)/(12*100);
            int t=0;
            if(position==0){
                t=Integer.parseInt(time)*12;
            }
            else{
                t=Integer.parseInt(time);
            }
            double e=p*r*(Math.pow(1+r,t))/(Math.pow(1+r,t)-1);
            double totalPaid= (e*t)-p;
            double totalPayable=p+totalPaid;
            textViewInterestAmount.setText("₹ "+String.valueOf((int) e));
            textViewTotalInterest.setText("₹ "+String.valueOf((int) totalPaid));
            textViewTotalPayableAmount.setText("₹ "+String.valueOf((int) totalPayable));

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