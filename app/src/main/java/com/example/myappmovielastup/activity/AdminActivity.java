package com.example.myappmovielastup.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myappmovielastup.R;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Product> productList;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Initialize ListView and populate data
        listView = findViewById(R.id.listView);
        productList = new ArrayList<>();
        populateProductList();
        adapter = new ProductAdapter(this, productList);
        listView.setAdapter((ListAdapter) adapter);

        // Handle item clicks (optional)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click if needed
                Toast.makeText(AdminActivity.this, "Clicked item: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateProductList() {
        // Example data, replace with your actual data source (e.g., database)
        productList.add(new Product("Product 1", "Type A", R.drawable.giaveupdata));
        productList.add(new Product("Product 2", "Type B", R.drawable.giaveupdata));
        productList.add(new Product("Product 3", "Type C", R.drawable.giaveupdata));
        // Add more products as needed
    }
}