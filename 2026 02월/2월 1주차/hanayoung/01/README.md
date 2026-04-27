# [백준 - S3] 9095. 1, 2, 3 더하기

## ⏰  **time**
30분

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 초기값 설정
```java
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
```
2. n번째는 n-1번째, n-2번째, n-3번째의 합과 같음. 재귀로 n-1, n-2, n-3 번째 값을 더한 값을 반환하고 dp에 저장하도록 함
```java
    static int recur(int n) {
        if(n <= 0) return 0;
        if(dp[n] != 0) return dp[n];
        return dp[n] = recur(n-1) + recur(n-2) + recur(n-3);
    }
```

## :black_nib: **Review**
- 실수해서 dp[n] = 을 빼먹고 제출했는데도 통과했다..! n이 너무 작아서였다고...

## 📡 Link
https://www.acmicpc.net/problem/9095
