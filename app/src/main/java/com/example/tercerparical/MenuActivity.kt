package com.example.tercerparical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.PopupMenu
import android.widget.Toast
import com.example.tercerparical.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity(), MenuItem.OnMenuItemClickListener {
    lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnMenuPop.setOnClickListener(){
            showPopup(it);
        }
        registerForContextMenu(binding.btnMenuContexto)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_opciones,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mnConfiguracion->{
                Toast.makeText(this,"Configurame",Toast.LENGTH_LONG).show()
                true
            }
            R.id.mnSalir->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showPopup(v:View){
        val popup = PopupMenu(this,v)
        val inflater: MenuInflater = popup.menuInflater
        popup.setOnMenuItemClickListener { onMenuItemClick(it) }
        inflater.inflate(R.menu.menu_emergente, popup.menu)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mnCambiarNombre->{
                Toast.makeText(this,"Cambiar nombre",Toast.LENGTH_LONG).show()
                true
            }
            R.id.mnModoOscuro->{
                Toast.makeText(this,"Cambiar modo oscuro",Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_contexto, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ctPreTexto -> {
                Toast.makeText(this,":)",Toast.LENGTH_LONG).show()
                true
            }
            R.id.ctBuscar -> {
                Toast.makeText(this,"Usa google",Toast.LENGTH_LONG).show()
                true
            }
            R.id.ctCopiar -> {
                Toast.makeText(this,"Copiar no esta permitido en las reglas de la Univa",Toast.LENGTH_LONG).show()
                true
            }
            R.id.ctVerInfo -> {
                Toast.makeText(this,"Id:" + binding.btnMenuContexto.id.toString(),Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}