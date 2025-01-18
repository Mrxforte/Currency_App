package com.example.currencyapp

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun HomeScreen() {
    var inputState by remember { mutableStateOf("") }
    var outputState by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("cm") }
    var outPutUnit by remember { mutableStateOf("m") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableStateOf(1.0) }
    var oconversionFactor = remember { mutableStateOf(1.0) }

    //    Unit converting function
    fun convertMe() {
        val inputValToDouble = inputUnit.toDoubleOrNull() ?: 0.0
        val result =
            (inputValToDouble * conversionFactor.value * 100.0 / oconversionFactor.value).roundToInt() / 100
        outputState = result.toString()
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
//        Big title of the app
        Text(text = "Currency App", fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(onValueChange = {
            inputState = it
        }, value = inputState, label = { Text(text = "Enter Value") })

        Spacer(Modifier.height(32.dp))
        Row(
        ) {
            val context = LocalContext.current
//            Button 1
            Box {
                Button(onClick = {
                    iExpanded = true
                    Toast.makeText(context, "Simple Toast From Jetpack", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "Convert")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }
                Spacer(Modifier.height(10.dp))
                DropdownMenu(onDismissRequest = { iExpanded = false }, expanded = iExpanded) {
                    DropdownMenuItem(onClick = {
                        iExpanded = false
                        inputUnit = "Cantimeters"
                        conversionFactor.value = 0.01
                        convertMe()

                    }, text = { Text(text = "Cantimeters") })
                    DropdownMenuItem(onClick = {
                        iExpanded = false
                        inputUnit = "Meters"
                        conversionFactor.value = 1.0
                        convertMe()
                    }, text = { Text(text = "Meters") })
                    DropdownMenuItem(onClick = {
                        iExpanded = false
                        inputUnit = "Feet"
                        conversionFactor.value = 0.3048
                        convertMe()
                    }, text = { Text(text = "Feet") })
                    DropdownMenuItem(onClick = {
                        iExpanded = false
                        inputUnit = "Milimeters"
                        conversionFactor.value = 0.001
                        convertMe()
                    }, text = { Text(text = "Milimeters") })
                }
            }
            Spacer(Modifier.width(30.dp))
//            Button 2
            Box {
                Button(onClick = {
                    oExpanded = true
                    Toast.makeText(context, "Simple Toast From Jetpack", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "Convert")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }

                DropdownMenu(onDismissRequest = { oExpanded = false }, expanded = oExpanded) {
                    DropdownMenuItem(onClick = {
                        oExpanded = false
                        outPutUnit = "Cantimeters"
                        oconversionFactor.value = 0.01
                        convertMe()

                    }, text = { Text(text = "Cantimeters") })
                    DropdownMenuItem(onClick = {
                        oExpanded = false
                        outPutUnit = "Meters"
                        oconversionFactor.value = 1.0
                        convertMe()
                    }, text = { Text(text = "Meters") })
                    DropdownMenuItem(onClick = {
                        oExpanded = false
                        outPutUnit = "Feet"
                        oconversionFactor.value = 0.3048
                        convertMe()
                    }, text = { Text(text = "Feet") })
                    DropdownMenuItem(onClick = {
                        oExpanded = false
                        outPutUnit = "Milimeters"
                        oconversionFactor.value = 0.001
                        convertMe()
                    }, text = { Text(text = "Milimeters") })
                }
            }
        }

        //             Result text
        Spacer(Modifier.height(300.dp))
        Text(text = "Results: $outputState $outPutUnit", fontSize = 20.sp, fontWeight = FontWeight.W500)

    }


}