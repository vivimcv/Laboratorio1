package com.example.videogames

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.videogames.databinding.ActivityDetailsBinding
import com.example.videogames.db.DBgames
import com.example.videogames.model.Game

class Details_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    private lateinit var dbGames: DBgames
    var game: Game? = null
    var id:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            val bundle = intent.extras
            if(bundle != null){
                id = bundle.getInt("ID", 0)
            }
        }else{
            id = savedInstanceState.getSerializable("ID") as Int
        }

        dbGames = DBgames(this)

        game = dbGames.getGame(id)

        if(game != null){
            with(binding){
                tieTitulo.setText(game?.title)
                tieGenero.setText(game?.genre)
                tieDeveloper.setText(game?.developer)

                //Para que no se abra el teclado al momento de hacer click en los TextInputEditText
                tieTitulo.inputType = InputType.TYPE_NULL
                tieGenero.inputType = InputType.TYPE_NULL
                tieDeveloper.inputType = InputType.TYPE_NULL

            }
        }

    }

    fun click(view:View){
        when(view.id){
            R.id.btEdit->{
                val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("ID",id)
                startActivity(intent)
                finish()
        }
            R.id.btBorrar ->{
                AlertDialog.Builder(this)
                    .setTitle("Confirmación")
                    .setMessage("Realmente deseas eliminar el juego${game?.title}?")
                    .setPositiveButton("Sí",DialogInterface.OnClickListener { dialogInterface, i ->
                        if(dbGames.deleteGames(id)) {
                            Toast.makeText(
                                this,
                                "Registro eliminado exitosamente",
                                Toast.LENGTH_LONG
                            ).show()
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                    })
                //si se desea realizar una acción cuando el usuario selecciona no
                    .setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                    .show()
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}