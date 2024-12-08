package ir.androidcoder.myapplication.coffeeView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ir.androidcoder.myapplication.R
import ir.androidcoder.myapplication.databinding.ActivityCoffeeBinding

class CoffeeActivity : AppCompatActivity() {

    lateinit var binding: ActivityCoffeeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCoffeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Intent to Home Activity
        binding.btnStart.setOnClickListener {
            HomeActivity.showHome(this@CoffeeActivity)
        }

    }
}