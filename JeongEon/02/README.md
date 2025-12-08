# [백준 - 실버 3] 15657. N과 M (8)

## ⏰**time**
15분

## :pushpin: **Algorithm**
* 백트래킹 (Backtracking)
* DFS (Depth First Search)

## ⏲️**Time Complexity**
$O(N^M)$

## :round_pushpin: **Logic**
1. **정렬**: 오름차순 출력을 위해 입력 수열을 먼저 정렬
2. **DFS** 탐색:

   * 현재 위치 `k`가 M에 도달하면 수열 출력
   * 중복 허용 & 비내림차순 조건 → `for`문은 현재 인덱스 이상부터 시작
3. 수열을 저장할 배열 `arr`에 값을 채워가며 재귀 호출

```
dfs(start_idx, depth):
  if depth == M:
    출력
    return

  for i from start_idx to N:
    arr[depth] = first[i]
    dfs(i, depth + 1)
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/15657](https://www.acmicpc.net/problem/15657)
