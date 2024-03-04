import java.time.LocalDateTime
import java.time.Duration

fun main() {
    val search = 9999
    val listSize = 999990
    binary(search,listSize)
    sequencial(search,listSize)
}
fun binary(search: Int, listSize:Int) {
    val startTime = LocalDateTime.now().toLocalTime()
    println("Binary!")
    val search = search

    val list = (1..listSize).toList()

    var inicio = 0
    var fim = list.size - 1

    var encontrado = false

    while (inicio <= fim) {
        val meio = (inicio + fim) / 2
        val elementoMeio = list[meio]

        when {
            search == elementoMeio -> {
                encontrado = true
                break
            }
            search < elementoMeio -> fim = meio - 1
            else -> inicio = meio + 1
        }
    }

    if (encontrado) {
        println("Valor $search encontrado.")
        val timeDifference = Duration.between(startTime, LocalDateTime.now())
        val seconds = timeDifference.toSeconds()
        val millis = timeDifference.toMillis()
        println("Tempo desde o início: $seconds segundos ${millis % 1000} milissegundos")
    } else {
        println("Valor $search não encontrado.")
    }
}

fun sequencial(search: Int, listSize:Int){
    val startTime = LocalDateTime.now()
    println("Sequencial")
    val search = search

    val list = (1..listSize).toList()

    var encontrado = false

    for ((_, item) in list.withIndex()) {
        if (item == search) {
            encontrado = true
            break
        }
    }

    if (encontrado) {
        kotlin.io.println("Valor $search encontrado.")
        val duration = Duration.between(startTime, LocalDateTime.now())
        val seconds = duration.toSeconds()
        val millis = duration.toMillis()
        kotlin.io.println("Tempo desde o início: $seconds segundos (${millis % 1000} milissegundos)")
    } else {
        kotlin.io.println("Valor $search não encontrado.")
    }
}
