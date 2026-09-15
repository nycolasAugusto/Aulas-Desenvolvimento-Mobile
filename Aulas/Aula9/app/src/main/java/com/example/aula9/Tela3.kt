package com.example.aula9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aula9.ui.theme.Aula9Theme

class Tela3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula9Theme {


                val nome  = intent.getStringExtra("nome")

                if(nome == null){
                    Text("Nome nao encontrado")
                }
                else{

                    Text("Bem vindo " + nome)
                }


            }
        }
    }
}

