package screen.UI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun RadioButtonElement() {
    val fruit = listOf("Apple", "Papaya", "Banana", "Orange")
    var selectedValue by remember { mutableStateOf(fruit[0]) }

    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            fruit.forEach { _fruit ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = (_fruit == selectedValue),
                        onClick = { selectedValue = _fruit })
                    Text(_fruit)
                }

            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Selected Value :")
            Text(
                selectedValue,
                style = TextStyle(fontSize = 20.sp, color = Color.Red)
            )
        }
    }

}