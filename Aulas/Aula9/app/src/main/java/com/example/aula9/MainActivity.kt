package com.example.aula9

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.aula9.ui.theme.Aula9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula9Theme {
                Telamenu()


            }
        }
    }
}

@Composable
fun Telamenu(){

    Column() {

    BotaoToast()
    BotaoMudarTela()
    BotaoMudarTelaComInfo()


    }
}

@Composable
fun BotaoToast() {

    var context = LocalContext.current

    Button(onClick = {
        Toast.makeText(context, "8---D", Toast.LENGTH_LONG).show()
    }){Text("Abrir Toast")}

}

@Composable
fun BotaoMudarTela() {

    var  context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, Tela2::class.java)
        context.startActivity(intent)

    }){Text("Mudar de Tela Normal")}



}

@Composable
fun BotaoMudarTelaComInfo() {

    var  context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, Tela3::class.java)
        intent.putExtra("nome", "lARI")

        context.startActivity(intent)

    }){Text("Tela COM INFO")}



}
