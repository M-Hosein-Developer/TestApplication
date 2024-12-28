package ir.androidcoder.myapplication.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ir.androidcoder.domain.model.RickyEntity
import ir.androidcoder.myapplication.baseAdapter.BasePagingAdapter
import ir.androidcoder.myapplication.databinding.ActivityRickyBinding
import ir.androidcoder.myapplication.baseAdapter.PostTAdapter
import ir.androidcoder.myapplication.baseAdapter.RickyAdapter
import ir.androidcoder.myapplication.baseAdapter.SwipeToDeleteCallback
import ir.androidcoder.myapplication.databinding.ActivityDigikalaBinding
import ir.androidcoder.myapplication.viewModel.MainViewModel
import ir.androidcoder.myapplication.viewModel.RickyViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    private val rickyViewModel : RickyViewModel by viewModels()
    private val posAdapter = PostTAdapter()


    private lateinit var binding : ActivityDigikalaBinding
    private lateinit var adapter: ColorAdapter
    private lateinit var pagedAdapter: ProductPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDigikalaBinding.inflate(layoutInflater)
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

//        binding.apply {
//            postList.adapter = posAdapter
//            postList.layoutManager = LinearLayoutManager(this@MainActivity , LinearLayoutManager.VERTICAL , false)
//        }
//
//        lifecycleScope.launch {
//            mainViewModel.pageByPagePosts.collectLatest {
//                Log.v("testData" , it.toString())
//                posAdapter.submitData(it)
//            }
//        }


        /*  binding.apply {


            //adapter
            rvRicky.adapter = RickyAdapter()
            rvRicky.layoutManager = LinearLayoutManager(this@MainActivity , LinearLayoutManager.VERTICAL , false)

            val swipeToDeleteCallback = object : SwipeToDeleteCallback(){
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.bindingAdapterPosition
                    (rvRicky.adapter as RickyAdapter).removeItem(position, lifecycleScope)
                }

            }

            ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(rvRicky)

            val newData = RickyEntity(
                "" ,
                listOf("" , "" , "") ,
                "mail" ,
                12 ,
                "https://rickandmortyapi.com/api/character/avatar/21.jpeg" ,
                RickyEntity.Location("" , " "),
                "ricky",
                RickyEntity.Origin("" , ""),
                "hiiiiiiiiiiiiii hellooo",
                "hi",
                "",
                ""
            )

            btnAdd.setOnClickListener {

                (rvRicky.adapter as RickyAdapter).addItem(0 , newData , lifecycleScope)

            }

        }

        lifecycleScope.launch {
            rickyViewModel.getRickyAndMorty.collectLatest {
                (binding.rvRicky.adapter as RickyAdapter).submitData(it)
            }
        }

    }

    private fun testAdapterAndSetupBaseAdapter(){




    }

       */
    }
}