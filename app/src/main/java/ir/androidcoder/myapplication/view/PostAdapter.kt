package ir.androidcoder.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.androidcoder.domain.model.PostDEntity
import ir.androidcoder.myapplication.databinding.RcPostItemBinding

class PostAdapter(private val data: List<PostDEntity>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    lateinit var binding: RcPostItemBinding

    inner class PostViewHolder(view : View) : RecyclerView.ViewHolder(view){

        fun bind(postDEntity: PostDEntity) {

            binding.apply {
                txtId.text = "${postDEntity.id}"
                textTitle.text = postDEntity.title
                textDes.text = postDEntity.body
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = RcPostItemBinding.inflate(LayoutInflater.from(parent.context))
        return PostViewHolder(binding.root)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(data[position])
    }

}