package com.example.converter340;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Currency extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "CONVERTIT_CURRENCY";
    Spinner spinnerInput;
    Spinner spinnerOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency);

        spinnerInput = findViewById(R.id.currency_spinner_input);
        ArrayAdapter<CharSequence> adapterIn = ArrayAdapter.createFromResource(this,
                R.array.currencySpinnerValues,
                android.R.layout.simple_spinner_item);
        adapterIn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInput.setAdapter(adapterIn);

        spinnerOutput = findViewById(R.id.currency_spinner_output);
        ArrayAdapter<CharSequence> adapterOut = ArrayAdapter.createFromResource(this,
                R.array.currencySpinnerValues,
                android.R.layout.simple_spinner_item);
        adapterOut.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOutput.setAdapter(adapterOut);

        findViewById(R.id.back_btn).setOnClickListener(this);
        findViewById(R.id.convert_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();
        Log.d(TAG, String.format("Clicked on: %s", eventSourceId));

        if (eventSourceId == R.id.back_btn) {
            finish();
        }
        else if (eventSourceId == R.id.convert_btn) {
            EditText editText = findViewById(R.id.currency_input);
            String userInputText = editText.getText().toString();
            double userInputNum = Double.parseDouble(editText.getText().toString());
            double math;
            String inputUnit = (String) spinnerInput.getSelectedItem();
            String outputUnit = (String) spinnerOutput.getSelectedItem();
            TextView resultText = findViewById(R.id.currency_result_text);

            if (inputUnit.equals("US Dollars") && outputUnit.equals("US Dollars")) {
                resultText.setText(userInputText);
            }
            else if (inputUnit.equals("US Dollars") && outputUnit.equals("Euros")) {
                math = userInputNum * 0.93;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("US Dollars") && outputUnit.equals("Yen")) {
                math = userInputNum * 128.52;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("US Dollars") && outputUnit.equals("Pounds")) {
                math = userInputNum * 0.78;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("Euros") && outputUnit.equals("US Dollars")) {
                math = userInputNum * 1.08;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("Euros") && outputUnit.equals("Euros")) {
                resultText.setText(userInputText);
            }
            else if (inputUnit.equals("Euros") && outputUnit.equals("Yen")) {
                math = userInputNum * 138.69;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("Euros") && outputUnit.equals("Pounds")) {
                math = userInputNum * 0.84;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("Yen") && outputUnit.equals("US Dollars")) {
                math = userInputNum * 0.0078;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));

            }
            else if (inputUnit.equals("Yen") && outputUnit.equals("Euros")) {
                math = userInputNum * 0.0072;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("Yen") && outputUnit.equals("Yen")) {
                resultText.setText(userInputText);
            }
            else if (inputUnit.equals("Yen") && outputUnit.equals("Pounds")) {
                math = userInputNum * 0.0061;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("Pounds") && outputUnit.equals("US Dollars")) {
                math = userInputNum * 1.28;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("Pounds") && outputUnit.equals("Euros")) {
                math = userInputNum * 1.19;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("Pounds") && outputUnit.equals("Yen")) {
                math = userInputNum * 164.89;

                DecimalFormat df = new DecimalFormat("#.##");
                math = Double.valueOf(df.format(math));

                resultText.setText(String.valueOf(math));
            }
            else if (inputUnit.equals("Pounds") && outputUnit.equals("Pounds")) {
                resultText.setText(userInputText);
            }
            else{
                Log.d(TAG, String.format("Unknown conversion", eventSourceId));
                resultText.setText("Error");
            }
        }
        else
            Log.d(TAG, String.format("Unknown click event source: %s", eventSourceId));
    }

}
