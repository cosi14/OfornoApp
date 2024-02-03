package com.android.ofornoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.android.ofornoapp.feature.addMesa.addMesaScreen
import com.android.ofornoapp.feature.mesa.ROUTE
import com.android.ofornoapp.feature.mesa.mesaScreen


@Composable
fun Navigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE){
        addMesaScreen(navController = navController)
        mesaScreen(navController = navController)

    }
}