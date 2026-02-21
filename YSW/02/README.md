# [백준 - S2] 18249. 욱제가 풀어야 하는 문제 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N + T)$

## :round_pushpin: **Logic**

이 문제는 dp[n] = dp[n-1] + dp[n-2] 형태의 점화식을 가지는 피보나치 계열 DP 문제입니다.
1, 2, 3, 5, 8 ... 이므로, 각 상태는 이전 두 상태의 합으로 정의됩니다.
단순 재귀로 구현하면 동일한 값이 반복 계산되어 시간복잡도가 O(2^n)으로 비효율적이기 때문에, 저는 Bottom-Up 방식의 동적 계획법을 사용했습니다.
최대 n 값까지 한 번만 미리 계산(O(N))해두고,각 테스트 케이스에서는 배열에서 바로 값을 꺼내 O(1)에 출력하도록 설계했습니다.

```java
		for (int i = 6; i <= maxIndex; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/18249