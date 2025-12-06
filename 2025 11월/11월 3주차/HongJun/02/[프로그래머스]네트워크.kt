import java.util.*
import kotlin.math.*

class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        var visited = BooleanArray(n)

        for (start in 0 until n) {
            if (!visited[start]) {
                answer++

                val q = ArrayDeque<Int>()
                q.add(start)
                visited[start] = true

                while(q.isNotEmpty()) {
                    var cur = q.removeFirst()

                    for(next in 0 until n) {
                        if (computers[cur][next] == 1 && !visited[next]) {
                            visited[next] = true
                            q.add(next)
                        }
                    }
                }
            }
        }


        return answer
    }
}