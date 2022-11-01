package br.com.alura.aluvery.ui.presentation

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.data.samples.sampleProducts
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.ui.components.CardProductItem
import br.com.alura.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductScreen(product: Product){
    CardProductItem(
        product = product,
        imageHeight = 400.dp,
        onClick = {}
    )
}

@Preview(showSystemUi = true)
@Composable
fun ProductScreenPreview(){
    AluveryTheme() {
        Surface() {
            ProductScreen(sampleProducts.random())
        }
    }
}