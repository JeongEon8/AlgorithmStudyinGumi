package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon1520 {

	 public static int[][] map;
	    public static int[][] dp;  // DP 테이블 추가
	    public static int N, M;

	    public static int[] di = { 1, 0, -1, 0 };
	    public static int[] dj = { 0, 1, 0, -1 };

	    public static int dfs(int i, int j) {
	        // 도착지점에 도달하면 1 반환 (경로 1개)
	        if (i == M - 1 && j == N - 1) {
	            return 1;
	        }

	        // 이미 계산한 적이 있으면 그 값을 반환
	        if (dp[i][j] != -1) {
	            return dp[i][j];
	        }

	        dp[i][j] = 0;  // 경로 초기화

	        for (int d = 0; d < 4; d++) {
	            int ni = i + di[d];
	            int nj = j + dj[d];
	            if (ni < 0 || nj < 0 || ni >= M || nj >= N) {
	                continue;
	            }

	            // 다음 위치로 이동할 때 경로가 낮은 곳으로만 이동
	            if (map[ni][nj] < map[i][j]) {
	                dp[i][j] += dfs(ni, nj);
	            }
	        }

	        return dp[i][j];
	    }

	    public static void main(String[] args) throws Exception {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	        String[] input = in.readLine().split(" ");
	        M = Integer.parseInt(input[0]);
	        N = Integer.parseInt(input[1]);
	        map = new int[M][N];
	        dp = new int[M][N];

	        // DP 테이블을 -1로 초기화 (아직 탐색하지 않았음을 나타냄)
	        for (int[] row : dp) {
	            Arrays.fill(row, -1);
	        }

	        // 맵에 대한 정보 2차원 배열 map에 넣기
	        for (int m = 0; m < M; m++) {
	            input = in.readLine().split(" ");
	            for (int n = 0; n < N; n++) {
	                map[m][n] = Integer.parseInt(input[n]);
	            }
	        }

	        // DFS 탐색 시작
	        int result = dfs(0, 0);
	        System.out.println(result);
	    }

}
