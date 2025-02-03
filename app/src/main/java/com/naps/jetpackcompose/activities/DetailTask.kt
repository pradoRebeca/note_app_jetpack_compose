package com.naps.jetpackcompose.activities

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.naps.jetpackcompose.base.Consts
import com.naps.jetpackcompose.data.SharedPreferences

@Composable
fun DetailTaskScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    localData: SharedPreferences
) {
    var title by remember { mutableStateOf(localData.get(Consts.title)) }
    var description by remember { mutableStateOf(localData.get(Consts.description)) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(title, fontSize = 25.sp,modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.height(15.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(description, fontSize = 18.sp, modifier = Modifier.padding(10.dp))
        }
    }
}