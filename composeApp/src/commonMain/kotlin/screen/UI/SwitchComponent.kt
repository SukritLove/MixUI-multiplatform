package screen.UI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import screen.color.MixColorData
import screen.line

@Composable
fun SwitchComponent() {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        NormalSwitch()
        line()

        IconSwitch()
        line()

        CustomSwitch()
        line()

        SwitchWithFunction()
        line()

        ResetSwitch()
    }

}

@Composable
fun ResetSwitch() {

    val switches = remember { List(4) { mutableStateOf(false) } }
    var swCount by remember { mutableStateOf(0) }


    fun onSwitchCheckedChange(index: Int, isChecked: Boolean) {
        switches[index].value = isChecked
        swCount += 1
        if (swCount > 3) {
            switches.forEach {
                it.value = false
                swCount = 0
            }
        }
    }


    Column(
        Modifier.fillMaxWidth().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.fillMaxWidth().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            for (i in 0 until switches.count()) {
                Switch(checked = switches[i].value, onCheckedChange = {
                    onSwitchCheckedChange(i, it)
                })
            }
        }
        Text("Switch Count : $swCount")
    }


}


private fun Reset(sw: Boolean, count: Int): Triple<Boolean, Boolean, Int> {
    return if (count > 3) {
        Triple(true, false, 0)
    } else {
        Triple(false, sw, 0)
    }
}


@Composable
private fun SwitchWithFunction() {
    var red by remember { mutableStateOf(false) }
    var blue by remember { mutableStateOf(false) }
    var yellow by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxWidth().background(Color.Gray).padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(checked = red, onCheckedChange = {
                red = it
            })
            Text("RED")
            Switch(checked = blue, onCheckedChange = {
                blue = it
            })
            Text("BLUE")
            Switch(checked = yellow, onCheckedChange = {
                yellow = it
            })
            Text("YELLOW")
        }
        val getColor = FindColor(red, blue, yellow)
        Spacer(Modifier.padding(15.dp))
        Card(Modifier.size(100.dp)) {
            Column(
                Modifier.fillMaxSize().background(getColor.first),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) { Text(getColor.second) }

        }

    }

}

fun FindColor(red: Boolean, blue: Boolean, yellow: Boolean): Pair<Color, String> {

    val colorData = MixColorData()
    return when {
        red && blue && yellow -> Pair(Color.Black, "Black")
        red && blue -> Pair(colorData.purple, "Purple")
        red && yellow -> Pair(colorData.orange, "Orange")
        blue && yellow -> Pair(colorData.green, "Green")
        red -> Pair(colorData.red, "Red")
        blue -> Pair(colorData.blue, "Blue")
        yellow -> Pair(colorData.yellow, "Yellow")
        else -> Pair(colorData.white, "White")
    }
}

@Composable
private fun CustomSwitch() {
    Text("Customize Switch")
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var checked by remember { mutableStateOf(false) }
        Switch(
            checked = checked, onCheckedChange = {
                checked = it
            }, colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        )
        Text(if (checked) "Turning On" else "Turning Off")
    }
}

@Composable
private fun IconSwitch() {
    Text("Switch with Icon")
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var checked by remember { mutableStateOf(false) }
        Switch(checked = checked, onCheckedChange = {
            checked = it
        }, thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        })
        Text(if (checked) "Checked" else "Uncheck")
    }
}

@Composable
private fun NormalSwitch() {
    Text("Normal Switch")
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var checked by remember { mutableStateOf(false) }
        Switch(checked = checked, onCheckedChange = {
            checked = it
        })
        Text(if (checked) "Turning On" else "Turning Off")
    }

}