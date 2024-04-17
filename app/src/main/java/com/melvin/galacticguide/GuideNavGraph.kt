package com.melvin.galacticguide

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.melvin.galacticguide.GuideDestinationsArgs.CHARACTER_ARG
import com.melvin.galacticguide.guide.presentation.detail.DetailScreen
import com.melvin.galacticguide.guide.presentation.detail.viewmodel.DetailViewModel
import com.melvin.galacticguide.guide.presentation.home.HomeScreen
import com.melvin.galacticguide.guide.presentation.home.viewmodel.HomeViewModel

@Composable
fun GuideNavGraph(
    navController: NavHostController = rememberNavController(),
    navActions: GuideNavigationActions = remember(navController) {
        GuideNavigationActions(navController)
    }
) {
    NavHost(navController = navController, startDestination = GuideDestinations.HOME_ROUTE) {
        composable(GuideDestinations.HOME_ROUTE) {
            val viewModel: HomeViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            HomeScreen(state = state) { selectedCharacter ->
                navActions.navigateToDetail(selectedCharacter?.id)
            }
        }

        composable(
            GuideDestinations.DETAILS_ROUTE,
            arguments = listOf(
                navArgument(CHARACTER_ARG) { type = NavType.IntType; defaultValue = 0 }
            )
        ) {
            val viewModel: DetailViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            DetailScreen(state)
        }
    }
}