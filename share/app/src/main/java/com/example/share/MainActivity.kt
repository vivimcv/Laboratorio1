package com.example.share

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    //
    private var imageURI: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when (view.id) {
            //click a la imagen
            R.id.shareImage -> {
                val pickIntent = Intent(Intent.ACTION_PICK)
                pickIntent.type = "image/*"
                gallery.launch(pickIntent)
            }
            //click al botón
            R.id.btnShare -> {
               /* val shareIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Este es mi texto a compartir")
                    type = "text/plain"
                }
                startActivity(shareIntent)*/
                if(imageURI == null){
                    Toast.makeText(this, "Elije una imagen primero", Toast.LENGTH_SHORT).show()
                }else{
                    //El usuario ya seleccionó una imagen y la quiere compartir
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "image/jpeg"
                    shareIntent.putExtra(Intent.EXTRA_STREAM, customizeContentUri())
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    startActivity(Intent.createChooser(shareIntent, "Compartir via:"))
                }

            }
        }


    }


    //funcion para abrir escoger la imagen
    //función para abrir la galería y escoger una imagen
//ActivityResultLauncher<Intent> = registerForActivityResult
   // private val gallery
    private val gallery: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback {
            //Manejando los casos cuando el usuario seleccionó una imagen y cuando no

            if(it.resultCode == Activity.RESULT_OK){  //Se seleccionó una imagen exitosamente

                Toast.makeText(this, "Imagen seleccionada exitosamente", Toast.LENGTH_SHORT).show()

                val data = it.data
                imageURI = data?.data!!

                //asignamos la imagen seleccionada al imageView

                var ivShareImage = findViewById<ImageView>(R.id.shareImage)
                //le asignamos la imagen

                ivShareImage.setImageURI(imageURI)

            }
            else{
                //El usuario canceló la elección de imagen
                Toast.makeText(this, "No se seleccionó ninguna imagen", Toast.LENGTH_SHORT).show()
            }
        }
    )
private fun customizeContentUri(): Uri? {

    var bitmap: Bitmap? = null
    var contentUri: Uri? = null

    //Obtenemos el bitmap desde el uri

    try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val source = ImageDecoder.createSource(contentResolver, imageURI!!)
            bitmap = ImageDecoder.decodeBitmap(source)
        } else {
            bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageURI)
        }
    } catch (e: Exception) {
        Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
    }

    val imagesFolder = File(cacheDir, "images")

    try {
        imagesFolder.mkdirs()
        val file =
            File(imagesFolder, "imagen_compartida.jpg") //Se le da nombre al contenido a compartir

        val stream = FileOutputStream(file)
        bitmap?.compress(Bitmap.CompressFormat.JPEG, 80, stream)

        stream.flush()
        stream.close()

        contentUri = FileProvider.getUriForFile(this, "com.tallercmovil.share.fileprovider", file)

    } catch (e: Exception) {
        Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
    }

    return contentUri


}}




