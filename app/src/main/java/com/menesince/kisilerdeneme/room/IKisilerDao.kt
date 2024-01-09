package com.menesince.kisilerdeneme.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.menesince.kisilerdeneme.data.entity.Kisiler

@Dao
interface IKisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun kisileriGoster() : List<Kisiler>

    @Insert
    suspend fun kaydet(kisi : Kisiler)

    @Update
    suspend fun guncelle(kisi : Kisiler)

    @Delete
    suspend fun sil(kisi: Kisiler)

    @Query("SELECT * FROM kisiler Where kisi_ad like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<Kisiler>


}


