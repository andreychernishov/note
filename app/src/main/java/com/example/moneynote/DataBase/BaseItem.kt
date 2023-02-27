package com.example.moneynote.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class BaseItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "bank_name")
    var BankName: String,
    @ColumnInfo(name = "money")
    var money: String
    )
