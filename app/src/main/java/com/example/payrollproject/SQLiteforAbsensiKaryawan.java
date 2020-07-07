package com.example.payrollproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteforAbsensiKaryawan extends SQLiteOpenHelper {
    public static String dbName = "absensi_karyawan";

    public SQLiteforAbsensiKaryawan(Context context) {
        super(context, dbName , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table absensi_karyawan" + "(id text, tanggal text, absensi text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS absensi_karyawan");
        onCreate(db);
    }

    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE absensi_karyawan");
        db.execSQL("create table absensi_karyawan" + "(id text, tanggal text, absensi text)");
    }

    public void insertDatabase(String id, String tanggal, String absensi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("tanggal", tanggal);
        contentValues.put("absensi", absensi);
        db.insert("absensi_karyawan", null, contentValues);
    }

    public Cursor fetchDatabaseAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from absensi_karyawan", null );
        return res;
    }
    public Cursor fetchDatabaseAllActive(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from absensi_karyawan", null );
        return res;
    }
    public void DeleteAbensi(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("DELETE FROM absensi_karyawan WHERE id = "+ id);
    }


}
