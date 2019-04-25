package com.example.taller2_backup

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import com.example.taller2_backup.helpers.FragmentHelper
import com.example.taller2_backup.network.Network
import com.example.taller2_backup.pojo.CountryInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.country_list.*
import org.json.JSONObject
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity(),FragmentHelper {



    lateinit var rvListaMonedas:RecyclerView
    var infoContainer:FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvListaMonedas = findViewById(R.id.rv_list_monedas)
        infoContainer = findViewById(R.id.info_container)

        /*setSupportActionBar(nav_toolbar)
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
        drawerToggle.syncState()*/




    }

    /*override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }*/

    override fun returnLayoutManager(): GridLayoutManager {
        return GridLayoutManager(this,1)
    }
    override fun returnRecyclerView(): RecyclerView {
        return rvListaMonedas
    }


    override fun getIsContainerVisible(): Boolean {
        return infoContainer!=null && infoContainer?.visibility == View.VISIBLE

    }

    override fun getMainIntent(): Intent {
        return Intent(this,SecondActivity::class.java)

    }
    override fun getFragmentTransaction(): FragmentTransaction {
        return supportFragmentManager.beginTransaction()
    }

}
