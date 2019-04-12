package com.example.taller2_backup

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.taller2_backup.fragmento.ListaCountry

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val fDetalles= ListaCountry()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().add(R.id.container,fDetalles).commit()
    }

}
