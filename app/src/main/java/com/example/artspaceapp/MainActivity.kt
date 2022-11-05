package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var taker by remember { mutableStateOf(1) }
    val imageRes = when (taker) {
        1 -> R.drawable.androidparty
        2 -> R.drawable.taotech_removebg_preview
        3 -> R.drawable.tao
        else -> R.drawable.ic_launcher_background
    }
    val artworkTitle = when (taker) {
        1 -> R.string.artwork1
        2 -> R.string.artwork2
        3 -> R.string.artwork3
        else -> R.string.artwork1
    }
    val artworkArtist = when (taker) {
        1 -> R.string.artist1
        2 -> R.string.artist2
        3 -> R.string.artist3
        else -> R.string.artist1
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .size(height = 500.dp, width = 350.dp)
                .border(BorderStroke(3.dp, SolidColor(Color.Black)), RectangleShape)
                .shadow(12.dp, RectangleShape)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                   .fillMaxSize()
                    .border(BorderStroke(30.dp, SolidColor(Color.White)), RectangleShape)
                    .shadow(12.dp, RectangleShape)
                //.padding(borderWidth)
                //.clip(RectangleShape)

            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(300.dp, 100.dp)
                .scale(1f)
                .padding(15.dp)
                .shadow(3.dp )
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.1f),
                            Color.Transparent,)
                    )
                )
                .wrapContentSize(Alignment.Center),


        ) {
            Text(
                text = stringResource(artworkTitle),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(artworkArtist),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        //BUTTONS
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(     //PREVIOUS BUTTON
                modifier= Modifier.size(width = 150.dp, height =50.dp),
                onClick = {taker = when (taker) {1 -> 1 else -> --taker }
            }) {
                Text(text = "Previous")
            }

            Spacer(modifier = Modifier.width(50.dp))

            Button(     //NEXT BUTTON
                modifier= Modifier.size(width = 150.dp, height =50.dp),
                onClick = {taker = when (taker) { in 1..2 -> ++taker else -> 1}
            }) {
                Text(text = "Next")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}