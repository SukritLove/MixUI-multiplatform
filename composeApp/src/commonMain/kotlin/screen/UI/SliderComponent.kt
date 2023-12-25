package screen.UI


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {


        var basicSliderPosition by remember { mutableStateOf(0f) }
        Slider(value = basicSliderPosition, onValueChange = { basicSliderPosition = it })
        Text(text = "Basic Slider value : ${(basicSliderPosition * 100).toInt()}")
        Spacer(Modifier.padding(10.dp))


        var stepSliderPosition by remember { mutableStateOf(0f) }
        Slider(
            value = stepSliderPosition,
            onValueChange = { stepSliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer
            ),
            steps = 3,
            valueRange = 0f..100f
        )
        Text(text = "Slider With step value : ${(stepSliderPosition).toInt()}")
        Spacer(Modifier.padding(15.dp))


        var rangeWithoutStepSliderPosition by remember { mutableStateOf(0f..100f) }
        RangeSlider(
            value = rangeWithoutStepSliderPosition,
            onValueChange = { range -> rangeWithoutStepSliderPosition = range },
            valueRange = 0f..100f
        )
        Text("Range Slide with Step : ${rangeWithoutStepSliderPosition.round().first}% <-> ${rangeWithoutStepSliderPosition.round().last}%")
        Spacer(Modifier.padding(15.dp))


        var rangeWithStepPosition by remember { mutableStateOf(0f..100f) }
        RangeSlider(
            value = rangeWithStepPosition,
            steps = 19,
            onValueChange = { range -> rangeWithStepPosition = range },
            valueRange = 0f..100f
        )
        Text("Range Slide with Step : ${rangeWithStepPosition.round().first}% <-> ${rangeWithStepPosition.round().last}%")
        Spacer(Modifier.padding(15.dp))


    }

}

private fun ClosedFloatingPointRange<Float>.round(): IntRange {
    val roundedStart = start.roundToNearestInteger()
    val roundedEnd = endInclusive.roundToNearestInteger()

    return roundedStart..roundedEnd
}

private fun Float.roundToNearestInteger(): Int {
    return this.toInt()
}