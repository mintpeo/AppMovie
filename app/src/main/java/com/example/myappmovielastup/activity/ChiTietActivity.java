package com.example.myappmovielastup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myappmovielastup.R;
import com.example.myappmovielastup.model.GioHang;
import com.example.myappmovielastup.model.PhimMoi;
import com.example.myappmovielastup.utils.Utils;
import com.nex3z.notificationbadge.NotificationBadge;

import okhttp3.internal.Util;

public class ChiTietActivity extends AppCompatActivity {

    TextView tenphim, mota, daodien, dienvien, theloai, thoiluong, ngonngu;
    Button btnthem;
    ImageView imghinhanh;
    Toolbar toobar;
    Spinner spinner;
    PhimMoi phimMoi;
    NotificationBadge badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        initView();
        ActionToolBar();
        initData();
        initControl();
    }

    private void initControl() {
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themGioHang();
            }
        });
    }

    private void themGioHang() {
        if (Utils.manggiohang.size() > 0) {
            boolean flag = false;
            int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
            for (int i = 0; i < Utils.manggiohang.size(); i++) {
                if (Utils.manggiohang.get(i).getIdphim() == phimMoi.getId()) {
                    Utils.manggiohang.get(i).setSoluong(soluong + Utils.manggiohang.get(i).getSoluong());
                    long gia = Long.parseLong(phimMoi.getGiave()) * Utils.manggiohang.get(i).getSoluong();
                    Utils.manggiohang.get(i).setGia(gia);
                    flag = true;
                }
            }
            if (flag == false) {
                    long gia = Long.parseLong(phimMoi.getGiave()) * soluong;
                GioHang gioHang = new GioHang();
                gioHang.setGia(gia);
                gioHang.setSoluong(soluong);
                gioHang.setIdphim(phimMoi.getId());
                gioHang.setTenphim(phimMoi.getTen());
                gioHang.setHinhphim(phimMoi.getHinhanh());
                Utils.manggiohang.add(gioHang);
            }
        } else {
            int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
            long gia = Long.parseLong(phimMoi.getGiave()) * soluong;
            GioHang gioHang = new GioHang();
            gioHang.setGia(gia);
            gioHang.setSoluong(soluong);
            gioHang.setIdphim(phimMoi.getId());
            gioHang.setTenphim(phimMoi.getTen());
            gioHang.setHinhphim(phimMoi.getHinhanh());
            Utils.manggiohang.add(gioHang);
        }
        int totalItem = 0;
        for (int i = 0; i < Utils.manggiohang.size(); i++) {
            totalItem = totalItem + Utils.manggiohang.get(i).getSoluong();
        }
        badge.setText(String.valueOf(totalItem));
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
        phimMoi = (PhimMoi) getIntent().getSerializableExtra("chitiet");
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

        Integer[] sp = new Integer[] {1, 2, 3, 4, 5};
        ArrayAdapter<Integer> adapterspin = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, sp);
        spinner.setAdapter(adapterspin);

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
        spinner = findViewById(R.id.chitiet_spinner);
        badge = findViewById(R.id.chitiet_sl);
        FrameLayout frameLayoutgiohang = findViewById(R.id.framegiohang);
        frameLayoutgiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giohang = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(giohang);
            }
        });

        if (Utils.manggiohang != null) {
            int totalItem = 0;
            for (int i = 0; i < Utils.manggiohang.size(); i++) {
                totalItem = totalItem + Utils.manggiohang.get(i).getSoluong();
            }
            badge.setText(String.valueOf(totalItem));
        }
    }
}