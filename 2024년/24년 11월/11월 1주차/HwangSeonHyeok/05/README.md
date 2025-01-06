# [백준 - S4] 1758. 알바생 강호

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

팁은 음수가 되지 않으므로 내림차순으로 정렬하고 팁을 많이주는 손님먼저 계산하면된다.

```java
	Collections.sort(tips, Collections.reverseOrder());
	long ans = 0;
	for (int i = 0; i < n; i++) {
		ans += Math.max(tips.get(i) - i, 0);
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1758
