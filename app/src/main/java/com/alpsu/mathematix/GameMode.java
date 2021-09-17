package com.alpsu.mathematix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameMode extends AppCompatActivity {
    Button btnAdd, btnSub, btnMult, btnDiv;
    public static boolean isAddition = false;
    public static boolean isSubtraction = false;
    public static boolean isMultiplication = false;
    public static boolean isDivision = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        btnMult = findViewById(R.id.btnMult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAddition = true;
                Intent intent = new Intent(GameMode.this,GameActivity.class);
                startActivity(intent);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSubtraction = true;
                Intent intent = new Intent(GameMode.this,GameActivity.class);
                startActivity(intent);
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMultiplication = true;
                Intent intent = new Intent(GameMode.this,GameActivity.class);
                startActivity(intent);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDivision = true;
                Intent intent = new Intent(GameMode.this,GameActivity.class);
                startActivity(intent);
            }
        });
    }
}