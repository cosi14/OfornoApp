package com.android.ofornoapp.feature.mesa

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MesaViewModel @Inject constructor(
    private val repository: MesaRepository
): ViewModel(){
 private  var _state :List<Mesa> = emptyList()

    val state
        get() = _state
    init {
         _state = repository.getMesas()
    }
}
data class Mesa(
    val NumMesa: Int,
    val NumComensales: Int,
    val Cobrada: Boolean,
    val Ticket: List<String>,
)