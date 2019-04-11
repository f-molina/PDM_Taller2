package com.example.taller2_backup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}
