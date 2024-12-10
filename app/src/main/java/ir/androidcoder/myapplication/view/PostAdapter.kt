package ir.androidcoder.myapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.androidcoder.domain.model.PostDEntity
import ir.androidcoder.myapplication.databinding.RvPostItemBinding

class PostAdapter : PagingDataAdapter<PostDEntity , PostAdapter.PostViewHolder>(DIFF_CALLBACK) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PostDEntity>() {
            override fun areItemsTheSame(oldItem: PostDEntity, newItem: PostDEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PostDEntity, newItem: PostDEntity): Boolean {
                return oldItem == newItem
            }
        }

    }


    inner class PostViewHolder(private var binding: RvPostItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(postDEntity: PostDEntity) {

            binding.apply {
                txtId.text = "${postDEntity.id}"
                textTitle.text = postDEntity.title
                textDes.text = postDEntity.body
            }

        }


    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = RvPostItemBinding.inflate(LayoutInflater.from(parent.context))
        return PostViewHolder(binding)
    }


}