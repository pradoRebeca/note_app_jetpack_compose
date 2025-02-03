package com.naps.jetpackcompose.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.naps.jetpackcompose.activities.CreateTaskScreen
import com.naps.jetpackcompose.activities.DetailTaskScreen
import com.naps.jetpackcompose.activities.EditTaskScreen
import com.naps.jetpackcompose.activities.ListTaskScreen
import com.naps.jetpackcompose.data.SharedPreferences

class CallScaffold(
    private val navController: NavController,
    private val localData: SharedPreferences
) {
    @Composable
    fun createScaffold(screen: String): PaddingValues {
        Scaffold(topBar = {
            when (screen) {
                Routes.TaskEdit.route -> BuildCenterAppBar("Edit note")
                Routes.TaskCreate.route -> BuildCenterAppBar("Create Note")
                Routes.TaskDetail.route -> BuildCenterAppBar("Note detail")
                Routes.TaskList.route -> BuildCenterAppBar("My notes", false)
            }
        }) { padding ->
            when (screen) {
                Routes.TaskList.route -> ListTaskScreen(
                    padding,
                    navController = navController,
                    localData = localData
                )

                Routes.TaskEdit.route -> EditTaskScreen(
                    padding,
                    navController = navController,
                    localData = localData
                )

                Routes.TaskCreate.route -> CreateTaskScreen(
                    padding,
                    navController = navController,
                    localData = localData
                )

                Routes.TaskDetail.route -> DetailTaskScreen(
                    padding,
                    navController = navController,
                    localData = localData
                )
            }
        }
        return PaddingValues()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BuildCenterAppBar(title: String, hasBackButton: Boolean = true) {
        CenterAlignedTopAppBar(
            title = { Text(title) },
            navigationIcon = {
                if (hasBackButton) {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            })
    }
}