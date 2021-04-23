package com.example.couponapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";

    private ImageView ivLogo;
    private EditText etUsername, etPassword;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ivLogo = findViewById(R.id.ivLogo);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        // Login
        btnLogin.setOnClickListener(view -> {
            Toast.makeText(LoginActivity.this, "Login not yet implemented!", Toast.LENGTH_SHORT).show();
            goMainActivity();
        });

        // Register
        btnRegister.setOnClickListener(view -> {
            Toast.makeText(LoginActivity.this, "Registering not yet implemented", Toast.LENGTH_SHORT).show();
            goMainActivity();
        });
    }

    // Goes to the Main Activity
    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}