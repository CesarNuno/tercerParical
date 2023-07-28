package com.example.tercerparical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.tercerparical.databinding.ActivityRoomBinding
import com.example.tercerparical.responses.data.database.Database
import com.example.tercerparical.responses.data.entities.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class roomActivity : AppCompatActivity() {
    lateinit var binding: ActivityRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = Room
            .databaseBuilder(applicationContext,Database::class.java,"Pruebas")
            .build()
        val usuarioDao = db.usuarioDao()
        CoroutineScope(Dispatchers.IO).launch {
            val usuarios = usuarioDao.listado()
            runOnUiThread{
                Toast.makeText(this@roomActivity,usuarios.size.toString(),Toast.LENGTH_LONG).show()
            }
        }
        this.binding.agregarUsuario.setOnClickListener{
            val nombre = "Gustavo"
            val apellido = "Valdez"
            CoroutineScope(Dispatchers.IO).launch {
                usuarioDao.insertarUsuario(Usuario(1,nombre,apellido))
                runOnUiThread{
                    Toast.makeText(this@roomActivity,"Agregado",Toast.LENGTH_LONG).show()
                }
            }
        }
        this.binding.actualizarUsuario.setOnClickListener{
            val nombre = "Gustavo"
            CoroutineScope(Dispatchers.IO).launch {
                usuarioDao.actualizarUsuario(Usuario(1,"Paulo","Perez"))
                runOnUiThread{
                    Toast.makeText(this@roomActivity,"Actualizado",Toast.LENGTH_LONG).show()
                }
            }
        }
        this.binding.borrarUsuario.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                usuarioDao.borrarUsuario(Usuario(1,"",""))
                runOnUiThread{
                    Toast.makeText(this@roomActivity,"Borrado",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}