package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditGaji extends AppCompatActivity {
    Button myButton;
    SQLiteforInformasiKaryawan SQLIK;
    SQLiteforGajiKaryawan SQLGK;
    String ID, DATE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gaji);
        //Declares
        SQLIK = new SQLiteforInformasiKaryawan(this);
        Intent intent = getIntent();
        ID = intent.getStringExtra("id");
        DATE = intent.getStringExtra("tanggal");

        Cursor ct = SQLIK.fetchDatabaseBasedOnId(Integer.parseInt(ID));
        ct.moveToFirst();
        String NAME = ct.getString(1);

        myButton = findViewById(R.id.deleteButton);
        myButton.setText("DELETE INFO GAJI " + NAME + " ON " + DATE);
    }

    public void ButtonDeleteOnClick(View view) {
        SQLGK = new SQLiteforGajiKaryawan(this);
        SQLGK.DeleteGaji(Integer.parseInt(ID), DATE);
        finish();
    }
}