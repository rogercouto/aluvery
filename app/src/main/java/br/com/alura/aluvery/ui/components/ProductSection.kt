package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.data.samples.sampleSections
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.model.Section

@Composable
fun ProductSection(section: Section, onProductClick: (Product) -> Unit){
    Column {
        Text(
            text = section.name, Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(section.products) {
                ProductItem(product = it, onClick = onProductClick)
            }

        }
    }
}

@Preview(showBackground = true, widthDp = 600)
@Composable
fun ProductSectionPreview(){
    ProductSection(section = sampleSections.first(), onProductClick = {})
}