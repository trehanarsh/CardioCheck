package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class HeartRiskRate extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_risk_rate);
    }




        boolean diabetic=false,smoker=false;
        public void onRadioButtonGend2(View View) {

            boolean checked = ((RadioButton) View).isChecked();
            switch (View.getId()) {
                case R.id.radioButton2:
                    if (checked){
                        diabetic = true;
                        ((RadioButton)findViewById(R.id.radioButton3)).setChecked(false);
                    }
                    break;
                case R.id.radioButton3:
                    if (checked)
                    {
                        diabetic = false;
                        ((RadioButton)findViewById(R.id.radioButton2)).setChecked(false);
                    }
                    break;
                case R.id.radioButton4:
                    if (checked)
                    {
                        smoker = true;
                        ((RadioButton)findViewById(R.id.radioButton1)).setChecked(false);
                    }
                    break;
                case R.id.radioButton1:
                    if (checked)
                    {
                        smoker = false;
                        ((RadioButton)findViewById(R.id.radioButton4)).setChecked(false);
                    }
                    break;
            }
        }


        public void calcrisk(View View) {
            Intent intent = getIntent();
            Integer age = intent.getIntExtra("age", 35);
            boolean male = intent.getBooleanExtra("male", false);
            boolean female = intent.getBooleanExtra("female", false);
            boolean others = intent.getBooleanExtra("others", false);
            EditText v1;
            String v2;

            v1 = (EditText) findViewById(R.id.textInputEditText5);
            v2= v1.getText().toString();
            int ldl = Integer.parseInt(v2);

            v1 = (EditText) findViewById(R.id.textInputEditText);
            v2= v1.getText().toString();
            int hdl = Integer.parseInt(v2);

            v1 = (EditText) findViewById(R.id.textInputEditText2);
            v2= v1.getText().toString();
            int sys = Integer.parseInt(v2);

            v1 = (EditText) findViewById(R.id.textInputEditText3);
            v2= v1.getText().toString();
            int dia = Integer.parseInt(v2);

            int score=0;

            if(age<=34)
                score+=-3;
            else if(age<=39)
                score+=0;
            else if(age<=44)
                score+=0;
            else if(age<=49)
                score+=3;
            else if(age<=54)
                score+=6;
            else if(age<=59)
                score+=7;
            else
                score+=9;

            if(ldl<100)
                score+=-2;
            else if(ldl>159)
                score+=2;

            if(hdl<=35)
                score+=5;
            else if(hdl<=44)
                score+=3;
            else if(hdl<=49)
                score+=1;
            else if(hdl>59)
                score+=-2;

            if(sys<120 && dia<80)
                score-=3;
            else if(sys<140 && dia<90)
                score+=0;
            else if(sys>159 || dia>99)
                score+=3;
            else
                score+=2;


            if(diabetic)
                score+=4;
            if(smoker)
                score+=2;



            if(male||others) {
                if (score >= 15) {
                    Intent highrisk = new Intent(this, highRisk.class);
                    startActivity(highrisk);
                } else if (score >= 11) {
                    Intent highrisk = new Intent(this, moderateRisk.class);
                    startActivity(highrisk);
                } else {
                    Intent highrisk = new Intent(this, lowRisk.class);
                    startActivity(highrisk);
                }
            }
            else {
                if (score >= 18) {
                    Intent highrisk = new Intent(this, highRisk.class);
                    startActivity(highrisk);
                } else if (score >= 13) {
                    Intent highrisk = new Intent(this, moderateRisk.class);
                    startActivity(highrisk);
                } else {
                    Intent highrisk = new Intent(this, lowRisk.class);
                    startActivity(highrisk);
                }
            }

        }



}
