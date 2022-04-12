package com.example.formulas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.formulas.databinding.ActivityMainBinding
import java.util.*

const val RESULTADO = "com.example.myfirstapp.MESSAGE"
class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    private lateinit var mBinding:ActivityMainBinding
    private lateinit var setImage:ImageView
    private lateinit var spinnview:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        setTheme(R.style.Theme_Formulas)
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        /*
ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinner_data, android.R.layout.simple_spinner_dropdown_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(adapter);*/

        //creando spinner
        val aaFormulas = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item)
            aaFormulas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //simple_spinner_dropdown_item
           //definiendo formulas
           // aaFormulas.addAll(listOf(getString(R.string.formulas1),getString(R.string.formulas2),getString(R.string.formulas3),getString(R.string.formulas4)))


            mBinding.spinnerFormulas.onItemSelectedListener = this
            mBinding.spinnerFormulas.adapter = aaFormulas

        //añadiendo imagen de cada formula
        // var images =
          //  intArrayOf(R.drawable.formula_ley_de_ohm)
            setImage=findViewById(R.id.ivFormulas)
      /*  aaFormulas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }*/


    }
//cuando se selecciona algo
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {


        //mBinding.tvSelect.text= position.toString()
  //  Toast.makeText(
     //   this@MainActivity,
      //  "You Select Position: " + position + " " + formulas[position],
       // Toast.LENGTH_SHORT
   // ).show()

        when(position){
            0->{setImage.setImageResource(R.drawable.tension)}
            1->{setImage.setImageResource(R.drawable.corriente)}
            2->{setImage.setImageResource(R.drawable.resistencia)}
            3->{setImage.setImageResource(R.drawable.potencia)}

        }


    }
//cuando no se está seleccionando
    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    fun click(view: View) {

       val intent = Intent(this, Resultados::class.java)




        with(mBinding) {



            if (validaCamposUno()) {
                if(validaCamposDos()){
                    val numeroA = a.text.toString().toDouble()
                    val numeroB = b.text.toString().toDouble()
                    val resultados = Bundle()
                    val operacion = Bundle()

                    // if (voltaje(numeroA, numeroB)) tvSelect.text = getString(R.string.si_primo, numero, "!")
                    // else tvResultado.text = getString(R.string.no_primo, numero)
                   // onItemSelected()= this@MainActivity
                   val seleccion = spinnerFormulas.selectedItemId.toString()
                    if (seleccion=="0"){
                        if(numeroB.toInt()==0 || numeroA.toInt()==0){
                            b.error = getString(R.string.mensaje1)
                            b.requestFocus()
                        }else{

                            val resultado= volt(numeroA,numeroB)
                            //mandando a otra actividad resultado, operación  y aplicando animación
                            resultados.putDouble("resultado",resultado)
                            intent.putExtras(resultados)
                            operacion.putString("operacion","voltaje")
                            intent.putExtras(operacion)
                            Toast.makeText(this@MainActivity, operacion.toString(), Toast.LENGTH_SHORT).show()

                            startActivity(intent)
                            Animatoo.animateInAndOut(this@MainActivity)}

                    }
                    else{
                        if (seleccion=="1"){
                            if(numeroB.toInt()==0 || numeroA.toInt()==0){
                                b.error = getString(R.string.mensaje2)
                                b.requestFocus()
                            }else{
                                val resultado= corriente(numeroA,numeroB)
                                //mandando a otra actividad y animación

                                if (resultado != null) {
                                    resultados.putDouble("resultado",resultado)
                                }
                                intent.putExtras(resultados)
                                operacion.putString("operacion","corriente")
                                intent.putExtras(operacion)

                                startActivity(intent)
                                Animatoo.animateInAndOut(this@MainActivity)
                            }

                        }
                        else{
                            if (seleccion=="2"){
                                if(numeroB.toInt()==0 || numeroA.toInt()==0){
                                    b.error = getString(R.string.mensaje2)
                                    b.requestFocus()
                                }else{
                                val resultado= resistencia(numeroA,numeroB)
                                //mandando a otra actividad y animación

                                    if (resultado != null) {
                                        resultados.putDouble("resultado",resultado)
                                    }
                                intent.putExtras(resultados)
                                    operacion.putString("operacion","resistencia")
                                    intent.putExtras(operacion)


                                startActivity(intent)
                                Animatoo.animateInAndOut(this@MainActivity)}

                            }
                            else{

                                if(numeroB.toInt()==0 || numeroA.toInt()==0){
                                    b.error = getString(R.string.mensaje1)
                                    b.requestFocus()
                                }else{

                                val resultado= potencia(numeroA,numeroB)
                                //mandando a otra actividad y animación

                                    if (resultado != null) {
                                        resultados.putDouble("resultado",resultado)
                                    }
                                intent.putExtras(resultados)
                                    operacion.putString("operacion","potencia")
                                    intent.putExtras(operacion)


                                startActivity(intent)
                                Animatoo.animateInAndOut(this@MainActivity)}

                            }

                        }

                    }


                  //  Toast.makeText(this@MainActivity, seleccion, Toast.LENGTH_SHORT).show()




                //else valida campos
                }else{
                    b.error = getString(R.string.hint)
                    b.requestFocus()

                }

            } else {
                a.error = getString(R.string.hint)
                a.requestFocus()
            }
            }
    }
    //val customAdapter = CustomAdapter(applicationContext, images, fruits)
    //spin.adapter = customAdapter
    private fun volt(a: Double, b: Double): Double = a*b
    private fun corriente(a: Double, b: Double): Double = a/b
    private fun resistencia(a: Double, b: Double): Double = a/b
    private fun potencia(a: Double, b: Double): Double = a*b

    private fun validaCamposUno(): Boolean{
        if(mBinding.a.text.toString() != "" ) return true
        else return false

    }
    private fun validaCamposDos(): Boolean{
        if( mBinding.b.text.toString() != ""   ) return true
        else return false

    }

}


