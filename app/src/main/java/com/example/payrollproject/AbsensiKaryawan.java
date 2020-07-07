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

public class AbsensiKaryawan extends AppCompatActivity {
    TextView myTextView;
    Button myButton;
    int pageCountStartAt;
    int pageCountEndAt;
    int firstDigit;
    SQLiteforAbsensiKaryawan SQLAbsensi;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi_karyawan);
        //Toolbars
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Set View
        myButton = (Button) findViewById(R.id.nextpagebutton);
        myButton.setVisibility(View.INVISIBLE);
        myButton = (Button) findViewById(R.id.previouspagebutton);
        myButton.setVisibility(View.INVISIBLE);

        //Edit View
        checkCountforButtonNextandPrevious();

        //Refresh
        Refresh();

    }

    //Previous and Next Button
    public void checkCountforButtonNextandPrevious() {
        Cursor cs = SQLAbsensi.fetchDatabaseAll();

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
            if (ct.getCount() != 0) {
                //for (int i = pageCountStartAt; i < pageCountEndAt; i++) {
                int i = pageCountStartAt;
                int k = pageCountEndAt;
                int j = pageCountStartAt;
                ct.moveToFirst();
                while (j < k) {
                    try {
                        String ID = ct.getString(0);
                        String NAME = ct.getString(1);
                        String DATE = ct.getString(2);

                        ChangeTextView(String.valueOf((j % 10) + 1), ID, NAME, DATE);
                        j++;
                        ct.moveToNext();
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
    }
}