package com.romesh.dagger_mvvm_room_coroutine.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.romesh.dagger_mvvm_room_coroutine.R
import com.romesh.dagger_mvvm_room_coroutine.Users
import kotlinx.android.synthetic.main.layout_single_item.view.*
class CustomAdapter(userList: List<Users>,private val interaction: Interaction? = null
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val users = mutableListOf<Users>()

    init {
        users.addAll(userList)
    }
    // Method #1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_single_item, parent, false)
        return ViewHolder(
            view,
            interaction
        )
    }
    // Method #2
    override fun getItemCount() = users.size

    // Method #3
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(user = users[position])

    }

    // Method #5
    class ViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        // Method #6
        fun bind(user: Users) {
            itemView.name.text = user.first_name
            Glide
                .with(itemView)
                .load(user.avatar)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(itemView.image);
            //Handle item click
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition,user)
            }
        }

    }

    // Method #7
    interface Interaction {
        fun onItemSelected(position: Int, item: Users)
    }
}