# [백준 - 실버1] 7562. 나이트의 이동 
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS, 큐

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
이동 좌표가 상하좌우가 아닌 대각선 쪽으로 8방향의 좌표를 모두 구해야한다.
bfs 풀이 방식에 for문으로 8방향을 확인해서 최소 이동 카운트를 구한다.


## :black_nib: **Review**
최소 몇 번이라고 물어보면 대부분 BFS인 것 같다.
8방향 좌표를 고려하는데 머리를 좀 써야하는 듯 하다


## 📡 Link
https://www.acmicpc.net/problem/7562