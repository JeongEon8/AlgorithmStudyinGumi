
# [백준- G4] 17144. 미세먼지 안녕!

## ⏰  **time**
3시간

## :pushpin: **Algorithm**
- 시뮬레이션
- 구현

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

1. **먼지 확산(spread)**
   - 각 칸의 먼지양 `dustAmount = map[i][j] / 5`를 인접 4방향으로 확산
   - 확산된 양만큼 원래 칸에서 감소
   - 배열 `temp`를 사용해 동시 업데이트 처리

2. 공기청정기 동작(airPurifier)
	- 위쪽 공기청정기는 반시계 방향, 아래쪽은 시계 방향
	- 공기 순환하면서 먼지 이동

```java
static void spread() {

	int[][] temp = new int[R][C];

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (map[i][j] > 0) {

				int dustAmount = map[i][j] / 5;
				int cnt = 0;

				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					if (map[nx][ny] == -1)
						continue;

					temp[nx][ny] += dustAmount;
					cnt++;

				}
				map[i][j] -= dustAmount * cnt;

			}
		}
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			map[i][j] += temp[i][j];
		}
	}
}
```

```java
static void airPurifier() {

	int[] top = new int[2];
	boolean check = false;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (map[i][j] == -1) {
				top[0] = i;
				check = true;
				break;
			}
		}

		if (check)
			break;
	}

	topLogic(top[0], 0);
	downLogic(top[0] + 1, 0);

}
```

```java
static void topLogic(int sx, int sy) {  // downLogic 로직도 모두 동일

	int dir = 0;
	int x = sx, y = sy;
	int prev = 0;

	while (true) {

		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (nx < 0 || nx > sx || ny < 0 || ny >= C) {
			dir = (dir + 1) % 4;
			nx = x + dx[dir];
			ny = y + dy[dir];
		}

		if (nx == sx && ny == sy) {
			map[nx][ny] = -1;
			break;
		}

		int tmp = map[nx][ny];
		map[nx][ny] = prev;
		prev = tmp;

		x = nx;
		y = ny;

	}
}
```

## :black_nib: **Review**
- `y`를 공기청정기 옆에서 시작하기 위해 `sy + 1`로 진행했다가 계속 틀렸다.
- gpt 한테도 물어봤는데 몰라서 한참 해맴.. 지피티 바보


## 📡**Link**
- https://www.acmicpc.net/problem/17144

