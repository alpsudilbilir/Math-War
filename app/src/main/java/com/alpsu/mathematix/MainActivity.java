package com.alpsu.mathematix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    Button btnHelp;
    Button btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnAbout = findViewById(R.id.btnAbout);
        btnHelp = findViewById(R.id.btnHelp);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GameMode.class);
                startActivity(intent);
                finish();
            }
        });
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HelpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("About");
                alert.setMessage("Developed with love by Alpsu Dilbilir.");
                alert.setCancelable(true);
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Nothing happens here.
                    }
                });
                alert.show();
            }
        });
    }

}