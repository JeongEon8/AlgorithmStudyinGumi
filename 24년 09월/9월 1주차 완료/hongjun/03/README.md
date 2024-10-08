# [백준 G3] 17471. 게리맨더링

## ⏰ **소요 시간**

50분

## :pushpin: **Algorithm**

백트래킹, 조합, DFS, BFS

## ⏲️**Time Complexity (시간 복잡도)**

$O(N)$

## :round_pushpin: **Logic**

- 먼저 1부터 N까지의 수를 두 그룹으로 나누는 조합을 모두 구한다.
  - 백트래킹이나 파이썬의 combinations를 이용하면 된다.
  - 모든 조합을 구하면 너무 많아지니까 두 그룹에서 겹치는게 없도록 n//2 만큼만 반복한다.
  - 다른 그룹에 이미 있는 숫자 조합이면 추가하지 않는 조건도 걸어준다.
- 각 그룹의 도시들을 BFS로 탐색해서 그룹의 도시끼리 다 연결이 되어있는지 확인한다.
- 다 연결이 된다면 각 도시의 인구수의 차의 최소값을 비교한다.

## :black_nib: **Review**

- 조합까진 생각하는게 쉬운데 겹치는 조합을 제거하는 부분이 좀 어려웠다.
- 그리고 도시를 두 그룹으로 나눴을 때 각 그룹에 속한 도시들끼리 연결되었는지 확인하는 BFS를 구현하는게 어려웠다.

## 📡 Link

https://www.acmicpc.net/problem/17471
