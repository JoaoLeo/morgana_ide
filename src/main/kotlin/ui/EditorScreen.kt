package com.morgana.ide.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.*
import androidx.compose.ui.*

@Composable
@Preview
fun EditorScreen() {
    var text by remember { mutableStateOf("") }

    Surface {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Code Editor") },
            singleLine = false,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}