package com.android.ofornoapp.feature.mesa

import androidx.lifecycle.ViewModel
import com.android.ofornoapp.domain.Mesa
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
        _state.value = repository.getDao()
    }

}

