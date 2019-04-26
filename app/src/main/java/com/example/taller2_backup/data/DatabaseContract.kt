package com.example.taller2_backup.data

import android.provider.BaseColumns

//La definición del objeto DatabaseContract sirve para establecer una capa de abstracción que define la estructura
//de la base de datos
//Las tablas de la BD se definen en esta clase como objeto
//palabra reservada "objecto" = Singleton

object DatabaseContract
{
    //Para cada entrada de la base de datos se define una entrada, y se debe de heredar de BaseColumns

    object MonedaEntry: BaseColumns //Se guardan los datos relevantes de la tabla, como su nombre y sus campos
    {
        const val MONEDAS = "moneda"

        //Constante para cada columna de la tabla
        const val  COLUMN_AMBITO = "ambito"
        const val COLUMN_ANIO = "anio"
        const val COLUMN_DISPONIBILIDAD = "disponibilidad"
        const val COLUMN_LOGO = "logo"
        const val COLUMN_NAME = "nombre"
    }
}