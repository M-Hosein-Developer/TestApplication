package ir.androidcoder.myapplication.baseAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import ir.androidcoder.domain.model.RickyEntity
import ir.androidcoder.myapplication.databinding.RvRickyItemBinding

class RickyAdapter : BasePagingAdapter<RickyEntity , RickyAdapter.RickyViewHolder>(
    BaseDiffCallback(
        { oldItem, newItem -> oldItem.id == newItem.id },
        { oldItem, newItem -> oldItem == newItem }
    )
) {

    inner class RickyViewHolder(private val binding: RvRickyItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: RickyEntity?) {
            binding.apply {
                if (data != null) {
                    val transformation = MultiTransformation(CenterCrop(), RoundedCorners(24))
                    Glide.with(imgPoser.context)
                        .load(data.image)
                        .apply(RequestOptions.bitmapTransform(transformation))
                        .into(imgPoser)
                    txtRickyTitle.text = data.name
                    txtRickyDesc.text = data.species
                }
            }
        }
    }

    override fun onBindViewHolder(holder: RickyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickyViewHolder {
        val binding = RvRickyItemBinding.inflate(LayoutInflater.from(parent.context))
        return RickyViewHolder(binding)
    }


}