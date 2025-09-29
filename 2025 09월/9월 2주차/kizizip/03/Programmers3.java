class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            int row = (int)(i / n);
            int col = (int)(i % n);
            answer[idx++] = Math.max(row, col) + 1;
        }

        return answer;
    }
}
