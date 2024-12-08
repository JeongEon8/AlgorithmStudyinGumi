# [백준 - S1] 25683. 행렬 곱셈 순서 4

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

r1*c인 행렬과 c*r2인 행렬의 곱셉 연산 횟수는 r1*c*r2이고 r1\*r2인 행렬이된다.  
앞에서부터 순방향으로 계산하는 경우와 뒤에서 부터 역방향부터 계산한 경우를 기록해두고 어느 index까지 순방향으로 계산하고 역방향계산해야 연산횟수가 최소인지를 구한다.

```java
long[] dp = new long[n];
dp[0] = 0;
dp[1] = m[0][0] * m[0][1] * m[1][1];
for (int i = 2; i < n; i++) {
	dp[i] = dp[i - 1] + m[0][0] * m[i][0] * m[i][1];

}

long[] dp2 = new long[n];
dp2[0] = 0;
dp2[1] = m[n - 1][0] * m[n - 1][1] * m[n - 2][0];
for (int i = 2; i < n; i++) {
	dp2[i] = dp2[i - 1] + m[n - i - 1][0] * m[n - i - 1][1] * m[n - 1][1];

}
long ans = Long.MAX_VALUE;
for (int i = 0; i < n; i++) {
	ans = Math.min(ans, dp[i] + dp2[n - i - 1]);
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25683
