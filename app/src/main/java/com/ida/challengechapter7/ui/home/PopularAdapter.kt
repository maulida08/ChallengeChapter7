package com.ida.challengechapter7.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ida.challengechapter7.data.model.Result
import com.ida.challengechapter7.databinding.ItemBinding

class PopularAdapter(private val onItemClick: OnClickListener):
    RecyclerView.Adapter<PopularAdapter.ViewHolder>(){

    private val IMAGE_BASE ="https://image.tmdb.org/t/p/w500/"


    private val diffCallBack = object : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean = oldItem.hashCode() == newItem.hashCode()
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    fun submitData(value: List<Result>?) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: PopularAdapter.ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(data: Result) {
                binding.apply {
                    Glide.with(binding.root).load(IMAGE_BASE+data.posterPath).into(itemMoviePoster)
                    tvTittle.text = data.originalTitle
                    root.setOnClickListener {
                        onItemClick.onClickItem(data)
                    }
                }
            }
        }

    interface OnClickListener{
        fun onClickItem(data: Result)
    }

}