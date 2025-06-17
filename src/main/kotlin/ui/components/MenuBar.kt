package ui.components

import androidx.compose.foundation.ContextMenuArea
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MenuBar() {
    Surface(
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth().height(40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            ContextMenuArea(items = {
                listOf(
                    ContextMenuItem("User-defined action") {
                        // Custom action
                    },
                    ContextMenuItem("Another user-defined action") {
                        // Another custom action
                    }
                )
            }) {
                // Blue box where context menu will be available
                Box(modifier = Modifier.background(Color.Blue).height(20.dp).width(75.dp))
            }
        }
    }
}
