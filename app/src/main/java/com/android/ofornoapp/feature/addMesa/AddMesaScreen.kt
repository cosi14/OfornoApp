package com.android.ofornoapp.feature.addMesa

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.ofornoapp.feature.mesa.Mesa

@Composable
fun AddMesaScreen(
    viewModel: AddMesaViewModel = hiltViewModel(),
    navigationToMesa: () -> Unit,
    state: MutableList<Mesa> = viewModel.state) {
    MesasApp(
        addMesa = {
            viewModel.addMesa(it)
        },
        state = state,
        navigateToMesa = navigationToMesa
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AddMesaContent(addMesa: (Mesa) -> Unit = {}, navigateToMesa: () -> Unit ) {
    var numMesa by remember { mutableStateOf("") }
    var numComensales by remember { mutableStateOf("") }
    var cobrada by remember { mutableStateOf(false) }
    var platos by remember { mutableStateOf("") }
    var ticket by remember { mutableStateOf(listOf<String>()) }

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = numMesa,
            onValueChange = { numMesa = it },
            label = { Text("Número de Mesa") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = numComensales,
            onValueChange = { numComensales = it },
            label = { Text("Número de Comensales") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Cobrada:")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = cobrada,
                onCheckedChange = { cobrada = it },
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        OutlinedTextField(
            value = platos,
            onValueChange = { platos = it },
            label = { Text("Ticket") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = {
                    addMesa(
                        Mesa(

                            numMesa.toIntOrNull() ?: 0,
                            numComensales.toIntOrNull() ?: 0,
                            cobrada,
                            ticket = ticket
                        // Separar el ticket por comas
                        )
                    )
                    // Limpiar los campos después de agregar la mesa
                    numMesa = ""
                    numComensales = ""
                    cobrada = false
                    platos = ""
                    // Ocultar el teclado
                    keyboardController?.hide()
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir Mesa")

            }
            IconButton(
                onClick = {
                    navigateToMesa()
                }
            ) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Añadir Mesa")

            }
        }
    }
}

@Composable
fun MostrarMesas(listMesas: MutableList<Mesa>) {
    LazyColumn {
        items(listMesas) { mesa ->
            MesaItem(mesa)
        }
    }
}

@Composable
fun MesaItem(mesa: Mesa) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("ID: ${mesa.ID}")
        Spacer(modifier = Modifier.width(8.dp))
        Text("Número de Mesa: ${mesa.NumMesa}")
        Spacer(modifier = Modifier.width(8.dp))
        Text("Comensales: ${mesa.NumComensales}")
        Spacer(modifier = Modifier.width(8.dp))
        Text("Cobrada: ${mesa.Cobrada}")
        Spacer(modifier = Modifier.width(8.dp))
        Text("Ticket: ${mesa.Ticket.joinToString()}")
    }
}

@Composable
fun MesasApp(
    addMesa: (Mesa) -> Unit = {},
    state: MutableList<Mesa>,
    navigateToMesa: () -> Unit,
) {
    var mesas by remember { mutableStateOf(emptyList<Mesa>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AddMesaContent({ Mesa ->
            addMesa(Mesa)

        }, navigateToMesa = navigateToMesa)
        Spacer(modifier = Modifier.height(16.dp))
        MostrarMesas(state)
    }
}





