package com.android.ofornoapp.feature.mesa

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MesaScreen (
    viewModel: MesaViewModel = hiltViewModel(),
navigationToAddMesa: () -> Unit,
){
val state = viewModel.state
 MesaContent (state = state , navigateToAddMesa = navigationToAddMesa)
}
@Composable
fun MesaContent(
    state: List<Mesa> = emptyList(),
    navigateToAddMesa: () -> Unit,
) {
    Column {
        LazyColumn {
            items(state) { mesa ->
                Mesa(mesa)
            }
        }
    }

    Button(onClick = { navigateToAddMesa() }) {
        Text(text = "Añadir Pila")
    }

}

@Composable
fun Mesa(mesa: Mesa) {
    Row {
        Text(mesa.NumMesa.toString())
        Text(mesa.Cobrada.toString())
        Text(mesa.NumComensales.toString())
    }
}
