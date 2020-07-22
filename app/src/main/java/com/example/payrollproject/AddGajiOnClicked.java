package com.example.payrollproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.CalendarView;
import android.widget.EditText;

public class AddGajiOnClicked extends AppCompatActivity {
    SQLiteforGajiKaryawan SQLITE;
    String date, Inputan, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gaji_on_clicked);
        Intent intent = getIntent();
        SQLITE = new SQLiteforGajiKaryawan(this);
        id = intent.getStringExtra("id");

        //Popup and Calendar
        CalendarView v = new CalendarView(this);
        v = findViewById(R.id.calendarGaji);
        v.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = year + "-" + month + "-" + dayOfMonth;

                //Pop up Window Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(AddGajiOnClicked.this);
                builder.setTitle("Masukkan Jumlah Gaji");

                // Set up the input
                final EditText input = new EditText(AddGajiOnClicked.this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                input.setMaxEms(8);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Inputan = input.getText().toString();
                        SQLITE.insertDatabase(id, date, Inputan);
                        Intent intent = new Intent(AddGajiOnClicked.this, GajiKaryawan.class);
                        finish();
                        startActivity(intent);
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
        });}
    }