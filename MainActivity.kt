package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Shivam",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val customFont = FontFamily(Font(R.font.rubikmedium_italic))
    var showAdditionalMessage by remember { mutableStateOf(false) }

    Surface(color = Color.White, modifier = modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.basketball),
                contentDescription = "basketball",
                modifier = Modifier.size(100.dp)
            )

            Button(onClick = { showAdditionalMessage = true }) {
                Text("My Favorite Quote Is...")
            }


            Text(
                text = "Hi, my name is $name!",
                color = Color.Red,
                fontSize = 30.sp,
                style = TextStyle(fontFamily = customFont)
            )

            if (showAdditionalMessage) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "You can't be afraid to fail. It's the only way you succeed - you're not gonna succeed all the time, and I know that- Lebron James",
                    color = Color.Red,
                    fontSize = 24.sp,
                    style = TextStyle(fontFamily = customFont)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Shivam")
    }
}
