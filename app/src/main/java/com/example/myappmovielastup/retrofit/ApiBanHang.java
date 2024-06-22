package com.example.myappmovielastup.retrofit;

import com.example.myappmovielastup.model.LoaiPhimModel;
import com.example.myappmovielastup.model.PhimMoiModel;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiBanHang {
    @GET("toolbarproduct.php")
    Observable<LoaiPhimModel> getLoaiSp();

    @GET("sanphammoi.php")
    Observable<PhimMoiModel> getSpMoi();

    @POST("dangphim.php")
    @FormUrlEncoded
    Observable<PhimMoiModel> getPhim(
            //@Field("page") int page,
            @Field("theloaiid") int theloaiid
    );
    @POST("timkiem.php")
    @FormUrlEncoded
    Observable<PhimMoiModel> search(
            //@Field("page") int page,
            @Field("search") String search
    );

}