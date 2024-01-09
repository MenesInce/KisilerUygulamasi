package com.menesince.kisilerdeneme.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.menesince.kisilerdeneme.data.entity.Kisiler

@Database(entities = [Kisiler :: class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getKisileriGoster () : IKisilerDao
}