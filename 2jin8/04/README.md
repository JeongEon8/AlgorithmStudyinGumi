# [백준 - S1] 14889. 스타트와 링크
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완전탐색

## :round_pushpin: **Logic**
- 조합을 이용해서 N/2명 고르기
- `used[i]=true`면 스타트 팀, `used[i]=false`면 링크 팀 ⇒ 각 팀의 능력치 구하기
```java
static void dfs(int depth, int start) {
  if (depth == N / 2) {
    int startScore = 0, linkScore = 0;
    // 스타트 팀의 능력치 구하기 (used[i]가 true)
    for (int i = 0; i < N - 1; i++) {
      if (!used[i]) continue;
      for (int j = i + 1; j < N; j++) {
        if (!used[j]) continue;
        startScore += arr[i][j] + arr[j][i];
      }
    }

    // 링크 팀의 능력치 구하기 (used[i]가 false)
    for (int i = 0; i < N - 1; i++) {
      if (used[i]) continue;
      for (int j = i + 1; j < N; j++) {
        if (used[j]) continue;
        linkScore += arr[i][j] + arr[j][i];
      }
    }
    ans = Math.min(ans, Math.abs(startScore - linkScore));
    return;
  }

  for (int i = start; i < N; i++) {
    if (used[i])
      continue;

    used[i] = true;
    dfs(depth + 1, i);
    used[i] = false;
  }
}
```

## :black_nib: **Review**
조합을 사용할 때는 시작점을 넘겨주는 것을 까먹어서 시간초과가 발생했었다.. 순열은 0부터, 조합은 start부터 반복문을 돌린다는 것을 기억하자.

## 📡**Link**
- https://www.acmicpc.net/problem/14889
