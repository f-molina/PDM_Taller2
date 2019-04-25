package com.example.taller2_backup.fragmento


import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.taller2_backup.CountryAdapter

import com.example.taller2_backup.R
import com.example.taller2_backup.helpers.FragmentHelper
import com.example.taller2_backup.network.Network
import com.example.taller2_backup.pojo.CountryInfo
import org.json.JSONObject
import java.io.IOException
import java.net.URL


class ListaCountry : Fragment() {

    lateinit var moneda: List<CountryInfo>
    lateinit var customLayoutManager: GridLayoutManager
    lateinit var countryAdapter: CountryAdapter
    lateinit var fragmentHelper: FragmentHelper
    var currentPosition = 0
    var isLandscape = false

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        fragmentHelper = context as FragmentHelper

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista_country, container, false)
        FetchPokemonTask().execute()
        return view
    }

    fun initRecycler() {
        customLayoutManager = fragmentHelper.returnLayoutManager()
        countryAdapter = CountryAdapter(moneda)
        val rvListaMonedas = fragmentHelper.returnRecyclerView()
        rvListaMonedas.apply {
            setHasFixedSize(true)
                layoutManager = customLayoutManager
            adapter = countryAdapter
        }

    }

    private inner class FetchPokemonTask : AsyncTask<Void, Void, String>() {


        override fun doInBackground(vararg params: Void?): String? {


            // val ID = pokemonNumbers[0]

            val prueba = Network.Factory

            //Por que?? !!
            val pokeAPI: URL = prueba.buildUrl()!!

            return try {
                prueba.getResponseFromHttpUrl(pokeAPI)

            } catch (e: IOException) {
                e.printStackTrace()
                ""
            }
        }

        override fun onPostExecute(receivedData: String?) {
            if (receivedData != null || receivedData != "") {
                Log.d("Info", receivedData + "")

                val jObj = JSONObject(receivedData)
                val jObjresult = jObj.getJSONArray("moneda")
                moneda = MutableList(10) { i ->
                    Log.d("prueba", i.toString())
                    val jObjresultobj = JSONObject(jObjresult[i].toString())

                    CountryInfo(
                            jObjresultobj.getString("ambito"), jObjresultobj.getString("nombre"),
                            jObjresultobj.getString("logo")
                    )

                }
                initRecycler()
            } else {
                Log.e("CUSTOM", "Error, see log")
            }

        }


    }

}
