package com.aleksandrbelous.coroutinetry.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrbelous.coroutinetry.databinding.HomeFragmentBinding
import com.aleksandrbelous.coroutinetry.databinding.HomeListItemBinding
import com.aleksandrbelous.coroutinetry.network.MovieItem

/**
 * @author Aleksandr Belous
 * @since 7/9/20.
 */
class HomeListAdapter(private val items: List<MovieItem>) :
    RecyclerView.Adapter<HomeListItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeListItemBinding.inflate(inflater, parent, false)
        return HomeListItemViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HomeListItemViewHolder, position: Int) {
        holder.titleView.text = items[position].title
    }


}

class HomeListItemViewHolder(binding: HomeListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val titleView: TextView = binding.itemTitle
}
