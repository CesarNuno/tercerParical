package com.example.tercerparical.responses.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tercerparical.responses.data.dao.MateriaDao
import com.example.tercerparical.responses.data.dao.ProfesorDao
import com.example.tercerparical.responses.data.dao.UsuarioDao
import com.example.tercerparical.responses.data.entities.Materia
import com.example.tercerparical.responses.data.entities.Profesor
import com.example.tercerparical.responses.data.entities.Usuario

@Database(entities = [Usuario::class/*,Profesor::class,Materia::class*/], version = 1)
abstract class Database:RoomDatabase() {
    abstract fun usuarioDao():UsuarioDao
    //abstract fun profesorDao():ProfesorDao
    //abstract fun materiaDao():MateriaDao
}