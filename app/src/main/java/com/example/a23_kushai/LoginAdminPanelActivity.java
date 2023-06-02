package com.example.a23_kushai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.a23_kushai.DBCHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

public class LoginAdminPanelActivity extends AppCompatActivity {
    DBCHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
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
                databaseHelper = new DBCHelper(getApplicationContext());
                db = databaseHelper.getReadableDatabase();
                String login = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();
                Cursor query = db.rawQuery("SELECT * FROM users;",null);
                while (query.moveToNext()){
                    if(login.equals(query.getString(1)) && password.equals(query.getString(2)))
                    {
                        Intent intent = new Intent(view.getContext(), AdminPanel.class);
                        startActivity(intent);
                    }
                }


            }
        });
    }
}