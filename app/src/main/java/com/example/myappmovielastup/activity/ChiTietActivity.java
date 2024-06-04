package com.example.myappmovielastup.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myappmovielastup.R;
import com.example.myappmovielastup.model.PhimMoi;

public class ChiTietActivity extends AppCompatActivity {

    TextView tenphim, mota, daodien, dienvien, theloai, thoiluong, ngonngu;
    Button btnthem;
    ImageView imghinhanh;
    Toolbar toobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        initView();
        ActionToolBar();
        initData();
    }

    private void ActionToolBar() {
        setSupportActionBar(toobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        PhimMoi phimMoi = (PhimMoi) getIntent().getSerializableExtra("chitiet");
        tenphim.setText(phimMoi.getTen());
        mota.setText(phimMoi.getMota());
        daodien.setText("Đạo diễn: " + phimMoi.getDaodien());
        dienvien.setText("Diễn viên: " + phimMoi.getDienvien());

        if (phimMoi.getTheloaiid() == 1)
            theloai.setText("Thể loại: Mọi lứa tuổi");
        if (phimMoi.getTheloaiid() == 13)
            theloai.setText("Thể loại: Trên 13 tuổi");
        if (phimMoi.getTheloaiid() == 16)
            theloai.setText("Thể loại: Trên 16 tuổi");
        if (phimMoi.getTheloaiid() == 18)
            theloai.setText("Thể loại: Trên 18 tuổi");

        thoiluong.setText("Thời lượng: " + phimMoi.getThoiluong());
        ngonngu.setText("Ngôn ngữ: " + phimMoi.getNgonngu());
        Glide.with(getApplicationContext()).load(phimMoi.getHinhanh()).into(imghinhanh);
    }



    private void initView() {
        tenphim = findViewById(R.id.chitiet_ten);
        mota = findViewById(R.id.chitiet_mota);
        daodien = findViewById(R.id.chitiet_daodien);
        dienvien = findViewById(R.id.chitiet_dienvien);
        theloai = findViewById(R.id.chitiet_theloai);
        thoiluong = findViewById(R.id.chitiet_thoiluong);
        ngonngu = findViewById(R.id.chitiet_ngonngu);
        imghinhanh = findViewById(R.id.chitiet_image);
        btnthem = findViewById(R.id.chitiet_btn);
        toobar = findViewById(R.id.toobar);
    }
}