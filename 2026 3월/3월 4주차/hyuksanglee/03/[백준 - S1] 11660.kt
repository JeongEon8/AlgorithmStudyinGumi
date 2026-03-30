import java.util.*

fun main(args: Array<String>)=with(System.`in`.bufferedReader()){
    val(N, M) = readLine().split(" ").map{it.toInt()}

    val array = Array(N + 1) { IntArray(N + 1) }
    for (i in 1..N) {
        val st = StringTokenizer(readLine())
        for (j in 1..N) {
            val num = st.nextToken().toInt()
            array[i][j] = num + array[i - 1][j] + array[i][j - 1] - array[i - 1][j - 1]
        }
    }

    for(m in 1..M){

        val (x1, y1, x2, y2) = readLine().split(" ").map{it.toInt()}
        val result = array[x2][y2] - array[x1 - 1][y2] - array[x2][y1 - 1] + array[x1 - 1][y1 - 1]
        println(result)
    }



}