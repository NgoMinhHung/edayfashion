package com.crazyteam.edayfashion.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crazyteam.edayfashion.R

class ActivityAdapterCart: RecyclerView.Adapter<ActivityViewHolderCart>(){

    private val activity = mutableListOf<Product>()

//    var onItemClick: ((Product) -> Unit) ? = null

    fun setActivity(input: MutableList<Product>){
        activity.clear()
        activity.addAll(input)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return activity.count()
    }

    override fun onBindViewHolder(holder: ActivityViewHolderCart, position: Int) {
        holder.activity = activity[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolderCart {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction_cart, parent, false)
        return ActivityViewHolderCart(view)
//            .also {
//            it.onClick = this.onItemClick
//        }
    }

}