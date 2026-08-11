package Aula01

fun main(){
    //ver se o texto é igual de tras para frente

    println("Digite um texto");
    val texto: String  = readln() ?: "nulo nao pode";

    if (texto == null){
        println("Nulo nao pode");
        return;
    }

    val textoOk: String  = texto.trim()
    val textoContra: String = texto.reversed().trim()


    if (textoOk.equals(textoContra , ignoreCase = true )){
        println("O texto de tras para frente é o mesmo");
        return
    }
    println(texto +" é diferente de "+ textoContra)
}