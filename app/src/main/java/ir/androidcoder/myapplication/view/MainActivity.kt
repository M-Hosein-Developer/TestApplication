package ir.androidcoder.myapplication.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import ir.androidcoder.myapplication.R
import ir.androidcoder.myapplication.databinding.ActivityDigikalaBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private val mainViewModel : MainViewModel by viewModels()
//    lateinit var adapter : PostAdapter


    private lateinit var binding : ActivityDigikalaBinding
    private lateinit var adapter: ColorAdapter
    private lateinit var pagedAdapter: ProductPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDigikalaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //        initUi(mainViewModel)

        //fake data
        val list = listOf(

            AllColor(
                R.color.red,
                "قرمز"
            ),
            AllColor(
                R.color.blue,
                "آبی"
            ),
            AllColor(
                R.color.black,
                "مشکی"
            )

        )
        val data = listOf(
            R.drawable.i_61,
            R.drawable.i_62,
            R.drawable.i_63
        )

        colorsAdapter(list)
        imageSlider(data)

    }

    private fun colorsAdapter(list: List<AllColor>) {
        binding.apply {
            adapter = ColorAdapter(list)
            rcColor?.adapter = adapter
            rcColor?.layoutManager = LinearLayoutManager(this@MainActivity , LinearLayoutManager.HORIZONTAL , true)
        }
    }

    private fun imageSlider(data: List<Int>) {
        pagedAdapter = ProductPagerAdapter(data)
        binding.imageView.adapter = pagedAdapter
        setupDotsIndicator(binding.imageView, binding.dotsLayout, data.size)
    }

    private fun setupDotsIndicator(viewPager: ViewPager2, dotsLayout: LinearLayout, itemCount: Int) {
        fun updateDots(currentPosition: Int) {
            dotsLayout.removeAllViews()

            for (i in 0 until itemCount) {
                val dot = ImageView(viewPager.context).apply {
                    setImageResource(
                        if (i == currentPosition) R.drawable.dot_active else R.drawable.dot_inactive
                    )
                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    params.marginEnd = 8
                    layoutParams = params
                }
                dotsLayout.addView(dot)
            }

        }

        updateDots(viewPager.currentItem)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateDots(position)
            }
        })
    }


    /*private fun initUi(mainViewModel: MainViewModel) {

        lifecycleScope.launch {
            mainViewModel.post.collect {
                it?.let {
                    binding.apply {
                        adapter = PostAdapter(it)
                        postList.adapter = adapter
                        postList.layoutManager = LinearLayoutManager(this@MainActivity , LinearLayoutManager.VERTICAL , false)
                    }
                }
            }
        }

    }
     */
}