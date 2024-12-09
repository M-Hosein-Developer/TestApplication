package ir.androidcoder.myapplication.coffeeView

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import ir.androidcoder.myapplication.R
import ir.androidcoder.myapplication.databinding.ActivityDetailBinding
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

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        //fake data
        val data = intent.extras?.getInt(EXTRA_PRODUCT_ID)
        val product = listOf(
            ProductModel(1, R.drawable.caffe2, "Caffe Mocha", "Deep Foam", "4.5", 4.8f),
            ProductModel(2, R.drawable.caffe3, "Flat White", "Espresso", "3.53", 4.8f),
            ProductModel(3, R.drawable.caffe5, "Caffe Mocha", "Deep Foam", "4.53", 4.8f),
            ProductModel(4, R.drawable.caffe4, "Caffe Mocha", "Deep Foam", "4.53", 4.8f),
            ProductModel(5, R.drawable.caffe1, "Caffe Mocha", "Deep Foam", "4.53", 4.8f),
        )

        if (data != null) {
            setupToolbar(product, data)
            product.onEach { it ->
                if (data == it.id)
                    setupUi(it)
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun setupUi(data: ProductModel) {
        val transformation = MultiTransformation(CenterCrop(), RoundedCorners(44))
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(data.image)
                .apply(RequestOptions.bitmapTransform(transformation))
                .into(imgDetailPoster)
            txtDetailTitle.text = data.title
            txtDetailDescription.text = data.description
            txtRate.text = data.rating.toString()
            txtTotalPrice.text = "$ ${data.price}"
            btnBuy.setOnClickListener {
                Toast.makeText(this@DetailActivity, data.title + " add to cart", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupToolbar(product: List<ProductModel>, data: Int) {
        binding.apply {
            toolbar.toolbarTitle.text = product[data - 1].title
            toolbar.btnBack.setOnClickListener {
                onBackPressedDispatcher
                finish()
            }
            toolbar.btnFavorite.setOnClickListener {
                Toast.makeText(this@DetailActivity, product[data - 1].title + " add to favorite list", Toast.LENGTH_SHORT).show()
            }
        }
    }
}