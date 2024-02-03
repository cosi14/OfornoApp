package com.android.ofornoapp.feature.editMesa

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.android.ofornoapp.feature.mesa.navigateToMesaScreen


val ROUTE = "edit_mesa_screen"
    fun NavController.navigateToEditMesaScreen() {
        navigate(ROUTE)
    }
    fun NavGraphBuilder.editMesaScreen(navController: NavHostController) {
        composable(ROUTE) {
            EditMesaScreen( navigationToMesa =  { navController.navigateToMesaScreen()
            })
        }
    }
