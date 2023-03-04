package br.edu.ifsp.dmos5.App02_ConversorTemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private EditText valueEditText;
    private TextView convertedValueTextView;
    private Button converterCelsiusButton ;
    private Button converterFahrenheitButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueEditText = findViewById(R.id.edittext_value);

        convertedValueTextView = findViewById(R.id.textview_value_converted);

        converterCelsiusButton = findViewById(R.id.button_converter_celsius);
        converterCelsiusButton.setOnClickListener(this);

        converterFahrenheitButton = findViewById(R.id.button_converter_Fahrenheit);
        converterFahrenheitButton.setOnClickListener(this);

    }

    public void onClick(View view){

        if(view == converterCelsiusButton){
            getTemperaturaCelsius();
        }
        if(view == converterFahrenheitButton){
            getTemperaturaFahrenheit();
        }

    }

    private double getValue(){

        double value;
        String valueString;

        valueString = valueEditText.getText().toString();

        try{
            value = Double.valueOf(valueString);

        }catch(NumberFormatException e){

            Toast.makeText(this, "Formato do valor invalido. ", Toast.LENGTH_SHORT).show();
            value = 0;

        }

        return value;

    }


    private void getTemperaturaCelsius(){

        double value = getValue();

        value = (value - 32)  / 1.8;

        convertedValueTextView.setText(String.format("%.2f °C",value));

    }

    private void getTemperaturaFahrenheit(){

        double value = getValue();

        value = 1.8 * value + 32;

        convertedValueTextView.setText(String.format("%.2f °F",value));

    }

}