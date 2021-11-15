package com.lambui.framework.mvi.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lambui.framework.mvi.R
import com.lambui.framework.mvi.data.model.Category
import com.lambui.framework.mvi.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val users: ArrayList<Category>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: Category) {
            itemView.textViewUserName.text = user.word
            itemView.textViewUserEmail.text = user.meaning
//            Glide.with(itemView.imageViewAvatar.context)
//                .load(user.)
//                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<Category>) {
        users.addAll(list)
    }

}