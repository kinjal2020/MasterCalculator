package com.example.mastercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CalculationUtilitiesActivity extends AppCompatActivity {

    private ImageView nextMutualFund;
    private ImageView nextInterest;
    private ImageView nextDiscount;
    private ImageView nextEmi;
    private ImageView nextSchoolResult;
    private ImageView nextSquare;
    private View back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_utilities);
        initBinding();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             finish();
            }
        });

        nextMutualFund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculationUtilitiesActivity.this, MutualFundActivity.class);
                startActivity(intent);
            }
        });

        nextInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculationUtilitiesActivity.this, InterestCalculatorActivity.class);
                startActivity(intent);
            }
        });

        nextEmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculationUtilitiesActivity.this, EMICalculatorActivity.class);
                startActivity(intent);
            }
        });

        nextDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculationUtilitiesActivity.this, DiscountActivity.class);
                startActivity(intent);
            }
        });

        nextSchoolResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculationUtilitiesActivity.this, SchoolResultActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initBinding() {
        nextMutualFund=findViewById(R.id.nextMutualFund);
        nextInterest=findViewById(R.id.nextInterest);
        nextDiscount=findViewById(R.id.nextDiscount);
        nextEmi=findViewById(R.id.nextEmi);
        nextSchoolResult=findViewById(R.id.nextSchoolResult);
        nextSquare=findViewById(R.id.nextSquare);
        back=findViewById(R.id.back);
    }



}