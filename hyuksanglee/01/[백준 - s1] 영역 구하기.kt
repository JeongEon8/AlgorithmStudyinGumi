import java.util.*

val DI = intArrayOf(1, 0, -1, 0)
val DJ = intArrayOf(0, 1, 0, -1)
var M = 0 // 세로 (mi)
var N = 0 // 가로 (mj)
lateinit var check: Array<BooleanArray>

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val firstLine = readLine().split(" ").map { it.toInt() }
    M = firstLine[0]
    N = firstLine[1]
    val K = firstLine[2]

    check = Array(M) { BooleanArray(N) { false } }

    for (i in 0 until K) {
        val rect = readLine().split(" ").map { it.toInt() }
        val x1 = rect[0]; val y1 = rect[1]
        val x2 = rect[2]; val y2 = rect[3]

        for (r in y1 until y2) {
            for (c in x1 until x2) {
                check[r][c] = true
            }
        }
    }

    val pq = PriorityQueue<Int>()
    for (i in 0 until M) {
        for (j in 0 until N) {
            if (!check[i][j]) {
                pq.add(dfs(i, j))
            }
        }
    }

    println(pq.size)
    val result = mutableListOf<Int>()
    while (pq.isNotEmpty()) result.add(pq.poll())
    println(result.joinToString(" "))
}

fun dfs(i: Int, j: Int): Int {
    check[i][j] = true
    var area = 1

    for (d in 0..3) {
        val ni = i + DI[d]
        val nj = j + DJ[d]

        if (ni in 0 until M && nj in 0 until N) {
            if (!check[ni][nj]) {
                area += dfs(ni, nj)
            }
        }
    }
    return area
}