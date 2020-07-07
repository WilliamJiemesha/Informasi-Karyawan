package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Date;

public class AddKaryawan extends AppCompatActivity {
    SQLiteforInformasiKaryawan InformasiKaryawan;
    InformasiKaryawan karyawan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_karyawan);

        InformasiKaryawan = new SQLiteforInformasiKaryawan(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Add Karyawan");
    }

    public void ButtonAddOnClick(View view) {
        EditText anotherEditText = (EditText) findViewById(R.id.edittextname);
        if (anotherEditText.getText().toString().equals("")) {
        } else {
            EditText newEditText = (EditText) findViewById(R.id.edittexttanggalmasuk);
            if (newEditText.getText().toString().equals("")) {
            } else {
                Cursor cu = InformasiKaryawan.fetchDatabaseAll();
                InformasiKaryawan.insertDatabase(String.valueOf(cu.getCount() + 1), anotherEditText.getText().toString(), newEditText.getText().toString(), 1);
                TextView mt = findViewById(R.id.edittexttanggalmasuk);
                mt.setText("");
                mt = findViewById(R.id.edittextname);
                mt.setText("");

                Intent in = new Intent(this, InformasiKaryawan.class);
                Toast.makeText(this, "Inserted" + anotherEditText.getText().toString() + "To Database", Toast.LENGTH_SHORT).show();
                startActivity(in);
                finish();
            }
        }
    }
}