package com.example.payrollproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

public class AddAbsensiFormAfterClicked extends AppCompatActivity {
    SQLiteforAbsensiKaryawan SQLITE;
    String id, date, Inputan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_absensi_form_after_clicked);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        SQLITE = new SQLiteforAbsensiKaryawan(this);

        setTitle("Add Absensi");

        CalendarView v = new CalendarView( this );
        v = findViewById(R.id.calendarView);
        v.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = year + "-" + month + "-" + dayOfMonth;

                //Pop up Window Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(AddAbsensiFormAfterClicked.this);
                builder.setTitle("Masukkan Jenis Absensi");

                // Set up the input
                final EditText input = new EditText(AddAbsensiFormAfterClicked.this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input.setMaxEms(4);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Inputan = input.getText().toString();
                        SQLITE.insertDatabase(id, date, Inputan);
                        Intent intent = new Intent(AddAbsensiFormAfterClicked.this, AbsensiKaryawan.class);
                        startActivity(intent);
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