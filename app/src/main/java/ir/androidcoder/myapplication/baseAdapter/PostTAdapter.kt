package ir.androidcoder.myapplication.baseAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.androidcoder.domain.model.PostDEntity
import ir.androidcoder.myapplication.databinding.RvPostItemBinding
import ir.androidcoder.myapplication.view.PostAdapter

class PostTAdapter : BasePagingAdapter<PostDEntity, PostTAdapter.PostTViewHolder>(
    BaseDiffCallback(
        { oldItem, newItem -> oldItem.id == newItem.id },
        { oldItem, newItem -> oldItem == newItem }
    )
) {

    inner class PostTViewHolder(private val binding: RvPostItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: PostDEntity?) {
            if (data != null){
                binding.apply {

                }
            }
        }

    }

    override fun onBindViewHolder(holder: PostTViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostTViewHolder {
        val binding = RvPostItemBinding.inflate(LayoutInflater.from(parent.context))
        return PostTViewHolder(binding)
    }


}