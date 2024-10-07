# [백준 ] 1. 
 
## ⏰  **소요 시간**
30분

## :pushpin: **Algorithm**
최단 경로, 다익스트라

## ⏲️**Time Complexity (시간 복잡도)**
$O(N*logN)$

## :round_pushpin: **Logic**
1. 입력을 받아서 출발 - (도착, 거리) 이렇게 그래프를 만든다.
2. 이후 우선순위 큐 (heapq)로 다익스트라를 진행한다.
3. 이동한 경로도 출력해야하기 때문에 이전 노드를 기록하는 parent배열을 하나 만든다.
4. 최단 경로가 갱신될 때 parent배열에 이전 노드를 넣어준다.
5. 경로를 저장하는 배열에 도착 노드를 넣고 도착 노드의 이전 노드부터 탐색한다.
6. 이전 노드가 시작 지점이 되면 while문을 빠져나온다.
7. path를 뒤집어서 출력한다.

## :black_nib: **Review**
다익스트라 또 까먹었다.

## 📡 Link
https://www.acmicpc.net/problem/11779