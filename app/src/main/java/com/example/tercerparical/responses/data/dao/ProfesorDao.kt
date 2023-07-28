package com.example.tercerparical.responses.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tercerparical.responses.data.entities.Profesor

@Dao
interface ProfesorDao {
    @Query("SELECT * FROM Profesor")
    fun listado():List<Profesor>

    @Query("SELECT * FROM Profesor WHERE id = :profesorId")
    fun obtener(profesorId: Profesor):Profesor

    @Query("SELECT * FROM Usuario WHERE nombre LIKE :profesorNombre")
    fun obtenerPorNombre(profesorNombre:String)

    @Insert
    fun insertarprofesor(profesor: Profesor)

    @Update
    fun actualizarProfesor(profesor: Profesor)

    @Delete
    fun borrarProfesor(profesor: Profesor)
}