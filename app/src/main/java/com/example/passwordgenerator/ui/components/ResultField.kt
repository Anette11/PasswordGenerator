package com.example.passwordgenerator.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.passwordgenerator.R

@Composable
fun ResultField(
    password: String,
    onCopyClick: () -> Unit,
    isEnable: Boolean
) = Surface(
    modifier = Modifier
        .fillMaxWidth()
        .padding(dimensionResource(id = R.dimen._16dp))
        .border(
            border = ButtonDefaults.outlinedBorder,
            shape = RoundedCornerShape(dimensionResource(id = R.dimen._4dp))
        )
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(dimensionResource(id = R.dimen._16dp)),
            text = password
        )
        IconCopy(
            isEnable = isEnable,
            onCopyClick = onCopyClick
        )
    }
}