package com.example.lab07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab07.ui.theme.Lab07Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab07Theme {
                AppNavigation()

                }
            }
        }
    }
@Composable
fun CustomScaffold(navController: NavHostController) {
    var count by remember { mutableStateOf(0) }
    Scaffold(
        topBar = { CustomTopBar(navController) },

        bottomBar = { CustomBottomBar(navController) },

        floatingActionButton = { CustomFAB(count) { count++ } },

        content = { padding -> CustomContent(padding)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center


            ){
                Text(text = "Haz presionado el boton: $count")
            }}

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavHostController) {
    TopAppBar(
        navigationIcon = {
                IconButton(onClick = { /*Todo*/ }){
                    Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
                }
        },
        title = { Text(text = "Sample Title")},
        actions = {
            IconButton(onClick = {/*TODO*/ }){
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = {navController.navigate("perfil")}) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = null
                )
            }
        }
    )
}
@Composable
fun CustomBottomBar(navController: NavHostController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { navController.navigate("herramientas") }) {
                Icon(Icons.Filled.Build, contentDescription = "Build description")
            }
            IconButton(onClick = { navController.navigate("configuracion") }) {
                Icon(Icons.Rounded.Settings, contentDescription = "Configuracion")

            }
            IconButton(onClick = { navController.navigate("Favoritos") }) {
                Icon(Icons.Rounded.Favorite, contentDescription = "Favorite description")

            }
            IconButton(onClick = { navController.navigate("borrar") }) {
                Icon(Icons.Rounded.Delete, contentDescription = "Delete description")

            }
        }
    }
}

@Composable
fun CustomFAB(count: Int, onClick: () -> Unit){

    FloatingActionButton(
        //backgroundColor = MaterialTheme.colors.primary,
        onClick = onClick
    ) {
        Text(
            text = "$count",
            fontSize = 24.sp


        )
    }

}
@Composable
fun CustomContent(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),

    ){Text(text = "Contenido de la pantalla principal")}
}


@Composable
fun Configuracion() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de Configuracion")
    }
}

@Composable
fun Favoritos() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de Favoritos")
    }
}

@Composable
fun Borrar() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de Papelera")

    }
}

@Composable
fun Herramientas() {

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de Herramientas")
    }
}


@Composable
fun PerfilUsuario() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center

    ) {
        Text(text = "Perfin de usuario")

    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { CustomScaffold(navController) }
        composable("perfil") { PerfilUsuario() }
        composable("herramientas") { Herramientas() }
        composable("configuracion") { Configuracion() }
        composable("Favoritos") { Favoritos() }
        composable("borrar") { Borrar() }


    }
}
















































