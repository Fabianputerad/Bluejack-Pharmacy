package com.example.projectasg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.ButtonLogin);
        registerButton = (Button) findViewById(R.id.ButtonRegis);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisPage();
            }
        });

    }
    public void openLoginPage(){
        Intent intent = new Intent(this, LoginPage.class );
        startActivity(intent);
    }

    public void openRegisPage(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}