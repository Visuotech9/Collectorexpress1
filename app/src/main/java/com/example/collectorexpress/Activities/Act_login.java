package com.example.collectorexpress.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.collectorexpress.R;

public class Act_login extends AppCompatActivity implements View.OnClickListener {

    Button btn_login;
    TextView tv_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_login);

        init();

    }

    private void init() {

        btn_login = findViewById(R.id.btn_login);
        tv_register = findViewById(R.id.tv_register);

        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                finish();
                Intent intent = new Intent(getApplicationContext(),Act_home.class);
                startActivity(intent);
                break;

            case R.id.tv_register:
                finish();
                Intent intent1 = new Intent(getApplicationContext(),Act_register.class);
                startActivity(intent1);
                break;

        }
    }
}
