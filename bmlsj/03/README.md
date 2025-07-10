# [백준 - G4] 3190. 뱀

## ⏰  **time**
60분

## :pushpin: **Algorithm**
Deque

## ⏲️**Time Complexity**
$O(N^4)$

## :round_pushpin: **Logic**

```java
static int[] dx = { 0, 1, 0, -1 };
static int[] dy = { 1, 0, -1, 0 }; // 우, 하, 좌, 상

public static boolean move(Deque<int[]> snake, int dir) {

	int[] curr = snake.peekLast();
	int x = curr[0] + dx[dir];
	int y = curr[1] + dy[dir];

	if (x < 0 || y < 0 || x >= N || y >= N) { // 벽
		return false;
	}

	// 자기 자신
	for (int[] body : snake) {
		if (body[0] == x && body[1] == y) {
			return false;
		}
	}

	if (map[x][y] == 1) { // 사과 일때
		map[x][y] = 0;
		snake.add(new int[] { x, y });
	} else { // 사과 아닐때
		snake.poll();
		snake.add(new int[] { x, y });
	}
		
	return true;
}
```


## :black_nib: **Review**
- 시간 복잡도가.. 최악이래... 조금 상처일지도

## 📡 Link
https://www.acmicpc.net/problem/3190