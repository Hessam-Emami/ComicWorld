package com.emami.android.comicworld.ui.explore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.emami.android.comicworld.data.ComicPreview
import com.emami.android.comicworld.databinding.RecyclerItemBinding

class ExploreListAdapter(val onClickListener: OnClickListener) :
    ListAdapter<ComicPreview, ExploreListAdapter.ViewHolder>(DiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comic = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(comic)
        }
        holder.bind(comic)
    }


    class ViewHolder(private val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ComicPreview) {
            binding.comicDTO = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RecyclerItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class DiffUtilCallback : DiffUtil.ItemCallback<ComicPreview>() {
    override fun areItemsTheSame(oldItem: ComicPreview, newItem: ComicPreview): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: ComicPreview, newItem: ComicPreview): Boolean =
        oldItem == newItem
}

class OnClickListener(val mclickListener: (comicPreview: ComicPreview) -> Unit){
    fun onClick(comicPreview: ComicPreview) = mclickListener(comicPreview)
}
