package com.android.ofornoapp.feature.mesa

import javax.inject.Inject


class MesaRepository @Inject constructor(
) {
    var listaDeMesas = mutableListOf<Mesa>()
    fun getMesas(): List<Mesa> {
        val mesas = mutableListOf<Mesa>()
        for (i in 1..5) {
           mesas.add(
               Mesa(
                   i,i+3,false, emptyList()
               )
           )
        }
        listaDeMesas =mesas;
        return mesas.toList()
    }
    fun addMesas(mesa: Mesa){
        listaDeMesas.add(mesa)
    }
}
