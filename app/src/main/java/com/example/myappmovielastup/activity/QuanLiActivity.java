package com.example.myappmovielastup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import com.example.myappmovielastup.R;
import com.example.myappmovielastup.activity.login.LoginActivity;

public class QuanLiActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btn_them;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li);
        initView();
        initController();
        ActionBar();
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initController() {
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThemPhimActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        toolbar = findViewById(R.id.quanli_toolbar);
        btn_them = findViewById(R.id.quanli_them);
    }
}