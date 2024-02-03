package com.android.ofornoapp.feature.mesa


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MesaScreen(
    viewModel: MesaViewModel = hiltViewModel(),
    navigationToAddMesa: () -> Unit,
) {
    val state = viewModel.state.collectAsState()
    MesaContent(state = state.value, navigateToAddMesa = navigationToAddMesa)
}

@Composable
fun MesaContent(
    state: List<Mesa> = emptyList(),
    navigateToAddMesa: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(state) { item ->
            Mesa(item, navigateToAddMesa)
        }
    }

}

@Composable
fun Mesa(
    mesa: Mesa,
    navigateToAddMesa: () -> Unit
) {

    Box(
        modifier = Modifier
            .padding(3.dp)
            .background(color = Color.Gray, shape = RectangleShape)
            .height(100.dp)
            .fillMaxWidth(),

        ) {
        Row {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Nª Mesa: " + mesa.NumMesa.toString(),
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(3.dp)
                )
                if (mesa.Cobrada) {
                    Text(
                        text = "Cobrada",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(3.dp)
                    )
                } else {
                    Text(
                        text = "Por cobrar",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(3.dp)
                    )
                }
                Text(
                    text = "Nª Personas: " + mesa.NumComensales.toString(),
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(3.dp)
                )
            }
            Column (
                modifier = Modifier
                .fillMaxWidth(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End) {
                IconButton(onClick = { navigateToAddMesa() }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit Icon")
                }
                IconButton(onClick = { navigateToAddMesa() }) {
                    Icon(Icons.Default.Close, contentDescription = "Remove Icon")
                }
            }
        }
    }
}