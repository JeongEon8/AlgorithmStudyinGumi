# [백준 - G3] 11085. 군사 이동

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 자료 구조
- 그래프 이론
- 그래프 탐색
- 분리 집합

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

길 정보를 너비 내림차순으로 정렬하고 너비가 넓은부터 선분을 쳐가면서 group화해주고 출발지와 도착지가 그룹이되면 그때의 start에서 end까지가는 최소 너비이므로 답이다.

```java
static int findParent(int idx) {
	if (parent[idx] == idx) {
		return idx;
	}
	return parent[idx] = findParent(parent[idx]);
}

static boolean setGroup(int a, int b) {
	int aRoot = findParent(parent[a]);
	int bRoot = findParent(parent[b]);
	if (aRoot == bRoot) {
		return false;
	} else {
		parent[bRoot] = aRoot;
		return true;
	}
}

Arrays.sort(roads);
for (Road road : roads) {
	int a = road.a;
	int b = road.b;
	if (setGroup(a, b)) {
		if (findParent(start) == findParent(end)) {
			System.out.println(road.width);
			break;
		}
	}
}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11085
