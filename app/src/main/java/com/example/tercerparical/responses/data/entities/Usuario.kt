package com.example.tercerparical.responses.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name="nombre") val name:String?,
    @ColumnInfo val apellido:String?
)
