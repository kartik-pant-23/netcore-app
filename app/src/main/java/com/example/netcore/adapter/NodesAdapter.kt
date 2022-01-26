package com.example.netcore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.netcore.R
import com.example.netcore.api.entities.Node
import com.example.netcore.databinding.ItemNodeBinding

class NodesAdapter(private val OnItemClickListener: (View, Int) -> Unit): ListAdapter<Node, NodesAdapter.NodesViewHolder>(
    object: DiffUtil.ItemCallback<Node>() {
        override fun areItemsTheSame(oldItem: Node, newItem: Node): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Node, newItem: Node): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }
) {

    inner class NodesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NodesViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_node, parent, false)
        return NodesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NodesViewHolder, position: Int) {
        ItemNodeBinding.bind(holder.itemView).apply {
            val node = getItem(position)
            name.text = node.data.properties.name
            url.text = node.data.properties.url ?: "~No Relevant URL~"
            categories.text = node.data.categories?.toString() ?: "~Category Not Found~"
        }
        holder.itemView.setOnClickListener {
            OnItemClickListener(it, getItem(position).id)
        }
    }
}