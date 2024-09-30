# [백준 - 골드3] 1937. 욕심쟁이 판다
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
DP, DFS

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 메모이제이션을 활용해서 판다가 갈 수 있는 곳(현재 있는 곳보다 대나무가 많은 곳)이면 간다.
2. 이때, 큰 값을 저장한다.
   ```cpp
	dp[y][x] = 1; //처음 가본 곳은 최소 1칸을 이동할 수 있다고 할 수 있기에 1로 초기화 해줍니다.
	for(int dir=0; dir<4; dir++){ //현재 위치에서 상, 하, 좌, 우를 확인합니다.
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx < 0 || ny < 0 || nx >=n || ny >= n) continue;
		if(m[ny][nx] > m[y][x]){ //대나무의 수가 더 많은 지역인지 확인합니다.
        	//현재 위치에서 갈 수 있는 최대 칸보다 ny, nx로 이동했을 때
            //더 많은 칸을 이동할 수 있는지 비교해서 갱신합니다.
			dp[y][x] = max(dp[y][x], func(ny,nx) + 1); 
		}
	}
   ```

## :black_nib: **Review**
- 메모이제이션 다시 공부해봐야겠다.
- DP는 항상 어려운 거 같다.

## 📡 Link
https://www.acmicpc.net/problem/1937
