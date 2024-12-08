package ir.androidcoder.myapplication.coffeeView.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.androidcoder.myapplication.databinding.CategoriesItemBinding

class CategoryAdapter(private val data: List<String>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding : CategoriesItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: String) {
            binding.txtCategory.text = data

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) { holder.bind(data[position]) }

}