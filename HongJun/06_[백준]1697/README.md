# [백준 - 실버1] 1697. 숨바꼭질
 
## ⏰  **time**
25분

## :pushpin: **Algorithm**
BFS, 큐

## ⏲️**Time Complexity**
$O(N * N)$

## :round_pushpin: **Logic**
너비 우선 탐색으로 갈 수 있는 모든 경로의 카운트(초)를 구하는 문제인 것 같다.
출발 지점부터 갈 수 있는 경우의 수를 모두 탐색해서 카운트의 최소값을 선택하면 된다.
큐를 사용한 BFS를 적용했다.


## :black_nib: **Review**
일반적인 BFS 문제가 아니라서 해결 방법을 생각하는 시간이 좀 걸렸다.

## 📡 Link
https://www.acmicpc.net/problem/1697