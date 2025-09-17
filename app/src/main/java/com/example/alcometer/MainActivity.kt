package com.example.alcometer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alcometer.ui.theme.AlcometerTheme

data class TabItem(
    var label: String, var icon: ImageVector, var contentDescription: String, var route: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlcometerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyNavController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home") {
            HomeScreen()
        }
        composable(route = "Compare") {
            CompareScreen()
        }
        composable(route = "Info") {
            InfoScreen()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(topBar = { TopAppBar { Text(text = "Alcometer") } },
        content = { MyNavController(navController = navController) },
        bottomBar = { MyBottomNavigation(navController) })
}

@Composable
fun MyBottomNavigation(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        TabItem("Home", Icons.Filled.LocalDrink, "Home Icon", "Home"),
        TabItem("Compare", Icons.Filled.CompareArrows, "Arrows facing each other icon", "Compare"),
        TabItem("Info", Icons.Filled.Info, "Icon with the letter I for Information", "Info")
    )
    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route)
                },
                icon = { Icon(item.icon, contentDescription = item.contentDescription) },
                label = { Text(item.label) })
        }
    }
}

@Composable
fun HomeScreen() {
    Text(text = "Home")
}

@Composable
fun CompareScreen() {
    Text(text = "Compare")
}

@Composable
fun InfoScreen() {
    Text(text = "Information Screen")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlcometerTheme {
        MyApp()
    }
}