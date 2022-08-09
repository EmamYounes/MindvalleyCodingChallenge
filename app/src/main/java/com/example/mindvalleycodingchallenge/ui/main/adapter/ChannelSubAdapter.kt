package com.example.mindvalleycodingchallenge.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindvalleycodingchallenge.R
import com.example.mindvalleycodingchallenge.ui.main.pojofile.ChannelSubItem
import com.squareup.picasso.Picasso


class ChannelSubAdapter(myDataset: MutableList<ChannelSubItem>) :
    RecyclerView.Adapter<ChannelSubAdapter.ChannelViewHolder>() {

    private var mDataset: MutableList<ChannelSubItem>? = null


    private var viewHolder: ChannelViewHolder? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChannelViewHolder {
        // create a new view
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.channel_sub_item, parent, false)

        return ChannelViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        viewHolder = holder
        holder.bind(mDataset?.get(position)!!, holder)
    }


    inner class ChannelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var episodeTitle: TextView = view.findViewById(R.id.episode_title)
        var episodeImage: ImageView = view.findViewById(R.id.episode_image)

        fun bind(model: ChannelSubItem, holder: ChannelViewHolder) {
            episodeTitle.text = model.title
            Picasso.with(holder.itemView.context).load(model.url).into(episodeImage);

        }
    }

    override fun getItemCount(): Int {
        return mDataset!!.size
    }

    fun addNewItem(obj: ChannelSubItem) {
        mDataset!!.add(obj)
        notifyItemInserted(mDataset!!.size - 1)
    }

    fun addList(lst: List<ChannelSubItem?>) {
        mDataset = lst as MutableList<ChannelSubItem>
        notifyDataSetChanged()
    }

    fun removeAll() {
        mDataset!!.clear()
        notifyDataSetChanged()
    }

    fun getCurrentList(): List<ChannelSubItem> {
        return mDataset!!
    }

    fun updateItem(pos: Int, obj: ChannelSubItem?) {
        obj?.let { mDataset!!.removeAt(pos) }
        obj?.let { mDataset!!.add(pos, it) }
        notifyDataSetChanged()
    } //for add new item

    fun updateItemWithoutNotify(pos: Int, obj: ChannelSubItem?) {
        obj?.let { mDataset!!.removeAt(pos) }
        obj?.let { mDataset!!.add(pos, it) }
    } //for add new item

    init {
        mDataset = myDataset
    }

}
