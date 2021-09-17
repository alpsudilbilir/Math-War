package com.alpsu.mathematix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    Button btnMenu;
    Button btnPlayAgain;
    TextView txtPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        btnMenu = findViewById(R.id.btnMenu);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        txtPoint = findViewById(R.id.txtPoint);

        txtPoint.setText(GameActivity.txtScoreCount.getText().toString());

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndScreen.this,GameMode.class);
                startActivity(intent);
                finish();
            }
        });


    }
}