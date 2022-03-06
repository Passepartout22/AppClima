package com.reeze.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)


        val ciudad = intent.getStringExtra("com.cbtis.appclima.ciudades.CIUDAD")


        if(Network.hayRed(this)){
            // ejecutar solicitud HTTP
        solicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=2dc9c9cad42415e73767d224608395ed&units=metric&lang=es")

        }else{
            // mostrar mensaje de error
            Toast.makeText(this, "No hay red", Toast.LENGTH_SHORT).show()
        }
            /*
        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()//en caso de error mover

            */
    }

    private fun solicitudHTTPVolley(url: String){
        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, {
            response ->
            try {
                Log.d("solicitudHTTPVolley", response)

                val gson = Gson ()

                val ciudad = gson.fromJson(response, Ciudad::class.java)
                tvCiudad?.text = ciudad.name
                tvGrados?.text = ciudad.main?.temp.toString()+"°"
                tvEstatus?.text = ciudad.weather?.get(0)?.description

            }catch (e: Exception){

            }
        }, { })
                queue.add(solicitud)
    }


}
