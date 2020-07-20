package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {
    //Intents
    Intent intentInformasiKaryawan, intentAbsensiKaryawan, intentGajiKaryawan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Declare Intents
        intentInformasiKaryawan  = new Intent(this, InformasiKaryawan.class);
        intentAbsensiKaryawan = new Intent(this, AbsensiKaryawan.class);
        intentGajiKaryawan = new Intent(this, GajiKaryawan.class);
        setTitle("Karyawan Menu");
    }

    public void InformasiKaryawanOnClick(View view) {
        startActivity(intentInformasiKaryawan);
    }

    public void AbsensiOnClick(View view) { startActivity(intentAbsensiKaryawan); }

    public void GajiOnClick(View view) { startActivity(intentGajiKaryawan); }
}