package com.example.myappmovielastup.retrofit;

import com.example.myappmovielastup.model.LoaiPhimModel;
import com.example.myappmovielastup.model.MessageModel;
import com.example.myappmovielastup.model.PhimMoiModel;
import com.example.myappmovielastup.model.UserModel;
import io.reactivex.rxjava3.disposables.Disposable;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiPhim {
    // thanh menu
    @GET("toolbarproduct.php")
    Observable<LoaiPhimModel> getLoaiPhim();

    // hien thi san pham
    @GET("sanphammoi.php")
    Observable<PhimMoiModel> getPhimMoi();

    // phan loai phim
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
    // Đăng kí
    @POST("register.php")
    @FormUrlEncoded
    Observable<UserModel> signup(
            @Field("email") String email,
            @Field("pass") String pass
    );

    // Đăng nhập
    @POST("login.php")
    @FormUrlEncoded
    Observable<UserModel> login(
            @Field("email") String email,
            @Field("pass") String pass
    );

    @POST("themphim.php")
    @FormUrlEncoded
    Observable<MessageModel> insertPhim(
            @Field("tenphim") String tenphim,
            @Field("hinhanh") String hinhanh,
            @Field("daodien") String daodien,
            @Field("dienvien") String dienvien,
            @Field("thoiluong") String thoiluong,
            @Field("ngonngu") String ngonngu,
            @Field("mota") String mota,
            @Field("theloaiid") int theloaiid
    );
}
