package com.example.myapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class ManageMoviesActivity extends AppCompatActivity {

    private ListView lvMovies;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_movies);

        lvMovies = findViewById(R.id.lvMovies);
        dbHelper = new DatabaseHelper(this);

        loadMovies();
    }

    private void loadMovies() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("Phim", null, null, null, null, null, null);

        String[] from = {"MaPhim", "TenPhim", "NSX"};
        int[] to = {R.id.tvMaPhim, R.id.tvTenPhim, R.id.tvNSX};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item_movie, cursor, from, to, 0);
        lvMovies.setAdapter(adapter);
    }
}
