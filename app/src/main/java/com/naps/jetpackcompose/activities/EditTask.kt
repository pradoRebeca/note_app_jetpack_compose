package com.naps.jetpackcompose.activities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.naps.jetpackcompose.base.Consts
import com.naps.jetpackcompose.data.SharedPreferences

@Composable
fun EditTaskScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    localData: SharedPreferences
) {

    var title by remember { mutableStateOf(localData.get(Consts.title)) }
    var description by remember { mutableStateOf(localData.get(Consts.description)) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(start = 10.dp, end = 10.dp, bottom = 20.dp, top = 20.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Title") }
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            label = { Text("Description") }
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {
                localData.save(Consts.title, title)
                localData.save(Consts.description, description)
                navController.popBackStack()
            }, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Create note", fontSize = 16.sp)
        }
    }
}
