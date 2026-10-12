public class Solution {

    public int solution(int n) {
        return dfs(n);
    }

    public int dfs(int n) {
        if (n == 0) {
            return 0;
        }

        if (n % 2 == 0) {
            return dfs(n / 2);
        }

        return dfs(n - 1) + 1;
    }
}
