# [백준 - G4] 1197. 최소 스패닝 트리

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 최소 스패닝 트리

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

- MST에서 크루스칼 알고리즘을 사용하는 문제.
- 비용이 가장 작은 순서로 정렬한다.
- 두 노드의 부모 노드를 유니온 파인드로 확인한다.
- 부모가 다른 경우 union을 실행하여 공통 부모로 변경한다.
- 사이클이 생기지 않게 간선이 n-1개가 되면 종료하고 더한 가중치 출력.

## :black_nib: **Review**
MST 개념을 까먹어서 이론부터 다시 봤다.

## 📡**Link**

https://www.acmicpc.net/problem/1197
