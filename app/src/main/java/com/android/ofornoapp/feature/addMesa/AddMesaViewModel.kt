package com.android.ofornoapp.feature.addMesa

import androidx.lifecycle.ViewModel
import com.android.ofornoapp.feature.mesa.Mesa
import com.android.ofornoapp.feature.mesa.MesaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddMesaViewModel @Inject constructor(
    private val repository: MesaRepository
): ViewModel(){
    private  var _state  = mutableListOf<Mesa>()
    val state
        get() = _state
    init {
       _state = repository.getMesas().toMutableList();
    }

    fun addMesa(mesa: Mesa) {
        repository.addMesas(mesa)
    }
}
