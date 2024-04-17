package com.melvin.galacticguide

import androidx.navigation.NavHostController
import com.melvin.galacticguide.GuideDestinationsArgs.CHARACTER_ARG
import com.melvin.galacticguide.GuideScreens.DETAILS_SCREEN
import com.melvin.galacticguide.GuideScreens.HOME_SCREEN

private object GuideScreens {
    const val HOME_SCREEN = "home"
    const val DETAILS_SCREEN = "details"
}

object GuideDestinationsArgs {
    const val CHARACTER_ARG = "character"
}

object GuideDestinations {
    const val HOME_ROUTE = HOME_SCREEN
    const val DETAILS_ROUTE = "$DETAILS_SCREEN?$CHARACTER_ARG={$CHARACTER_ARG}"
}

class GuideNavigationActions(private val navController: NavHostController) {

    fun navigateToDetail(characterId: Int?) {
        characterId?.let {
            navController.navigate(
                "$DETAILS_SCREEN?$CHARACTER_ARG=$it"
            ) {
                launchSingleTop = true
            }
        }
    }
}