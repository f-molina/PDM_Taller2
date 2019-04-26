package com.example.taller2_backup.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns


//Se crea una cadena de texto con la instrucción de crear una tabla usando SQL
//El nombre de la tabla y el de las columnas se asignan según los datos definidos en DatabaseContract.kt
private const val SQL_CREATE_ENTRIES =
    "CREATE TABLE ${DatabaseContract.MonedaEntry.MONEDAS} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY,"+
                "${DatabaseContract.MonedaEntry.COLUMN_AMBITO}TEXT,"+
                "${DatabaseContract.MonedaEntry.COLUMN_ANIO}INTEGER,"+
                "${DatabaseContract.MonedaEntry.COLUMN_DISPONIBILIDAD}TEXT,"+
                "${DatabaseContract.MonedaEntry.COLUMN_NAME}TEXT"+
                "${DatabaseContract.MonedaEntry.COLUMN_LOGO}TEXT)"

//Se crea una instrucción para borrar la tabla usando SQL, esto se hace si es necesario actualizar la estructura
//de la tabla

private const val SQL_DELETE_ENTRIES=
        "DROP TABLE IF EXISTS ${DatabaseContract.MonedaEntry.MONEDAS}"

//Creamos la base de datos con la instancia de SQLiteOpenHelper
class Database(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)

{
    // Este método se ejecuta cuando es necesario crear el esquema de base de datos.
    // Este recibe como parámetro una instancia de SQLiteDatabase y que permite ejecutar SQL de DDL.
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    //Si la base de datos ya existe y se define una nueva versión, se ejecutan los scripts para migrar
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)//Borramos la versión anterior, ya que no necesitamos lo viejo
        onCreate(db)//Creamos la nueva base de datos
    }

    //Definimos el nombre y la version
    companion object {
        const val DATABASE_VERSION=1
        const val DATABASE_NAME = "taller2.db"
    }
}


