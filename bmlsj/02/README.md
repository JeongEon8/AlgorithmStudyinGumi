
# [백준- G2] 1655. 가운데를 말해요
## ⏰  **time**
90분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**

1. 조합으로 3개의 벽을 세운다.
2. 바이러스 BFS로 퍼트린다.
3. 남은 0(안전 영역) 개수 세기
4. 최대 안전영역 출력

```java
static void combination(int start, int depth) {

	if (depth == 3) {

		// map을 복사
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, M);
		}

		// 바이러스 퍼트리기
		spreadVirus(copyMap);

		// 안전 영역 계산
		int cnt = countArea(copyMap);
		maxAns = Math.max(maxAns, cnt);

		return;
	}

	for (int i = start; i < blanks.size(); i++) {
		Point pos = blanks.get(i);
		map[pos.x][pos.y] = 1; // 벽o
		combination(i + 1, depth + 1);
		map[pos.x][pos.y] = 0; // 벽X
	}
}
```

## :black_nib: **Review**
- BFS문제여서 조합이 시간 복잡도가 클 거라 여겨 생각을 못했다.
- 가장 큰 값을 구해야하기 때문에 `map`을 복사하는 것도 중요

## 📡**Link**
- https://www.acmicpc.net/problem/14502

