package lloretEnriquez.jaume.apiheater.screens.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.compose.base.R
import coil.transform.CircleCropTransformation
import lloretEnriquez.jaume.apiheater.models.MovieModel
import lloretEnriquez.jaume.apiheater.screens.Screen
import lloretEnriquez.jaume.apiheater.ui.theme.ApiHeaterTheme

@Composable
fun MovieItem(navController: NavController, movieModel: MovieModel, id: Int) {
    Card(modifier = Modifier.padding(8.dp, 4.dp)
        .fillMaxWidth()
        .height(110.dp)
        .clickable {
            navController.navigate(route = "${Screen.Detail.route}/${id}")
        },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Row(
            modifier = Modifier.padding(4.dp)
                .fillMaxSize(),
        ) {
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
                modifier =  Modifier.fillMaxHeight()
                    .weight(0.2f),
            )
            Column(
                modifier = Modifier.padding(4.dp)
                    .fillMaxHeight()
                    .weight(0.8f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = movieModel.title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = movieModel.category,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.background(
                            Color.LightGray
                        )
                        .padding(4.dp),
                )
                Text(
                    text = movieModel.description,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApiHeaterTheme {
        val movie = MovieModel("aaaa", "sdsadsa", "dsfsdfdsfdsfdsfdsfsd", "sdasdasd")
        MovieItem(navController = rememberNavController(), movieModel = movie, id = 0)
    }
}