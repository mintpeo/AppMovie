package com.example.myappmovielastup.retrofit;

import com.example.myappmovielastup.model.LoaiSpModel;
import com.example.myappmovielastup.model.SanPhamMoiModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiBanHang {
    @GET("banhang.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("sanphammoi.php")
    Observable<SanPhamMoiModel> getSpMoi();
}
