package com.example.tercerparical.responses.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tercerparical.responses.data.entities.Usuario

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM Usuario")
    fun listado():List<Usuario>

    @Query("SELECT * FROM Usuario WHERE id = :userId")
    fun obtener(userId:Int):Usuario

    @Query("SELECT * FROM Usuario WHERE nombre LIKE :userNombre")
    fun obtenerPorNombre(userNombre:String)

    @Insert
    fun insertarUsuario(user:Usuario)

    @Update
    fun actualizarUsuario(user: Usuario)

    @Delete
    fun borrarUsuario(user: Usuario)
}