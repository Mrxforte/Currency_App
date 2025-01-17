package com.example.currencyapp

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
//        Big title of the app
        Text(text = "Currency App", fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(onValueChange = {}, value = "")
        Spacer(Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val context = LocalContext.current
//            Button 1
            Box {
                Button(onClick = {
                    Toast.makeText(context, "Simple Toast From Jetpack", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "Convert")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }
                Spacer(Modifier.height(10.dp))
                DropdownMenu(onDismissRequest = {}, expanded = true) {
                    DropdownMenuItem(onClick = {}, text = { Text(text = "Item 1") })
                    DropdownMenuItem(onClick = {}, text = { Text(text = "Item 2") })
                    DropdownMenuItem(onClick = {}, text = { Text(text = "Item 3") })
                    DropdownMenuItem(onClick = {}, text = { Text(text = "Item 4") })
                }
            }
//            Button 2
            Box {
                Button(onClick = {
                    Toast.makeText(context, "Simple Toast From Jetpack", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "Convert")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }

                DropdownMenu(onDismissRequest = {}, expanded = false) {
                    DropdownMenuItem(onClick = {}, text = { Text(text = "Item 1") })
                    DropdownMenuItem(onClick = {}, text = { Text(text = "Item 2") })
                    DropdownMenuItem(onClick = {}, text = { Text(text = "Item 3") })
                    DropdownMenuItem(onClick = {}, text = { Text(text = "Item 4") })
                }
            }

        }

//             Result text
        Spacer(Modifier.height(300.dp))
        Text(text = "Results", fontSize = 20.sp, fontWeight = FontWeight.W500)

    }

}