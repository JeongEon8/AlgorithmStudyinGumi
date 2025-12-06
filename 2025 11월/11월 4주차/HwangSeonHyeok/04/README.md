# [백준 - S2] 11060. 점프 점프

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
dp로 출발부터 다음 목적지까지 최소로 뛸 수 있는지 기록하면서 진행한다.
```java
for (int i = 0; i < n; i++) {
    if (dp[i] == MAX_COUNT)
        continue;
    for (int j = 1; j <= maze[i]; j++) {
        if (i + j < n) {
            dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
        }
    }
}
```  
## :black_nib: **Review** 
BFS가 더 빨랐을듯??
## 📡**Link**
https://www.acmicpc.net/problem/11060