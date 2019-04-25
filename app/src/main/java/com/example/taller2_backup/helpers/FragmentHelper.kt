package com.example.taller2_backup.helpers

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

interface FragmentHelper {

    fun returnLayoutManager():GridLayoutManager
    fun returnRecyclerView():RecyclerView

}