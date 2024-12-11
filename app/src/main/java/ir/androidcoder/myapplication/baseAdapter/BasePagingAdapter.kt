package ir.androidcoder.myapplication.baseAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

open class BasePagingAdapter<T : Any, VB : ViewDataBinding>(

    diffCallback: DiffUtil.ItemCallback<T>,
    private val bindItem: (item: T, binding: VB) -> Unit,
    private val layoutId: Int

) :

    PagingDataAdapter<T, BasePagingAdapter<T, VB>.PagerViewHolder>(diffCallback) {

    inner class PagerViewHolder(val binding: VB) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T?) {
            if (item != null) {
                bindItem(item, binding)
                binding.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding: VB = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), layoutId, parent, false
        )
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
