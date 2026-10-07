# [PGS - LV2] 12900. 2 x n 타일링

## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
짝수인 경우 마지막 자리수가 0이므로 1만 올리면 무조건 1자리를 바꿀 수 있다.
홀수의 경우 가장 마지막 01 부분을 키워서 10으로 바꾸면 가장 비트가 다른 가장 작은 수이다.
```java
dp[0]= 1;
dp[1] = 1;
for(int i = 2; i<=n; i++){
	dp[i] = (dp[i-2] + dp[i-1]) %1000000007;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12900