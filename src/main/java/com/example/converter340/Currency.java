package com.example.converter340;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Currency extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "CONVERTIT_CURRENCY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency);

        Spinner spinnerInput;
        spinnerInput = findViewById(R.id.currency_spinner_input);
        ArrayAdapter<CharSequence> adapterIn = ArrayAdapter.createFromResource(this,
                R.array.currencySpinnerValues,
                android.R.layout.simple_spinner_item);
        adapterIn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInput.setAdapter(adapterIn);

        Spinner spinnerOutput;
        spinnerOutput = findViewById(R.id.currency_spinner_output);
        ArrayAdapter<CharSequence> adapterOut = ArrayAdapter.createFromResource(this,
                R.array.currencySpinnerValues,
                android.R.layout.simple_spinner_item);
        adapterOut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOutput.setAdapter(adapterOut);

        findViewById(R.id.back_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();
        Log.d(TAG, String.format("Clicked on: %s", eventSourceId));

        switch (eventSourceId) {
            case R.id.back_btn:
                finish();
                Log.e(TAG, String.format("Whoo hoo!", eventSourceId));
                break;
            case R.id.convert_Btn:
                Log.e(TAG, String.format("Whoo hoo!", eventSourceId));
                break;
            default:
                Log.d(TAG, String.format("Unknown click event. Source: %s", eventSourceId));
                break;
        }
    }

}
