package com.example.projectasg;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    Button regisBtn, lgnbtn;
    EditText username, email, pass, conpass;
    MenuItem logout;
    private UserController userController;
    int userId=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        regisBtn = (Button) findViewById(R.id.regisbuttonpage);
        username = findViewById(R.id.UsernameRegis_edit);
        email = findViewById(R.id.EmailRegis_edit);
        pass = findViewById(R.id.PasswordRegis_edit);
        conpass = findViewById(R.id.ConfirmPasswordRegis_edit);
        lgnbtn = (Button) findViewById(R.id.loginbtn_signUp);
        pass.setTransformationMethod(new PasswordTransformationMethod());
        conpass.setTransformationMethod(new PasswordTransformationMethod());
        userController = new UserController();

        lgnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLogin();
            }
        });
        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmailPass();
            }
        });
    }
    public boolean validateEmailPass(){
        String emailInput = email.getText().toString();
        String password = pass.getText().toString();
        String Username = username.getText().toString();
        String ConPass = conpass.getText().toString();


        if(emailInput.isEmpty()|| password.isEmpty() || Username.isEmpty() || ConPass.isEmpty()) {
            email.setError("cannot be empty!");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please Input valid Email!");
            return false;
        } else if (Username.length()<5) {
            username.setError("Username must be at least 5 characters");
            return false;
            
        } else if (!pass(password)) {
            pass.setError("Password must be alphanumeric");
            return false;
        } else {
            userController.registerUser(Username, emailInput, password);
            userId++;
            email.setError(null);
            toHomePge();
            return true;
        }
    }

    public void toHomePge(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void toLogin(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    public boolean pass(String password){
        if(password == null){
            return false;
        }
    
        String pattern = "^[a-zA-Z0-9]*$";
        return password.matches(pattern);

    }
}