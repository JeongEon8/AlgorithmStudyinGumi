# [백준 - G1] 17143. 낚시왕

## ⏰ **time**

70분

## :pushpin: **Algorithm**

- 구현
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N*3)$

## :round_pushpin: **Logic**

상어 class엔 속도, 이동방향, 크기만 기록한다.

```java
static class Shark {
	int s, d, z;

	public Shark(int s, int d, int z) {
		super();
		this.s = s;
		this.d = d;
		this.z = z;
	}

	@Override
	public String toString() {
		return "sh " + z;
	}
}
```
속도는 가로로 움직이는 경우와 세로로 움직이는 경우를 판단해서 같은방향 같은 위치로 돌아오는 것을 한싸이클을 돈것으로 생각해 s의 크기를 줄인다.
상어는 2차원 Shark배열에 바로 배치한다.
```java
if (d <= 2) {
	if (r == 1) {
		s = 0;
	} else {
		s %= (r * 2 - 2);
	}
} else {
	if (c == 1) {
		s = 0;
	} else {
		s %= (c * 2 - 2);
	}
}
```

낚시는 문제에 나온 순서대로 낚시왕이 현제 step에서 가장 위에있는 상어가 있으면 잡고 상어를 이동시키고 그다음 step을 진행하고를 반복한다. 상어의 이동에서 상어끼리 잡아먹는경우도 처리해준다.
```java
static void moveShark(int i, int j, Shark s) {
	int nextY = i + dy[s.d] * s.s;
	int nextX = j + dx[s.d] * s.s;
	int nextDir = s.d;
	if (nextY > r) {
		nextY = r - (nextY - r);
		nextDir = 1;
		if (nextY < 1) {
			nextY = 1 + (1 - nextY);
			nextDir = 2;
		}
	} else if (nextY < 1) {
		nextY = 1 + (1 - nextY);
		nextDir = 2;
		if (nextY > r) {
			nextY = r - (nextY - r);
			nextDir = 1;

		}
	} else if (nextX > c) {
		nextX = c - (nextX - c);
		nextDir = 4;
		if (nextX < 1) {
			nextX = 1 + (1 - nextX);
			nextDir = 3;
		}
	} else if (nextX < 1) {
		nextX = 1 + (1 - nextX);
		nextDir = 3;
		if (nextX > c) {
			nextX = c - (nextX - c);
			nextDir = 4;
		}
	}
	if (newMap[nextY][nextX] == null || newMap[nextY][nextX].z < s.z) {
		newMap[nextY][nextX] = new Shark(s.s, nextDir, s.z);
	}

}

static void fishing(int step, int sum) {
	if (step == c + 1) {
		System.out.println(sum);
		return;
	}
	int newSum = sum;
	for (int i = 1; i <= r; i++) {
		if (map[i][step] != null) {
			newSum += map[i][step].z;
			map[i][step] = null;
			break;
		}
	}
	newMap = new Shark[r + 1][c + 1];
	for (int i = 1; i <= r; i++) {
		for (int j = 1; j <= c; j++) {
			Shark s = map[i][j];
			if (s != null) {
				moveShark(i, j, s);
			}
		}
	}
	for (int i = 1; i <= r; i++) {
		for (int j = 1; j <= c; j++) {
			map[i][j] = newMap[i][j];
		}
	}

	fishing(step + 1, newSum);
}
```

## :black_nib: **Review**
for문 도는중에 index 몇개를 오타내서 찾는데 오래걸렸다.

## 📡**Link**

https://www.acmicpc.net/problem/17143
