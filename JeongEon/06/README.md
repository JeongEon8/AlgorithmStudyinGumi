# [소프티어 - Lv2] 6282. 장애물 인식 프로그램
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 한 블록을 DFS로 탐색한다.
2. 반복문을 돌며 모든 배열을 탐색한다.
```cpp
void DFS(int y, int x) {
	cnt++;
	visited[y][x] = true;

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
			continue;
		}

		if (arr[ny][nx] == 1 && visited[ny][nx] == false) {
			DFS(ny, nx);
		}
	}
}
```

## :black_nib: **Review**


## 📡 Link
https://softeer.ai/practice/6282
