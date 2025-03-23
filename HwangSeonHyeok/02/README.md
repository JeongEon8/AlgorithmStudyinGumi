# [백준 - S1] 1446. 지름길

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
각 지름길을 출발위치의 오름차순으로 정렬한다.  
각 도착지점의 최소거리를 계산하고 그 뒤에 갈 수 있는 지름길의 시작지점까지의 최단 거리를 업데이트한다.
```java
Arrays.sort(shortCuts);
int ans = d;
int[] highway = new int[10001];
for (int i = 0; i < 10001; i++) {
	highway[i] = i;
}
for (int i = 0; i < n; i++) {
	ShortCut sc = shortCuts[i];
	if (sc.end > d)
		continue;
	highway[sc.end] = Math.min(highway[sc.end], Math.min(highway[sc.start] + sc.dist, sc.end));
	for (int j = i + 1; j < n; j++) {
		ShortCut next = shortCuts[j];
		if (next.start <= sc.end)
			continue;
		highway[next.start] = Math.min(highway[next.start], highway[sc.end] + next.start - sc.end);
	}
	ans = Math.min(highway[sc.end] + d - sc.end, ans);
}
```

## :black_nib: **Review**
이 문제는 다르게 풀 수 있는 방법이 많을듯하다


## 📡**Link**

https://www.acmicpc.net/problem/1446
