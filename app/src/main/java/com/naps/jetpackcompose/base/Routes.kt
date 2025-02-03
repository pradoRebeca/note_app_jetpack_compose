package com.naps.jetpackcompose.base

sealed class Routes(val route: String) {
    data object TaskList : Routes("taskList")
    data object TaskEdit : Routes("taskEdit")
    data object TaskCreate : Routes("taskCreate")
    data object TaskDetail : Routes("taskDetail")
}