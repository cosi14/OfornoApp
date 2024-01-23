package com.android.ofornoapp.feature.mesa
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.android.ofornoapp.feature.addMesa.navigateToAddMesaScreen

val ROUTE = "mesa_screen"
fun NavController.navigateToMesaScreen() {
    navigate(ROUTE)
}
fun NavGraphBuilder.mesaScreen(navController: NavHostController) {
    composable(ROUTE) { MesaScreen(
        navigationToAddMesa =  { navController.navigateToAddMesaScreen() }
    ) }
}