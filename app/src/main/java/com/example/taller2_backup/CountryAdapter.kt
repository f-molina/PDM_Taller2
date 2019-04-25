package com.example.taller2_backup

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.taller2_backup.pojo.CountryInfo
import kotlinx.android.synthetic.main.country_list.view.*

class CountryAdapter(val items: List<CountryInfo>,val clickListener:(Int)->Unit): RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CountryAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.country_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        var m:CountryInfo = items.get(position)
        holder.bind(items[position],clickListener,position)

        Glide.with(holder.itemView.context)
                .load(m.logo)
                .into(holder.itemView.flag_image)

    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var countryName : TextView
        lateinit var ambito : TextView

        fun bind(item:CountryInfo,clickListener: (Int) -> Unit,position: Int)= with(itemView){

            countryName = findViewById(R.id.country_name)
            country_name.text= item.ambito
            country_detail.text = item.nombre

            /*this.setOnClickListener {
                var mIntent = Intent(it.context,  SecondActivity:: class.java)
                mIntent.putExtra("key_nombre", item.nombre)
                mIntent.putExtra("key_ambito", item.ambito)
                this.context.startActivity(mIntent)
            }*/
            this.setOnClickListener{clickListener(position)}
        }
    }
}