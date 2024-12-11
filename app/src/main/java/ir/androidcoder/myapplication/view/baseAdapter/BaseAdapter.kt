package ir.androidcoder.myapplication.view.baseAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T , VH : RecyclerView.ViewHolder>(private val data : List<T>) : RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int = data.size


}