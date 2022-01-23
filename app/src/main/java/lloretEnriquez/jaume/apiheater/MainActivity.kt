package lloretEnriquez.jaume.apiheater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import lloretEnriquez.jaume.apiheater.screens.detail.DetailScreen
import lloretEnriquez.jaume.apiheater.screens.home.HomeScreen
import lloretEnriquez.jaume.apiheater.screens.Screen
import lloretEnriquez.jaume.apiheater.ui.theme.ApiHeaterTheme
import lloretEnriquez.jaume.apiheater.viewsModels.MovieViewModel

class MainActivity : ComponentActivity() {

    private val movieViewModel by viewModels<MovieViewModel>()
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiHeaterTheme {
                movieViewModel.getMovieList()
                navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(
                        route = Screen.Home.route
                    ) {
                        HomeScreen(
                            navController = navController,
                            movieModelList = movieViewModel.movieModelListResponse,
                        )
                    }
                    composable(
                        route = Screen.Detail.route+Screen.Detail.arguments,
                        arguments = listOf(
                            navArgument("id") {type = NavType.IntType}
                        ),
                    ) {
                        backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("id")
                        requireNotNull(id)
                        DetailScreen(
                            navController = navController,
                            movieModel = movieViewModel.movieModelListResponse[id]
                        )
                    }
                }
            }
        }
    }
}