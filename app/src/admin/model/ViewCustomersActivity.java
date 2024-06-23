package src.admin.model;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewCustomersActivity extends AppCompatActivity {

    private ListView lvCustomers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customers);

        lvCustomers = findViewById(R.id.lvCustomers);

        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<List<Customer>> call = apiService.getCustomers();

        call.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                List<Customer> customers = response.body();
                ArrayAdapter<Customer> adapter = new ArrayAdapter<>(ViewCustomersActivity.this, android.R.layout.simple_list_item_1, customers);
                lvCustomers.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                // Xử lý lỗi kết nối
            }
        });
    }
}