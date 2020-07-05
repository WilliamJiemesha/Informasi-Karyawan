package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class InformasiKaryawan extends AppCompatActivity {
    TextView myTextView;
    SQLiteforInformasiKaryawan InformasiKaryawan;
    Switch mySwitch;
    EditText myEditText;
    Button myButton;
    int pageCountStartAt;
    int pageCountEndAt;
    int firstDigit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_karyawan);
        //Declare Objects
        InformasiKaryawan = new SQLiteforInformasiKaryawan(this);
        mySwitch = (Switch) findViewById(R.id.EditChecked);

        //Making invisible for onCreate
        myEditText = (EditText) findViewById(R.id.edittextname);
        myEditText.setVisibility(View.INVISIBLE);
        myEditText = (EditText) findViewById(R.id.edittextidfordeletion);
        myEditText.setVisibility(View.INVISIBLE);
        myEditText = (EditText) findViewById(R.id.edittexttanggalmasuk);
        myEditText.setVisibility(View.INVISIBLE);

        myButton = (Button) findViewById(R.id.buttonadd);
        myButton.setVisibility(View.INVISIBLE);
        myButton = (Button) findViewById(R.id.buttondelete);
        myButton.setVisibility(View.INVISIBLE);
        myButton = (Button) findViewById(R.id.nextpagebutton);
        myButton.setVisibility(View.INVISIBLE);
        myButton = (Button) findViewById(R.id.previouspagebutton);
        myButton.setVisibility(View.INVISIBLE);
        //ForPages
        firstDigit = 0;
        checkCountforButtonNextandPrevious();
        //InformasiKaryawan.clearDatabase("informasi_karyawan"); <-- For Reset Database if needed. Will crash on start application.

        //Getting from DB and Insert into textviews
        Refresh();

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Informasi Karyawan");

    }

    public void checkCountforButtonNextandPrevious() {
        Cursor cs = InformasiKaryawan.fetchDatabaseAll();

        //Page Next
        if (firstDigit != 0) {
            pageCountStartAt = firstDigit * 10;
            int save = cs.getCount() / 10;
            if (save < firstDigit) {
                pageCountEndAt = (firstDigit + 1) * 10;
            } else {
                pageCountEndAt =  firstDigit * 10 + (cs.getCount() % 10);
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

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent1);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent1);
                myTextView.setText(TanggalContent);

                break;
            case ("2"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent2);
                myTextView.setText(IDContent);

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent2);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent2);
                myTextView.setText(TanggalContent);

                break;
            case ("3"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent3);
                myTextView.setText(IDContent);

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent3);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent3);
                myTextView.setText(TanggalContent);
                break;
            case ("4"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent4);
                myTextView.setText(IDContent);

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent4);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent4);
                myTextView.setText(TanggalContent);
                break;
            case ("5"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent5);
                myTextView.setText(IDContent);

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent5);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent5);
                myTextView.setText(TanggalContent);
                break;
            case ("6"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent6);
                myTextView.setText(IDContent);

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent6);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent6);
                myTextView.setText(TanggalContent);
                break;
            case ("7"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent7);
                myTextView.setText(IDContent);

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent7);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent7);
                myTextView.setText(TanggalContent);
                break;
            case ("8"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent8);
                myTextView.setText(IDContent);

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent8);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent8);
                myTextView.setText(TanggalContent);
                break;
            case ("9"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent9);
                myTextView.setText(IDContent);

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent9);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent9);
                myTextView.setText(TanggalContent);
                break;
            case ("10"):
                //ID
                myTextView = (TextView) findViewById(R.id.IDContent10);
                myTextView.setText(IDContent);

                //Nama
                myTextView = (TextView) findViewById(R.id.NamaContent10);
                myTextView.setText(NamaContent);

                //Tanggal
                myTextView = (TextView) findViewById(R.id.TanggalContent10);
                myTextView.setText(TanggalContent);
                break;


        }
    }


    public void SwitchEditChecked(View view) {
        if (mySwitch.isChecked()) {
            myEditText = (EditText) findViewById(R.id.edittextname);
            myEditText.setVisibility(View.VISIBLE);
            myEditText = (EditText) findViewById(R.id.edittextidfordeletion);
            myEditText.setVisibility(View.VISIBLE);
            myEditText = (EditText) findViewById(R.id.edittexttanggalmasuk);
            myEditText.setVisibility(View.VISIBLE);

            myButton = (Button) findViewById(R.id.buttonadd);
            myButton.setVisibility(View.VISIBLE);
            myButton = (Button) findViewById(R.id.buttondelete);
            myButton.setVisibility(View.VISIBLE);

        } else {
            myEditText = (EditText) findViewById(R.id.edittextname);
            myEditText.setVisibility(View.INVISIBLE);
            myEditText = (EditText) findViewById(R.id.edittextidfordeletion);
            myEditText.setVisibility(View.INVISIBLE);
            myEditText = (EditText) findViewById(R.id.edittexttanggalmasuk);
            myEditText.setVisibility(View.INVISIBLE);

            myButton = (Button) findViewById(R.id.buttonadd);
            myButton.setVisibility(View.INVISIBLE);
            myButton = (Button) findViewById(R.id.buttondelete);
            myButton.setVisibility(View.INVISIBLE);
        }
    }

    public void ButtonAddOnClick(View view) {
        EditText anotherEditText = (EditText) findViewById(R.id.edittextname);
        if (anotherEditText.getText().toString().equals("")) {
        } else {
            EditText newEditText = (EditText) findViewById(R.id.edittexttanggalmasuk);
            if (newEditText.getText().toString().equals("")) {
            } else {
                Cursor cu = InformasiKaryawan.fetchDatabaseAll();
                InformasiKaryawan.insertDatabase(String.valueOf(cu.getCount() + 1), anotherEditText.getText().toString(), newEditText.getText().toString());
            }
        }

        checkCountforButtonNextandPrevious();
        //Getting from DB and Insert into textviews
        Refresh();

    }

    public void PreviousOnClick(View view) {
        Cursor cs = InformasiKaryawan.fetchDatabaseAll();
        if (cs.getCount() > 10) {
            firstDigit--;
        }
        checkCountforButtonNextandPrevious();
    }

    public void Refresh() {
        Clear();
        Cursor cs = InformasiKaryawan.fetchDatabaseAll();
        if (cs.getCount() != 0) {
            for (int i = pageCountStartAt; i < pageCountEndAt; i++) {
                Cursor ct = InformasiKaryawan.fetchDatabaseBasedOnId(i + 1);
                ct.moveToFirst();

                String ID = ct.getString(0);
                String NAME = ct.getString(1);
                String DATE = ct.getString(2);

                ChangeTextView(String.valueOf((i % 10) + 1), ID, NAME, DATE);

            }
        } else {
            Clear();
        }
    }

    public void Clear(){
        for (int i = 0; i < 10; i++){
            ChangeTextView(String.valueOf(i + 1), "---", "-", "--");
        }
    }
    public void NextOnClick(View view) {
        Cursor cs = InformasiKaryawan.fetchDatabaseAll();
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
                Toast.makeText(this, "Memes", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}