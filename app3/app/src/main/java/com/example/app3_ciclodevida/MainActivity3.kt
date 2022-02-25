package com.example.app3_ciclodevida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }
    fun onclick(view: View) {
        val  intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        //TAMBIÉN DE LA SIGUIENTE FORMA YA QUE NO SE PASA PARÁMETROS
        // startActivity(Intent(this,MainActivity2::class.java ))
    }
}