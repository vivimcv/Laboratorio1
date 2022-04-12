package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var animesFragment: AnimesFragment
    private lateinit var gamesFragment: GamesFragment
    private lateinit var initialFragment: InitialFragment

    //este objeto maneja las transacciones de los fragmentos
    private lateinit var transaction:FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animesFragment = AnimesFragment()
        gamesFragment = GamesFragment()
        initialFragment = InitialFragment()


        supportFragmentManager.beginTransaction().add(R.id.flFragmentContaine, initialFragment).commit()

    }

    fun click(view: View) {
        val transaction = supportFragmentManager.beginTransaction()
        when(view.id){
            //cuando se da click en los botones
            R.id.btnAnimes ->{
                transaction.replace(R.id.flFragmentContaine,animesFragment).commit()
                transaction.addToBackStack(null)
            }
            R.id.btnGames->{
                transaction.replace(R.id.flFragmentContaine,gamesFragment).commit()
                transaction.addToBackStack(null)


            }
        }
    }
}