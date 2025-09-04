
# [백준- G3] 15685. 드래곤 커브

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(2^g)$

## :round_pushpin: **Logic**

1. 시작 방향인 d를 list에 넣고, `g` 세대까지 90도 회전한 방향들을 넣는다.
2. 시작점 `(x, y)`를 HashSet에 추가하고, 방향 리스트를 순회하며 각 방향에 맞게 회전된 `(x, y)`들을 HashSet에 추가한다.
3. 정사각형 수를 세기 위해 `(x, y)`, `(x+1, y)`, `(x, y+1)`, `(x+1, y+1)`가 모두 HashSet에 존재하면 1×1 정사각형으로 판단한다.
   

```java
static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Node))
				return false;
			Node node = (Node) o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
```
```java
static boolean countSquare(Node node) {

	int[] dx = { 1, 0, 1 };
	int[] dy = { 0, 1, 1 };

	for (int i = 0; i < 3; i++) {
		int nx = node.x + dx[i];
		int ny = node.y + dy[i];

	if (!allPoints.contains(new Node(nx, ny))) {
			return false;
		}
	}

	return true;

}
```
```java

static int[] dx = { 1, 0, -1, 0 };
static int[] dy = { 0, -1, 0, 1 };

static void curve(int x, int y, int d, int g) {
	ArrayList<Integer> dirs = new ArrayList<Integer>();
	dirs.add(d);

	for (int gen = 0; gen < g; gen++) {
		for (int i = dirs.size() - 1; i >= 0; i--) {
			dirs.add((dirs.get(i) + 1) % 4);
		}
	}

	allPoints.add(new Node(x, y));
	for (int dir : dirs) {
		x += dx[dir];
		y += dy[dir];
		allPoints.add(new Node(x, y));
	}
}
```


## :black_nib: **Review**

처음에는 좌표들을 리스트에 넣어 진행했는데, 방향들을 넣어 후에 방향대로 좌표를 set에 넣는게 더 잘 맞는 로직이었다.
하지만, 세대마다 기존의 리스트를 뒤집어 새로운 방향을 추가하므로 최악의 시간 복잡도 달성~~

`boolean[101][101]` 로 `allPoints`를 대체하면 더 최적화 가능하다구 한다.


## 📡**Link**
- https://www.acmicpc.net/problem/15685

