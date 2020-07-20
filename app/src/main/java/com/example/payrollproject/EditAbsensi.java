package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//DELETE DOESNT WORK FOR SOME REASON <---------- IMPORTANT


public class EditAbsensi extends AppCompatActivity {
    SQLiteforInformasiKaryawan SQLITE;
    SQLiteforAbsensiKaryawan SQLAB;
    String id;
    String tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_absensi);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        tanggal = intent.getStringExtra("tanggal");
        SQLITE = new SQLiteforInformasiKaryawan(this);
        SQLAB = new SQLiteforAbsensiKaryawan(this);

        try {
            Cursor cs = SQLITE.fetchDatabaseBasedOnId(Integer.parseInt(id));
            cs.moveToFirst();
            String DATE = cs.getString(1);
            cs = SQLAB.fetchDatabaseAllBasedOnID(Integer.parseInt(id));
            cs.moveToFirst();
            String ABSENSI = cs.getString(2);
            Button myButton = findViewById(R.id.buttonDelete);
            myButton.setText("DELETE ABSENSI TANGGAL "+ DATE +", ALASAN: "+ ABSENSI);
        }catch (Exception ex){
            String What = ex.toString();
        }
    }

    public void DeleteButtonOnClick(View view) {
        try {
            SQLAB.DeleteAbsensi(Integer.parseInt(id), tanggal);
            Intent intention = new Intent(this, AbsensiKaryawan.class);
            startActivity(intention);
            finish();
        }catch (Exception ex){
            String what = ex.toString();
        }
    }
}