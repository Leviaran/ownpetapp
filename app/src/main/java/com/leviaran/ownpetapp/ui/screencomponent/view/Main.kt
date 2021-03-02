package com.leviaran.ownpetapp.ui.screencomponent.view

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.leviaran.ownpetapp.R
import com.leviaran.ownpetapp.data.dto.PetsResponseItem

@Composable
fun Main(listPet: List<PetsResponseItem>, theme: () -> Unit) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            Home(navController = navController, listDog = listPet, theme = { theme() })
        }

        composable(
            "${Screen.Details.route}|{url}|{temp}|{breedfor}|{name}|{origin}|{lifespan}|{breedgroup}",
            arguments = listOf(
                navArgument("url"){type = NavType.StringType },
                navArgument("temp"){type = NavType.StringType },
                navArgument("breedfor"){type = NavType.StringType },
                navArgument("name"){type = NavType.StringType },
                navArgument("origin"){type = NavType.StringType },
                navArgument("lifespan"){type = NavType.StringType },
                navArgument("breedgroup"){type = NavType.StringType }
            )
        ) {
            Details(
                navController = navController,
                url = it.arguments?.getString("url")?:"",
                temp = it.arguments?.getString("temp")?:"",
                breedFor = it.arguments?.getString("breedfor")?:"",
                name = it.arguments?.getString("name")?:"",
                origin = it.arguments?.getString("origin")?:"",
                lifeSpan = it.arguments?.getString("lifespan")?:"",
                breedGroup = it.arguments?.getString("breedgroup")?:""
            )
        }
    }


}

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home", R.string.text_home)
    object Details : Screen("details", R.string.text_details)
}