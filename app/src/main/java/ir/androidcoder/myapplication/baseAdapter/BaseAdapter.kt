package ir.androidcoder.myapplication.baseAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T , VH : RecyclerView.ViewHolder>(private val data : MutableList<T>) : RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int = data.size

    fun removeData(position: Int){
        data.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addData(newData : T , position: Int){
        data.add(newData)
        notifyItemChanged(position)
    }


}