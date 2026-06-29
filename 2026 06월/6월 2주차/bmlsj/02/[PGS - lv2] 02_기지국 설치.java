
class Solution {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2 * w + 1;

        int start = 1;

        for (int stat : stations) {
            int left = stat - w;

            if (start < left) {
                int len = left - start;
                answer += (len + cover - 1) / cover;
            }

            start = stat + w + 1;
        }

        if (start <= n) {
            int len = n - start + 1;
            answer += (len + cover - 1) / cover;
        }
        return answer;
    }
}
