# [백준 - S5] 11650. 좌표 정렬하기 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

좌표를 정렬하는 문제였다. 정렬기준을 x좌표로 오름차순으로 정렬하고 x좌표가 같다면 y좌표기준으로 오름차순으로 정렬햇다.

```java
		list.sort((p1, p2) -> {
			if (p1.x == p2.x) {
				return p1.y - p2.y;
			}
			return p1.x - p2.x;
		});
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11650
