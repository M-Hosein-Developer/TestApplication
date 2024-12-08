package ir.androidcoder.myapplication.coffeeView.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.androidcoder.myapplication.coffeeView.ProductModel
import ir.androidcoder.myapplication.databinding.ProductItemBinding

class ProductAdapter(private val data : List<ProductModel> , private val context: Context , val onItemClicked :(Int) ->Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(productModel: ProductModel) {
            binding.apply {
                Glide
                    .with(context)
                    .load(productModel.image)
                    .centerCrop()
                    .into(imgProduct);

                txtProductTitle.text = productModel.title
                txtProductDescription.text = productModel.description
                txtProductPrice.text = "$ ${productModel.price}"

                root.setOnClickListener {
                    onItemClicked(productModel.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(data[position])
    }


}