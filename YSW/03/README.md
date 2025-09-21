# [백준 - S5] 11651. 좌표 정렬하기2 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**

Comparator를 사용해서 정렬을 하였다.

```java
	Arrays.sort(locations, Comparator.comparing((Location l) -> l.y).thenComparing(l -> l.x));
```

## :black_nib: **Review**

Comparator 사용법을 알고 있으면 쉽게 풀 수 있는 문제였다.

## 📡**Link**

https://www.acmicpc.net/problem/11651
