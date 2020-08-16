package com.example.payrollproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Date;

public class AddKaryawan extends AppCompatActivity {
    SQLiteforInformasiKaryawan InformasiKaryawan;
    String date, Inputan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_karyawan);

        InformasiKaryawan = new SQLiteforInformasiKaryawan(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Add Karyawan");
        CalendarView v;
        v = findViewById(R.id.calendarInformasiKaryawan);
        v.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = year + "-" + month + "-" + dayOfMonth;

                //Pop up Window Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(AddKaryawan.this);
                builder.setTitle("Masukkan Nama Karyawan");

                // Set up the input
                final EditText input = new EditText(AddKaryawan.this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input.setMaxEms(15);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Inputan = input.getText().toString();
                        Cursor cuu = InformasiKaryawan.fetchDatabaseAll();
                        InformasiKaryawan.insertDatabase(String.valueOf(cuu.getCount() + 1), Inputan, date, 1);
                        Toast.makeText(AddKaryawan.this, "Inserted "+ Inputan +" To Database", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(AddKaryawan.this, InformasiKaryawan.class);
                        startActivity(in);
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

            }
        });
    }
}