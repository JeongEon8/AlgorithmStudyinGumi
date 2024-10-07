# [백준 - 골드3] 1520. 퇴사
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
 DP

## ⏲️**Time Complexity**
$O(M * N)$

## :round_pushpin: **Logic**
1. dp 배열 생성

2.  for문을 3방향(왼쪽, 아래, 대각선) 탐색돌려준다.
	- 3방향 이동후 map밖으로 벗어났는지 확인
 	- 이동할 dp에 저장 된값이랑 이동하기전 dp에서 이동 할 위치에 사탕을 더한값을 비교하여 큰 값으로 갱신	
3.  dp에서 오른쪽 아래 좌표에 값 출력

   ```java
		dp[0][0]= map[0][0];
		for(int n =0; n<N; n++) {
			for(int m=0; m<M; m++) {
				for(int d =0; d<3; d++) {
					int ni = n+di[d];
					int nj = m+dj[d];
					if(ni<0 || nj<0||ni>=N || nj>=M) {
						continue;
					}
					
					if(dp[ni][nj] < dp[n][m] + map[ni][nj]) {
						dp[ni][nj]=dp[n][m] + map[ni][nj];
					}
				}
			}
		}
   ```

## :black_nib: **Review**
- dp는 한번에 dp로 풀어야겠다는 생각이 잘안드네요

## 📡 Link
https://www.acmicpc.net/problem/11048
