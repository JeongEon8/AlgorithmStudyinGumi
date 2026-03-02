# [백준 - S4] 1269. 대칭 차집합 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 자료 구조
- 집합과 맵
- 해시를 사용한 집합과 맵
- 트리를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(A+B)$

## :round_pushpin: **Logic**

이 문제는 두 집합 A와 B가 주어질 때, 교집합을 제외한 두 집합의 원소 개수(대칭 차집합)를 구하는 문제입니다. 각 집합의 원소를 HashSet에 저장하고, B 집합의 원소를 순회하며 A 집합에 존재하는 경우를 세어 교집합 크기를 구했습니다.
마지막으로 A.size() + B.size() - 2 * 교집합 크기를 계산하여 대칭 차집합의 원소 개수를 출력했습니다.

```java
		for (int key : hashsetB) {
			if (hashsetA.contains(key)) {
				count++;
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1269