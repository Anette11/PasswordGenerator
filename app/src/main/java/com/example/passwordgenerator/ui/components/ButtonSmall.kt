package com.example.passwordgenerator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.passwordgenerator.R

@Composable
fun ButtonSmall(
    text: String,
    onClick: () -> Unit,
    isEnable: Boolean
) = Surface(
    modifier = Modifier
        .width(dimensionResource(id = R.dimen._40dp))
        .height(dimensionResource(id = R.dimen._40dp)),
    shape = MaterialTheme.shapes.small
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isEnable) MaterialTheme.colors.primary else Color.Gray)
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen._4dp)))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h5,
            color = Color.White
        )
    }
}