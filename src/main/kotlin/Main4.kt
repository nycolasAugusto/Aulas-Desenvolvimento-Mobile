fun main(){

    val nome = "Joao";
    val sobre: String? = "Pinto";

    print("Nome $nome --- Sobre $sobre");
    val nomeCompleto = nome + " " + sobre;
    println();
    println(nomeCompleto.toString());
    println(nomeCompleto.length);
    println(nomeCompleto.substring(3, 6));
    println(nomeCompleto[2]);
}