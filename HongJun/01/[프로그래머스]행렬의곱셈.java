class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int len1 = arr1.length;
        int len2 = arr2.length;

        int c1 = arr1[0].length;
        int c2 = arr2[0].length;

        int[][] answer = new int[len1][c2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}