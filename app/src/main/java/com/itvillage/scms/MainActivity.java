package com.itvillage.scms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText userNameEditText, passwordEditText;
    private Button sign_in_but;
    private TextView sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        sign_up = findViewById(R.id.sign_up);
        sign_in_but = findViewById(R.id.sign_in_but);

        sign_in_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(userNameEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), SignUpActivity.class));
            }
        });
    }

    private void login(String userName, String password) {
        if (userName.equals("admin")) {
            startActivity(new Intent(this, FacultyHomeActivity.class));
        } else {
            startActivity(new Intent(this, StudentHomeActivity.class));
        }

    }
}