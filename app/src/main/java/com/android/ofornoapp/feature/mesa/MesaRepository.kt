package com.android.ofornoapp.feature.mesa

import androidx.compose.runtime.mutableStateOf
import javax.inject.Inject


class MesaRepository @Inject constructor() {
    //No soy capaz de que no se refresque la lista cada vez que navego
    private var listaDeMesas = mutableStateOf(mutableListOf<Mesa>())
init {
    listaDeMesas   = mutableStateOf(mutableListOf(
      Mesa(
            101,
            4,
            false,
             emptyList()
        ),
        Mesa(
            102,
            6,
            false,
            emptyList()
        ),
        Mesa(
            103,
            2,
            false,
            emptyList()
        )
    ))
}
    fun getMesas(): List<Mesa> { return listaDeMesas.value }

    fun addMesas(mesa: Mesa) = listaDeMesas.value.add(mesa)

    fun editMesas(mesa: Mesa) {
        val updatedList = listaDeMesas.value
        val indiceMesaAReemplazar = updatedList.indexOfFirst { it.ID == mesa.ID }
        if (indiceMesaAReemplazar != -1) {
            updatedList[indiceMesaAReemplazar] = mesa
            listaDeMesas.value = updatedList
        } else {
            println("No se encontró ninguna mesa con la ID ${mesa.ID}.")
        }
    }

    fun removeMesas(mesa: Mesa) {
        val updatedList = listaDeMesas
        updatedList.value.add(mesa)
        listaDeMesas = updatedList

    }
}



