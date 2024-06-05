package com.example.myapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class ViewBookingsActivity extends AppCompatActivity {

    private ListView lvBookings;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bookings);

        lvBookings = findViewById(R.id.lvBookings);
        dbHelper = new DatabaseHelper(this);

        loadBookings();
    }

    private void loadBookings() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("Ve", null, null, null, null, null, null);

        String[] from = {"MaVe", "MaKH", "NgayBanVe"};
        int[] to = {R.id.tvMaVe, R.id.tvMaKH, R.id.tvNgayBanVe};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item_booking, cursor, from, to, 0);
        lvBookings.setAdapter(adapter);
    }
}
