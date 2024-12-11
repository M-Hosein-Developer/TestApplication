package ir.androidcoder.myapplication.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.LOG_TAG
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import ir.androidcoder.myapplication.R
import ir.androidcoder.myapplication.databinding.ActivityDigikalaBinding
import ir.androidcoder.myapplication.databinding.ActivityMainBinding
import ir.androidcoder.myapplication.viewModel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    private val posAdapter = PostAdapter()


    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: ColorAdapter
    private lateinit var pagedAdapter: ProductPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi(mainViewModel)

        /*
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
        imageSlider(data
         */
    }

    /*
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

        binding.dotsIndicator.attachTo(binding.imageView)

//        setupDotsIndicator(binding.imageView, binding.dotsLayout, data.size)
    }

    private fun setupDotsIndicator(viewPager: ViewPager2, dotsLayout: LinearLayout, itemCount: Int) {
        val dots = mutableListOf<ImageView>()

        for (i in 0 until itemCount) {
            val dot = ImageView(viewPager.context).apply {
                setImageResource(R.drawable.dot_active)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.marginEnd = 14
                params.marginStart = 14
                layoutParams = params
            }
            dotsLayout.addView(dot)
            dots.add(dot)
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

                for (i in dots.indices) {
                    val scale = when (i) {
                        position -> 0.9f + 0.5f * (1 - positionOffset)
                        position + 1 -> 1.0f + 0.5f * positionOffset
                        else -> 1f
                    }
                    dots[i].scaleX = scale
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                for (i in dots.indices) {
                    dots[i].setImageResource(
                        if (i == position) {
                            R.drawable.dot_active
                        } else if (i < position) {
                            R.drawable.last_dot_active
                        } else {
                            R.drawable.dot_inactive
                        }
                    )
                }
            }
        })
    }
     */

    private fun initUi(mainViewModel: MainViewModel) {

        binding.apply {
            postList.adapter = posAdapter
            postList.layoutManager = LinearLayoutManager(this@MainActivity , LinearLayoutManager.VERTICAL , false)
        }

        lifecycleScope.launch {
            mainViewModel.pageByPagePosts.collectLatest {
                Log.v("testData" , it.toString())
                posAdapter.submitData(it)
            }
        }

    }

}