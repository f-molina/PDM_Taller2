package com.example.taller2_backup

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.taller2_backup.network.Network
import com.example.taller2_backup.pojo.CountryInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.country_list.*
import org.json.JSONObject
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var moneda: MutableList<CountryInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(nav_toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Menu"

        val drawerToggle = ActionBarDrawerToggle(
                this,
                drawer_layout,
                nav_toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )

        //Aqui se "inicializa" el icono del menu
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        FetchPokemonTask().execute()


    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    fun initRecycler() {
        viewManager = GridLayoutManager(this, 1)
        viewAdapter = CountryAdapter(moneda)

        rv_list_monedas.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
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

        override fun onPostExecute(pokemonInfo: String?) {
            if (pokemonInfo != null || pokemonInfo != "") {
                Log.d("Info", pokemonInfo + "")

                val jObj = JSONObject(pokemonInfo)
                val jObjresult = jObj.getJSONArray("moneda")
                moneda = MutableList(10) { i ->
                    Log.d("prueba", i.toString())
                    val jObjresultobj = JSONObject(jObjresult[i].toString())

                    CountryInfo(jObjresultobj.getString("ambito"), jObjresultobj.getString("nombre"),
                            jObjresultobj.getString("logo"))

                }
                initRecycler()
            } else {
                country_name.text = pokemonInfo
            }

        }

    }
}
