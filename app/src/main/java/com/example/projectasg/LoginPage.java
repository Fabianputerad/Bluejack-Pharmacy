package com.example.projectasg;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends AppCompatActivity {

    Button loginBtn, signup;
    EditText emailTxt, pswTxt, emailregis, pswregis;
    private UserController userController;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        emailTxt = findViewById(R.id.EmailLogIn_edit);
        pswTxt = findViewById(R.id.PasswordLogIn_edit);
        pswTxt.setTransformationMethod(new PasswordTransformationMethod());
        loginBtn = (Button) findViewById(R.id.LoginPage);
        signup = (Button) findViewById(R.id.signUp_loginpage);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSignUp();
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            String inputUsername = emailTxt.getText().toString();
            String inputPass = pswTxt.getText().toString();

            @Override
            public void onClick(View view) {
                validateEmailPass();
            }
        });
    }
    private boolean validateEmailPass() {
        String emailInput = emailTxt.getText().toString();
        String password = pswTxt.getText().toString();
        if(emailInput.isEmpty()|| password.isEmpty() ) {
            emailTxt.setError("cannot be empty!");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            emailTxt.setError("Please Input valid Email!");
            return false;
        }
        else {
            emailTxt.setError(null);
            toHomePge();
            return true;
        }

    }

    public void toHomePge(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void toSignUp(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

}