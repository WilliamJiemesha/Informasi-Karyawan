package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditAbsensi extends AppCompatActivity {
    SQLiteforAbsensiKaryawan SQLITE;
    String id;
    String tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_absensi);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        tanggal = intent.getStringExtra("tanggal");
        SQLITE = new SQLiteforAbsensiKaryawan(this);

        Cursor cs = SQLITE.fetchDatabaseAllBasedOnID(Integer.parseInt(id));
        String NAME = cs.getString(1);
        Button myButton = findViewById(R.id.buttondelete);
    }

    public void DeleteButtonOnClick(View view) {
        SQLITE.DeleteAbensi(Integer.parseInt(id), tanggal);
    }
}