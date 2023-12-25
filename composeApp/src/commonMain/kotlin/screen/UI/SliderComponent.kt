package screen.UI


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SliderComponent() {
    LazyColumn(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        item {
            var sliderPosition by remember { mutableStateOf(0f) }
            Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
            Text(text = "Basic Slider value : ${(sliderPosition * 100).toInt()}")
            Spacer(Modifier.padding(10.dp))
        }

        item {
            var sliderPosition by remember { mutableStateOf(0f) }
            Slider(
                value = sliderPosition, onValueChange = { sliderPosition = it },
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary,
                    inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                steps = 3,
                valueRange = 0f..100f
            )
            Text(text = "Slider With step value : ${(sliderPosition).toInt()}")
            Spacer(Modifier.padding(15.dp))
        }
        item {
            var sliderPosition by remember { mutableStateOf(0f..100f) }
            RangeSlider(
                value = sliderPosition,
                onValueChange = { range -> sliderPosition = range },
                valueRange = 0f..100f
            )
            Text("Range Slide with Step : ${sliderPosition.round().first}% <-> ${sliderPosition.round().last}%")
            Spacer(Modifier.padding(15.dp))
        }

        item {
            var sliderPosition by remember { mutableStateOf(0f..100f) }
            RangeSlider(
                value = sliderPosition,
                steps = 19,
                onValueChange = { range -> sliderPosition = range },
                valueRange = 0f..100f
            )
            Text("Range Slide with Step : ${sliderPosition.round().first}% <-> ${sliderPosition.round().last}%")
            Spacer(Modifier.padding(15.dp))
        }

    }

}

fun ClosedFloatingPointRange<Float>.round(): IntRange {
    val roundedStart = start.roundToNearestInteger()
    val roundedEnd = endInclusive.roundToNearestInteger()

    return roundedStart..roundedEnd
}

fun Float.roundToNearestInteger(): Int {
    return this.toInt()
}