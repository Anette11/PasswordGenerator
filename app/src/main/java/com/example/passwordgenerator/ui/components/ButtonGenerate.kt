package com.example.passwordgenerator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.passwordgenerator.R

@Composable
fun ButtonGenerate(
    isEnable: Boolean = false,
    onClick: () -> Unit
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = dimensionResource(id = R.dimen._16dp)),
    horizontalArrangement = Arrangement.Center
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isEnable) MaterialTheme.colors.primary else Color.Gray
        )
    ) {
        Text(
            text = stringResource(id = R.string.button_generate_text),
            style = MaterialTheme.typography.h6,
            color = Color.White
        )
    }
}