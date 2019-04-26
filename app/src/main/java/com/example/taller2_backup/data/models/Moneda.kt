package com.example.taller2_backup.data.models

//Modelo Moneda: Representando los datos de las monedas en la base de datos
data class Moneda(var idMoneda:Int, var ambito: String,var anio:Int,var disponibilidad: String, var logo: String,
                  var nombre: String)

