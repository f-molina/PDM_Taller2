package com.example.taller2_backup

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.example.taller2_backup.fragmento.CoinInfoFragment


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_second)

        if(resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish()
            return
        }
        if(savedInstanceState == null){
            val fragment = CoinInfoFragment()
            fragment.arguments = intent.extras
            supportFragmentManager.beginTransaction().add(R.id.container_second,fragment).commit()
        }
        /*
        val fDetalles= ListaCountry()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().add(R.id.container,fDetalles).commit()*/
    }

}
