package com.example.lab1pdma017006.ui.alumno

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

class AlumnoViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private lateinit var _context: Context
    private var _printDataTemplate = "Nombre: %s, Carnet: %s"
    fun init(context: Context?) {
        if (context != null) {
            this._context = context
        }
    }

    fun showAlumnoData(nombre: String, carnet: String) {

        if (nombre.isEmpty()) {
            Toast.makeText(this._context, "El campo nombre esta vacio", Toast.LENGTH_SHORT).show()
            return
        }
        if (carnet.isEmpty()) {
            Toast.makeText(this._context, "El campo carnet esta vacio", Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(
            this._context,
            String.format(this._printDataTemplate, nombre, carnet),
            Toast.LENGTH_SHORT
        ).show()
    }

}