package com.example.tercerparical.responses.data.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Profesor(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name="nombre") val nombre:String,
    @ColumnInfo(name="salario") val salario:Double,
    @ColumnInfo(name="correo") val correo:String?,
    @ColumnInfo(name="telefono") val telefono:String?
)
