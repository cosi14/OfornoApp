package com.android.ofornoapp.feature.mesa

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MesaViewModel @Inject constructor(

): ViewModel(){
 private  var _state :List<Mesa> = emptyList()
    val mesa1 = Mesa(1, 1, false ,emptyList())
    val listaDeObjetos: List<Mesa> = listOf(mesa1)
    val state
        get() = _state
    init {
         _state = listaDeObjetos
    }
}
data class Mesa(
    val NumMesa: Int,
    val NumComensales: Int,
    val Cobrada: Boolean,
    val Ticket: List<String>,
)