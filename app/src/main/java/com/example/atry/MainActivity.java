package com.example.atry;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etWeight = findViewById(R.id.etWeight);
        EditText etHeight = findViewById(R.id.etHeight);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> {
            String weightStr = etWeight.getText().toString();
            String heightStr = etHeight.getText().toString();

            if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                float weight = Float.parseFloat(weightStr);
                // Convert height from cm to meters
                float height = Float.parseFloat(heightStr) / 100;

                float bmi = weight / (height * height);
                displayResult(bmi, tvResult);
            }
        });
    }

    private void displayResult(float bmi, TextView tvResult) {
        String category;
        if (bmi < 18.5) category = "Underweight";
        else if (bmi < 25) category = "Normal weight";
        else if (bmi < 30) category = "Overweight";
        else category = "Obese";

        tvResult.setText(String.format("BMI: %.2f\nCategory: %s", bmi, category));
    }
}