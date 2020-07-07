package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeleteKaryawan extends AppCompatActivity {
    public static int IDKaryawanUntukDihapus;

    SQLiteforInformasiKaryawan InformasiKaryawan;
    InformasiKaryawan ik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_karyawan);
        ik = new InformasiKaryawan();
        Intent intent = getIntent();
        String value = intent.getStringExtra("id");
        IDKaryawanUntukDihapus = Integer.parseInt(value);

        InformasiKaryawan = new SQLiteforInformasiKaryawan(this);
        Cursor cs = InformasiKaryawan.fetchDatabaseBasedOnId(IDKaryawanUntukDihapus);
        cs.moveToFirst();
        String NAME = cs.getString(1);
        Button buttond = (Button)findViewById(R.id.buttondelete);
        buttond.setText("Delete Karyawan bernama " + NAME + "?");
    }

    public void DeleteOnClick(View view) {
        InformasiKaryawan.DeleteKaryawan(IDKaryawanUntukDihapus);
        Intent intents = new Intent(this, InformasiKaryawan.class);
        startActivity(intents);
        finish();
    }
}