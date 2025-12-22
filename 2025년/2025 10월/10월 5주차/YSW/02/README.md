# [백준 - G5] 18291. 비요뜨의 징검다리 건너기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 조합론
- 분할 정복을 이용한 거듭제곱

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

분할 정복을 사용하여 2^n을 계산한다. 2^n을 구하기 위해 먼저 2^(n/2)를 재귀적으로 구한 후, 이 결과를 제곱하여 2^n을 구하고, 지수 n이 홀수일 때만 추가로 2를 한 번 더 곱해줬다.

```java
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 2 % MOD;
		}

		long half = pow(n / 2);
		long result = (half * half) % MOD;

		if (n % 2 == 1) {
			result = (result * 2) % MOD;
		}

		return result;
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/18291
