package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
    }

    public void calcbm(View View) {
        EditText weight = (EditText) findViewById(R.id.editText1);
        String x1=weight.getText().toString();
        EditText hieght = (EditText) findViewById(R.id.editText2);
        String x2=hieght.getText().toString();
        float r1 = Float.parseFloat(x1);
        float r2 = Float.parseFloat(x2);
        float bmi = (r1 * 10000) / (r2 * r2);

        TextView mText = (TextView) findViewById(R.id.textView8);
        String strbmi="";
        if(bmi<=20)
            strbmi="Underweight";
        else if(bmi<=25)
            strbmi="Normal";
        else if(bmi<=30)
            strbmi="Overweight";
        else
            strbmi="Obese";



        mText.setText("Your BMI: " +  bmi + "\n" +"( " + strbmi + " )");

    }
}
