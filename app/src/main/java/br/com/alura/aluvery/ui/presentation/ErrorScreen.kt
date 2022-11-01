package br.com.alura.aluvery.ui.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.ui.theme.AluveryTheme

@Composable
fun ErrorScreen(){
    Surface() {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.Default.Error,
                contentDescription = "Ícone de erro",
                tint = Color.DarkGray,
                modifier = Modifier
                    .size(128.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text("Ocorreu um erro!",
                fontSize = 24.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ErrorScreenPreview(){
    AluveryTheme {
        ErrorScreen()
    }
}