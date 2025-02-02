# [백준 - G5] 1068. 트리

## ⏰ **time**
30분

## :pushpin: **Algorithm**

- DFS

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
- 자식 노드를 입력 받을 때 vector에 추가한다.
- 루트 노드를 시작으로 dfs를 돌린다.
- 리프 노드인지를 판단하기 위해 node가 k일 때 -1을 return하게 한다.
- 크기가 1이면 리프 노드 수를 +1 한다.

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1068