package br.com.alura.aluvery.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.alura.aluvery.data.samples.sampleProducts
import br.com.alura.aluvery.data.samples.sampleSections
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.model.Section
import br.com.alura.aluvery.ui.components.CardProductItem
import br.com.alura.aluvery.ui.components.ProductSection
import br.com.alura.aluvery.ui.components.SearchTextField
import br.com.alura.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(
    navController: NavController,
    sections: List<Section> = sampleSections,
    products: List<Product> = sampleProducts,
    defaultSearch: String = ""
){
    Surface(Modifier.background(color = Color.LightGray)) {
        Column {
            var text by remember{ mutableStateOf(defaultSearch) }
            val filteredProducts = remember(text) {
                if (text.isNotBlank()){
                    products.filter {
                        it.name.contains(text, ignoreCase = true) || it.description?.contains(text) ?: false
                    }
                } else {
                    products
                }
            }
            SearchTextField(searchText = text, onSearchChange = {
                text = it
            })
            if (text.isBlank()){
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    items(sections){
                        ProductSection(section = it, onProductClick = { product ->
                            navController.navigate("product/${product.name}")
                        })
                    }
                }
            }else{
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ){
                    items(filteredProducts){
                        CardProductItem(
                            product = it,
                            modifier = Modifier
                                .padding(horizontal = 16.dp),
                            onClick = { product ->
                                navController.navigate("product/${product.name}")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SectionsPreview(){
    AluveryTheme() {
        Surface(Modifier.background(color = Color.LightGray)) {
            HomeScreen(rememberNavController())
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProductsPreview(){
    AluveryTheme() {
        Surface(Modifier.background(color = Color.LightGray)) {
            HomeScreen(rememberNavController(), defaultSearch = "Hamb")
        }
    }
}