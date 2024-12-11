package ir.androidcoder.myapplication.baseAdapter

import androidx.recyclerview.widget.DiffUtil
import ir.androidcoder.domain.model.PostDEntity
import ir.androidcoder.myapplication.R
import ir.androidcoder.myapplication.databinding.RvPostItemBinding

class PostTAdapter : BasePagingAdapter<PostDEntity, RvPostItemBinding>(
    DIFF_CALLBACK ,
    {item , binding ->
        binding.apply {
            txtId.text = item.id.toString()
            textDes.text = item.body
            textTitle.text = item.title
        }
    },
    R.layout.rv_post_item
) {

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

}