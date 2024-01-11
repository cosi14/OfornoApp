package com.android.ofornoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.ofornoapp.ui.theme.OfornoAppTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OfornoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ScaffoldExample()
                }
            }
        }
    }
}

var presses = 0

@Composable
fun CenteredBottomAppBar() {
    BottomAppBar(
        modifier = Modifier.background(Color.White),
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomIconButton(
                icon = Icons.Default.KeyboardArrowUp,
                iconSize = 60,
                onClick = { presses++ }
            )
            Spacer(modifier = Modifier.width(16.dp))
            CustomIconButton(
                icon = Icons.Default.KeyboardArrowDown,
                iconSize = 60,
                onClick = { presses++ }
            )
        }
    }
}

@Composable
fun CustomIconButton(icon: ImageVector, iconSize: Int, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(iconSize.dp)
    ) {
        Icon(
            modifier = Modifier.size(iconSize.dp),
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var colorFondo by remember { mutableStateOf(Color.Cyan) }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                   IconButton(onClick = { /*TODO*/ }) {
                       Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                   }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {

                    Text("Restaurante Oforno")
                }

            )
        },
        bottomBar = {
            CenteredBottomAppBar()
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            //Queria poner una imagen pero no me funciona y la app nose abre y nose como conseguir bitmap para usar el Image
          //  AsyncImage(model ="https://www.tooltyp.com/wp-content/uploads/2014/10/1900x920-8-beneficios-de-usar-imagenes-en-nuestros-sitios-web.jpg" , contentDescription ="" )
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    Mi plan era poder pasar elementos de una lista a otra pero no me salio asi que lo hare en el siguiente commit.
                """.trimIndent(),
            )
            LazyRow(
                horizontalArrangement =
                Arrangement.SpaceAround
            ) {
                items(5) { index ->
                    Button(onClick = { /*TODO*/ }) {
                        Image(imageVector = Icons.Default.Check, contentDescription ="Check" )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Item: $index")
                    }

                }
            }
            LazyRow(
                horizontalArrangement =
                Arrangement.SpaceAround
            ) {
                items(5) { index ->
                    Button(
                        onClick = {
                            this@LazyRow.item{
                                colorFondo = Color.Green}
                        } ,
                        colors = ButtonDefaults.buttonColors(containerColor =  colorFondo)

                    ) {
                        Image(imageVector = Icons.Default.Close, contentDescription ="Close" )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Item: $index")

                    }

                }
            }
        }
    }
}
@Composable
fun TodoApp() {
    var taskText by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = taskText,
            onValueChange = { taskText = it },
            label = { Text("Agregar nueva tarea") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                if (taskText.isNotEmpty()) {
                    guardarTarea(context, taskText)
                    taskText = ""
                }
            }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        TareasList(context = context)
    }
}

@Composable
fun TareasList(context: android.content.Context) {
    val tareas = leerTareas(context)

    LazyColumn {
        items(tareas) { tarea ->
            Text(text = tarea)
        }
    }
}

fun guardarTarea(context: android.content.Context, tarea: String) {
    val file = File(context.filesDir, "tareas.txt")
    file.appendText("$tarea\n")
}

fun leerTareas(context: android.content.Context): List<String> {
    val file = File(context.filesDir, "tareas.txt")
    if (!file.exists()) return emptyList()

    return file.readLines()
}

@Preview
@Composable
fun PreviewTodoApp() {
    TodoApp()
}
@Preview
@Composable
fun CenteredBottomAppBarPreview() {
    CenteredBottomAppBar()
}