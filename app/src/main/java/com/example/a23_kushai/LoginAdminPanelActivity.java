package com.example.a23_kushai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginAdminPanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin_panel);
        ImageButton buttonBack = findViewById(R.id.bnt_Back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginAdminPanelActivity.super.finish();
            }
        });
        Button buttonLogin = findViewById(R.id.btn_Login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextLogin = findViewById(R.id.editTxtLogin);
                EditText editTextPassword = findViewById(R.id.editTxtPassword);
                if(editTextPassword.getText().toString().equals("admin") && editTextPassword.getText().toString().equals("admin"))
                {
                    Intent intent = new Intent(view.getContext(), AdminPanel.class);
                    startActivity(intent);
                }

            }
        });
    }
}