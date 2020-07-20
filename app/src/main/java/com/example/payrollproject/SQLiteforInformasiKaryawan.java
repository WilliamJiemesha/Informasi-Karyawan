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
    //THIS DATABASE CLASS IS FOR INFORMASI KARYAWAN

    public SQLiteforInformasiKaryawan(Context context) {
        super(context, dbName , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table informasi_karyawan" + "(id text primary key, nama_karyawan text, tanggal_masuk text, aktif int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS informasi_karyawan");
        onCreate(db);
    }

    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE informasi_karyawan");
        db.execSQL("create table informasi_karyawan" + "(id text primary key, nama_karyawan text, tanggal_masuk text, aktif int)");
    }

    public void insertDatabase(String id, String name, String date, int active){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("nama_karyawan", name);
        contentValues.put("tanggal_masuk", date);
        contentValues.put("aktif", active);
        db.insert("informasi_karyawan", null, contentValues);
    }

    public Cursor fetchDatabaseBasedOnId(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =  db.rawQuery( "select * from informasi_karyawan where id = "+id+" and aktif = 1", null );
        return res;
    }

    public Cursor fetchDatabaseAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from informasi_karyawan", null );
        return res;
    }
    public Cursor fetchDatabaseAllActive(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from informasi_karyawan where aktif = 1", null );
        return res;
    }
    public void DeleteKaryawan(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE informasi_karyawan SET aktif = 0 WHERE id = "+ id);
    }

}
