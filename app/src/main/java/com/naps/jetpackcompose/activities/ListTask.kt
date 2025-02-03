package com.naps.jetpackcompose.activities

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.naps.jetpackcompose.base.Consts
import com.naps.jetpackcompose.base.Routes
import com.naps.jetpackcompose.data.SharedPreferences

@Composable
fun ListTaskScreen(
    paddingValues: PaddingValues, navController: NavController, localData: SharedPreferences
) {
    var title by remember { mutableStateOf(localData.get(Consts.title)) }
    var showAlertDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(15.dp)
            .fillMaxWidth()
    ) {

        if (showAlertDialog) {
            AlertDialog(
                onDismissRequest = {},
                text = { Text("Do you really want delete a task?") },
                confirmButton = {
                    Button(onClick = {
                        localData.delete(Consts.title)
                        localData.delete(Consts.description)
                        title = ""
                        showAlertDialog = false

                    }) { Text("Confirm") }
                },
                dismissButton = {
                    Button(onClick = {
                        showAlertDialog = false
                    }) { Text("No") }
                }
            )
        }

        if (title != "") {
            Card(modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(Routes.TaskDetail.route) }) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(10.dp),
                    )
                    Row {
                        IconButton(onClick = { navController.navigate(Routes.TaskEdit.route) }) {
                            Icon(Icons.Default.Edit, contentDescription = null)
                        }
                        IconButton(onClick = {
                            showAlertDialog = true
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = null)
                        }
                    }
                }
            }
        } else {
            Box(contentAlignment = Alignment.Center) { Text("No tasks") }
        }

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp),
        ) {
            FloatingActionButton(onClick = {
                navController.navigate(Routes.TaskCreate.route)
            }) {
                Text(text = "+")
            }
        }
    }
}