# [백준 - S2] 11724. 연결 요소의 개수 
 https://www.acmicpc.net/problem/11724

## ⏰  **소요 시간**
20분

## :pushpin: **Algorithm**
그래프 탐색, BFS, DFS

## ⏲️**Time Complexity (시간 복잡도)**
$O(N)$

## :round_pushpin: **Logic**
BFS, DFS 이론을 적용하면 풀 수 있는 문제이다.
두 방식 모두 풀어보는 연습을 해야하지만 먼저 bfs로 풀어보았다.
1. 입력한 두 점 u, v를 2차원 배열에 넣어서 그래프를 만들어준다.

2. bfs 함수에 인자를 시작 지점으로 해서 작성한다.
    - deque을 사용하여 시작 지점을 방문 표시 해주고 deque에 넣는다.
    - deque가 비어있을 때 까지 while문을 돌린다.
    - 맨 앞에 있는 원소를 popleft로 뺀다.
    - 그래프에서 해당 원소와 연결된 노드들을 찾는다 -> for문
    - 연결된 노드가 방문하지 않은 노드라면 -> if
    - 방문 표시를 해주고 deque에 append한다.

3. bfs 함수가 끝났다는 것은 하나로 연결된 그래프들의 탐색이 끝났다는 뜻이다.

4. bfs 함수 실행 이후 연결 요소의 개수에 +1을 해준다.

## :black_nib: **Review**
그래프 탐색 화이팅!
