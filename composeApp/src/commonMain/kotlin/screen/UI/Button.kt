package screen.UI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ButtonZone() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        var normButton by remember { mutableStateOf(false) }
        var outlineButton by remember { mutableStateOf(false) }

        Button(onClick = {
            normButton = !normButton
            if (normButton) outlineButton = false
        }
        ) {
            Text("Button 1")

        }
        Text(
            text = if (normButton) {
                "Normal Button"
            } else if (outlineButton) {
                "Outline Button"
            } else {
                "Which Button"
            }
        )
        OutlinedButton(onClick = {
            outlineButton = !outlineButton
            if (outlineButton) normButton = false

        }) {
            Text("Button 2")
        }
    }
}
