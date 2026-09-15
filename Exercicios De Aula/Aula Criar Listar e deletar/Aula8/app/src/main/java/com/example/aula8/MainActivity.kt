package com.example.aula8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula8.ui.theme.Aula8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaMercado()
        }
    }
}

@Composable
@Preview
fun TelaMercado(){


    var novoItem by remember { mutableStateOf("") }
    var listaMercado = remember {
        mutableStateListOf("Pizza", "Lasanha", "Pao de Lasanha", "Cebola", "feijao")
    }
    //Card para
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Card(
                modifier = Modifier.height(180.dp).fillMaxWidth(),
                border = BorderStroke(2.dp, Color.DarkGray)
            ) {


                Text("Lista de Mercado")
                TextField(value = novoItem, onValueChange = { novoItem = it})
                Button(
                    {
                        listaMercado.add(novoItem)
                        novoItem = ""

                    }
                ) {Text("Add") }

            }

            for (item in listaMercado){
                ItensDaLista(item, removerItem = {listaMercado.remove(item)}
                )
            }


        }

    }
}

@Composable
private fun ItensDaLista(nome: String = "Nome do Item",  removerItem:() -> Unit) {
    var marcado by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .height(90.dp)
            .fillMaxWidth(),
        border = BorderStroke(2.dp, Color.DarkGray)
    ) {

        Row(
            modifier = Modifier.fillMaxSize().padding(all = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(checked = marcado, onCheckedChange = { marcado = it })
            Text(nome)

            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Deletar",
                modifier = Modifier.clickable(onClick = {removerItem()})

            )
        }


    }
}