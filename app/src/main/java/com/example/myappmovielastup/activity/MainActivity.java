package com.example.myappmovielastup.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myappmovielastup.R;
import com.example.myappmovielastup.adapter.LoaiPhimAdapter;
import com.example.myappmovielastup.adapter.PhimMoiAdapter;
import com.example.myappmovielastup.model.LoaiPhim;
import com.example.myappmovielastup.model.PhimMoi;
import com.example.myappmovielastup.retrofit.ApiBanHang;
import com.example.myappmovielastup.retrofit.RetrofitClient;
import com.example.myappmovielastup.utils.Utils;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManHinhChinh;
    NavigationView navigationView;
    ListView listViewManHinhChinh;
    DrawerLayout drawerLayout;
    LoaiPhimAdapter loaiPhimAdapter;
    List<LoaiPhim> mangloaisp;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanHang apiBanHang;
    List<PhimMoi> mangspmoi;
    PhimMoiAdapter spAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);

        Anhxa();
        ActionBar();

        if (isConnected(this)) {
            //Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
            ActionViewFlipper();
            getLoaiSanPham();
            getSpMoi();
            getEventClick();
        } else {
            Toast.makeText(getApplicationContext(), "ko co ket noi", Toast.LENGTH_LONG).show();
        }
    }

    private void getEventClick() {
        listViewManHinhChinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent trangchu = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(trangchu);
                        break;
                    case 1:
                        Intent dangnhap = new Intent(getApplicationContext(), null);
                        startActivity(dangnhap);
                        break;
                    case 2:
                        Intent dangphimP = new Intent(getApplicationContext(), TheLoaiActivity.class);
                        dangphimP.putExtra("theloaiid", 1);
                        startActivity(dangphimP);
                        break;
                    case 3:
                        Intent dangphimT13 = new Intent(getApplicationContext(), TheLoaiActivity.class);
                        dangphimT13.putExtra("theloaiid", 13);
                        startActivity(dangphimT13);
                        break;
                    case 4:
                        Intent dangphimT16 = new Intent(getApplicationContext(), TheLoaiActivity.class);
                        dangphimT16.putExtra("theloaiid", 16);
                        startActivity(dangphimT16);
                        break;
                    case 5:
                        Intent dangphimT18 = new Intent(getApplicationContext(), TheLoaiActivity.class);
                        dangphimT18.putExtra("theloaiid", 18);
                        startActivity(dangphimT18);
                        break;
                }
            }
        });
    }

    private void getSpMoi() {
        compositeDisposable.add(apiBanHang.getSpMoi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamMoiModel -> {
                            if (sanPhamMoiModel.isSuccess()) {
                                    mangspmoi = sanPhamMoiModel.getResult();
                                    spAdapter = new PhimMoiAdapter(getApplicationContext(), mangspmoi);
                                    recyclerViewManHinhChinh.setAdapter(spAdapter);

                            }
                        }
                        ,throwable -> {
                            Toast.makeText(getApplicationContext(), "ko the ket noi: " +throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                ));
    }

    private void getLoaiSanPham() {
        compositeDisposable.add(apiBanHang.getLoaiSp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        loaiSpModel -> {
                            mangloaisp = loaiSpModel.getResult();
                            // khoi tao adapter
                            loaiPhimAdapter = new LoaiPhimAdapter(getApplicationContext(), mangloaisp);
                            listViewManHinhChinh.setAdapter(loaiPhimAdapter);

//                            if (loaiSpModel.isSuccess()) {
//                                // Kiểm tra xem kết quả có null hoặc rỗng không
//                                if (loaiSpModel.getResult() != null && !loaiSpModel.getResult().isEmpty()) {
//                                    String ten = loaiSpModel.getResult().get(1).gettensanpham();
//                                    if (ten != null && !ten.isEmpty()) {
//                                        Toast.makeText(getApplicationContext(), ten, Toast.LENGTH_LONG).show();
//                                    } else {
//                                        Toast.makeText(getApplicationContext(), "Tên không hợp lệ", Toast.LENGTH_LONG).show();
//                                    }
//                                } else {
//                                    Toast.makeText(getApplicationContext(), "Dữ liệu không hợp lệ", Toast.LENGTH_LONG).show();
//                                }
//                            }
                        }
//                        , throwable -> {
//                            // Xử lý lỗi ở đây
//                            Toast.makeText(getApplicationContext(), "Có lỗi xảy ra: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
//                        }
                ));
    }

    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://files.betacorp.vn/media/images/2024/05/24/combo-hoc-sinh-sinh-vien-1702-x-621-3-134524-240524-28.png");
        mangquangcao.add("https://files.betacorp.vn/media/images/2024/05/24/combo-groupsale-1702-x-621-3-134140-240524-17.png");
        mangquangcao.add("https://files.betacorp.vn/media/images/2024/05/24/1702x621-3-142118-240524-87.png");

        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewlipper);
        recyclerViewManHinhChinh = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewManHinhChinh.setLayoutManager(layoutManager);
        recyclerViewManHinhChinh.setHasFixedSize(true);
        listViewManHinhChinh = findViewById(R.id.listviewmanhinhchinh);
        navigationView = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawlayout);
        // khoi tao list
        mangloaisp = new ArrayList<>();
        mangspmoi = new ArrayList<>();
    }

    private boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo moblie = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null && wifi.isConnected()) || (moblie != null && moblie.isConnected())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}