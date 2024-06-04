package com.example.myappmovielastup.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappmovielastup.R;
import com.example.myappmovielastup.adapter.TheLoaiAdapter;
import com.example.myappmovielastup.model.PhimMoi;
import com.example.myappmovielastup.retrofit.ApiBanHang;
import com.example.myappmovielastup.retrofit.RetrofitClient;
import com.example.myappmovielastup.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TheLoaiActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ApiBanHang apiBanHang;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    //int page = 0;
    int theloaiid;
    TheLoaiAdapter adapterTL;
    List<PhimMoi> phimMoiList;
    LinearLayoutManager linearLayoutManager;
    Handler handler = new Handler();
    boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        theloaiid = getIntent().getIntExtra("theloaiid", 1);
        Anhxa();
        ActionToolBar();
        getData();
        addEventLoad();
    }

    private void addEventLoad() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isLoading == false) {
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == phimMoiList.size() - 1) {
                        isLoading = true;
                        loadMore();
                    }
                }
            }
        });
    }

    private void loadMore() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                // add null
                phimMoiList.add(null);
                adapterTL.notifyItemInserted(phimMoiList.size() - 1);
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // remover null
                phimMoiList.remove(phimMoiList.size() - 1);
                adapterTL.notifyItemRemoved(phimMoiList.size());
                //page = page + 1;
                //getData(page);
                adapterTL.notifyDataSetChanged();
                isLoading = false;
            }
        }, 2000);
    }

    private void getData() {
        compositeDisposable.add(apiBanHang.getPhim(theloaiid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        phimMoiModel -> {
                            if (phimMoiModel.isSuccess()) {
                                if (adapterTL == null) {
                                    phimMoiList = phimMoiModel.getResult();
                                    adapterTL = new TheLoaiAdapter(getApplicationContext(), phimMoiList);
                                    recyclerView.setAdapter(adapterTL);
                                } else {
                                    int vitri = phimMoiList.size() - 1;
                                    int soluongadd = phimMoiModel.getResult().size();
                                    for (int i = 0; i < soluongadd; i++) {
                                        phimMoiList.add(phimMoiModel.getResult().get(i));
                                    }
                                    adapterTL.notifyItemRangeInserted(vitri, soluongadd);
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "het du lieu roi", Toast.LENGTH_LONG).show();
                            }
                        }
                        , throwable -> {
                            Toast.makeText(getApplicationContext(), "ko the ket noi", Toast.LENGTH_LONG).show();
                        }
                ));
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbar = findViewById(R.id.toobar);
        recyclerView = findViewById(R.id.recyclerview_dp);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        phimMoiList = new ArrayList<>();
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}