package com.example.converter340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "CONVERTIT_MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button currencyButton = findViewById(R.id.currency_btn);
        currencyButton.setOnClickListener(this);

        Button cookingButton = findViewById(R.id.cook_btn);
        cookingButton.setOnClickListener(this);

        Button physicalButton = findViewById(R.id.physical_btn);
        physicalButton.setOnClickListener(this);

        Button tempButton = findViewById(R.id.temp_btn);
        tempButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();
        Log.d(TAG, String.format("event source id: %s", eventSourceId));

        if (eventSourceId == R.id.currency_btn) {
            handleCurrencyButtonClick();
        }
        else if (eventSourceId == R.id.cook_btn){
            handleCookingButtonClick();
        }
        else if (eventSourceId == R.id.physical_btn){
            handlePhysicalButtonClick();
        }
        else if (eventSourceId == R.id.temp_btn){
            handleTempButtonClick();
        }
        else{
            Log.d(TAG, String.format("Unknown click event source: %s", eventSourceId));
        }
    }

    private void handleCurrencyButtonClick() {
        Intent intent = new Intent(this, Currency.class);
        startActivity(intent);
    }
    private void handleCookingButtonClick() {
        Intent intent = new Intent(this, Cooking.class);
        startActivity(intent);
    }
    private void handlePhysicalButtonClick() {
        Intent intent = new Intent(this, Physical.class);
        startActivity(intent);
    }
    private void handleTempButtonClick() {
        Intent intent = new Intent(this, Temperature.class);
        startActivity(intent);
    }
}