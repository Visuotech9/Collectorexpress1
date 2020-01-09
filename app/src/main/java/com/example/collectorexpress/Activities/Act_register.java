package com.example.collectorexpress.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.collectorexpress.R;

public class Act_register extends AppCompatActivity implements View.OnClickListener{

    TextView tv_login;
    Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_register);

        init();

    }

    private void init() {

        btn_register = findViewById(R.id.btn_register);
        tv_login = findViewById(R.id.tv_login);

        btn_register.setOnClickListener(this);
        tv_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                finish();
                Intent intent = new Intent(getApplicationContext(),Act_home.class);
                startActivity(intent);
                break;

            case R.id.tv_login:
                finish();
                Intent intent1 = new Intent(getApplicationContext(),Act_login.class);
                startActivity(intent1);
                break;

        }
    }
}
