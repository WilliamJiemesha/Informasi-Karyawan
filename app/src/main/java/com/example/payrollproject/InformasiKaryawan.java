package com.example.payrollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class InformasiKaryawan extends AppCompatActivity {
    TextView myTextView;
    SQLiteforInformasiKaryawan InformasiKaryawan;
    Switch mySwitch;
    EditText myEditText;
    Button myButton;

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

        //InformasiKaryawan.clearDatabase("informasi_karyawan");

        //Getting from DB and Insert into textviews
        Cursor cs = InformasiKaryawan.fetchDatabaseAll();
        if (cs.getCount() != 0) {
            for (int i = 0; i < cs.getCount(); i++) {
                Cursor ct = InformasiKaryawan.fetchDatabaseBasedOnId(i + 1);
                ct.moveToFirst();

                String ID = ct.getString(0);
                String NAME = ct.getString(1);
                String DATE = ct.getString(2);

                ChangeTextView(String.valueOf(i + 1), ID, NAME, DATE);

            }
        }

    }
    public void checkCountforButtonNextandPrevious(){

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
        //Getting from DB and Insert into textviews
        Cursor cs = InformasiKaryawan.fetchDatabaseAll();
        if (cs.getCount() != 0) {
            for (int i = 0; i < cs.getCount(); i++) {
                Cursor ct = InformasiKaryawan.fetchDatabaseBasedOnId(i + 1);
                ct.moveToFirst();

                String ID = ct.getString(0);
                String NAME = ct.getString(1);
                String DATE = ct.getString(2);

                ChangeTextView(String.valueOf(i + 1), ID, NAME, DATE);

            }
        }

    }
}