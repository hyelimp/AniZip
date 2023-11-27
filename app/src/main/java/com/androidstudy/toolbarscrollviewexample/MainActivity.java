package com.androidstudy.toolbarscrollviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animain);


        Button btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        Button btnContent = (Button) findViewById(R.id.btnContent);
        btnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdapterViewActivity.class);
                startActivity(intent);
            }
        });

        Button btnLocation = (Button) findViewById(R.id.btnLocation);
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
                startActivity(intent);
            }
        });

        Button btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WebViewCallActivity.class);
                startActivity(intent);
            }
        });
    }

//    Button btnGoSignUp = (Button) findViewById(R.id.btnGoSignUp);
//        btnGoSignUp.setOnClickListener(new View.OnClickListener(){
//        @Override
//        public void onClick (View view){
//        Intent intent = new Intent(getApplicationContext(), SignUpSuccess.class);
//        startActivity(intent);
//    }
//    });

}

