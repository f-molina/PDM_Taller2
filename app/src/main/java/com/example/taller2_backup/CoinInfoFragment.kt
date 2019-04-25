package com.example.taller2_backup


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CoinInfoFragment : Fragment() {

    lateinit var txtName:TextView
    lateinit var txtDetail:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_coin_info, container, false)
        txtName = view.findViewById(R.id.tv_fragment_name)
        txtDetail = view.findViewById(R.id.tv_fragment_ambito)
        txtName.text = arguments!!.getString("name","nel")
        txtDetail.text = arguments!!.getString("ambito","nel")
        //Log.d("CUSTOM",arguments!!.getString("name","nel"))
        return view
    }
    companion object {

        fun newInstance(param1: String,param2: String) =
                CoinInfoFragment ().apply {
                    arguments = Bundle().apply {
                        putString("name", param1)
                        putString("ambito", param2)
                    }
                }
    }


}
