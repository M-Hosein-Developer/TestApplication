package ir.androidcoder.myapplication.coffeeView

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ir.androidcoder.myapplication.R
import ir.androidcoder.myapplication.util.Constants.EXTRA_PRODUCT_ID

class DetailActivity : AppCompatActivity() {

    companion object {
        fun showDetail(context: Context , id : Int) {
            context.let {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(EXTRA_PRODUCT_ID, id)
                it.startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val product = listOf(
            ProductModel(1, R.drawable.caffe2, "Caffe Mocha" , "Deep Foam" , "4.5" , 4.8f),
            ProductModel(2, R.drawable.caffe3, "Flat White" , "Espresso" , "3.53" , 4.8f),
            ProductModel(3, R.drawable.caffe5, "Caffe Mocha" , "Deep Foam" , "4.53" , 4.8f),
            ProductModel(4, R.drawable.caffe4, "Caffe Mocha" , "Deep Foam" , "4.53" , 4.8f),
            ProductModel(5, R.drawable.caffe1, "Caffe Mocha" , "Deep Foam" , "4.53" , 4.8f),
        )

        val data = intent.extras?.getInt(EXTRA_PRODUCT_ID)


        Toast.makeText(this@DetailActivity, "hiii + $data", Toast.LENGTH_SHORT).show()
        
    }
}