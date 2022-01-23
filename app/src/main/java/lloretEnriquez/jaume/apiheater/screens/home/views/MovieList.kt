package lloretEnriquez.jaume.apiheater.screens.home.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import lloretEnriquez.jaume.apiheater.models.MovieModel

@Composable
fun MovieList(navController: NavController, movieModelList: List<MovieModel>) {
    LazyColumn {
        itemsIndexed(items = movieModelList) {
                index, item -> MovieItem(id = index, navController = navController, movieModel = item)
        }
    }
}