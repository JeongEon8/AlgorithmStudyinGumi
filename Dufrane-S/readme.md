# [백준 - G5] 15989. 1,2,3 더하기 4

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- dp

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

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
