package ir.androidcoder.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import ir.androidcoder.myapplication.databinding.RowColorsBinding

class ColorAdapter(private val data: List<AllColor>) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    private lateinit var binding : RowColorsBinding

    inner class ColorViewHolder(item : View) : RecyclerView.ViewHolder(item){
        fun binds(allColor: AllColor) {
            binding.apply {

                binding.rowColor.setBackgroundResource(allColor.color)
                binding.textColor.text = allColor.title

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        binding = RowColorsBinding.inflate(LayoutInflater.from(parent.context))
        return ColorViewHolder(binding.root)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.binds(data[position])
    }

}