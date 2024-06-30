package com.example.myappmovielastup.retrofit;

import com.example.myappmovielastup.model.Booking;
import com.example.myappmovielastup.model.Customer;
import com.example.myappmovielastup.model.LoaiPhimModel;
import com.example.myappmovielastup.model.PhimMoi;
import com.example.myappmovielastup.model.PhimMoiModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiBanHang {
    // thanh menu
    @GET("toolbarproduct.php")
    Observable<LoaiPhimModel> getLoaiSp();

    // hien thi san pham
    @GET("sanphammoi.php")
    Observable<PhimMoiModel> getSpMoi();

    // phan loai phim
    @POST("dangphim.php")
    @FormUrlEncoded
    Observable<PhimMoiModel> getPhim(
            //@Field("page") int page,
            @Field("theloaiid") int theloaiid
    );
    @GET("movies")
    Call<List<PhimMoi>> getPhimMoi();

    @GET("bookings")  // Thay "bookings" bằng endpoint thực tế của API
    Call<List<Booking>> getBookings();
    @GET("customer")
    Call<List<Customer>> getCustomer();
}
