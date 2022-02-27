package com.example.videogames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.videogames.databinding.ActivityEditBinding
import com.example.videogames.db.DBgames
import com.example.videogames.model.Game

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private lateinit var dbGames: DBgames
    var game: Game? = null
    var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        binding= ActivityEditBinding.inflate(layoutInflater)
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

            }
        }
}

    fun click(view: View) {
        with(binding){
            if(!tieTitulo.text.toString().isEmpty() && !tieGenero.text.toString().isEmpty() && !tieDeveloper.text.toString().isEmpty()){
                if(dbGames.updateGames(id, tieTitulo.text.toString(), tieGenero.text.toString(), tieDeveloper.text.toString())){
                    Toast.makeText(this@EditActivity, "Registro actualizado exitosamente", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@EditActivity, Details_Activity::class.java)
                    intent.putExtra("ID", id)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this@EditActivity, "Error al actualizar el registro", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this@EditActivity, "Ningún campo puede quedar vacío", Toast.LENGTH_LONG).show()
            }
        }
    }
}