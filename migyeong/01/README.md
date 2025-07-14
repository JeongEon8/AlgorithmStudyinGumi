# [백준 - G4] 14520. 연구소

## ⏰  **time**
50분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 벽 3개 조합을 찾는다.
2. 최대 안전 구영영역을 계산한다.
```java
static void makeWall(int start, int wallNum) {
	if (wallNum == 3) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				testMap[i][j] = map[i][j];
			}
		}

		for (int[] v : virus) {
			bfs(v[0], v[1]);
		}

		max = Math.max(max, getSafeSize());
		return;
	}

	for (int i = start; i < n * m; i++) {
		int x = i / m;
		int y = i % m;

		if (map[x][y] == 0) {
			map[x][y] = 1;
			makeWall(i + 1, wallNum + 1);
			map[x][y] = 0;
		}
	}
}
```

## :black_nib: **Review**
- 조합 구하기 도전 성공!

## 📡 Link
https://www.acmicpc.net/problem/14520
