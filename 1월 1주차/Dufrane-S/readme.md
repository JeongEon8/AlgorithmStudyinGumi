# [백준 - G5] 15989. 1,2,3 더하기 4

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- dp

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
먼저 1로 만들 수 있는 경우의 수를 초기화 => 모든 수가 1가지 경우의 수
2를 활용할 수 있는 경우의 수 추가 => =dp[i-2]+dp[i]
3을 활용할 수 있는 경우의 수 추가 => =dp[i-3]+dp[i]
```java
for (int i = 0; i <= 10000; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= 10000; i++) {
            dp[i] = dp[i - 2] + dp[i];
        }
        for (int i = 3; i <= 10000; i++) {
            dp[i] = dp[i - 3] + dp[i];
        }
```

## :black_nib: **Review**
- 

## 📡**Link**

https://www.acmicpc.net/problem/15989
