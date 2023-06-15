package com.example.hazirveritabanikullanimi

import android.util.Log

class Kategorilerdao {
    fun tumKategoriler(vt:VeriTabaniYardimcisi):ArrayList<Kategoriler>{
        var kategoriListe=ArrayList<Kategoriler>()
        val db=vt.writableDatabase
        val cursor=db.rawQuery("SELECT * FROM kategoriler",null)
        while (cursor.moveToNext()){
            val kategori=Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id"))
            ,cursor.getString(cursor.getColumnIndex("kategori_ad")))
            kategoriListe.add(kategori)
        }
        return kategoriListe
    }
}