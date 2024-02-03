package com.android.ofornoapp.feature.editMesa

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.ofornoapp.feature.mesa.Mesa

@Composable
fun EditMesaScreen(viewModel: EditMesaViewModel = hiltViewModel(), navigationToMesa: () -> Unit) {
    EditMesaContent( editMesa = {
        viewModel.EditarMesas(it)
    })
}
@Composable
fun EditMesaContent(
    editMesa: (Mesa) -> Unit = {},
) {
    val mesa = Mesa(
        12 ,3,false , emptyList()
    )
    Box(contentAlignment = Alignment.Center) {
        Button(onClick = { editMesa(mesa)

        }) {
            Text(text = "Añadir Pila")
        }
    }
}