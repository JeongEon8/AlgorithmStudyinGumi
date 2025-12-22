# [백준 - S3] 11726. 2×n 타일링 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

n=1일때는 1 , 2일때는 2, 3일때는 3, 4일때는 5, 5일때는 8 ...을 관찰한 뒤,
2×n 직사각형을 채우는 마지막 방법을 세로 타일 1개 혹은 가로 타일 2개로 나누어 생각하면,
dp[n] = dp[n−1] + dp[n−2]이라는 결론이 나왔다.

```java
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11726
