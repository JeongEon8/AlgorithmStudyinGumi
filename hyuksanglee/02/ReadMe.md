# [백준 - 골드3] 1520. 내리막 길
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
DFS, DP

## ⏲️**Time Complexity**
$O(M * N)$

## :round_pushpin: **Logic**
1. 2차원 배열에 맵에 대한 정보를 담는 map 생성, dp를 활용해서 2차원 메모이제이션 dp를 생성,

2. dp를 방문 처리를 위해 -1로 초기화

3. dfs탐색
   	- 도착지점에 도찰하면 1로 리턴
   	- 해당 지역이 dp에 저장 된 지역이면 해당칸 리턴
   	- 4방향으로 탐색하고 현재칸 보다 작으면 재귀호출하고 리턴값 해당dp의 값에 더해준다
4. 반환된 값 출력
   ```java
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
   ```

## :black_nib: **Review**
- 처음에는 dp없이 방문처리만하다가 시간초과떳어요

## 📡 Link
https://www.acmicpc.net/problem/1520
