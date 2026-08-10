public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            // 짝수면 순간이동을 거꾸로 한 것
            if (n % 2 == 0) {
                n /= 2;
            }
            // 홀수면 점프를 거꾸로 한 것
            else {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}
