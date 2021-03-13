/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.home.HomeScreen
import com.example.androiddevchallenge.ui.screens.login.LoginScreen
import com.example.androiddevchallenge.ui.screens.welcome.Welcome

object Destinations {
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val HOME = "home"
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val navigationActions = remember(navController) { NavigationActions(navController) }

    NavHost(navController, startDestination = Destinations.WELCOME) {
        composable(Destinations.WELCOME) {
            Welcome(onLoginClick = navigationActions.onWelcomeLogin)
        }

        composable(Destinations.LOGIN) {
            LoginScreen(onLoginClick = navigationActions.onLogin)
        }

        composable(Destinations.HOME) {
            HomeScreen()
        }
    }
}

class NavigationActions(navController: NavHostController) {
    val onWelcomeLogin: () -> Unit = {
        navController.navigate(Destinations.LOGIN)
    }

    val onLogin: () -> Unit = {
        navController.navigate(Destinations.HOME) {
            popUpTo(Destinations.WELCOME) { inclusive = true }
        }
    }
}
