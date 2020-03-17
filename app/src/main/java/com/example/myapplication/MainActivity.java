package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//        EditText nam = (EditText) findViewById(R.id.textInputEditText7);
//        String name=nam.getText().toString();


    boolean female=false;
    boolean male=false;
    boolean others=false;

    public void onRadioButtonGend(View View) {
        boolean checked = ((RadioButton) View).isChecked();
        switch (View.getId()) {
            case R.id.radioButton7:
                if (checked)
                {
                    male = true;
                    ((RadioButton)findViewById(R.id.radioButton6)).setChecked(false);
                    ((RadioButton)findViewById(R.id.radioButton5)).setChecked(false);
                }
                break;
            case R.id.radioButton6:
                if (checked)
                {
                    others = true;
                    ((RadioButton)findViewById(R.id.radioButton5)).setChecked(false);
                    ((RadioButton)findViewById(R.id.radioButton7)).setChecked(false);
                }
                break;
            case R.id.radioButton5:
                if (checked)
                {
                    female = true;
                    ((RadioButton)findViewById(R.id.radioButton6)).setChecked(false);
                    ((RadioButton)findViewById(R.id.radioButton7)).setChecked(false);
                }
                break;
        }
    }



            public void calcheart(View View) {
                EditText AG = (EditText) findViewById(R.id.textInputEditText8);
                String AG1=AG.getText().toString();
                int age = Integer.parseInt(AG1);

                Intent hrisk = new Intent( MainActivity.this , riskpage2.class);
                hrisk.putExtra("male",male);
                hrisk.putExtra("female",female);
                hrisk.putExtra("others",others);
                hrisk.putExtra("age",age);
                startActivity(hrisk);
            }




            public void calcbmi(View View) {
                Intent hrisk = new Intent( MainActivity.this , bmi.class);
                startActivity(hrisk);
            }

            public void quitalcoholtobacco(View View) {
                Intent hrisk = new Intent( MainActivity.this , quit.class);
                startActivity(hrisk);
            }



}
