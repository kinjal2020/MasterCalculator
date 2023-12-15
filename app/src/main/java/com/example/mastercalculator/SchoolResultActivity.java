package com.example.mastercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SchoolResultActivity extends AppCompatActivity {



    private TextView textviewPercentage;
    private EditText editTextTotalMarks;
    private EditText editTextYourMarks;
    private View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_result);
        initBinding();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }


    private void initBinding() {
        editTextTotalMarks = findViewById(R.id.editTextTotalMarks);
        editTextYourMarks = findViewById(R.id.editTextYourMark);
        textviewPercentage = findViewById(R.id.textViewPercentage);
        back = findViewById(R.id.back);
    }


    public void calculate(View view) {
        String totalMark = editTextTotalMarks.getText().toString();
        String yourMark = editTextYourMarks.getText().toString();

        if (TextUtils.isEmpty(totalMark)) {
            editTextTotalMarks.setError("Enter total mark");
        } else if (TextUtils.isEmpty(yourMark)) {
            editTextYourMarks.setError("Enter your mark");
        } else {
            float p = Float.parseFloat(totalMark);
            float d = Float.parseFloat(yourMark);
            float ans = (d*100)/p;
            textviewPercentage.setText(String.valueOf((int) ans+"%"));
        }

    }

}