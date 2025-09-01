
# [백준- G5] 14503. 로봇 청소기

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**
$O(N×M)$

## :round_pushpin: **Logic**

1. 현재 칸이 아직 청소되지 않았다면 청소한다.
2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인한다.
	- 있으면
		→ 현재 방향을 반시계 방향으로 회전한다.
		→ 회전한 방향 앞 칸이 청소되지 않은 빈 칸이면, 그 칸으로 전진한다. (그리고 1번으로 돌아감)
		→ 아니라면 다시 2번으로 돌아감 (즉, 회전만 계속)

	- 없으면
		→ 현재 방향을 유지한 채 뒤로 한 칸 후진한다.
		→ 뒤가 벽이면 작동을 멈춘다.

```java
static void clean(int x, int y, int dir) {

	while (true) {

		if (!visited[x][y]) {
			visited[x][y] = true;
			cnt++;
		}

		boolean moved = false;

		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			// 주변에 빈칸이 있는 경우
			if (!visited[nx][ny] && map[nx][ny] == 0) {
				visited[nx][ny] = true;
				moved = true;
				x = nx;
				y = ny;
				cnt++;
				break;
			}
		}

		if (!moved) { // 주변에 청소되지 않은 빈칸이 없는 경우
			// 뒤쪽 칸이 벽이 아닌 경우
			int bx = x - dx[dir];
			int by = y - dy[dir];
			if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
				x = bx;
				y = by;
			} else {
				break; // 벽이면 종료
			}
		}
	}
}	
```


## :black_nib: **Review**
원래는 아래에 `if(moved)`인 경우의 로직을 또 구현해주었다.
하지만, 위의 for문 안의 로직에 빈칸인 경우를 처리하는 로직이 있기 때문에 처음부터 반시계로 돌면 한번에 해결 가능


## 📡**Link**
- https://www.acmicpc.net/problem/14503

