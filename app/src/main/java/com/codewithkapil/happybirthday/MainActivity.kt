package com.codewithkapil.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithkapil.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HappyBirthdayGreetingWithImageView("Sam", "Emma")
                }
            }
        }
    }
}

@Composable
fun HappyBirthdayGreetingWithTextView(name: String, from: String) {
    Column {
        Text(
            text = "Happy Birthday $name!",
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )
        Text(
            text = "-From $from!", fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp, top = 10.dp)
        )
    }
}

@Composable
fun HappyBirthdayGreetingWithImageView(name: String, from: String) {
    val image = painterResource(id = R.drawable.bg_birthday_card)
    Box {
        Image(
            painter = image, contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        HappyBirthdayGreetingWithTextView(name, from)
    }
}


@Preview(showBackground = true)
@Composable
fun HappyBirthdayGreetingWithImageViewPreview() {
    HappyBirthdayTheme {
        HappyBirthdayGreetingWithImageView("Sam", "Emma")
    }
}