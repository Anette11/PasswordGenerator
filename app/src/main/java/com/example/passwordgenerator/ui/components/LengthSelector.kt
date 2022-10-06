package com.example.passwordgenerator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.passwordgenerator.R

@Composable
fun LengthSelector(
    length: Int,
    onIncreaseClick: () -> Unit,
    onDecreaseClick: () -> Unit,
    isIncreaseEnable: Boolean,
    isDecreaseEnable: Boolean
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(dimensionResource(id = R.dimen._16dp)),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
) {
    ButtonSmall(
        text = stringResource(id = R.string.decrease),
        onClick = onDecreaseClick,
        isEnable = isDecreaseEnable
    )
    Text(
        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen._16dp)),
        text = "$length"
    )
    ButtonSmall(
        text = stringResource(id = R.string.increase),
        onClick = onIncreaseClick,
        isEnable = isIncreaseEnable
    )
}