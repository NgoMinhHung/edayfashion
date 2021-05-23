package com.crazyteam.edayfashion.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crazyteam.edayfashion.R

class ActivityAdapter : RecyclerView.Adapter<ActivityViewHolder>(){

    private val activity = mutableListOf<Product>()

    var onItemClick: ((Product) -> Unit) ? = null
    fun setActivity(input: MutableList<Product>){
        activity.clear()
        activity.addAll(input)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return activity.count()
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.activity = activity[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return ActivityViewHolder(view).also {
            it.onClick = this.onItemClick
        }
    }

}