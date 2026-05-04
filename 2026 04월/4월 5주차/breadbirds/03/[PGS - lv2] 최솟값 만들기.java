import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;

        // 배열 A와 B를 오름차순으로 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            // 배열 A는 순서대로, 배열 B는 역순으로 접근하여 곱하여 answer에 더함
            answer += A[i] * B[B.length - i - 1];
        }

        return answer;
    }
}
