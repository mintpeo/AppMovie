package com.example.myappmovielastup.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myappmovielastup.R;
import com.example.myappmovielastup.databinding.ActivityThemPhimBinding;
import com.example.myappmovielastup.retrofit.ApiPhim;
import com.example.myappmovielastup.retrofit.RetrofitClient;
import com.example.myappmovielastup.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ThemPhimActivity extends AppCompatActivity {

    Spinner theloai;
    int theloaiid = 0;
    ApiPhim apiPhim;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ActivityThemPhimBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemPhimBinding.inflate(getLayoutInflater());
        apiPhim = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiPhim.class);
        setContentView(binding.getRoot());
        initView();
        initData();
    }

    private void initData() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Vui lòng chọn thể loại");
        stringList.add("Mọi lứa tuổi");
        stringList.add("Trên 13 tuổi");
        stringList.add("Trên 16 tuổi");
        stringList.add("Trên 18 tuổi");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, stringList);
        theloai.setAdapter(adapter);

        theloai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    theloaiid = 1;
                } else if (position == 2) {
                    theloaiid = 13;
                } else if (position == 3) {
                    theloaiid = 16;
                } else {
                    theloaiid = 18;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.themphimBtnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themsanpham();
            }
        });
    }

    private void themsanpham() {
        String str_Tenphim = binding.themphimTenphim.getText().toString().trim();
        String str_Hinhanh = binding.themphimHinhanh.getText().toString().trim();
        String str_Daodien = binding.themphimDaodien.getText().toString().trim();
        String str_Dienvien = binding.themphimDienvien.getText().toString().trim();
        String str_Thoiluong = binding.themphimThoiluong.getText().toString().trim();
        Integer thoiluong = Integer.parseInt(str_Thoiluong);
        String str_Ngonngu = binding.themphimNgonngu.getText().toString().trim();
        String str_Mota = binding.themphimMota.getText().toString().trim();

        if (TextUtils.isEmpty(str_Tenphim) || TextUtils.isEmpty(str_Hinhanh) ||
                TextUtils.isEmpty(str_Daodien) || TextUtils.isEmpty(str_Dienvien) ||
                thoiluong == 0 || TextUtils.isEmpty(str_Ngonngu) ||
                TextUtils.isEmpty(str_Mota) || theloaiid == 0) {
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đủ thông tin", Toast.LENGTH_LONG).show();
        } else {
            compositeDisposable.add(apiPhim.insertPhim(str_Tenphim, str_Hinhanh, str_Daodien, str_Dienvien, thoiluong, str_Ngonngu, str_Mota, theloaiid)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            messageModel -> {
                                if (messageModel.isSuccess()) {
                                    Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }, throwable -> {
                                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
                            }
                    ));
        }
    }

    private void initView() {
        theloai = findViewById(R.id.themphim_theloai);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}