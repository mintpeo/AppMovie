package com.example.myappmovielastup.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myappmovielastup.model.PhimMoi;
import com.example.myappmovielastup.retrofit.ApiBanHang;
import com.example.myappmovielastup.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageMoviesActivity extends AppCompatActivity {

    private ListView lvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_movies);

        lvMovies = findViewById(R.id.lvMovies);

        ApiBanHang apiService = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        Call<List<PhimMoi>> call = apiService.getPhimMoi();

        call.enqueue(new Callback<List<PhimMoi>>() {
            @Override
            public void onResponse(Call<List<PhimMoi>> call, Response<List<PhimMoi>> response) {
                List<PhimMoi> movies = response.body();
                ArrayAdapter<PhimMoi> adapter = new ArrayAdapter<>(ManageMoviesActivity.this, android.R.layout.simple_list_item_1, movies);
                lvMovies.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PhimMoi>> call, Throwable t) {
                // Xử lý lỗi kết nối
            }
        });
    }
}

