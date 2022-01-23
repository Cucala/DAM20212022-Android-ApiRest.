package lloretEnriquez.jaume.apiheater.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.base.R
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import lloretEnriquez.jaume.apiheater.models.MovieModel
import lloretEnriquez.jaume.apiheater.screens.Screen
import lloretEnriquez.jaume.apiheater.ui.theme.ApiHeaterTheme

@Composable
fun DetailScreen(
    navController: NavController,
    movieModel: MovieModel
) {
    Column(
        modifier = Modifier.padding(4.dp)
            .heightIn(min = 400.dp, max = 400.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "back",
            color = Color.Red,
            style = MaterialTheme.typography.button,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) {
                        inclusive = true
                    }
                }
            }
        )
        Image(
            painter = rememberImagePainter(
                data = movieModel.imageUrl,
                builder = {
                    scale(Scale.FILL)
                    placeholder(R.drawable.notification_action_background)
                    transformations(CircleCropTransformation())
                },
            ),
            contentDescription = movieModel.description,
            modifier =  Modifier.fillMaxSize()
                .weight(0.2f),
            alignment = Alignment.Center
        )
        Text(
            text = movieModel.title,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = movieModel.category,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .background(
                    Color.LightGray
                )
                .padding(4.dp),
        )
        Text(
            text = movieModel.description,
            style = MaterialTheme.typography.body1,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApiHeaterTheme {
        val movie = MovieModel("aaaa", "sdsadsa", "dsfsdfdsfdsfdsfdsfsd", "sdasdasd")
        DetailScreen(navController = rememberNavController(), movieModel = movie)
    }
}