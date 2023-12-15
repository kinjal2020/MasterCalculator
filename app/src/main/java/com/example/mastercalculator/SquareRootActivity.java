package com.example.mastercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SquareRootActivity extends AppCompatActivity {

    private TextView textviewResult;
    private EditText editTextInputNumber;
    private EditText editTextSquare;
    private View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_root);
        initBinding();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void initBinding() {
        editTextInputNumber = findViewById(R.id.editTextInputNumber);
        editTextSquare = findViewById(R.id.editTextSquare);
        textviewResult = findViewById(R.id.textViewResult);
        back = findViewById(R.id.back);
    }


    public void calculate(View view) {
        String inputNumber = editTextInputNumber.getText().toString();
        String square = editTextSquare.getText().toString();

        if (TextUtils.isEmpty(inputNumber)) {
            editTextInputNumber.setError("Enter total mark");
        } else if (TextUtils.isEmpty(square)) {
            editTextSquare.setError("Enter your mark");
        } else {
            int p = Integer.parseInt(inputNumber);
            int d = Integer.parseInt(square);
            int ans=1;
            for(int i=0;i<d;i++){
                ans=ans*p;
            }
            textviewResult.setText(String.valueOf(ans));
        }

    }

}