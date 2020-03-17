package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class riskpage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riskpage2);
    }

    public void nextfrompage2(View View) {
        Intent intent = getIntent();
        Integer age = intent.getIntExtra("age", 35);
        boolean male = intent.getBooleanExtra("male", false);
        boolean female = intent.getBooleanExtra("female", false);
        boolean others = intent.getBooleanExtra("others", false);

        Intent hrisk = new Intent( this , riskpage1.class);
        hrisk.putExtra("male",male);
        hrisk.putExtra("female",female);
        hrisk.putExtra("others",others);
        hrisk.putExtra("age",age);
        startActivity(hrisk);

    }
}
