# [백준 - G5] 4811. 알약

## ⏰ **time**

25분

## :pushpin: **Algorithm**
- 수학
- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1개짜리를 먹으면 1개짜리가 1개줄고 반개짜리가 하나 늘어난다.  
반개짜리만 남은 경우는 항상 먹을 수 있는 경우의 수가 1개씩이다.  
이를 이용해서 bottom-up으로 올라간다.
```java
for (int i = 0; i <= 30; i++) {
    dp[0][i] = 1;
}
for (int i = 1; i <= 30; i++) {
    for (int j = 0; j <= 30; j++) {
        dp[i][j] = 0;
        if (j > 0)
            dp[i][j] += dp[i][j - 1];
        if (j + 1 <= 30)
            dp[i][j] += dp[i - 1][j + 1];
    }
}
```

## :black_nib: **Review**  
탑 다운보다 바텀 업이 더 편한거 같다.
## 📡**Link**
https://www.acmicpc.net/problem/4811