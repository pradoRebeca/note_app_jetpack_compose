package com.naps.jetpackcompose.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.naps.jetpackcompose.data.SharedPreferences

class Navigation {
    private lateinit var navController: NavHostController
    private  lateinit var localData: SharedPreferences

    private fun NavGraphBuilder.composableScreen(route: String){
        composable(route){
            CallScaffold(navController, localData).createScaffold(route)
        }
    }

    @Composable
    fun Create(){
        navController = rememberNavController()
        localData = SharedPreferences(LocalContext.current)

        NavHost(navController = navController, startDestination = Routes.TaskList.route ){
            composableScreen(Routes.TaskEdit.route)
            composableScreen(Routes.TaskList.route)
            composableScreen(Routes.TaskDetail.route)
            composableScreen(Routes.TaskCreate.route)

        }
    }
}