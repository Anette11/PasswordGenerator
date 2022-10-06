package com.example.passwordgenerator.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.passwordgenerator.R

@Composable
fun ConditionSector(
    isSelected: Boolean = false,
    text: String,
    onClick: () -> Unit
) = Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
) {
    RadioButton(
        selected = isSelected,
        onClick = onClick
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._16dp)))
    Text(text = text)
}