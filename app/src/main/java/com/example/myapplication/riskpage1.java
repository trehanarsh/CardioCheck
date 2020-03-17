package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class riskpage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riskpage1);
    }

    boolean chck = false;

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked)
            chck = true;
    }


    public void nextfrompage1(View View) {

        if (chck) {
            Intent hrisk = new Intent(this, highRisk.class);
            startActivity(hrisk);
        } else {

            Intent intent = getIntent();
            Integer age = intent.getIntExtra("age", 35);
            boolean male = intent.getBooleanExtra("male", false);
            boolean female = intent.getBooleanExtra("female", false);
            boolean others = intent.getBooleanExtra("others", false);

            Intent hrisk = new Intent(this, HeartRiskRate.class);
            hrisk.putExtra("male", male);
            hrisk.putExtra("female", female);
            hrisk.putExtra("others", others);
            hrisk.putExtra("age", age);
            startActivity(hrisk);

        }


    }


}