package  Aula02;

fun main(){

    val numeros = listOf(10, 25,40,5,80)
    val numerosDobrado = numeros.map { it * 2 }

    val numerosMaiorQueTrinta = numeros.filter { it > 30 }

    print("//dobrados")
    numeros.forEach{ print("[$it] ") }

    print("\n//Maior que 30")
    numerosMaiorQueTrinta.forEach{ print("[$it] ") }

    print("\n//dobrados")
    numerosDobrado.forEach{ print("[$it] ") }


}