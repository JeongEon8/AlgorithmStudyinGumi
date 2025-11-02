# [백준 - G5] 30460. 스위치

## ⏰ **time**

30분

## :pushpin: **Algorithm**
- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
dp[스위치 위치][4]로 dp 배열을 만들고 0엔 스위치를 지금 누른 경우 1은 1개전에 누른 경우 2는 2개 전에 누른경우 3은 안누른 경우로 memoization하면서 계산한다.
```java
dp[0][0] = scores[0] * 2;
dp[0][3] = scores[0];
for (int i = 1; i < n; i++) {
    int score = scores[i];
    dp[i][0] = Math.max(dp[i - 1][2], dp[i - 1][3]) + score * 2;
    dp[i][1] = dp[i - 1][0] + score * 2;
    if (i > 1) {
        dp[i][2] = dp[i - 1][1] + score * 2;
    }

    dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]) + score;

}
```

## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/30460