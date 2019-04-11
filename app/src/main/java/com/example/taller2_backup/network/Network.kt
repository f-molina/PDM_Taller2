package com.example.taller2_backup.network

import android.net.Uri
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

class Network {


    companion object Factory {
        val POKEMON_API_BASE_URL = "https://taller2-a645b.firebaseio.com/monedas.json/"

        private val TAG = Network::class.java!!.simpleName

        fun buildUrl(): URL? {
            val builtUri = Uri.parse(POKEMON_API_BASE_URL)
                .buildUpon()
                .build()

            var url: URL? = null
            try {
                url = URL(builtUri.toString())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }

            Log.d(TAG, "Built URI " + url!!)

            return url
        }

        fun buildUr(aux:String): URL?{
            val builtUri = Uri.parse(aux)

            var url: URL? = null
            try {
                url = URL(builtUri.toString())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }

            Log.d(TAG, "Built URI " + url!!)

            return url

        }

        @Throws(IOException::class)
        fun getResponseFromHttpUrl(url: URL): String? {
            val urlConnection = url.openConnection() as HttpURLConnection
            try {
                val `in` = urlConnection.inputStream

                val scanner = Scanner(`in`)
                scanner.useDelimiter("\\A")

                val hasInput = scanner.hasNext()
                return if (hasInput) {
                    scanner.next()
                } else {
                    null
                }
            } finally {
                urlConnection.disconnect()
            }
        }

    }

}