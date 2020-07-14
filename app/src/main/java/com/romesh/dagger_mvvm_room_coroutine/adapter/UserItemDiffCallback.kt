package com.romesh.dagger_mvvm_room_coroutine.adapter

import androidx.recyclerview.widget.DiffUtil
import com.romesh.dagger_mvvm_room_coroutine.Users

class UserItemDiffCallback : DiffUtil.ItemCallback<Users>() {

    override fun areItemsTheSame
                (oldItem: Users, newItem: Users): Boolean
            = oldItem.id == newItem.id

    override fun areContentsTheSame
                (oldItem: Users, newItem: Users): Boolean
            = oldItem == newItem
}