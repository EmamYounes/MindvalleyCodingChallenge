package com.example.mindvalleycodingchallenge.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mindvalleycodingchallenge.R
import com.example.mindvalleycodingchallenge.ui.main.pojofile.ChannelMainItem


class ChannelMainAdapter(myDataset: MutableList<ChannelMainItem>) :
    RecyclerView.Adapter<ChannelMainAdapter.ChannelViewHolder>() {

    private var mDataset: MutableList<ChannelMainItem>? = null


    private var viewHolder: ChannelViewHolder? = null
    lateinit var channelSubAdapter: ChannelSubAdapter
    var activity: FragmentActivity? = null

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
        private var channelMainTitle: TextView = view.findViewById(R.id.channel_main_title)
        var channelMainSubTitle: TextView = view.findViewById(R.id.channel_main_sub_title)
        var rvSubType: RecyclerView = view.findViewById(R.id.rv_sub_type)

        fun bind(model: ChannelMainItem, holder: ChannelViewHolder) {
            channelMainTitle.text = model.title
            channelMainSubTitle.text = model.subtitle
        }

        private fun initRecyclerView(model: ChannelMainItem) {
            channelSubAdapter= ChannelSubAdapter(model.channelSubList)
            rvSubType.adapter = channelSubAdapter
            rvSubType.layoutManager = LinearLayoutManager(activity)
            rvSubType.setHasFixedSize(false)
        }
    }

    override fun getItemCount(): Int {
        return mDataset!!.size
    }

    fun addNewItem(obj: ChannelMainItem) {
        mDataset!!.add(obj)
        notifyItemInserted(mDataset!!.size - 1)
    }

    fun addList(lst: List<ChannelMainItem?>) {
        mDataset = lst as MutableList<ChannelMainItem>
        notifyDataSetChanged()
    }

    fun removeAll() {
        mDataset!!.clear()
        notifyDataSetChanged()
    }

    fun getCurrentList(): List<ChannelMainItem> {
        return mDataset!!
    }

    fun updateItem(pos: Int, obj: ChannelMainItem?) {
        obj?.let { mDataset!!.removeAt(pos) }
        obj?.let { mDataset!!.add(pos, it) }
        notifyDataSetChanged()
    } //for add new item

    fun updateItemWithoutNotify(pos: Int, obj: ChannelMainItem?) {
        obj?.let { mDataset!!.removeAt(pos) }
        obj?.let { mDataset!!.add(pos, it) }
    } //for add new item

    init {
        mDataset = myDataset
    }

}
