package com.example.myappmovielastup.activity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myappmovielastup.R;
import com.example.myappmovielastup.model.Booking;
import com.example.myappmovielastup.retrofit.ApiBanHang;
import com.example.myappmovielastup.retrofit.RetrofitClient;
import com.example.myappmovielastup.utils.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBookingsActivity extends AppCompatActivity {

    private ListView lvBookings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bookings);

        lvBookings = findViewById(R.id.lvBookings);

        ApiBanHang apiService = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        Call<List<Booking>> call = apiService.getBookings();

        call.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {
                List<Booking> bookings = response.body();
                ArrayAdapter<Booking> adapter = new ArrayAdapter<>(ViewBookingsActivity.this, android.R.layout.simple_list_item_1, bookings);
                lvBookings.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {
                // Xử lý lỗi kết nối
            }
        });
    }
}

