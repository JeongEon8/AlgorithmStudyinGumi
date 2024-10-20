# [백준 - S2] 16931. 겉넓이 구하기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**

밑면의 넓이 합은 n*m*2이므로 미리 구하고 각칸마다 노출된 옆면들의 넓이를 더해준다.

```java
int ans = n * m * 2;
for (int i = 1; i <= n; i++) {
	for (int j = 1; j <= m; j++) {
		ans += Math.max(0, graph[i][j] - graph[i - 1][j]);
		ans += Math.max(0, graph[i][j] - graph[i + 1][j]);
		ans += Math.max(0, graph[i][j] - graph[i][j - 1]);
		ans += Math.max(0, graph[i][j] - graph[i][j + 1]);
	}
}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/16931
