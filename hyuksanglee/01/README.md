# [백준 - G1] 1311. 할 일 정하기 1

## ⏰ **time**

40분

## :pushpin: **Algorithm**
- 다이나믹 프로그래밍
- 비트마스킹
- 비트필드를 이용한 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(2^n)$

## :round_pushpin: **Logic**
비트 마스크를 이용해서 일을 배분하는 경우를 모두 기록한다.  
```java
dp[0] = 0;
for (int i = 0; i < allWorking; i++) {
    if (dp[i] == Integer.MAX_VALUE)
        continue;
    int workNum = Integer.bitCount(i);
    for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) == 0) {
            int nextVisited = i | (1 << j);
            int nextCost = dp[i] + costs[j][workNum];
            dp[nextVisited] = Math.min(dp[nextVisited], nextCost);
        }
    }
}
```

## :black_nib: **Review**  
비트 마스킹 복습
## 📡**Link**
https://www.acmicpc.net/problem/1311