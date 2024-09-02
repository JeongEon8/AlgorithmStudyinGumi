# [백준 S1] 1446. 지름길
 
## ⏰  **소요 시간**
40분

## :pushpin: **Algorithm**
최단경로, 다익스트라

## ⏲️**Time Complexity (시간 복잡도)**
$O(N logN)$

## :round_pushpin: **Logic**
- 우선순위큐인 heapq를 사용하여 다익스트라를 구현한다.
- 지름길의 도착 위치가 목적치의 좌표보다 크면 패스한다 -> 인덱스 에러 때문..
- bfs처럼 힙큐에 원소를 넣고 가장 거리가 작은 길부터 뽑아서 탐색한다.

## :black_nib: **Review**
다익스트라는 리스트를 많이 생성해야해서 인덱스랑 각 리스트가 하는 역할이 너무 헷갈리는 것 같다...ㅜㅜ

## 📡 Link
https://www.acmicpc.net/problem/1446