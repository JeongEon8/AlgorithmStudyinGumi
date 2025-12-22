# [백준 - G1] 2098. 외판원 순회

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 비트마스킹
- 비트필드를 이용한 다이나믹 프로그래밍
- 외판원 순회 문제

## ⏲️**Time Complexity**

$O(2^n)$

## :round_pushpin: **Logic**
외판원 순회는 결국 순회하고 돌아오는 사이클 구조라 어디를 시작 지점으로 잡든 상관없다.  
이를 이용해 0번에서 시작하고 0번으로 돌아오는 구성으로 돌아오는 최단 경로를 메모이제이션을 통해 모두 기록하며 구한다.
0번은 이미 방문했으므로 마스킹이 홀수인 경우만 확인하면된다.
```java
dp[1][0] = 0;
for (int mask = 3; mask <= allVisited; mask += 2) {
    for (int i = 1; i < n; i++) {
        if ((mask & (1 << i)) == 0)
            continue;
        int prev = mask ^ (1 << i);
        for (int j = 0; j < n; j++) {
            if (graph[j][i] == 0 || (mask & (1 << j)) == 0 || dp[prev][j] == Integer.MAX_VALUE)
                continue;
            dp[mask][i] = Math.min(dp[mask][i], dp[prev][j] + graph[j][i]);
        }
    }
}
int ans = Integer.MAX_VALUE;
for (int i = 1; i < n; i++) {
    if (dp[allVisited][i] != Integer.MAX_VALUE && graph[i][0] != 0) {
        ans = Math.min(ans, dp[allVisited][i] + graph[i][0]);
    }
}
```  
## :black_nib: **Review** 
TSP
## 📡**Link**
https://www.acmicpc.net/problem/2098