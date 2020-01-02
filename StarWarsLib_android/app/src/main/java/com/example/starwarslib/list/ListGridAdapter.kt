package com.example.starwarslib.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarslib.databinding.GridViewItemBinding
import com.example.starwarslib.database.StarWarsItem

class ListGridAdapter(private val onClickListener: OnClickListener): ListAdapter<StarWarsItem, ListGridAdapter.EntityViewHolder>(DiffCallBack) {

    class EntityViewHolder(private val binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (starWarsEntity: StarWarsItem) {
            binding.property = starWarsEntity
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<StarWarsItem>() {
        override fun areItemsTheSame(oldItem: StarWarsItem, newItem: StarWarsItem): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: StarWarsItem, newItem: StarWarsItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        return EntityViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entityProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(entityProperty)
        }
        holder.bind(entityProperty)
    }
    class OnClickListener(val clickListener: (starWarsEntityProperty: StarWarsItem) -> Unit) {
        fun onClick(starWarsEntityProperty: StarWarsItem) = clickListener(starWarsEntityProperty)
    }
}