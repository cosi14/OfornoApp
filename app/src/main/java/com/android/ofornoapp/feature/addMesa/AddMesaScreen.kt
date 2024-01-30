package com.android.ofornoapp.feature.addMesa

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.ofornoapp.feature.mesa.Mesa

@Composable
fun AddMesaScreen(viewModel: AddMesaViewModel = hiltViewModel()) {
        AddMesaContent(addMesa = {
            viewModel.guardarMesa(it)
        })
    mostrarMesas {
        viewModel.mostrarMesas()
    }

}


    @Composable
    fun AddMesaContent(
        addMesa: (Mesa) -> Unit = {},
    ) {
        val mesa = Mesa(
         12 ,3,false , emptyList()
        )
        Box(contentAlignment = androidx.compose.ui.Alignment.Center) {
            Button(onClick = { addMesa(mesa)

            }) {
                Text(text = "Añadir Pila")
            }
        }
    }
@Composable
fun  mostrarMesas(getMesas: () -> List<Mesa>) {
Column {
   var listMesa = getMesas()
    listMesa.forEach{mesa ->
        Text(text = mesa.NumComensales.toString())
        Text(text = mesa.Cobrada.toString())
        Text(text = mesa.NumMesa.toString())
    }
    }

}


