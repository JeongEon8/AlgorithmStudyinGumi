
class Solution {

    public int solution(String s) {

        int maxLen = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, expand(s, i, i));
            maxLen = Math.max(maxLen, expand(s, i, i + 1));
        }

        return maxLen;
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
