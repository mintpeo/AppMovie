package com.example.myappmovielastup.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.myappmovielastup.R;

public class GiaVeActivity extends AppCompatActivity {

    ImageView imageViewGiaVe;
    Toolbar toobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gia_ve);

        Anhxa();
        getImage();
        ActionBar();
    }

    private void ActionBar() {
        setSupportActionBar(toobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getImage() {
        //Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
        Glide.with(getApplicationContext()).load(R.drawable.giaveupdata).into(imageViewGiaVe);
    }

    private void Anhxa() {
        imageViewGiaVe = findViewById(R.id.giave);
        toobar = findViewById(R.id.toobar);
    }
}