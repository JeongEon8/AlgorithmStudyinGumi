# [백준 - 골드 4] 17404. RGB거리 2

## ⏰**time**

40분

## :pushpin: **Algorithm**

- DP (동적 계획법)
- RGB 거리 변형 문제

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 각 집을 빨강(R), 초록(G), 파랑(B) 중 하나로 칠할 때의 비용을 `cost[i][3]`에 저장합니다.

2. 첫 번째 집의 색을 R/G/B 중 하나로 고정해서 세 번 시도합니다.
   - `C`를 첫 번째 집의 색으로 두고, `dp` 배열을 모두 `INF`로 초기화한 뒤,
   - `dp[0][C] = cost[0][C]`만 남겨두어 “첫 집의 색이 C”인 경우만 허용합니다.

```java
for (int C = 0; C < 3; C++) {
    for (int i = 0; i < N; i++) {
        Arrays.fill(dp[i], INF);
    }
    dp[0][C] = cost[0][C];
```

3. 일반 RGB 거리(1149번)와 같은 점화식으로, 인접한 집의 색이 다르게만 칠하도록 DP를 채웁니다.

```java
for (int i = 1; i < N; i++) {
    dp[i][R] = Math.min(dp[i - 1][G], dp[i - 1][B]) + cost[i][R];
    dp[i][G] = Math.min(dp[i - 1][R], dp[i - 1][B]) + cost[i][G];
    dp[i][B] = Math.min(dp[i - 1][R], dp[i - 1][G]) + cost[i][B];
}
```

4. 첫 번째 집의 색과 마지막 집의 색이 같으면 안 되므로,
   - 첫 집이 R이면 마지막 집은 G/B만,
   - 첫 집이 G이면 마지막 집은 R/B만,
   - 첫 집이 B이면 마지막 집은 R/G만 허용하여 최소값을 구합니다.

```java
int min = Math.min(
    dp[N - 1][C == R ? G : R],
    dp[N - 1][C == B ? G : B]
);
ans = Math.min(ans, min);
```

5. 세 번의 시도(C = R, G, B) 중에서 가장 작은 값을 정답으로 출력합니다.

## :black_nib: **Review**

- 원형 구조이기 때문에 시작 집의 색깔을 고정하고 계산해야 했다.

## 📡 Link

https://www.acmicpc.net/problem/17404
