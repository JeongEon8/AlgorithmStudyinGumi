class Solution {
    fun solution(land: Array<IntArray>): Int {
        val n = land.size

        // DP 테이블 초기화
        val dp = Array(n) { IntArray(4) }

        // 첫 번째 줄은 그대로
        for (i in 0 until 4) {
            dp[0][i] = land[0][i]
        }

        // DP 채우기
        for (i in 1 until n) {
            for (j in 0 until 4) {
                for (k in 0 until 4) {
                    if (j == k) continue
                    dp[i][j] = maxOf(dp[i][j], land[i][j] + dp[i - 1][k])
                }
            }
        }

        // 마지막 줄에서 최대값 찾기
        return dp[n - 1].maxOrNull()!!
    }
}
