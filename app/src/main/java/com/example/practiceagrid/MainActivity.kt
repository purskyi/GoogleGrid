package com.example.practiceagrid

import android.os.Bundle
import android.service.autofill.Dataset
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practiceagrid.data.DataSource
import com.example.practiceagrid.model.Topic
import com.example.practiceagrid.ui.theme.PracticeAGridTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeAGridTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    GridApp()
                }

                
            }
        }
    }
}







@Composable
fun GridApp(){
        VerticalGrid(DataSource.topics)

}


@Composable
fun VerticalGrid(gridTopics: List<Topic>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 200.dp)) {
        items(gridTopics) { topic ->
            GridCard(topic)
        }
    }
}
    @Composable
    fun GridCard(topic: Topic, modifier: Modifier = Modifier) {
        Card(modifier = modifier
            .padding(8.dp)

        ){
            Row(modifier = modifier
                .align(alignment = Alignment.Start)
                .height(68.dp)){
                Image(
                    painter = painterResource(id = topic.imageResId),
                    contentDescription = stringResource(id = topic.stringResId),
                    modifier = Modifier
                        .height(68.dp)
                        .width(68.dp)

                )

                Column(modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 0.dp)
                )
                {
                    Text(
                        text = LocalContext.current.getString(topic.stringResId),
                        style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp),
                        modifier = Modifier.wrapContentSize())

                    Text(
                        text = LocalContext.current.getString(topic.intAmountOfTopic),
                        fontSize = 14.sp,
                        modifier = Modifier.wrapContentSize()

                    )

                }

            }

        }
    }


@Preview(showBackground = true)
@Composable
fun GridCardPreview() {
  
    GridCard(topic = Topic(R.string.film, R.integer.film_course_count, R.drawable.film))
}