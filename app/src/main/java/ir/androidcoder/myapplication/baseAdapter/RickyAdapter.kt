package ir.androidcoder.myapplication.baseAdapter

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import ir.androidcoder.domain.model.RickyEntity
import ir.androidcoder.myapplication.R
import ir.androidcoder.myapplication.databinding.RvRickyItemBinding

class RickyAdapter(private val context: Context) : BasePagingAdapter<RickyEntity, RvRickyItemBinding>(
    DIFF_CALLBACK,
    {item , binding ->
        val transformation = MultiTransformation(CenterCrop(), RoundedCorners(24))
        binding.apply {
            Glide.with(context)
                .load(item.image)
                .apply(RequestOptions.bitmapTransform(transformation))
                .into(imgPoser)

            txtRickyTitle.text = item.name
            txtRickyDesc.text = item.species
            txtRickyGender.text = item.gender
        }
    },
    R.layout.rv_ricky_item
) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RickyEntity>() {
            override fun areItemsTheSame(oldItem: RickyEntity, newItem: RickyEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickyEntity, newItem: RickyEntity): Boolean {
                return oldItem == newItem
            }
        }

    }

}