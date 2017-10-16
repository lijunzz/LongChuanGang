package net.junzz.app.lcg

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.junzz.app.ui.widget.RoundAvatar

class ListAdapter(val data: List<ListItemDO>) : RecyclerView.Adapter<ListAdapter.ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ListHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.avatarView.setImageAvatar(data[position].avatar)
        holder.titleView.text = data[position].title
    }

    class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryView = itemView.findViewById<TextView>(R.id.tv_list_item_category)
        val avatarView = itemView.findViewById<RoundAvatar>(R.id.ra_list_item_avatar)
        val titleView = itemView.findViewById<TextView>(R.id.tv_list_item_title)
    }
}