package com.example.ibs_001.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text1 = (TextView)findViewById(R.id.text1);
        final TextView text2 = (TextView)findViewById(R.id.text2);
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int openHand = decideOpenHand();
                String openHandText = changeTextOpenHand(openHand);
                decideGame(1, openHand,text2);
                text1.setText(openHandText);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int openHand = decideOpenHand();
                String openHandText = changeTextOpenHand(openHand);
                decideGame(2, openHand,text2);
                text1.setText(openHandText);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int openHand = decideOpenHand();
                String openHandText = changeTextOpenHand(openHand);
                decideGame(3, openHand,text2);
                text1.setText(openHandText);
            }
        });
    }

    String changeTextOpenHand(int hand){
        String handText = "";
        if (hand == 1) handText = "グー";
        else if (hand == 2) handText = "チョキ";
        else if (hand == 3) handText = "パー";
        return handText;
    }
    int decideOpenHand(){
        Random rnd = new Random();
        int hand = rnd.nextInt(3)+1;
        return hand;
    }
    void decideGame(int playerHaand, int openHand, TextView decideText){
        String decision;
        if (playerHaand == openHand) decision = "あいこ";
        else if ((playerHaand == 3 && openHand == 1) || (playerHaand+1 == openHand)) decision = "勝ち！";
        else decision = "負け";
        decideText.setText(decision);
    }
}
