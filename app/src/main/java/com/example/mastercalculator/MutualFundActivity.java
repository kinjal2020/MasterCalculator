package com.example.mastercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MutualFundActivity extends AppCompatActivity {

    private ImageView backArrow;
    private EditText editTextMutualFund;
    private EditText editTextReturn;
    private EditText editTextTimePeriod;
    private TextView textViewTotal;
    private TextView textViewInvested;
    private TextView textViewEstReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_fund);
        initBinding();

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initBinding() {
        backArrow = findViewById(R.id.bacKArrow);
        editTextMutualFund = findViewById(R.id.editTextMutualFund);
        editTextReturn = findViewById(R.id.editTextReturn);
        editTextTimePeriod = findViewById(R.id.editTextTimePeriod);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewEstReturn = findViewById(R.id.textViewEstReturn);
        textViewInvested = findViewById(R.id.textViewInvested);
    }

    public void calculateMutualFund(View view) {
        String mutualFund = editTextMutualFund.getText().toString();
        String expectedReturn = editTextReturn.getText().toString();
        String timePeriod = editTextTimePeriod.getText().toString();

        if (TextUtils.isEmpty(mutualFund)) {
            editTextMutualFund.setError("Enter Mutual Fund amount");
        } else if (TextUtils.isEmpty(expectedReturn)) {
            editTextReturn.setError("Enter the expected return");
        } else if (TextUtils.isEmpty(timePeriod)) {
            editTextTimePeriod.setError("Enter time period in year");
        } else {
            float mf = Float.parseFloat(mutualFund);
            float r = Float.parseFloat(expectedReturn);
            int t = Integer.parseInt(timePeriod)*12;
            int n = 12;
            double maturityAmount = mf * (Math.pow(1 + r / 100,t));
            double estReturn=maturityAmount-mf;
            textViewTotal.setText("₹ "+String.valueOf((int)maturityAmount));
            textViewEstReturn.setText("₹ "+String.valueOf((int)estReturn));
            textViewInvested.setText("₹ "+mutualFund);

            Log.i("TAG", "calculateMutualFund: " + "" + maturityAmount);
        }
    }

    public void clearAll(View view) {
        editTextMutualFund.setText("");
        editTextReturn.setText("");
        editTextTimePeriod.setText("");
        textViewTotal.setText("---");
        textViewInvested.setText("---");
    }
}