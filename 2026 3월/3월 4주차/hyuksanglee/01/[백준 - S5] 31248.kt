
import java.util.*
val result = StringBuilder()
var moveCount = 0
fun main(args: Array<String>)= with(System.`in`.bufferedReader()){
    val n = readLine().toInt()


    hanoi(n, 'A', 'B', 'C', 'D')

    // 출력
    println(moveCount)
    print(result.toString())
}

fun dfs(n: Int, from: Char, adj: Char, to: Char) {
    if (n == 0) return
    dfs(n - 1, from, to, adj)
    appendMove(from, to)
    dfs(n - 1, adj, from, to)
}


fun hanoi(n: Int, a: Char, b: Char, c: Char, d: Char) {
    if (n <= 0) return

    if (n == 1) {
        appendMove(a, d)
        return
    }

    if (n == 2) {
        appendMove(a, b)
        appendMove(a, d)
        appendMove(b, d)
        return
    }

    dfs(n - 2, a, b, c)

    appendMove(a, b)

    appendMove(a, d)

    appendMove(b, d)

    hanoi(n - 2, c, a, b, d)
}

fun appendMove(from: Char, to: Char) {
    result.append("$from $to\n")
    moveCount++
}