package com.reeze.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstado)

        val ciudad = intent.getStringExtra("com.reeze.appclima.ciudades.CIUDAD")

        val ciudadfc = com.reeze.appclima.Ciudad("Felipe Carrillo Puerto", grados = 15, estatus = "soleado")
        val ciudadmx = com.reeze.appclima.Ciudad("Ciudad de Mexico", grados = 30, estatus = "Cielo despejado")
        val ciudadbe= com.reeze.appclima.Ciudad("Ciudad de Berlin", grados = 5, estatus = "Cielo nublado")

        if(ciudad == "ciudad-fcp"){
            tvCiudad?.text = ciudadfc.nombre
            tvGrados?.text = ciudadfc.grados.toString() + "°"
            tvEstatus?.text = ciudadfc.estatus

        } else if(ciudad == "ciudad-mexico"){

            tvCiudad?.text = ciudadmx.nombre
            tvGrados?.text = ciudadmx.grados.toString() + "°"
            tvEstatus?.text = ciudadmx.estatus

        } else if(ciudad == "ciudad-berlin"){

            tvCiudad?.text = ciudadbe.nombre
            tvGrados?.text = ciudadbe.grados.toString() + "°"
            tvEstatus?.text = ciudadbe.estatus

        } else {
            Toast.makeText(this, "Upps, al parecer no se encontra la información o no exíste", Toast.LENGTH_SHORT).show()
        }
    }
}