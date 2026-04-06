import java.util.*
import java.lang.StringBuilder

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val st = StringTokenizer(readLine())

    val arrayP = IntArray(N + 2)
    val arrayM = IntArray(N + 2)

    for (n in 1..N) {
        val k = st.nextToken().toInt()
        if (k > 0) {
            arrayP[k]++
        } else {
            arrayM[-k]++
        }
    }

    for (n in N downTo 1) {
        arrayP[n] += arrayP[n + 1]
    }
    for (n in 1..N) {
        arrayM[n] += arrayM[n - 1]
    }

    val answers = mutableListOf<Int>()
    for (i in 0..N) {
        val pLiar = arrayP[i + 1]
        val mLiar = if (i > 0) arrayM[i - 1] else 0

        val actualLiar = pLiar + mLiar

        if (actualLiar == i) {
            answers.add(i)
        }
    }

    val sb = StringBuilder()
    sb.append(answers.size).append("\n")
    for (ans in answers) {
        sb.append(ans).append(" ")
    }
    println(sb.toString())
}