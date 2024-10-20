# [백준 - G5] 14588. Line Friends

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 최단 경로
- 플로이드 워셜

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

라인끼리 연결된 연결이 가능한지 범위체크를하고 가능하면 각각 1의 거리로 설정하고 플로이드 워셜로 최단거리를 구한다.

```java
for (int i = 1; i <= n; i++) {
	String[] split = in.readLine().split(" ");
	int start = Integer.parseInt(split[0]);
	int end = Integer.parseInt(split[1]);
	lineArr[i] = new Line(start, end);
}
for (int i = 1; i <= n; i++) {
	Line lineA = lineArr[i];
	for (int j = i + 1; j <= n; j++) {
		Line lineB = lineArr[j];
		if (check(lineA, lineB)) {
			friendDist[i][j] = 1;
			friendDist[j][i] = 1;
		}

	}
}
for (int m = 1; m <= n; m++) {
	for (int i = 1; i <= n; i++) {
		if (friendDist[i][m] == 0)
			continue;
		for (int j = 1; j <= n; j++) {
			if (m == j || i == j || friendDist[m][j] == 0)
				continue;
			if (friendDist[i][j] == 0)
				friendDist[i][j] = 100000;
			friendDist[i][j] = Math.min(friendDist[i][j], friendDist[i][m] + friendDist[m][j]);
		}
	}
}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/14588
