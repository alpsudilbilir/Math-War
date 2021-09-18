package com.alpsu.mathematix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import android.graphics.Color;

public class GameActivity extends AppCompatActivity {
    static TextView txtScoreCount;
    TextView txtTimeCount;
    TextView txtLifeCount;
    TextView questionTxt;
    EditText editTxtAnswer;
    Button btnOK;
    Button btnNext;

    Random rand = new Random();

    int num1, num2;
    int result;
    int score = 0;
    int life = 3;
    CountDownTimer timer;
    private static final long START_TIMER_IN_MILLIS = 30000;
    Boolean timerStopped = false;
    long time_left_in_millis = START_TIMER_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initView();
        gameContinue();
        startTimer();


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = 0;
                try{
                    answer = Integer.parseInt(editTxtAnswer.getText().toString());
                }catch (NumberFormatException n){
                    Toast.makeText(GameActivity.this, "Enter a number!", Toast.LENGTH_SHORT).show();
                }
                if(answer == result){
                    score += 10;
                    txtScoreCount.setText(String.valueOf(score));
                    Toast.makeText(GameActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                    gameContinue();
                    editTxtAnswer.setText("");
                }else{
                    life -= 1;
                    txtLifeCount.setText(String.valueOf(life));
                    Toast.makeText(GameActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    gameOver();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtAnswer.setText("");
                gameContinue();
            }
        });
    }

    public void gameContinue(){
        if(GameMode.isAddition){
            num1 = rand.nextInt(100);
            num2 = rand.nextInt(100);
            result = num1 + num2;
            questionTxt.setText((num1 + " + " + num2 + " = ?"));
        }
        if (GameMode.isSubtraction){
            num1 = rand.nextInt(100);
            num2 = rand.nextInt(num1);
            result = num1 - num2;
            questionTxt.setText((num1 + " - " + num2 + " = ?"));
        }
        if(GameMode.isMultiplication){
            num1 = rand.nextInt(10);
            num2 = rand.nextInt(10);
            result = num1 * num2;
            questionTxt.setText((num1 + " x " + num2 + " = ?"));
        }
        if(GameMode.isDivision){
            num1 = rand.nextInt(100);
            num2 = rand.nextInt(num1);
            result = num1 / num2;
            questionTxt.setText((num1 + " / " + num2 + " = ?"));
        }
    }
    public void gameOver(){
        if(life == 0){
            pauseTimer();
            resetTimer();
            makeFalseAll();
            Intent intent = new Intent(GameActivity.this,EndScreen.class);
            startActivity(intent);
            finish();
        }
    }
    public void startTimer(){

        timer = new CountDownTimer(time_left_in_millis,1000) {
            @Override
            public void onTick(long l) {
                time_left_in_millis = l;
                updateText();
            }

            @Override
            public void onFinish() {
                timerStopped = true;
                makeFalseAll();
                Intent intent = new Intent(GameActivity.this,EndScreen.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
    public void updateText(){
        txtTimeCount.setText(String.format(Locale.getDefault(),"%02d",(int)((time_left_in_millis/1000) % 60)));
    }
    public void pauseTimer(){
        timer.cancel();
        timerStopped = true;
    }
    public void resetTimer(){
        time_left_in_millis = START_TIMER_IN_MILLIS;
        updateText();
    }

    @Override
    public void onBackPressed() {
        makeFalseAll();
        pauseTimer();
        resetTimer();
        Intent intent = new Intent(GameActivity.this,GameMode.class);
        startActivity(intent);
        finish();
    }
    public void makeFalseAll(){
        GameMode.isAddition = false;
        GameMode.isSubtraction = false;
        GameMode.isMultiplication = false;
        GameMode.isDivision = false;
    }
    public void initView(){
        txtScoreCount = findViewById(R.id.txtScoreCount);
        txtTimeCount = findViewById(R.id.txtTimeCount);
        txtLifeCount = findViewById(R.id.txtLifeCount);
        questionTxt = findViewById(R.id.questionTxt);
        editTxtAnswer = findViewById(R.id.editTxtAnswer);
        btnOK = findViewById(R.id.btnOK);
        btnNext = findViewById(R.id.btnNext);

    }
}