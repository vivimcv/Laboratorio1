package com.example.app3_ciclodevida

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.View
import com.blogspot.atifsoftwares.animatoolib.Animatoo

class MainActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    private val LOGTAG = "DebugInfo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mp = MediaPlayer.create(this,R.raw.zelda)
        mp.start()
        Log.i(LOGTAG,"onCreate()")
    }

    override fun onPause() {
        super.onPause()
        mp.pause()
        Log.i(LOGTAG,"onPause()")
    }

    override fun onRestart() {
        super.onRestart()
        mp.start()
        Log.i(LOGTAG,"onRestart()")

    }

    override fun onStart() {
        super.onStart()
        Log.i(LOGTAG,"onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOGTAG,"onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOGTAG,"onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOGTAG,"onDestroy()")
    }

    fun onclick(view: View) {
        val  intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
        //TAMBIÉN DE LA SIGUIENTE FORMA YA QUE NO SE PASA PARÁMETROS
       // startActivity(Intent(this,MainActivity2::class.java ))
        Animatoo.animateZoom(this)

    }
}