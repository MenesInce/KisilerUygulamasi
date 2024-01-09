package com.menesince.kisilerdeneme.data.datasource

import android.util.Log
import com.menesince.kisilerdeneme.data.entity.Kisiler
import com.menesince.kisilerdeneme.room.IKisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kDao : IKisilerDao) {

    suspend fun kisileriGoster() : List<Kisiler> =
        withContext(Dispatchers.IO) {
            return@withContext kDao.kisileriGoster()
        }

    suspend fun ara(aramaKelimesi : String)  : List<Kisiler> =
        withContext(Dispatchers.IO) {

            return@withContext kDao.ara(aramaKelimesi)
        }



    suspend fun kaydet (kisi_ad: String, kisi_tel:String) {
        val yeniKisi = Kisiler(0,kisi_ad,kisi_tel)
        kDao.kaydet(yeniKisi)
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String) {
        val guncellenenKisi = Kisiler(kisi_id,kisi_ad,kisi_tel)
        kDao.guncelle(guncellenenKisi)
    }

    suspend fun sil(kisi_id:Int){
        val silinenKisi = Kisiler(kisi_id,"","")
        kDao.sil(silinenKisi)
    }

}