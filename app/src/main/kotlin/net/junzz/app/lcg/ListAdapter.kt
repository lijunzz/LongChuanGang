package net.junzz.app.lcg

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class ListAdapter(val data: List<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = TextView(parent.context)
        return ViewHolder(textView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    // itemView
    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}