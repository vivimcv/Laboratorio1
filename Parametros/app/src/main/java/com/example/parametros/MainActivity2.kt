package com.example.parametros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.parametros.model.Alumno1
import com.example.parametros.model.Alumno2

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Bundle = intent.extras

        val usuario = Bundle?.getString("usuario", "")
        val sesion = Bundle?.getInt("sesion", 0)

        //se hace un casting al final
        val alumno1 = Bundle?.getSerializable("alumno1") as Alumno1
        val alumno2 = Bundle?.getParcelable<Alumno2>("alumno2")


        Toast.makeText(this, "Nombre:$usuario, Sesion: $sesion", Toast.LENGTH_LONG).show()

//si viene nulo no utiliza el toast
        if (alumno1 != null) {
            Toast.makeText(
                this,
                "Nombre del alumno serializable: ${alumno1.nombre}, Numero de cuenta:${alumno1.numCuenta}",
                Toast.LENGTH_LONG
            ).show()
        }
// si viene nulo si utiliza el toast
        Toast.makeText(
            this,
            "Nombre del alumno${alumno2?.nombre}, Numero de cuenta:${alumno2?.numCuenta}",
            Toast.LENGTH_LONG
        ).show()


    }
}