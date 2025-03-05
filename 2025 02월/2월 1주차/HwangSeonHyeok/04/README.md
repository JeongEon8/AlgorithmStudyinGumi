# [백준 - S3] 2193. 이친수

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
직전 수가 어떤수든 0은 나올수 이고 1은 직전수가 0일때만 나올 수 이으므로 이 경우를 기록하면서 센다
```java
dp = new long[n][2];
dp[0][1] = 1;
for(int i = 1; i<n; i++){
	dp[i][1] = dp[i-1][0];
	dp[i][0] = dp[i-1][0]+dp[i-1][1];
}
long ans = dp[n-1][0]+dp[n-1][1];
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/2193
