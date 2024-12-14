package ir.androidcoder.myapplication.baseAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.androidcoder.domain.model.PostDEntity
import ir.androidcoder.myapplication.databinding.RvPostItemBinding

class TestAdapter(private val data : MutableList<PostDEntity>) : BaseAdapter<PostDEntity, TestAdapter.TestView>(data) {

    inner class TestView(private val binding: RvPostItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(postDEntity: PostDEntity) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestView {
        val binding = RvPostItemBinding.inflate(LayoutInflater.from(parent.context))
        return TestView(binding)
    }

    override fun onBindViewHolder(holder: TestView, position: Int) {
        holder.bind(data[position])
    }

}