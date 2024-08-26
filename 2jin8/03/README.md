# [백준 - G5] 16987. 계란으로 계란치기
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
백트래킹

## :round_pushpin: **Logic**
- 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란 ⇒ 깬 계란의 최대 수 갱신 & 종료
- 현재 계란이 깨져있거나 깰 수 있는 계란이 없음 ⇒ 다음 계란으로 넘어가기 & 종료
- 손에 있는 계란으로 다른 계란 하나를 치기
  - 깨진 계란의 개수를 추가해서 재귀 호출하기
```java
static void dfs(int depth, int cnt) { // cnt: 깨진 계란의 수
  // 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란이면 종료하기
  if (depth == N) {
    if (ans < cnt) ans = cnt;
    return;
  }

  // 현재 계란이 깨져있는 경우거나 깰 수 있는 계란이 없는 경우
  if (S[depth] <= 0 || cnt >= N - 1) {
    dfs(depth + 1, cnt);
    return;
  }

  // 손에 있는 계란으로 다른 계란 중 하나를 한 번 치기
  for (int i = 0; i < N; i++) {
    // 현재 계란을 깨려는 경우 또는 이미 깨진 계란인 경우는 넘어가기
    if (depth == i || S[i] <= 0)
      continue;

    // 다른 계란의 무게만큼 내구도 감소
    S[i] -= W[depth];
    S[depth] -= W[i];

    if (S[i] <= 0 && S[depth] <= 0) { // 계란이 2개 깨진 경우
      dfs(depth + 1, cnt + 2);
    } else if (S[i] <= 0 || S[depth] <= 0) { // 계란이 1개 깨진 경우
      dfs(depth + 1, cnt + 1);
    } else { // 계란이 깨지지 않은 경우
      dfs(depth + 1, cnt);
    }
    
    // 내구도 원복
    S[i] += W[depth];
    S[depth] += W[i];
  }
}
```

## :black_nib: **Review**
고려해야 할 조건이 많아 풀 때 조금 헷갈렸다. 문제에서 고려해야 할 조건들이 잘 주어지니까 문제를 풀기 전에 정리하는 습관을 가져야 할 것 같다.

## 📡**Link**
- [백준 16987_계란으로 계란치기](https://www.acmicpc.net/problem/16987)
