package br.com.alura.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.alura.aluvery.data.samples.sampleProducts
import br.com.alura.aluvery.ui.presentation.ErrorScreen
import br.com.alura.aluvery.ui.presentation.HomeScreen
import br.com.alura.aluvery.ui.presentation.ProductScreen
import br.com.alura.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme() {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main" ){
                    composable("main") { HomeScreen(navController) }
                    composable("product/{productName}") {
                        val productName = it.arguments?.getString("productName")
                        val displayProduct = sampleProducts.find { product ->
                            product.name == productName
                        }
                        displayProduct?.let{ product ->
                            ProductScreen(product = product)
                        } ?: apply {
                            ErrorScreen()
                        }
                    }
                }
            }
        }
    }
}

