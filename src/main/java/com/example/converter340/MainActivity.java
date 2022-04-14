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

        Button button = findViewById(R.id.currency_btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();
        Log.d(TAG, String.format("event source id: %s", eventSourceId));

        switch (eventSourceId) {
            case R.id.currency_btn:
                handleCurrencyButtonClick();
                break;
            default:
                Log.d(TAG, String.format("Unknown click event. Source: %s", eventSourceId));
                break;
        }
    }

    private void handleCurrencyButtonClick() {
        Intent intent = new Intent(this, Currency.class);
        startActivity(intent);
    }

}