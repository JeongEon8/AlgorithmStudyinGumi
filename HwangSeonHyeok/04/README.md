# [백준 - S2] 14231. 박스 포장

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
현제보다 작은 박스중 가장 많은 박스가 담긴 박스를 넣는 식으로 DP에 기록하며 계산한다.

```java
	for(int i = 0; i<n;i++) {
		dp[i] = 1;
		for(int j = 0; j<i;j++) {
			if(arr[i]>arr[j]) {
				dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		if(dp[i]>ans) {
			ans = dp[i];
		}
	}

```

## :black_nib: **Review**
LIS의 길이를 구하는 문제

## 📡**Link**

https://www.acmicpc.net/problem/14231
