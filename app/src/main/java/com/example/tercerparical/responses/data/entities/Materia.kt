package com.example.tercerparical.responses.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Materia(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name="nombre") val nombre:String,
    @ColumnInfo(name = "idMaestro") val maestro:Int
)
