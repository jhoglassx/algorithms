import java.time.LocalDateTime
import java.time.Duration

fun main() {
    val search = 9999
    val listSize = 999990
    binarySearch(search, listSize)
    sequentialSearch(search, listSize)
}

fun binarySearch(search: Int, listSize: Int) {
    val startTime = LocalDateTime.now().toLocalTime()
    println("Binary Search!")
    val searchValue = search

    val list = (1..listSize).toList()

    var start = 0
    var end = list.size - 1

    var found = false

    while (start <= end) {
        val mid = (start + end) / 2
        val midElement = list[mid]

        when {
            searchValue == midElement -> {
                found = true
                break
            }
            searchValue < midElement -> end = mid - 1
            else -> start = mid + 1
        }
    }

    if (found) {
        println("Value $searchValue found.")
        val timeDifference = Duration.between(startTime, LocalDateTime.now())
        val seconds = timeDifference.toSeconds()
        val millis = timeDifference.toMillis()
        println("Time elapsed: $seconds seconds ${millis % 1000} milliseconds")
    } else {
        println("Value $searchValue not found.")
    }
}

fun sequentialSearch(search: Int, listSize: Int) {
    val startTime = LocalDateTime.now()
    println("Sequential Search")
    val searchValue = search

    val list = (1..listSize).toList()

    var found = false

    for ((_, item) in list.withIndex()) {
        if (item == searchValue) {
            found = true
            break
        }
    }

    if (found) {
        println("Value $searchValue found.")
        val duration = Duration.between(startTime, LocalDateTime.now())
        val seconds = duration.toSeconds()
        val millis = duration.toMillis()
        println("Time elapsed: $seconds seconds ${millis % 1000} milliseconds")
    } else {
        println("Value $searchValue not found.")
    }
}
