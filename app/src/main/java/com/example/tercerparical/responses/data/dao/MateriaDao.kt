package com.example.tercerparical.responses.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tercerparical.responses.data.entities.Materia
import com.example.tercerparical.responses.data.entities.Profesor

@Dao
interface MateriaDao {
    @Query("SELECT Materia.id, Materia.nombre , Profesor.nombre FROM Materia JOIN Profesor WHERE Materia.idMaestro = Profesor.id")
    fun listado():List<Materia>

    @Query("SELECT Materia.id, Materia.nombre , Profesor.nombre FROM Materia JOIN Profesor ON Materia.idMaestro = Profesor.id WHERE id = :materiaId")
    fun obtener(materiaId: Materia):Materia

    @Query("SELECT Materia.id, Materia.nombre , Profesor.nombre FROM Materia JOIN Profesor ON Materia.idMaestro = Profesor.id WHERE nombre LIKE :materiaNombre")
    fun obtenerPorNombre(materiaNombre:String)

    @Insert
    fun insertarMateria(materia: Materia)

    @Update
    fun actualizarMateria(materia: Materia)

    @Delete
    fun borrarMateria(materia: Materia)
}