package com.melvin.galacticguide.guide.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(name: String) {
    Column {
        Text(text = name)
    }
}