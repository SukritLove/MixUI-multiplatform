package screen.UI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import screen.line

@Composable
fun FloatingButtonComponent() {
    var smallBtn by remember { mutableStateOf(false) }
    var normalBtn by remember { mutableStateOf(false) }
    var largeBtn by remember { mutableStateOf(false) }
    var extendedBtn by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            FloatingSmall(onClick = {
                smallBtn = !smallBtn
            })
            FloatingNormal {
                normalBtn = !normalBtn
            }
            FloatingLarge {
                largeBtn = !largeBtn
            }
        }
        Spacer(Modifier.padding(15.dp))
        FloatingExtended { extendedBtn = !extendedBtn }
        Spacer(Modifier.padding(15.dp))
        line()

        when {
            smallBtn -> {
                DialogComponent(
                    onDismissRequest = { smallBtn = false },
                    onConfirmation = { smallBtn = false },
                    dialogTitle = "Small floating button Dialog",
                    dialogText = "This is an example of an alert dialog with buttons.",
                    icon = Icons.Filled.Info
                )
            }

            normalBtn -> {
                DialogComponent(
                    onDismissRequest = { normalBtn = false },
                    onConfirmation = { normalBtn = false },
                    dialogTitle = "Normal floating button Dialog",
                    dialogText = "This is an example of an alert dialog with buttons.",
                    icon = Icons.Filled.Info
                )
            }

            largeBtn -> {
                DialogComponent(
                    onDismissRequest = { largeBtn = false },
                    onConfirmation = { largeBtn = false },
                    dialogTitle = "Large floating button Dialog",
                    dialogText = "This is an example of an alert dialog with buttons.",
                    icon = Icons.Filled.Info
                )
            }

            extendedBtn -> {
                DialogComponent(
                    onDismissRequest = { extendedBtn = false },
                    onConfirmation = { extendedBtn = false },
                    dialogTitle = "Extended floating button Dialog",
                    dialogText = "This is an example of an alert dialog with buttons.",
                    icon = Icons.Filled.Info
                )
            }
        }

        Text("Small : ${if (smallBtn) "Confirmed" else "Dismissed"}")
        Text("Normal : ${if (normalBtn) "Confirmed" else "Dismissed"}")
        Text("Large : ${if (largeBtn) "Confirmed" else "Dismissed"}")
        Text("Extended : ${if (extendedBtn) "Confirmed" else "Dismissed"}")
    }

}

@Composable
fun FloatingSmall(onClick: () -> Unit) {
    SmallFloatingActionButton(
        onClick = { onClick() },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }
}

@Composable
fun FloatingNormal(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@Composable
fun FloatingLarge(onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = { onClick() },
        shape = CircleShape,
    ) {
        Icon(Icons.Filled.Add, "Large floating action button")
    }
}

@Composable
fun FloatingExtended(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
        text = { Text(text = "Extended FAB") },
    )
}