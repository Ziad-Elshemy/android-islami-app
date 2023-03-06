package com.route.islami_app.ui.suraDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_app.R

class VersesAdapter : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.verses_content)
    }

    var items: List<String>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_verse, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.content.setText(items?.get(position))
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun changeData(verses: List<String>) {
        this.items = verses
        notifyDataSetChanged()//reload the adapter
    }
}