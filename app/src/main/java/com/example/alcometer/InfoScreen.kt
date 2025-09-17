package com.example.alcometer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoScreen() {
    Column(modifier = Modifier.padding(6.dp)) {
        Text(
            text = stringResource(R.string.informationDisclaimer),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.informationAlcoholDisclaimer),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color.Red
        )
    }
}