package com.example.mindvalleycodingchallenge.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindvalleycodingchallenge.R
import com.example.mindvalleycodingchallenge.ui.main.pojofile.CategoriesItem


class CategoriesAdapter(myDataset: MutableList<CategoriesItem>, context: Context) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var mDataset: MutableList<CategoriesItem>? = null


    private var viewHolder: CategoriesViewHolder? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesViewHolder {
        // create a new view
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)

        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        viewHolder = holder
        holder.bind(mDataset?.get(position)!!, position)
    }


    inner class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var categoriseName: TextView = view.findViewById(R.id.categorise_name)

        fun bind(model: CategoriesItem, position: Int) {
            categoriseName.text = model.name
        }
    }

    override fun getItemCount(): Int {
        return mDataset!!.size
    }

    fun addNewItem(obj: CategoriesItem) {
        mDataset!!.add(obj)
        notifyItemInserted(mDataset!!.size - 1)
    }

    fun addList(lst: List<CategoriesItem?>) {
        mDataset = lst as MutableList<CategoriesItem>
        notifyDataSetChanged()
    }

    fun removeAll() {
        mDataset!!.clear()
        notifyDataSetChanged()
    }

    fun getCurrentList(): List<CategoriesItem> {
        return mDataset!!
    }

    fun updateItem(pos: Int, obj: CategoriesItem?) {
        obj?.let { mDataset!!.removeAt(pos) }
        obj?.let { mDataset!!.add(pos, it) }
        notifyDataSetChanged()
    } //for add new item

    fun updateItemWithoutNotify(pos: Int, obj: CategoriesItem?) {
        obj?.let { mDataset!!.removeAt(pos) }
        obj?.let { mDataset!!.add(pos, it) }
    } //for add new item

    init {
        mDataset = myDataset
    }

}
