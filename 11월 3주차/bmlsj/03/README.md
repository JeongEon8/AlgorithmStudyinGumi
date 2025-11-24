
# [백준- S3] 1735. 분수 합

## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

a와 b를 나눌 수 있는 수가 없을 때까지 나눈다.

```java
while (true) {
	boolean check = false;
	for (int i = 2; i <= Math.max(a, b); i++) {
		if (a % i == 0 && b % i == 0) {
			a /= i;
			b /= i;
			check = true;
			break;
		}
	}		
	if (!check) break;
}
```

## :black_nib: **Review**
GCD를 쓰면 더 빠름

## 📡**Link**
- https://www.acmicpc.net/problem/1735

