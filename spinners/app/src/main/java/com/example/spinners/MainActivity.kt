import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val country = arrayOf<String?>("India", "USA", "Canada")
    private var spCountry: Spinner? = null
    private val cars = arrayOf<String?>("Ferrari", "Lamborghini", "Rolls Roys")
    private var spCars: Spinner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)
        spCountry = findViewById(R.id.spCountry)
        spCountry.setAdapter(
            ArrayAdapter<Any?>(
                this,
                R.layout.simple_spinner_dropdown_item,
                country
            )
        )
        spCars = findViewById(R.id.spCars)
        spCars.setAdapter(ArrayAdapter<Any?>(this, R.layout.simple_spinner_dropdown_item, cars))
    }
}