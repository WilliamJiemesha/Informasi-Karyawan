package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {
    //Intents
    Intent intentInformasiKaryawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Declare Intents
        intentInformasiKaryawan  = new Intent(this, InformasiKaryawan.class);

        setTitle("Choose Category");
    }

    public void InformasiKaryawanOnClick(View view) {
        startActivity(intentInformasiKaryawan);
    }

}