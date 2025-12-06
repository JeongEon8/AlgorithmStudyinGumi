import kotlin.math.*
import java.util.*

class Solution {
    fun solution(name: String): Int {
        var answer = 0
        var n = name.length
        var minMove = n-1

        for (i in name.indices) {
            var up = name[i] - 'A'
            var down = 'Z' - name[i] + 1
            answer += min(up, down)

            // 2. [좌우 이동] 연속된 A 찾기
            var next = i + 1
            // 현재 i 다음부터 연속된 A가 끝나는 지점 찾기
            while (next < n && name[next] == 'A') {
                next++
            }

            minMove = min(i+i+n-next, minMove)
            minMove = min(minMove, (n-next)*2+i)
        }

        return answer + minMove
    }
}