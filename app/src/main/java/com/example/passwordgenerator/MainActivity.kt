package com.example.passwordgenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.passwordgenerator.ui.components.GeneratorScreen
import com.example.passwordgenerator.ui.theme.PasswordGeneratorTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordGeneratorTheme {
                GeneratorScreen()
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GeneratorScreenPreview() {
    PasswordGeneratorTheme {
        GeneratorScreen()
    }
}