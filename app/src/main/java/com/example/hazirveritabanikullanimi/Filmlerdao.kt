package com.example.hazirveritabanikullanimi

class Filmlerdao {
    //select * from filmler, kategoriler, yonetmenler where filmler.kategori_id=kategoriler.kategori_id and filmler.yonetmen_id=yonetmenler.yonetmen_id and filmler.kategori_id=2
    fun tumFilmlerbyKategoriId(vt:VeriTabaniYardimcisi,kategori_Id:Int):ArrayList<Filmler>{
        var filmlerListe=ArrayList<Filmler>()
        val db=vt.writableDatabase
        val cursor=db.rawQuery("select * from filmler, kategoriler, yonetmenler where filmler.kategori_id=kategoriler.kategori_id and filmler.yonetmen_id=yonetmenler.yonetmen_id and filmler.kategori_id=$kategori_Id",null)
        while (cursor.moveToNext()){
            val kategori=Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id"))
                ,cursor.getString(cursor.getColumnIndex("kategori_ad")))
            val yonetmen=Yonetmenler(cursor.getInt(cursor.getColumnIndex("yonetmen_id"))
                ,cursor.getString(cursor.getColumnIndex("yonetmen_ad")))
            val film=Filmler(cursor.getInt(cursor.getColumnIndex("film_id"))
                ,cursor.getString(cursor.getColumnIndex("film_ad"))
                ,cursor.getInt(cursor.getColumnIndex("film_yil"))
                ,cursor.getString(cursor.getColumnIndex("film_resim")),kategori,yonetmen)
            filmlerListe.add(film)
        }
        return filmlerListe
    }
}