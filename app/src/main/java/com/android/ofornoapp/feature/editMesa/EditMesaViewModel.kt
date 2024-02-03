package com.android.ofornoapp.feature.editMesa

import androidx.lifecycle.ViewModel
import com.android.ofornoapp.feature.mesa.Mesa
import com.android.ofornoapp.feature.mesa.MesaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditMesaViewModel @Inject constructor(
    private val repository: MesaRepository
): ViewModel(){
    fun EditarMesas (mesa: Mesa) {
        return  repository.editMesas(mesa)
    }
}