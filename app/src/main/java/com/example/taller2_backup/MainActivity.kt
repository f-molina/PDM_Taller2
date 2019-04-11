package com.example.taller2_backup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.taller2_backup.pojo.CountryInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var country: MutableList<CountryInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(nav_toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Toolbar"

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


        country = MutableList(20) { i ->


            CountryInfo(i, "colon", "El Salvador", 1980, "Disponible")

        }

        initRecycler()


    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    fun initRecycler() {
        viewAdapter = CountryAdapter(country)
        var layoutManagerTest: GridLayoutManager = GridLayoutManager(this, 1)

        rv_list_monedas.apply {
            setHasFixedSize(true)
            layoutManager = layoutManagerTest
            adapter = viewAdapter
        }

    }
}
