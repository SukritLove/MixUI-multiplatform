package core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import ui.theme.DarkColorsScheme
import ui.theme.LightColorsScheme
import ui.theme.Typography

@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorsScheme else LightColorsScheme,
        typography = Typography,
        content = content
    )
}