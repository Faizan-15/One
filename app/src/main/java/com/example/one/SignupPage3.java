package com.example.one;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupPage3 extends AppCompatActivity {

    EditText etUsername, etGmail, etPassword, etConfirmPassword;
    Button btnRegister;
    TextView tvBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page3);

        // Link Java variables with XML views
        etUsername = findViewById(R.id.etSignUpUsername);
        etGmail = findViewById(R.id.etSignUpGmail);
        etPassword = findViewById(R.id.etSignUpPassword);
        etConfirmPassword = findViewById(R.id.etSignUpConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvBackToLogin = findViewById(R.id.tvBackToLogin);

        // Handle Sign Up Button Click
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String gmail = etGmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPass = etConfirmPassword.getText().toString().trim();

                // Check for empty fields
                if (username.isEmpty() || gmail.isEmpty() || password.isEmpty() || confirmPass.isEmpty()) {
                    Toast.makeText(SignupPage3.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!gmail.endsWith("@gmail.com")) {
                    etGmail.setError("Must be a valid @gmail.com address");
                } else if (!password.equals(confirmPass)) {
                    // Check if both passwords match
                    etConfirmPassword.setError("Passwords do not match!");
                } else {
                    Toast.makeText(SignupPage3.this, "Account Created Successfully!", Toast.LENGTH_SHORT).show();
                    // Go back to Login Screen
                    Intent intent = new Intent(SignupPage3.this, LoginScreen2.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        // Handle "Already have an account? Login" Click
        tvBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Closes SignUpActivity and returns to LoginActivity
            }
        });
    }
}