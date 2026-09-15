enum class NivelLog {
    INFO,
    WARNING,
    ERROR
}

data class EventoLog(
    val id: String,
    val timestamp: Long,
    val nivel: NivelLog,
    val mensagem: String,
    val metadados: Map<String, String>
)

class ProcessadorLogs(val logs: List<EventoLog>) {

    fun filtrarErrosPorServico(nomeServico: String): List<EventoLog> {
        return logs.filter { log ->
            log.nivel == NivelLog.ERROR && log.metadados["servico"] == nomeServico
        }
    }

    fun contarOcorrenciasPorNivel(): Map<NivelLog, Int> {
        return logs.groupBy { it.nivel }
            .mapValues { (_, listaDeLogs) -> listaDeLogs.size }
    }

    fun gerarRelatorioFormatado(): List<String> {
        return logs.map { log ->
            val servico = log.metadados["servico"] ?: "Desconhecido"
            "[${log.nivel}] - ${log.mensagem} (Serviço: $servico)"
        }
    }
}

fun main() {
    val listaDeLogs = listOf(
        EventoLog("1", 1600000000L, NivelLog.ERROR, "Falha na conexão", mapOf("servico" to "auth-api")),
        EventoLog("2", 1600000001L, NivelLog.INFO, "Usuário logado", mapOf("servico" to "auth-api")),
        EventoLog("3", 1600000002L, NivelLog.ERROR, "Timeout no banco", mapOf("servico" to "payment-api")),
        EventoLog("4", 1600000003L, NivelLog.WARNING, "Uso de memória alto", mapOf())
    )

    val processador = ProcessadorLogs(listaDeLogs)


    println("--- Erros do serviço auth-api ---")
    println(processador.filtrarErrosPorServico("auth-api"))

    println("\n--- Contagem por Nível ---")
    println(processador.contarOcorrenciasPorNivel())

    println("\n--- Relatório Formatado ---")
    processador.gerarRelatorioFormatado().forEach { println(it) }
}