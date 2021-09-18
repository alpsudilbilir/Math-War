package com.alpsu.mathematix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HelpActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}