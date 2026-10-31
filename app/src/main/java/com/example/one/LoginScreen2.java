package com.example.one;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen2 extends AppCompatActivity {

    // Step 1: Declare UI variables
    EditText etGmail, etUsername, etPassword;
    Button btnLogin, btnGoogleSignIn;
    TextView tvGoToSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen2);

        // Step 2: Link Java variables to XML views using their IDs
        etGmail = findViewById(R.id.etLoginGmail);
        etUsername = findViewById(R.id.etLoginUsername);
        etPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogleSignIn = findViewById(R.id.btnGoogleSignIn);
        tvGoToSignUp = findViewById(R.id.tvGoToSignUp);

        // Step 3: Set click listener for Login Button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text typed by the user and remove extra spaces using .trim()
                String gmail = etGmail.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Validation: Check if any field is empty
                if (gmail.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginScreen2.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!gmail.endsWith("@gmail.com")) {
                    // Simple validation to ensure it is a Gmail address
                    etGmail.setError("Please enter a valid @gmail.com address");
                } else {
                    // Success message
                    Toast.makeText(LoginScreen2.this, "Welcome " + username + "! Login Successful.", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Step 4: Set click listener for Google Sign-In Button
        btnGoogleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginScreen2.this, "Connecting to Google Account...", Toast.LENGTH_SHORT).show();
            }
        });

        // Step 5: Set click listener for Sign Up Hypertext
        tvGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate from LoginActivity to SignUpActivity
                Intent intent = new Intent(LoginScreen2.this, SignupPage3.class);
                startActivity(intent);
            }
        });
    }
}