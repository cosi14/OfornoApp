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
    fun guardarMesa(mesa: Mesa) {
        repository.addMesas(mesa)
    }
    fun mostrarMesas(): List<Mesa> {
      return  repository.getMesas()
    }
}