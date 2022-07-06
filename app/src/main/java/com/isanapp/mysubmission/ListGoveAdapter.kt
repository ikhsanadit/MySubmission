package com.isanapp.mysubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListGoveAdapter(private val listGove: ArrayList<government>): RecyclerView.Adapter<ListGoveAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.id_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.id_item_username)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_government, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, username,followers,following,company,location, avatar) = listGove[position]
        holder.imgPhoto.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvUsername.text = username

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listGove[holder.adapterPosition]) }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: government)
    }

    override fun getItemCount(): Int = listGove.size

}