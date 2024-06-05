package com.example.myapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class ViewCustomersActivity extends AppCompatActivity {

    private ListView lvCustomers;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customers);

        lvCustomers = findViewById(R.id.lvCustomers);
        dbHelper = new DatabaseHelper(this);

        loadCustomers();
    }

    private void loadCustomers() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("KhachHang", null, null, null, null, null, null);

        String[] from = {"MaKH", "HoTen", "SDT"};
        int[] to = {R.id.tvMaKH, R.id.tvHoTen, R.id.tvSDT};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item_customer, cursor, from, to, 0);
        lvCustomers.setAdapter(adapter);
    }
}
