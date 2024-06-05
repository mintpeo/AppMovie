package src.admin.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    private Button btnViewBookings;
    private Button btnManageMovies;
    private Button btnViewCustomers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        btnViewBookings = findViewById(R.id.btnViewBookings);
        btnManageMovies = findViewById(R.id.btnManageMovies);
        btnViewCustomers = findViewById(R.id.btnViewCustomers);

        btnViewBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, ViewBookingsActivity.class);
                startActivity(intent);
            }
        });

        btnManageMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, ManageMoviesActivity.class);
                startActivity(intent);
            }
        });

        btnViewCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboardActivity.this, ViewCustomersActivity.class);
                startActivity(intent);
            }
        });
    }
}
