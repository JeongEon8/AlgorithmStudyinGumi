# [백준 - G4] 15685. 드래곤 커브

## ⏰ **time**

90분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

드래곤 커브를 직접 격자 위에 그린 뒤, 1×1 정사각형의 네 꼭짓점이 모두 드래곤 커브에 포함되는 경우의 수를 구하는 구현 문제이다.

1. 방향 리스트 생성

드래곤 커브는 방향 리스트로 표현할 수 있다.

- 0세대: 시작 방향 d 하나로 시작
- 다음 세대:
  - 기존 방향 리스트를 뒤에서부터
  - 각 방향을 `(dir + 1) % 4`로 회전시켜 뒤에 추가

2. 드래곤 커브 그리기

- 시작점을 격자에 표시
- 생성된 방향 리스트를 순서대로 따라가며 이동한 좌표를 모두 격자에 표시
- 격자는 `boolean[101][101]` 배열을 사용하여 커브가 지나간 모든 점을 기록한다.

3. 정사각형 개수 세기

모든 좌표 `(x, y)`에 대해 아래 네 점이 모두 드래곤 커브의 일부라면, 1×1 정사각형 1개 카운트한다.

- `(x, y)`, `(x+1, y)`, `(x, y+1)`, `(x+1, y+1)`

```java
static int[] dx = { 1, 0, -1, 0 };
static int[] dy = { 0, -1, 0, 1 };

static void move(int x, int y, int d, int g) {

	List<Integer> dirs = new ArrayList<Integer>();
	dirs.add(d);

	for (int i = 0; i < g; i++) {
		for (int j = dirs.size() - 1; j >= 0; j--) {
			dirs.add((dirs.get(j) + 1) % 4);
		}
	}

	// System.out.println(dirs);
	// dirs의 좌표 이동
	map[x][y] = true;
	for (int dir : dirs) {
		x += dx[dir];
		y += dy[dir];

		nodes.add(new Node(x, y));
	}
}
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/15685](https://www.acmicpc.net/problem/15685)
