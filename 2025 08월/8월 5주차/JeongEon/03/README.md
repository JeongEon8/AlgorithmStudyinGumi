# \[백준 - 실버 2] 1182. 부분수열의 합

## ⏰  **time**

15분

## \:pushpin: **Algorithm**

백트래킹(DFS, 부분집합 생성)

## ⏲️**Time Complexity**

\$O(2^N)\$

* 각 원소를 포함/비포함 → 총 $2^N$가지 부분수열 탐색

## \:round\_pushpin: **Logic**

1. 배열의 각 원소에 대해 **선택 / 비선택** 두 가지 경우로 재귀를 돌린다.
2. 매 단계에서 `tmp + arr[idx] == sum`이면 카운트 증가.
3. 종료 조건: `idx == N`이면 탐색 종료.
4. 초기 호출: `solve(0, 0)`.

```cpp
void solve(int idx, int tmp) {
    if (idx == N) return;
    if (tmp + arr[idx] == sum) cnt++;
    solve(idx + 1, tmp);              // 현재 원소 제외
    solve(idx + 1, tmp + arr[idx]);   // 현재 원소 포함
}
```

⚠️ 주의: 공집합은 카운트하지 않음 → 이 구현은 자동으로 조건 만족.

## \:black\_nib: **Review**

* 부분집합 탐색은 “포함/비포함” 두 갈래 DFS로 깔끔히 처리된다.
* 기저 조건을 단순히 `idx == N`으로 잡고, 정답 카운트는 재귀 진입 시 처리하면 코드가 간결해졌다.

## 📡 Link

[https://www.acmicpc.net/problem/1182](https://www.acmicpc.net/problem/1182)
