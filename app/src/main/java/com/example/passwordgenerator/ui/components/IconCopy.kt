package com.example.passwordgenerator.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.passwordgenerator.R

@Composable
fun IconCopy(
    isEnable: Boolean,
    onCopyClick: () -> Unit
) = Icon(
    modifier = Modifier
        .padding(
            end = dimensionResource(id = R.dimen._16dp),
            bottom = dimensionResource(id = R.dimen._16dp),
            top = dimensionResource(id = R.dimen._16dp)
        )
        .clickable { onCopyClick() },
    imageVector = Icons.Default.ContentCopy,
    contentDescription = stringResource(id = R.string.icon_copy_content_description),
    tint = if (isEnable) MaterialTheme.colors.secondary else Color.Gray
)