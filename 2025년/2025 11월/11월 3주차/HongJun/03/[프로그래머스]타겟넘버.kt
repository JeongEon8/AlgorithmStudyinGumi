class Solution {
    fun solution(numbers: IntArray, target: Int): Int {

        fun dfs(index: Int, curSum: Int): Int {
            // 모든 숫자를 다 사용하면 종료
            if (index == numbers.size) {
                return if (curSum == target) 1 else 0
            }

            // 더하는 경우, 빼는 경우
            var plus = dfs(index + 1, curSum + numbers[index])
            var minus = dfs(index + 1, curSum - numbers[index])

            return plus+minus
        }

        var answer = dfs(0, 0)

        return answer
    }

}