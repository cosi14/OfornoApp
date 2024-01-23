package com.android.ofornoapp.feature.addMesa

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val ROUTE = "add_mesa_screen"
fun NavController.navigateToAddMesaScreen() {
    navigate(ROUTE)
}
fun NavGraphBuilder.addMesaScreen() {
    composable(ROUTE) { AddMesaScreen() }
}