import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.morgana.ide.service.FileService

@Composable
fun FileExplorer(path: String = "./", modifier: Modifier = Modifier) {
    val filesAndDirectories = remember("/home/joaoleo/Documentos") {
        try {
            FileService.getFilesAndDirs(path)?.toList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    Surface(elevation = 2.dp, modifier = modifier) {
        Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Text(
                text = "Project Explorer",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            filesAndDirectories?.forEach { file ->
                Text(
                    text = if (file.isDirectory) "📁 ${file.name}" else "📄 ${file.name}",
                    modifier = Modifier.padding(start = if (file.isDirectory) 4.dp else 16.dp, bottom = 4.dp)
                )
            }
        }
    }
}