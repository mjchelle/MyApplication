package com.example.myapplication.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class LogoutActivity extends LoginActivity {

    Button signOutButton;
    Button backButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        signOutButton = (Button) findViewById(R.id.buttonSignout2);
        backButton = (Button) findViewById(R.id.buttonBackToGame);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
                startActivity(new Intent(LogoutActivity.this, MainActivity.class));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogoutActivity.this, MainActivity.class));
            }
        });
    }

   /* @Override
    public void onStart() {
        super.onStart();
    }*/
}