package com.example.taller2_backup

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taller2_backup.pojo.CountryInfo
import kotlinx.android.synthetic.main.country_list.view.*

class CountryAdapter(val items: List<CountryInfo>): RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CountryAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.country_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item:CountryInfo)= with(itemView){
            country_name.text= item.name
            country_detail.text=item.country
        }
    }
}