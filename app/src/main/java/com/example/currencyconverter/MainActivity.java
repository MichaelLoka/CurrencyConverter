package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.assignment1.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currency Currency= new currency();
        TextInputLayout dollar = (TextInputLayout)findViewById(R.id.Dollar_text_value);
        TextInputLayout pound = (TextInputLayout)findViewById(R.id.Pound_text_value);
        Button CalcBtn= (Button)findViewById(R.id.convert_btn);
        CalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dollar.getEditText().getText().toString().equals("") && pound.getEditText().getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Invalid data - Please enter Value",Toast.LENGTH_LONG).show();
                }
                else if((!dollar.getEditText().getText().toString().equals("") && (! pound.getEditText().getText().toString().equals("") )))
                {
                    Toast.makeText(getApplicationContext(),"Please enter Value in One Field ONLY",Toast.LENGTH_LONG).show();
                }

                else if(! dollar.getEditText().getText().toString().equals(""))
                {
                    float d=Float.parseFloat(dollar.getEditText().getText().toString());
                    Currency.setCurrency_value(d);
                    d=Currency.ConvertToPound();
                    pound.getEditText().setText(String.valueOf(d));
                }
                else
                {
                    float p=Float.parseFloat(pound.getEditText().getText().toString());
                    Currency.setCurrency_value(p);
                    p=Currency.ConvertToDollar();
                    dollar.getEditText().setText(String.valueOf(p));
                }

            }
        });

        Button clear =(Button) findViewById(R.id.clear_btn);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dollar.getEditText().getText().toString().equals("") && pound.getEditText().getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Invalid data - The Fields are Already Empty",Toast.LENGTH_LONG).show();
                }
                else{
                    dollar.getEditText().getText().clear();
                    pound.getEditText().getText().clear();
                }


            }
        });
    }
}