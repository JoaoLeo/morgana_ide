import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FileExplorer(modifier: Modifier = Modifier) {
    Surface(
        elevation = 2.dp,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            Text(
                text = "Project Explorer",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Sample file tree
            Text("📁 src/", modifier = Modifier.padding(start = 4.dp, bottom = 4.dp))
            Text("📄 Main.kt", modifier = Modifier.padding(start = 16.dp, bottom = 4.dp))
            Text("📄 EditorScreen.kt", modifier = Modifier.padding(start = 16.dp, bottom = 4.dp))
            Text("📁 resources/", modifier = Modifier.padding(start = 4.dp, bottom = 4.dp))
        }
    }
}