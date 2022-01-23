package lloretEnriquez.jaume.apiheater.viewsModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import lloretEnriquez.jaume.apiheater.models.MovieModel
import lloretEnriquez.jaume.apiheater.services.ApiServices
import java.lang.Exception

class MovieViewModel : ViewModel() {
    var movieModelListResponse : List<MovieModel> by mutableStateOf(listOf())
    private var errorMessage : String by mutableStateOf("")

    fun getMovieList() {
        viewModelScope.launch {
            val apiServices = ApiServices.getInstance()
            try {
                val movieList = apiServices.getMovies()
                movieModelListResponse = movieList
            }
            catch (e : Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}