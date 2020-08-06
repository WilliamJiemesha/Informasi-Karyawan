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
import android.widget.TextView;
import android.widget.Toast;

public class AbsensiKaryawan extends AppCompatActivity {
    TextView myTextView;
    Button myButton;
    int pageCountStartAt;
    int pageCountEndAt;
    int firstDigit;
    SQLiteforAbsensiKaryawan SQLAbsensi;
    String[] id = new String[9];
    String[] tanggal = new String[9];
    String IDTemp, TanggalTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi_karyawan);
        //Toolbars
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SQLAbsensi = new SQLiteforAbsensiKaryawan(this);
        //Set View
        myButton = (Button) findViewById(R.id.nextpagebutton);
        myButton.setVisibility(View.INVISIBLE);
        myButton = (Button) findViewById(R.id.previouspagebutton);
        myButton.setVisibility(View.INVISIBLE);
        firstDigit = 0;
        //Edit View
        checkCountforButtonNextandPrevious();

    }

    //Previous and Next Button
    public void checkCountforButtonNextandPrevious() {
        Cursor coo = SQLAbsensi.fetchDatabaseAll();

        //Page Next
        if (firstDigit != 0) {
            pageCountStartAt = firstDigit * 10;
            int save = coo.getCount() / 10;
            if (save < firstDigit) {
                pageCountEndAt = (firstDigit + 1) * 10;
            } else {
                pageCountEndAt = firstDigit * 10 + (coo.getCount() % 10);
                myButton = (Button) findViewById(R.id.nextpagebutton);
                myButton.setVisibility(View.INVISIBLE);
            }
        } else {
            pageCountStartAt = 0;
            if (coo.getCount() > 10) {
                pageCountEndAt = 10;
                myButton = (Button) findViewById(R.id.nextpagebutton);
                myButton.setVisibility(View.VISIBLE);
            } else {
                pageCountEndAt = coo.getCount();
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
    public void PreviousOnClick(View view) {
        Cursor cs = SQLAbsensi.fetchDatabaseAll();
        if (cs.getCount() > 10) {
            firstDigit--;
        }
        checkCountforButtonNextandPrevious();
    }
    public void NextOnClick(View view) {
        Cursor cs = SQLAbsensi.fetchDatabaseAll();
        if (cs.getCount() > 10) {
            firstDigit++;
        }
        checkCountforButtonNextandPrevious();
    }


    //Toolbar & Toolbar Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        //Shows '+' icon Top Right Side of Toolbar
        getMenuInflater().inflate(R.menu.menu_add_only, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_add:
                //What happens after menu '+' is Clicked
                Intent intention = new Intent(AbsensiKaryawan.this, AddAbsensi.class);
                startActivity(intention);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //RefreshBasically
    public void Refresh() {
        try {
            Clear();
            Cursor ct = SQLAbsensi.fetchDatabaseAll();
            SQLiteforInformasiKaryawan dbx = new SQLiteforInformasiKaryawan(this);
            Cursor cs = dbx.fetchDatabaseAll();
            if (ct.getCount() != 0) {
                //for (int i = pageCountStartAt; i < pageCountEndAt; i++) {
                int i = pageCountStartAt;
                int k = pageCountEndAt;
                int j = pageCountStartAt;
                ct.moveToFirst();
                while (j < k) {
                    try {
                        cs.moveToFirst();
                        boolean diditwork = false;
                        try{
                            String checkValue1 = cs.getString(0);
                            String checkValue2 = ct.getString(0);
                            while (!checkValue2.equals(checkValue1)){
                                cs.moveToNext();
                                checkValue1 = cs.getString(0);
                            }
                            IDTemp = checkValue1;
                            diditwork = true;
                        }catch(Exception ex){

                        }
                        if (diditwork == true) {
                            String NAME = cs.getString(1);
                            String DATE = ct.getString(1);
                            TanggalTemp = ct.getString(1);
                            String ABSENSI = ct.getString(2);

                            ChangeTextView(String.valueOf((j % 10) + 1), NAME, DATE, ABSENSI);
                            id[(j % 10)] = IDTemp;
                            tanggal[j % 10] = TanggalTemp;
                            j++;
                            ct.moveToNext();
                        }
                    } catch (Exception ex) {
                        if (i > ct.getCount()) {
                            j = k;
                        }
                    }
                    i++;
                }
            } else {
                Clear();
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void Clear() {
        for (int i = 0; i < 10; i++) {
            ChangeTextView(String.valueOf(i + 1), "---", "-", "--");
        }
    }

    public void ChangeTextView(String inputs, String NamaContent, String TanggalContent, String JenisAbsensiContent) {
        switch (inputs) {
            case ("1"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent1);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent1);
                myTextView.setText(TanggalContent);


                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent1);
                myTextView.setText(JenisAbsensiContent);

                break;
            case ("2"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent2);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent2);
                myTextView.setText(TanggalContent);

                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent2);
                myTextView.setText(JenisAbsensiContent);

                break;
            case ("3"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent3);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent3);
                myTextView.setText(TanggalContent);

                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent3);
                myTextView.setText(JenisAbsensiContent);

                break;
            case ("4"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent4);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent4);
                myTextView.setText(TanggalContent);

                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent4);
                myTextView.setText(JenisAbsensiContent);

                break;
            case ("5"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent5);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent5);
                myTextView.setText(TanggalContent);

                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent5);
                myTextView.setText(JenisAbsensiContent);

                break;
            case ("6"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent6);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent6);
                myTextView.setText(TanggalContent);

                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent6);
                myTextView.setText(JenisAbsensiContent);

                break;
            case ("7"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent7);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent7);
                myTextView.setText(TanggalContent);

                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent7);
                myTextView.setText(JenisAbsensiContent);

                break;
            case ("8"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent8);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent8);
                myTextView.setText(TanggalContent);

                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent8);
                myTextView.setText(JenisAbsensiContent);

                break;
            case ("9"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent9);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent9);
                myTextView.setText(TanggalContent);

                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent9);
                myTextView.setText(JenisAbsensiContent);

                break;
            case ("10"):
                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent10);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent10);
                myTextView.setText(TanggalContent);

                //Absensi
                myTextView = (TextView) findViewById(R.id.JenisAbsensiContent10);
                myTextView.setText(JenisAbsensiContent);

                break;
        }
    }

    //TextView Middle Clicked
    public void TextViewOnClick(View view) {
        Intent intent = new Intent(this, EditAbsensi.class);
        finish();
        switch (view.getId()) {
            case (R.id.NamaContent1):
                TextView t1 = findViewById(R.id.NamaContent1);
                if (t1.getText().toString() != "---") {
                    intent.putExtra("id", id[0]);
                    intent.putExtra("tanggal", tanggal[0]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent2):
                TextView t2 = findViewById(R.id.NamaContent2);
                if (t2.getText().toString() != "---") {
                    intent.putExtra("id", id[1]);
                    intent.putExtra("tanggal", tanggal[1]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent3):
                TextView t3 = findViewById(R.id.NamaContent3);
                if (t3.getText().toString() != "---") {
                    intent.putExtra("id", id[2]);
                    intent.putExtra("tanggal", tanggal[2]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent4):
                TextView t4 = findViewById(R.id.NamaContent4);
                if (t4.getText().toString() != "---") {
                    intent.putExtra("id", id[3]);
                    intent.putExtra("tanggal", tanggal[3]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent5):
                TextView t5 = findViewById(R.id.NamaContent5);
                if (t5.getText().toString() != "---") {
                    intent.putExtra("id", id[4]);
                    intent.putExtra("tanggal", tanggal[4]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent6):
                TextView t6 = findViewById(R.id.NamaContent6);
                if (t6.getText().toString() != "---") {
                    intent.putExtra("id", id[5]);
                    intent.putExtra("tanggal", tanggal[5]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent7):
                TextView t7 = findViewById(R.id.NamaContent7);
                if (t7.getText().toString() != "---") {
                    intent.putExtra("id", id[6]);
                    intent.putExtra("tanggal", tanggal[6]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent8):
                TextView t8 = findViewById(R.id.NamaContent8);
                if (t8.getText().toString() != "---") {
                    intent.putExtra("id", id[7]);
                    intent.putExtra("tanggal", tanggal[7]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent9):
                TextView t9 = findViewById(R.id.NamaContent9);
                if (t9.getText().toString() != "---") {
                    intent.putExtra("id", id[8]);
                    intent.putExtra("tanggal", tanggal[8]);
                    startActivity(intent);
                }
                break;
            case (R.id.NamaContent10):
                TextView t10 = findViewById(R.id.NamaContent10);
                if (t10.getText().toString() != "---") {
                    intent.putExtra("id", id[9]);
                    intent.putExtra("tanggal", tanggal[9]);
                    startActivity(intent);
                }
                break;
        }
    }
}