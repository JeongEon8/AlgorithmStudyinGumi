# [백준 - G4] 1753. 최단경로
 
## ⏰  **time**
3시간

## :pushpin: **Algorithm**
다익스트라

## ⏲️**Time Complexity**
$O(V+ElogV)$

## :round_pushpin: **Logic**
1. 각 노드에 도달하는 거리를 담는 배열을 만들고 Integer.MAX_VALUE로 설정
2. ArrayList에 인접한 노드들의 인덱스와 거리를 담음
3. 시작지점이 K인 경우 우선순위큐에 담음
4. 우선순위큐를 돌며 각 노드에 도달하는 거리를 업데이트함
5. 방문한 적 없거나, 더 가깝게 도달할 수 있으면 값 수정

## :black_nib: **Review**
- 메모리초과... 시간 초과... 각종 초과 어택 😥😥

## 📡 Link
https://www.acmicpc.net/problem/1753
