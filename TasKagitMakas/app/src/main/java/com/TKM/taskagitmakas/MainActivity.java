package com.TKM.taskagitmakas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button tas, kagit, makas;
    TextView  comScore, userScore, result, comChoiceResult;
    int comScr=0,userScr =0,comChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tas = findViewById(R.id.mainBtnTas);
        kagit = findViewById(R.id.mainBtnKagit);
        makas = findViewById(R.id.mainBtnMakas);
        comScore = findViewById(R.id.mainTxtComScore);
        userScore = findViewById(R.id.mainTxtUserScore);
        result = findViewById(R.id.mainTxtSonuc);
        comChoiceResult = findViewById(R.id.mainTxtComChoice);
        comScore.setText(String.valueOf(comScr));
        userScore.setText(String.valueOf(userScr));
    }

    public void mainBtnClick(View view) {
        switch(view.getId()){
            case R.id.mainBtnTas:comChoiceMethod(1);
                break;
            case R.id.mainBtnKagit:comChoiceMethod( 2);
                break;
            case R.id.mainBtnMakas:comChoiceMethod(3);
                break;
        }
    }
    public void comChoiceMethod(int userChoice){
        comChoice = (int) (Math.random()*3+1);
        String comSecimi = null;
        if(comChoice==1)comSecimi="Tas";
        if(comChoice==2)comSecimi="Kağıt";
        if(comChoice==3)comSecimi="Makas";
        comChoiceResult.setText("Computer Choice:" + comSecimi);
        if((comChoice==1 && userChoice==1) || (comChoice==2 && userChoice==2) || (comChoice==3 && userChoice==3)){
            result.setText("Scoreless");
        }
       else if((comChoice==1 && userChoice==3) || (comChoice==2 && userChoice==1) || (comChoice==3 && userChoice==2)){
            result.setText("Computer win");
            comScr++;comScore.setText(String.valueOf(comScr));
        }else{
           result.setText("USER WİN");
           userScr++; userScore.setText(String.valueOf(userScr));
        }
    }
}