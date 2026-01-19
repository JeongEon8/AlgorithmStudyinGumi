# [백준 - 실버 2] 5567. 결혼식

## ⏰ **Time**
8분

## :pushpin: **Algorithm**
BFS

## ⏲️ **Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 인접 행렬 `map`을 사용해 사람 간의 친구 관계를 저장한다.
2. **상근이(1번)의 직접 친구**를 먼저 탐색하여 `friends`와 `visited` 배열에 표시한다.
3. 이후, **상근이의 친구의 친구**를 다시 한 번 탐색하여 `visited` 배열에 표시한다.
4. 상근이 본인을 제외한(2번부터 N번까지) `visited`가 true인 인원 수를 센다.
5. 친구 관계는 최대 2단계까지만 고려하므로 DFS/BFS를 깊이 제한 형태로 구현할 수 있다.

```
1번의 직접 친구 → visited 표시
직접 친구들의 친구 → visited 표시
visited 된 사람 수(1번 제외) 카운트
```

## :black_nib: **Review**
- 상근아~~ 결혼식에 왜 난 초대 안해준거야~~

## 📡 Link
[https://www.acmicpc.net/problem/5567](https://www.acmicpc.net/problem/5567)
