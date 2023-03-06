package com.route.islami_app.ui.home.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_app.R

class SuraNamesAdapter(val items: List<String>) :
    RecyclerView.Adapter<SuraNamesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.chapter_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chapter_name, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(items.get(position))
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(pos: Int, name: String)
    }
}