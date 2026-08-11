package Aula02

fun main(){
    //ver se o texto é igual de tras para frente

    println("Digite um Numero Inteiro");
    var texto: String  = readln() ?: "0";
    val num = texto.toIntOrNull();

    if (num == null){
        println("Nulo nao pode");
        return;
    }


    val numeros = intArrayOf(1,2,3,4,5)

    print("Lista de nums \n");
    for (n in numeros){

        print("$n - ");
    }
    numeros;

    print("\nLista multiplicada por : $num  \n")

    for (n in numeros){
        n.toInt();
        val res = (n * num);

        print("$res - ");

    }





}