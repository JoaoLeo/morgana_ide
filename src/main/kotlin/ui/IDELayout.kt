package com.morgana.ide.ui

import FileExplorer
import androidx.compose.foundation.ContextMenuArea
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.MenuBar

@Composable
fun IDELayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Menu Bar
        MenuBar()

        // Main content area with context menu
        ContextMenuArea(
            items = {
                listOf(
                    ContextMenuItem("New File") {
                        // Handle new file
                        println("New File clicked")
                    },
                    ContextMenuItem("Open File") {
                        // Handle open file
                        println("Open File clicked")
                    },
                    ContextMenuItem("Save") {
                        // Handle save
                        println("Save clicked")
                    }
                )
            }
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                // File Explorer/Project Tree (left panel)
                FileExplorer(modifier = Modifier.width(250.dp).fillMaxHeight())

                EditorScreen(modifier = Modifier.weight(1f).fillMaxHeight())
            }
        }
    }
}
