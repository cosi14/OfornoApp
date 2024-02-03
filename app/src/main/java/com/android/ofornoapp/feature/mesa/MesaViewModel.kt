package com.android.ofornoapp.feature.mesa

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MesaViewModel @Inject constructor(
    private val repository: MesaRepository
): ViewModel(){

    private var _state = MutableStateFlow(emptyList<Mesa>())
    val state: StateFlow<List<Mesa>> = _state

    init {
        _state.value = repository.getMesas()
    }

}

data class Mesa(
    val ID :Int,
    val NumMesa: Int,
    val NumComensales: Int,
    val Cobrada: Boolean,
    val Ticket: List<String>,
){

    companion object {
        private var contadorId: Int = 0

        fun getNextId(): Int {
            return contadorId++
        }
    }

    constructor(numMesa: Int, numComensales: Int, cobrada: Boolean, ticket: List<String>) :
            this(getNextId(), numMesa, numComensales, cobrada, ticket)
}