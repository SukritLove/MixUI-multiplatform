package org.example.mixui

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(darkTheme = isSystemInDarkTheme(),
                dynamicColor = false,)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(darkTheme = isSystemInDarkTheme(),
        dynamicColor = false,)
}