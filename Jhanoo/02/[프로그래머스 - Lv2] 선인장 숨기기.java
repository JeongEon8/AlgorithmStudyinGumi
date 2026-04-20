import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] dropTime = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(dropTime[i], INF);
        }
        
        for (int i = 0; i < drops.length; i++) {
            int x = drops[i][0];
            int y = drops[i][1];
            dropTime[x][y] = i + 1;
        }
        
        int[][] rowMin = new int[m][n - w + 1];
        for (int i = 0; i < m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                while (!dq.isEmpty() && dropTime[i][dq.peekLast()] >= dropTime[i][j]) {
                    dq.pollLast();
                }
                dq.offerLast(j);

                while (!dq.isEmpty() && dq.peekFirst() <= j - w) {
                    dq.pollFirst();
                }

                if (j >= w - 1) {
                    rowMin[i][j - w + 1] = dropTime[i][dq.peekFirst()];
                }
            }
        }
        
        int[][] rectMin = new int[m - h + 1][n - w + 1];
        for (int j = 0; j < n - w + 1; j++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {
                while (!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[i][j]) {
                    dq.pollLast();
                }
                dq.offerLast(i);

                while (!dq.isEmpty() && dq.peekFirst() <= i - h) {
                    dq.pollFirst();
                }

                if (i >= h - 1) {
                    rectMin[i - h + 1][j] = rowMin[dq.peekFirst()][j];
                }
            }
        }
        
        int[] answer = {0, 0};
        int bestTime = -1;

        for (int i = 0; i <= m - h; i++) {
            for (int j = 0; j <= n - w; j++) {
                int firstHitTime = rectMin[i][j];

                if (firstHitTime == INF) {
                    return new int[] {i, j};
                }

                if (firstHitTime > bestTime) {
                    bestTime = firstHitTime;
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }
}