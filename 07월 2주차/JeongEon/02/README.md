# [백준 - G4] 20166. 문자열 지옥에 빠진 호석

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 먼저 신이 문자열을 주기 전에 미리 경우의 수를 다 만든다.
2. 신이 문자열을 주면 map으로 찾는다!
```cpp
void dfs(int nowY, int nowX, int depth, string s) {
	if (depth == 5) {
		return;
	}
	caseMap[s]++;

	for(int i = 0; i < 8; i++) {
		int ny = nowY + dy[i];
		int nx = nowX + dx[i];

		if (0 > ny) {
			ny = N - 1;
		}
		if(0 > nx) {
			nx = M - 1;
		}
		if(ny >= N) {
			ny = 0;
		}
		if(nx >= M) {
			nx = 0;
		}
		dfs(ny, nx, depth + 1, s + board[ny][nx]);
	}
}
```

## :black_nib: **Review**
- DFS인데 어렵다. 난 알고리즘 다 까먹었나부다... 망했다! 갸악

## 📡 Link
https://www.acmicpc.net/problem/20166
