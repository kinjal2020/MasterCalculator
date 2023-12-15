package com.example.mastercalculator;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mastercalculator.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private TextView textViewStartApp;
    private TextView textViewAboutUs;
    private View btnShareApp;
    private View btnRateApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBinding();

        textViewStartApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculationUtilitiesActivity.class);
                startActivity(intent);
            }
        });

        textViewAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutiUsActivity.class);
                startActivity(intent);
            }
        });


        btnShareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                startActivity(Intent.createChooser(intent,"Share Via"));
            }
        });

    }

    private void initBinding() {
        textViewStartApp = findViewById(R.id.textViewStartApp);
        textViewAboutUs = findViewById(R.id.textViewAboutUS);
        btnShareApp = findViewById(R.id.btnShareApp);
        btnRateApp = findViewById(R.id.btnRateApp);
    }


}