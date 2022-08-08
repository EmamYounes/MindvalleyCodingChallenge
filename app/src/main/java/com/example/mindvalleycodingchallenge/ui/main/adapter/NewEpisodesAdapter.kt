package com.example.mindvalleycodingchallenge.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindvalleycodingchallenge.R
import com.example.mindvalleycodingchallenge.ui.main.pojofile.MediaItem
import com.squareup.picasso.Picasso


class NewEpisodesAdapter(myDataset: MutableList<MediaItem>) :
    RecyclerView.Adapter<NewEpisodesAdapter.NewEpisodesViewHolder>() {

    private var mDataset: MutableList<MediaItem>? = null


    private var viewHolder: NewEpisodesViewHolder? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewEpisodesViewHolder {
        // create a new view
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)

        return NewEpisodesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewEpisodesViewHolder, position: Int) {
        viewHolder = holder
        holder.bind(mDataset?.get(position)!!, holder)
    }


    inner class NewEpisodesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var episodeTitle: TextView = view.findViewById(R.id.episode_title)
        var episodeImage: ImageView = view.findViewById(R.id.episode_image)

        fun bind(model: MediaItem, holder: NewEpisodesViewHolder) {
            episodeTitle.text = model.title
            Picasso.with(holder.itemView.context).load(model.coverAsset?.url).into(episodeImage);

        }
    }

    override fun getItemCount(): Int {
        return mDataset!!.size
    }

    fun addNewItem(obj: MediaItem) {
        mDataset!!.add(obj)
        notifyItemInserted(mDataset!!.size - 1)
    }

    fun addList(lst: List<MediaItem?>) {
        mDataset = lst as MutableList<MediaItem>
        notifyDataSetChanged()
    }

    fun removeAll() {
        mDataset!!.clear()
        notifyDataSetChanged()
    }

    fun getCurrentList(): List<MediaItem> {
        return mDataset!!
    }

    fun updateItem(pos: Int, obj: MediaItem?) {
        obj?.let { mDataset!!.removeAt(pos) }
        obj?.let { mDataset!!.add(pos, it) }
        notifyDataSetChanged()
    } //for add new item

    fun updateItemWithoutNotify(pos: Int, obj: MediaItem?) {
        obj?.let { mDataset!!.removeAt(pos) }
        obj?.let { mDataset!!.add(pos, it) }
    } //for add new item

    init {
        mDataset = myDataset
        mDataset = myDataset
    }

}
