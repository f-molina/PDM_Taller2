package com.example.taller2_backup.helpers

import android.content.Intent
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

interface FragmentHelper {

    fun returnLayoutManager():GridLayoutManager
    fun returnRecyclerView():RecyclerView
    fun getIsContainerVisible():Boolean
    fun getMainIntent():Intent
    fun getFragmentTransaction():FragmentTransaction

}