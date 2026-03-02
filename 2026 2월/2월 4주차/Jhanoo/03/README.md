# [백준 - 골드 1] 2098. 외판원 순회

## ⏰**time**

43분

## :pushpin: **Algorithm**

- 비트마스크 DP (TSP)
- 완전 탐색 + 메모이제이션

## ⏲️**Time Complexity**

$O(2^N \times N^2)$  
(\(N \leq 16\)이므로 비트마스크 DP로 충분히 가능)

## :round_pushpin: **Logic**

1. 인접 행렬 `W[i][j]`에 i→j로 가는 비용을 저장합니다. 0이면 길이 없는 경우입니다.

```java
int[][] W = new int[N][N];
for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
        W[i][j] = Integer.parseInt(st.nextToken());
    }
}
```

2. 방문 상태를 비트마스크로 표현하여 `dp[mask][u]`를  
   **mask 상태(방문한 도시 집합)에서 현재 도시가 u일 때, 여기까지 오는 최소 비용**으로 둡니다.  
   시작 도시는 0으로 고정하고, `dp[1<<0][0] = 0`으로 시작합니다.

```java
int start = 0;
int FULL = (1 << N) - 1;
final int INF = 1_000_000_000;
int[][] dp = new int[1 << N][N];
for (int mask = 0; mask <= FULL; mask++) {
    Arrays.fill(dp[mask], INF);
}
dp[1 << start][start] = 0;
```

3. 모든 `mask`와 현재 도시 `u`에 대해, 아직 방문하지 않은 도시 `v`로 이동하는 상태 전이를 수행합니다.

```java
for (int mask = 1; mask <= FULL; mask++) {
    if ((mask & (1 << start)) == 0) continue; // 시작 도시 미포함 상태는 무시
    for (int u = 0; u < N; u++) {
        if ((mask & (1 << u)) == 0) continue; // u가 mask에 포함되지 않으면 스킵
        int cur = dp[mask][u];
        if (cur == INF) continue;

        for (int v = 0; v < N; v++) {
            if ((mask & (1 << v)) != 0) continue; // 이미 방문
            if (W[u][v] == 0) continue;          // 길 없음
            int nmask = mask | (1 << v);
            dp[nmask][v] = Math.min(dp[nmask][v], cur + W[u][v]);
        }
    }
}
```

4. 모든 도시를 방문한 상태 `FULL`에서, 다시 시작 도시로 돌아오는 비용을 고려해 최소 값을 구합니다.

```java
int ans = INF;
for (int u = 1; u < N; u++) {
    if (dp[FULL][u] == INF) continue;
    if (W[u][start] == 0) continue;
    ans = Math.min(ans, dp[FULL][u] + W[u][start]);
}
System.out.println(ans);
```

## :black_nib: **Review**

- 어렵다...

## 📡 Link

https://www.acmicpc.net/problem/2098
