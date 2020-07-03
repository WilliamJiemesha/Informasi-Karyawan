package com.example.payrollproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

public class SQLiteforInformasiKaryawan extends SQLiteOpenHelper {
    public static final String dbName = "PayrollProject";
    public static final String INFORMASIKARYAWAN_TABLE_NAME = "informasi_karyawan";
    public static final String INFORMASIKARYAWAN_COLUMN_ID = "id";
    public static final String INFORMASIKARYAWAN_COLUMN_NAME = "nama_karyawan";
    public static final String INFORMASIKARYAWAN_COLUMN_DATE = "tanggal_masuk";

    public static final int VersionControl = 1;




    public SQLiteforInformasiKaryawan(Context context) {
        super(context, dbName , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table informasi_karyawan" + "(id text primary key, nama_karyawan text, tanggal_masuk text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS informasi_karyawan");
        onCreate(db);
    }

    public void clearDatabase(String TABLE_NAME) {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+TABLE_NAME;
        db.execSQL(clearDBQuery);
        db.execSQL("create table informasi_karyawan" + "(id text primary key, nama_karyawan text, tanggal_masuk text)");

    }

    public void insertDatabase(String id, String name, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("nama_karyawan", name);
        contentValues.put("tanggal_masuk", date);
        db.insert("informasi_karyawan", null, contentValues);
    }

    public Cursor fetchDatabaseBasedOnId(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from informasi_karyawan where id = "+id+"", null );
        return res;
    }

    public Cursor fetchDatabaseAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from informasi_karyawan", null );
        return res;
    }


}
