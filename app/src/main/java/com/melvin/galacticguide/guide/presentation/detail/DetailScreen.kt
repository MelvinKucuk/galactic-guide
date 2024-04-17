package com.melvin.galacticguide.guide.presentation.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.melvin.galacticguide.R
import com.melvin.galacticguide.guide.domain.model.Character
import com.melvin.galacticguide.guide.presentation.component.DetailRow
import com.melvin.galacticguide.guide.presentation.detail.viewmodel.DetailState

@Composable
fun DetailScreen(state: DetailState) {
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = state.character?.name ?: "",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            DetailRow(
                name = stringResource(R.string.height),
                value = state.character?.height ?: ""
            )
            DetailRow(name = stringResource(R.string.mass), value = state.character?.mass ?: "")
            DetailRow(
                name = stringResource(R.string.hair_color),
                value = state.character?.hairColor ?: ""
            )
            DetailRow(
                name = stringResource(R.string.skin_color),
                value = state.character?.skinColor ?: ""
            )
            DetailRow(
                name = stringResource(R.string.eye_color),
                value = state.character?.eyeColor ?: ""
            )
            DetailRow(
                name = stringResource(R.string.birth_year),
                value = state.character?.birthYear ?: ""
            )
            DetailRow(
                name = stringResource(R.string.gender),
                value = state.character?.gender ?: ""
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DetailScreenPreview() {
    DetailScreen(
        DetailState(
            isLoading = false,
            character = Character(
                name = "Luke Skywalker",
                height = "172",
                mass = "77",
                hairColor = "blond",
                skinColor = "fair",
                eyeColor = "blue",
                birthYear = "19BBY",
                gender = "male",
                id = 1
            )
        )
    )
}