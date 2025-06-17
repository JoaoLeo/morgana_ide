package com.morgana.ide.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditorScreen(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("// Welcome to Morgana IDE\n// Start coding here...\n\nfun main() {\n    println(\"Hello, World!\")\n}") }

    Surface(
        modifier = modifier,
        elevation = 1.dp
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Tab bar for open files
            TabRow(
                selectedTabIndex = 0,
                modifier = Modifier.fillMaxWidth()
            ) {
                Tab(
                    selected = true,
                    onClick = { /* Switch tab */ },
                    text = { Text("Main.kt") }
                )
            }

            // Code editor
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                textStyle = LocalTextStyle.current.copy(
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace
                ),
                placeholder = { Text("Start typing your code...") }
            )
        }
    }
}