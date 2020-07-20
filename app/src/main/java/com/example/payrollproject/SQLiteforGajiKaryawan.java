package com.example.payrollproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteforGajiKaryawan extends SQLiteOpenHelper {
    public static String dbName = "gaji_karyawan";

    public SQLiteforGajiKaryawan(Context context) {
        super(context, dbName , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists gaji_karyawan" + "(id text, gaji text, tanggal text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS gaji_karyawan");
        onCreate(db);
    }

    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE gaji_karyawan");
        db.execSQL("create table gaji_karyawan" + "(id text, gaji text, tanggal text)");
    }

    public void insertDatabase(String id, String tanggal, String absensi){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO gaji_karyawan (id, tanggal, absensi) VALUES ('"+ id +"', '"+ tanggal +"', '"+ absensi +"')");
    }

    public Cursor fetchDatabaseAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from gaji_karyawan order by tanggal ASC", null );
        return res;
    }
    public Cursor fetchDatabaseAllBasedOnID(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from gaji_karyawan where id = "+ id + " order by tanggal ASC", null );
        return res;
    }

    public void DeleteAbsensi(int id, String tanggal){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM gaji_karyawan WHERE id = "+ id + " AND tanggal = '"+ tanggal+"'");
    }


}
