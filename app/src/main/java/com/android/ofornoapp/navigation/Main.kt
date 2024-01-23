package com.android.ofornoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.android.ofornoapp.feature.mesa.MesaScreen

val ROUTE = "mesa_screen"
@Composable
fun Navigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE){
      MesaScreen(navController = navController)
    }
}