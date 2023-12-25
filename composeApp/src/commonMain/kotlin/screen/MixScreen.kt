package screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import screen.UI.ButtonComponent
import screen.UI.RadioButtonComponent
import screen.UI.SliderComponent


@Composable
fun MixScreen() {
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        ButtonComponent()
        line()
        RadioButtonComponent()
        line()
        SliderComponent()

    }
}

@Composable
fun line() {
    Spacer(Modifier.padding(10.dp))
    Box(
        Modifier.fillMaxWidth().height(5.dp).clip(shape = RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colorScheme.outline)

    )
    Spacer(Modifier.padding(10.dp))
}

