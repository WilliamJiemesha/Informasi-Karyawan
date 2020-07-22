package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class GajiKaryawan extends AppCompatActivity {
    TextView myTextView;
    SQLiteforGajiKaryawan GajiKaryawan;
    Button myButton;
    int pageCountStartAt;
    int pageCountEndAt;
    int firstDigit;
    String[] ID = new String[9];
    String[] Tanggal = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_karyawan);
        GajiKaryawan = new SQLiteforGajiKaryawan(this);
        firstDigit = 0;
        myButton = (Button) findViewById(R.id.nextpagebutton);
        myButton.setVisibility(View.INVISIBLE);
        myButton = (Button) findViewById(R.id.previouspagebutton);
        myButton.setVisibility(View.INVISIBLE);

        checkCountforButtonNextandPrevious();
        Refresh();

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Gaji Karyawan");
    }


    public void checkCountforButtonNextandPrevious() {
        Cursor cs = GajiKaryawan.fetchDatabaseAll();
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

    public void ChangeTextView(String inputs, String NamaContent, String GajiContent, String TanggalContent) {
        switch (inputs) {
            case ("1"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent1);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent1);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent1);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("2"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent2);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent2);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent2);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("3"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent3);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent3);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent3);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("4"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent4);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent4);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent4);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("5"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent5);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent5);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent5);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("6"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent6);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent6);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent6);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("7"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent7);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent7);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent7);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("8"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent8);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent8);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent8);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("9"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent9);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent9);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent9);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;
            case ("10"):
                //ID
                myTextView = (TextView) findViewById(R.id.NamaContent10);
                myTextView.setText(NamaContent);
                myTextView.setGravity(Gravity.CENTER);
                //Nama
                myTextView = (TextView) findViewById(R.id.GajiContent10);
                myTextView.setText(GajiContent);
                myTextView.setGravity(Gravity.CENTER);
                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent10);
                myTextView.setText(TanggalContent);
                myTextView.setGravity(Gravity.CENTER);
                break;


        }
    }

    public void PreviousOnClick(View view) {
        Cursor cs = GajiKaryawan.fetchDatabaseAll();
        if (cs.getCount() > 10) {
            firstDigit--;
        }
        checkCountforButtonNextandPrevious();
    }

    public void Refresh() {
        try {
            Clear();
            Cursor cs = GajiKaryawan.fetchDatabaseAll();
            if (cs.getCount() != 0) {
                //for (int i = pageCountStartAt; i < pageCountEndAt; i++) {
                int i = pageCountStartAt;
                int k = pageCountEndAt;
                int j = pageCountStartAt;
                Cursor ct = GajiKaryawan.fetchDatabaseAll();
                //Informasi Karyawan

                SQLiteforInformasiKaryawan SQL = new SQLiteforInformasiKaryawan(this);
                Cursor cu = SQL.fetchDatabaseAll();
                cu.moveToFirst();

                //End of InformasiKaryawan
                ct.moveToFirst();
                boolean pembenar = false;
                while (j < k) {
                    try {
                        String IDTemp = null;
                        String TanggalTemp = null;
                        try {
                            String strOne = cu.getString(0);
                            String strTwo = ct.getString(0);
                            while (!strOne.equals(strTwo)) {
                                cu.moveToNext();
                                strOne = cu.getString(0);
                            }
                            pembenar = true;
                            IDTemp = strOne;
                        } catch (Exception ex) {

                        }
                        if (pembenar == true) {

                            String NAMA = cu.getString(1);
                            String GAJI = ct.getString(1);
                            String DATE = ct.getString(2);

                            ChangeTextView(String.valueOf((j % 10) + 1), NAMA, DATE, GAJI);
                            ID[j % 10] = IDTemp;
                            Tanggal[j % 10] = DATE;
                            j++;
                            ct.moveToNext();
                        }
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
        Cursor cs = GajiKaryawan.fetchDatabaseAll();
        if (cs.getCount() > 10) {
            firstDigit++;
        }
        checkCountforButtonNextandPrevious();
    }


    //Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_only, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_add:
                finish();
                Intent intent = new Intent(this, AddGaji.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    //OnClickTextView
    public void TextViewOnClick(View view) {
        Intent intent = new Intent(this, EditGaji.class); // Ganti Bangke
        switch (view.getId()) {
            case (R.id.NamaContent1):
                TextView t1 = findViewById(R.id.NamaContent1);
                if (t1.getText().toString() != "---") {
                    intent.putExtra("id", ID[0]);
                    intent.putExtra("tanggal", Tanggal[0]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent2):
                TextView t2 = findViewById(R.id.NamaContent2);
                if (t2.getText().toString() != "---") {
                    intent.putExtra("id", ID[1]);
                    intent.putExtra("tanggal", Tanggal[1]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent3):
                TextView t3 = findViewById(R.id.NamaContent3);
                if (t3.getText().toString() != "---") {
                    intent.putExtra("id", ID[2]);
                    intent.putExtra("tanggal", Tanggal[2]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent4):
                TextView t4 = findViewById(R.id.NamaContent4);
                if (t4.getText().toString() != "---") {
                    intent.putExtra("id", ID[3]);
                    intent.putExtra("tanggal", Tanggal[3]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent5):
                TextView t5 = findViewById(R.id.NamaContent5);
                if (t5.getText().toString() != "---") {
                    intent.putExtra("id", ID[4]);
                    intent.putExtra("tanggal", Tanggal[4]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent6):
                TextView t6 = findViewById(R.id.NamaContent6);
                if (t6.getText().toString() != "---") {
                    intent.putExtra("id", ID[5]);
                    intent.putExtra("tanggal", Tanggal[5]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent7):
                TextView t7 = findViewById(R.id.NamaContent7);
                if (t7.getText().toString() != "---") {
                    intent.putExtra("id", ID[6]);
                    intent.putExtra("tanggal", Tanggal[6]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent8):
                TextView t8 = findViewById(R.id.NamaContent8);
                if (t8.getText().toString() != "---") {
                    intent.putExtra("id", ID[7]);
                    intent.putExtra("tanggal", Tanggal[7]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent9):
                TextView t9 = findViewById(R.id.NamaContent9);
                if (t9.getText().toString() != "---") {
                    intent.putExtra("id", ID[8]);
                    intent.putExtra("tanggal", Tanggal[8]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent10):
                TextView t10 = findViewById(R.id.NamaContent10);
                if (t10.getText().toString() != "---") {
                    intent.putExtra("id", ID[9]);
                    intent.putExtra("tanggal", Tanggal[9]);
                    startActivity(intent);
                }
                break;
        }
        finish();
    }
    
}