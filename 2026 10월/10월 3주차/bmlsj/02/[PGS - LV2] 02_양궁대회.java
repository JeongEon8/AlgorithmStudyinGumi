import java.util.*;

class Solution {
    int maxDiff = -1;
    int[] bestResult = {-1}; 

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        dfs(0, n, info, ryan);
        return bestResult;
    }

    static void dfs(int idx, int leftArrows, int[] info, int[] ryan) {
        if (idx == 11 || leftArrows == 0) {
            ryan[10] += leftArrows;
            
            calculateScore(info, ryan);
            
            ryan[10] -= leftArrows;
            return;
        }

        if (leftArrows >= info[idx] + 1) {
            ryan[idx] = info[idx] + 1;
            dfs(idx + 1, leftArrows - ryan[idx], info, ryan);
            ryan[idx] = 0; // 백트래킹
        }

        ryan[idx] = 0;
        dfs(idx + 1, leftArrows, info, ryan);
    }

    static void calculateScore(int[] info, int[] ryan) {
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < 11; i++) {

            if (info[i] == 0 && ryan[i] == 0) continue;

            if (info[i] >= ryan[i]) {
                apeachScore += (10 - i);
            } else {
                ryanScore += (10 - i);
            }
        }

        int diff = ryanScore - apeachScore;
        if (diff > 0) {
            if (diff > maxDiff) {
                maxDiff = diff;
                bestResult = ryan.clone();
            } 
            else if (diff == maxDiff) {
                if (isBetter(ryan, bestResult)) {
                    bestResult = ryan.clone();
                }
            }
        }
    }

    static boolean isBetter(int[] current, int[] best) {

        for (int i = 10; i >= 0; i--) {
            if (current[i] > best[i])
                return true;
            if (current[i] < best[i])
                return false;
        }
        
        return false;
    }
}