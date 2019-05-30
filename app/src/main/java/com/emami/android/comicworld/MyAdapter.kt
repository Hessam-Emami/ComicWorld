package com.emami.android.comicworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.siyamed.shapeimageview.CircularImageView
import com.github.siyamed.shapeimageview.RoundedImageView
import com.squareup.picasso.Picasso

class MyAdapter(): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


        var data = listOf<Comic>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

        override fun getItemCount() = data.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
            holder.bind(item)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder.from(parent)
        }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: Comic) {
            Picasso.get().load(item.imgSource).into(itemView.findViewById<RoundedImageView>(R.id.comicImageView)
            )
            itemView.findViewById<TextView>(R.id.comicNameView).text=item.name

        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.recycler_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}
