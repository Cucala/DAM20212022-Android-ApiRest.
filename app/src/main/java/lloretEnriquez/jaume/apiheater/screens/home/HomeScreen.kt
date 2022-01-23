package lloretEnriquez.jaume.apiheater.screens.home

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import lloretEnriquez.jaume.apiheater.models.MovieModel
import lloretEnriquez.jaume.apiheater.screens.home.views.MovieList
import lloretEnriquez.jaume.apiheater.viewsModels.MovieViewModel

@Composable
fun HomeScreen(navController: NavController, movieModelList : List<MovieModel>) {
    Surface(color = MaterialTheme.colors.background) {
        MovieList(navController = navController, movieModelList = movieModelList)
    }
}
