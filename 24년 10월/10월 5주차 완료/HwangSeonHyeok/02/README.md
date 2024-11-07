# [백준 - S4] 17419. 비트가 넘쳐흘러

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 이분 탐색
- 매개 변수 탐색

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

$K = K-(K&((~K)+1))$  
이 연산을 하면 가장 작은 자리수 1이 지워진다. 즉 1의 개수만큼 연산하면 0이된다.

```java
	int ans = 0;
	for (int i = 0; i < n; i++) {
		if (bit.charAt(i) - '0' == 1) {
			ans++;
		}
	}
```

## :black_nib: **Review**

연산을 해보면서 규칙을 찾았다.

## 📡**Link**

https://www.acmicpc.net/problem/17419
