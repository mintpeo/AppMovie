
package src.admin.model;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

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

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<List<Movie>> call = apiService.getMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                List<Movie> movies = response.body();
                ArrayAdapter<Movie> adapter = new ArrayAdapter<>(ManageMoviesActivity.this, android.R.layout.simple_list_item_1, movies);
                lvMovies.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                // Xử lý lỗi kết nối
            }
        });
    }
}
