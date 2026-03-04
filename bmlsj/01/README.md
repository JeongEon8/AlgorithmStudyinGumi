# [백준 - 골드 5] 17836. 공주님을 구해라

## ⏰**time**

60분

## :pushpin: **Algorithm**

BFS

## ⏲️**Time Complexity**

$O(N × M)$

## :round_pushpin: **Logic**

1. 검 보유 여부에 따라 다른 상태를 가지므로 3차원 `visited`를 활용해야한다! => 이거 판단 아직 어려운 듯
2. 검을 만났을 경우: 상태를 1로 변경. 이때 현재 상태는 유지하고 다음 상태를 1로 해야한다.
3. 아직 방문하지 않았을 때
   - 벽일 경우 반드시 검을 보유해야 통과 가능
   - 시간 `T`를 초과하지 않을 것

## :black_nib: **Review**

- 내가 공주님을 구함..!! 대박슨
- `hasGram`이랑 `nextGram`이랑 너무 헷갈려..!
- `hasGram`을 1로 바로 변경해버리면 밑의 연산들이 모두 1로 계산되기 때문에 `nextGram`을 활용

## 📡 Link

<https://www.acmicpc.net/problem/17836>
