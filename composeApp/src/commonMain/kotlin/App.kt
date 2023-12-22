import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import core.presentation.AppTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import screen.MixScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
) {
    AppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            MixScreen()
        }

    }
}