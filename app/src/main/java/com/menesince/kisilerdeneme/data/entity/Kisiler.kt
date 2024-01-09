package com.menesince.kisilerdeneme.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable
@Entity("kisiler")
class Kisiler (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") @NotNull var id : Int,
    @ColumnInfo("kisi_ad") @NotNull var kisi_ad : String,
    @ColumnInfo("kisi_tel") @NotNull var kisi_tel : String) : Serializable {
}