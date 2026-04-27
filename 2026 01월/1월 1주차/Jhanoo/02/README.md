# [백준 - 골드 5] 2166. 다각형의 면적

## ⏰**time**

27분

## :pushpin: **Algorithm**

DP Knapsack 문제

## ⏲️**Time Complexity**

$O(N \times (C + 100)) \approx O(NC)$

## :round_pushpin: **Logic**

1. 각 도시의 홍보는 여러 번 가능 -> 무한 배낭
2. 최대 고객 증가량이 100이므로 limit = C + 100 까지 계산

## :black_nib: **Review**

- C명 이상 조건 때문에 `dp[C]`가 아닌 `C+100`까지 확장해서 골라야 한다.

## 📡 Link

https://www.acmicpc.net/problem/1106
