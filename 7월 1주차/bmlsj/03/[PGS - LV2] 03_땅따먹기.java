class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = land.length - 2; i >= 0; i--) {
            land[i][0] += Math.max(land[i + 1][1], Math.max(land[i+1][2], land[i+1][3]));
            land[i][1] += Math.max(land[i + 1][0], Math.max(land[i+1][2], land[i+1][3]));
            land[i][2] += Math.max(land[i + 1][0], Math.max(land[i+1][1], land[i+1][3]));
            land[i][3] += Math.max(land[i + 1][0], Math.max(land[i+1][1], land[i+1][2]));
        }
        
        
        return Math.max(
            Math.max(land[0][0], land[0][1]),
            Math.max(land[0][2], land[0][3])
        );
    }
}