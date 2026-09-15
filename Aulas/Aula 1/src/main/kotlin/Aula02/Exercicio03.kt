package Aula02;

fun executarVariasVezes(qtd: Int, acao: () -> Unit) {
    for (i in 1..qtd){
        acao()
    }
}

fun main(){
    executarVariasVezes(3){
        println("1")
    }
    executarVariasVezes(1){
        println("2")
    }
}