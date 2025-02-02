package com.naps.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naps.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlin.math.round


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    setContent {
                        Form(paddingValues = innerPadding)
                    }
                }
            }

        }
    }


    @Composable
    fun Form(paddingValues: PaddingValues) {
        var name by remember { mutableStateOf("") }
        var surname by remember { mutableStateOf("") }
        var street by remember { mutableStateOf("") }
        var state by remember { mutableStateOf("") }
        var numberHouse by remember { mutableStateOf("") }
        var info by remember { mutableStateOf("") }
        var cep by remember { mutableStateOf("") }
        var numberDoc by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)

            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .border(
                            border = BorderStroke(
                                width = 2.dp,
                                color = Color.Black
                            ), shape = CircleShape
                        )
                        .padding(5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Person Icon",
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Nome") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    OutlinedTextField(
                        value = surname,
                        onValueChange = { surname = it },
                        label = { Text("Sobrenome") },
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    value = street,
                    onValueChange = { street = it },
                    label = { Text("Rua") })
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    value = state,
                    onValueChange = { state = it },
                    label = { Text("Estado") })
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = numberHouse,
                        onValueChange = { numberHouse = it },
                        label = { Text("Numero") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    OutlinedTextField(
                        value = info,
                        onValueChange = { info = it },
                        label = { Text("Complemento") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    OutlinedTextField(
                        value = cep,
                        onValueChange = { cep = it },
                        label = { Text("CEP") },
                        modifier = Modifier.weight(1f)
                    )
                }
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = numberDoc,
                    onValueChange = { numberDoc = it },
                    label = { Text("Numero doc (RG/CPF)") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { Log.i("Form", "Formulario: Nome: $name, Sobrenome: $surname") }
                ) {
                    Text("Cadastrar")
                }

            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun ShowScreenPreview() {
        Form(paddingValues = PaddingValues())
    }

}



