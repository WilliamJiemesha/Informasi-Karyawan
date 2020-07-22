package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Ref;

//SENDING ID FROM HERE TO ADDABSENSIFORMAFTERCLICKED <---------- IMPORTANT // On The Making


public class AddAbsensi extends AppCompatActivity {
    SQLiteforInformasiKaryawan InformasiKaryawan;
    Button myButton;
    TextView myTextView;
    int pageCountStartAt;
    int pageCountEndAt;
    int firstDigit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_absensi);
        setTitle("Pilih Karyawan");
        myButton = findViewById(R.id.nextpagebutton);
        myButton.setVisibility(View.INVISIBLE);
        firstDigit = 0;
        InformasiKaryawan = new SQLiteforInformasiKaryawan(this);
        checkCountforButtonNextandPrevious();
    }
    public void checkCountforButtonNextandPrevious() {
        Cursor cs = InformasiKaryawan.fetchDatabaseAllActive();

        //Page Next
        if (firstDigit != 0) {
            pageCountStartAt = firstDigit * 10;
            int save = cs.getCount() / 10;
            if (save < firstDigit) {
                pageCountEndAt = (firstDigit + 1) * 10;
            } else {
                pageCountEndAt = firstDigit * 10 + (cs.getCount() % 10);
                myButton = (Button) findViewById(R.id.nextpagebutton);
                myButton.setVisibility(View.INVISIBLE);
            }
        } else {
            pageCountStartAt = 0;
            if (cs.getCount() > 10) {
                pageCountEndAt = 10;
                myButton = (Button) findViewById(R.id.nextpagebutton);
                myButton.setVisibility(View.VISIBLE);
            } else {
                pageCountEndAt = cs.getCount();
            }
        }

        //Page Previous
        if (firstDigit > 0) {
            myButton = (Button) findViewById(R.id.previouspagebutton);
            myButton.setVisibility(View.VISIBLE);
        } else {
            myButton = (Button) findViewById(R.id.previouspagebutton);
            myButton.setVisibility(View.INVISIBLE);
        }
        Refresh();

    }
    public void ChangeTextView(String inputs, String IDContent, String NamaContent, String TanggalContent) {
        switch (inputs) {
            case ("1"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent1);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent1);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent1);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("2"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent2);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent2);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent2);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("3"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent3);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent3);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent3);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("4"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent4);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent4);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent4);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("5"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent5);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent5);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent5);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("6"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent6);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent6);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent6);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("7"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent7);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent7);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent7);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("8"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent8);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent8);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent8);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("9"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent9);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent9);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent9);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("10"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent10);
                myTextView.setText(IDContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent10);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent10);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;


        }
    }

    public void PreviousOnClick(View view) {
        Cursor cs = InformasiKaryawan.fetchDatabaseAllActive();
        if (cs.getCount() > 10) {
            firstDigit--;
        }
        checkCountforButtonNextandPrevious();
    }

    public void Refresh() {
        try {
            Clear();
            Cursor cs = InformasiKaryawan.fetchDatabaseAllActive();
            if (cs.getCount() != 0) {
                //for (int i = pageCountStartAt; i < pageCountEndAt; i++) {
                int i = pageCountStartAt;
                int k = pageCountEndAt;
                int j = pageCountStartAt;
                while (j < k) {
                    try {
                        Cursor ct = InformasiKaryawan.fetchDatabaseBasedOnId(i + 1);
                        ct.moveToFirst();

                        String ID = ct.getString(0);
                        String NAME = ct.getString(1);
                        String DATE = ct.getString(2);

                        ChangeTextView(String.valueOf((j % 10) + 1), ID, NAME, DATE);
                        j++;
                    } catch (Exception ex) {
                        if (i > cs.getCount()) {
                            j = k;
                        }
                    }
                    i++;

                }

                //}
            } else {
                Clear();
            }
        } catch (Exception ex) {

        }
    }

    public void Clear() {
        for (int i = 0; i < 10; i++) {
            ChangeTextView(String.valueOf(i + 1), "---", "-", "--");
        }
    }

    public void NextOnClick(View view) {
        Cursor cs = InformasiKaryawan.fetchDatabaseAllActive();
        if (cs.getCount() > 10) {
            firstDigit++;
        }
        checkCountforButtonNextandPrevious();
    }

    public void TextViewOnClick(View view) {
        Intent intent = new Intent(this, AddAbsensiFormAfterClicked.class);
        switch (view.getId()) {
            case (R.id.NamaContent1):
                TextView t1 = findViewById(R.id.IDContent1);
                if (t1.getText().toString() != "---") {
                    intent.putExtra("id", t1.getText().toString());
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent2):
                TextView t2 = findViewById(R.id.IDContent2);
                if (t2.getText().toString() != "---") {
                    intent.putExtra("id", t2.getText().toString());
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent3):
                TextView t3 = findViewById(R.id.IDContent3);
                if (t3.getText().toString() != "---") {
                    intent.putExtra("id", t3.getText().toString());
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent4):
                TextView t4 = findViewById(R.id.IDContent4);
                if (t4.getText().toString() != "---") {
                    intent.putExtra("id", t4.getText().toString());
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent5):
                TextView t5 = findViewById(R.id.IDContent5);
                if (t5.getText().toString() != "---") {
                    intent.putExtra("id", t5.getText().toString());
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent6):
                TextView t6 = findViewById(R.id.IDContent6);
                if (t6.getText().toString() != "---") {
                    intent.putExtra("id", t6.getText().toString());
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent7):
                TextView t7 = findViewById(R.id.IDContent7);
                if (t7.getText().toString() != "---") {
                    intent.putExtra("id", t7.getText().toString());
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent8):
                TextView t8 = findViewById(R.id.IDContent8);
                if (t8.getText().toString() != "---") {
                    intent.putExtra("id", t8.getText().toString());
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent9):
                TextView t9 = findViewById(R.id.IDContent9);
                if (t9.getText().toString() != "---") {
                    intent.putExtra("id", t9.getText().toString());
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent10):
                TextView t10 = findViewById(R.id.IDContent10);
                if (t10.getText().toString() != "---") {
                    intent.putExtra("id", t10.getText().toString());
                    startActivity(intent);
                }
                break;
        }
        finish();
    }

}