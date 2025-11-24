class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val answer = IntArray(2)

        // 전체 넓이
        val total = brown + yellow

        // 세로 길이는 최소 3부터 시작
        for (h in 3..total) {

            // 세로 길이가 전체 넓이의 약수인 경우만 고려
            if (total % h == 0) {

                // 가로 길이 구하기
                var w = total/h

                // 노랑 개수 맞추기
                if ((w-2)*(h-2) == yellow) {

                    // 가로가 세로보다 같거나 긴 경우만 고려
                    if (w >= h) {
                        answer[0] = w
                        answer[1] = h
                    }

                }
            }
        }

        return answer
    }
}