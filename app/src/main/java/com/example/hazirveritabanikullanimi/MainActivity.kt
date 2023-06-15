package com.example.hazirveritabanikullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hazirveritabanikullanimi.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        veritabaniKopyala()
        val vt=VeriTabaniYardimcisi(this)
        /*val liste=Kategorilerdao().tumKategoriler(vt)
         for(k in liste){
            Log.e("kategori id:",k.kategori_id.toString())
            Log.e("kategori ad:",k.kategori_ad)
        }*/
        val liste=Filmlerdao().tumFilmlerbyKategoriId(vt, 2)
        for(k in liste){
            Log.e("film id:",k.film_id.toString())
            Log.e("film ad:",k.film_ad)
            Log.e("film yıl:",k.film_yil.toString())
            Log.e("film resim:",k.film_resim)
            Log.e("kategori id:",k.kategori.kategori_id.toString())
            Log.e("kategori ad:",k.kategori.kategori_ad)
            Log.e("yonetmen id:",k.yonetmen.yonetmen_id.toString())
            Log.e("yonetmen ad:",k.yonetmen.yonetmen_ad)
        }

    }
    fun veritabaniKopyala(){
        val db=DatabaseCopyHelper(this)
        try {
            db.createDataBase()//veritabani oluşturmak telefona veritabani kopyalayacak
        }catch (e:Exception){
            e.printStackTrace()
        }
        try {
            db.openDataBase()//veritabanı aç
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}