import java.util.*

class Solution {
    data class Node(val word: String, val step: Int)

    fun solution(begin: String, target: String, words: Array<String>): Int {
        var visited = BooleanArray(words.size)
        var q = ArrayDeque<Node>()
        q.add(Node(begin, 0))

        while (q.isNotEmpty()) {
            val current = q.removeFirst()

            if (current.word == target) {
                return current.step
            }

            for (i in words.indices) {
                if (!visited[i] && canChange(current.word, words[i])) {
                    q.add(Node(words[i], current.step + 1))
                    visited[i] = true
                }
            }
        }

        return 0

    }

    fun canChange(begin: String, end: String): Boolean {
        var temp = 0
        for (i in begin.indices) {
            if (begin[i] != end[i]) temp++
        }

        if (temp == 1) return true
        else return false
    }
}