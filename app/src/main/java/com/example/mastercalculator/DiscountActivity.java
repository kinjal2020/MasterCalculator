package com.example.mastercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DiscountActivity extends AppCompatActivity {

    private EditText editTextPrice;
    private EditText editTextDiscount;
    private TextView textViewAfterDiscount;
    private TextView textviewSavedAmount;
    private View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        initBinding();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initBinding() {
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextDiscount = findViewById(R.id.editDiscount);
        textViewAfterDiscount = findViewById(R.id.textViewDiscount);
        textviewSavedAmount = findViewById(R.id.textViewSavedAmount);
        back = findViewById(R.id.back);
    }

    public void count(View view) {
        String price = editTextPrice.getText().toString();
        String discount = editTextDiscount.getText().toString();

        if (TextUtils.isEmpty(price)) {
            editTextPrice.setError("Enter price");
        } else if (TextUtils.isEmpty(discount)) {
            editTextDiscount.setError("Enter discount");
        }else{
            float p=Float.parseFloat(price);
            float d=Float.parseFloat(discount);
            float ans=d/100*p;
            float discountPrice=p-ans;
            Log.i("TAG", "count: "+ ans );
            Log.i("TAG", "count: "+discountPrice );
            textViewAfterDiscount.setText(String.valueOf("₹ "+(int)discountPrice));
            textviewSavedAmount.setText(String.valueOf("₹ "+(int)ans));

        }

    }
}