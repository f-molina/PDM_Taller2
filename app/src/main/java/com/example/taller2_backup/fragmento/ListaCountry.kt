package com.example.taller2_backup.fragmento


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.taller2_backup.R
import kotlinx.android.synthetic.main.fragment_lista_country.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ListaCountry : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_country, container, false).apply {
            findViewById<TextView>(R.id.tv_fragment_name).text = arguments?.getString("key_nombre")
            findViewById<TextView>(R.id.tv_fragment_ambito).text = arguments?.getString("key_ambito")


        }

    }
}
