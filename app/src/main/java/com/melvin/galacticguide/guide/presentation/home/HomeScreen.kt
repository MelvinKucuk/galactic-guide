package com.melvin.galacticguide.guide.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.melvin.galacticguide.guide.domain.model.Character
import com.melvin.galacticguide.guide.presentation.component.CharacterRow
import com.melvin.galacticguide.guide.presentation.home.viewmodel.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(
    state: StateFlow<HomeState>,
    onCharacterClick: (Character?) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        val uiState by state.collectAsStateWithLifecycle()
        val characters = uiState.characterList.collectAsLazyPagingItems()
        LazyColumn(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 24.dp)
        ) {
            items(characters.itemCount) { index ->
                val character = characters[index]
                CharacterRow(
                    name = character?.name ?: "",
                    initials = character?.initials ?: ""
                ) {
                    onCharacterClick(character)
                }
            }

            when (val paginationState = characters.loadState.append) { // Pagination
                is LoadState.Error -> {
                    // TODO
                }

                is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                else -> {}
            }
        }

        when (val paginationState = characters.loadState.refresh) { //FIRST LOAD
            is LoadState.Error -> {
                // TODO
            }

            is LoadState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            else -> {}
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(MutableStateFlow(HomeState())) {}
}