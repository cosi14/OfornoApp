package com.android.ofornoapp.feature.addMesa

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.android.ofornoapp.feature.mesa.navigateToMesaScreen

val ROUTE = "add_mesa_screen"
fun NavController.navigateToAddMesaScreen() {
    navigate(ROUTE)
}
fun NavGraphBuilder.addMesaScreen(navController: NavHostController) {
    composable(ROUTE) { AddMesaScreen(
        navigationToMesa =  { navController.navigateToMesaScreen() }
    ) }
}