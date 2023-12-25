package screen.color

import androidx.compose.ui.graphics.Color

data class MixColorData(
    val black: Color = Color(0xFF000000),
    val white: Color = Color(0xFFFFFFFF),

    val red: Color = Color(0xFFFF0000),
    val blue: Color = Color(0xFF0000FF),
    val yellow: Color = Color(0xFFFFFF00),

    val purple: Color = Color(0xFF800080),
    val green: Color = Color(0xFF008000),
    val orange: Color = Color(0xFFFFA500)
)