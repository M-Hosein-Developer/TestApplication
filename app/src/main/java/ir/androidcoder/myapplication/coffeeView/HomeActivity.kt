package ir.androidcoder.myapplication.coffeeView

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ir.androidcoder.myapplication.R
import ir.androidcoder.myapplication.coffeeView.adapter.CategoryAdapter
import ir.androidcoder.myapplication.coffeeView.adapter.ProductAdapter
import ir.androidcoder.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    companion object {
        fun showHome(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        //fake data
        val category = listOf(
            "All Coffee",
            "Machiato",
            "Latte",
            "Americano",
            "Iced Coffee",
            "Hot Chocolate",
            "Espresso"
        )
        val product = listOf(
            ProductModel(1, R.drawable.caffe2, "Caffe Mocha" , "Deep Foam" , "4.5" , 4.8f),
            ProductModel(2, R.drawable.caffe3, "Flat White" , "Espresso" , "3.53" , 4.8f),
            ProductModel(3, R.drawable.caffe5, "Caffe Mocha" , "Deep Foam" , "4.53" , 4.8f),
            ProductModel(4, R.drawable.caffe4, "Caffe Mocha" , "Deep Foam" , "4.53" , 4.8f),
            ProductModel(5, R.drawable.caffe1, "Caffe Mocha" , "Deep Foam" , "4.53" , 4.8f),
        )

        categoryList(category)
        productList(product)

    }

    private fun categoryList(category : List<String>){
        binding.apply {
            rvCategory.adapter = CategoryAdapter(category)
            rvCategory.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun productList(product: List<ProductModel>) {
        binding.apply {
            rvProduct.adapter = ProductAdapter(product, this@HomeActivity) { id ->
                DetailActivity.showDetail(this@HomeActivity, id)
            }
            rvProduct.layoutManager = GridLayoutManager(this@HomeActivity, 2)
        }
    }

}