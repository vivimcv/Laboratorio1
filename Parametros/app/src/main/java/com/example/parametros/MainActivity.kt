package com.example.parametros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.parametros.model.Alumno1
import com.example.parametros.model.Alumno2
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    //para firebase
    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //instanciando firebase

        analytics = Firebase.analytics

        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT) {
            param(FirebaseAnalytics.Param.ITEM_ID, "1")
            param(FirebaseAnalytics.Param.ITEM_NAME, "Pantalla principal")
            param(FirebaseAnalytics.Param.CONTENT_TYPE, "Pantalla")
        }
    }

    fun click(view: View) {

        when (view.id) {
            R.id.btnEnviar -> {


                ///instanciamos objetos de nuestras clases  creadas
                val alumno1 = Alumno1("vivi", "312432534")//serializable
                val alumno2 = Alumno2("toño", "3253664")//parcerable

                val intent = Intent(this, MainActivity2::class.java)

                val parametros = Bundle()
                parametros.putString("usuario", "Vivi")
                parametros.putInt("sesion", 2)
                parametros.putSerializable("alumno1", alumno1)
                parametros.putParcelable("alumno2", alumno2)


                intent.putExtras(parametros)


                startActivity(intent)
            }
            R.id.btnEventoFB -> {
                analytics.logEvent("click-boton") {
                    param("action", "click")
                    param("texto-boton", "Ingresar")
                }

            }
        }

    }
}