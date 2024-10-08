# [백준 - S3] 2606. 바이러스
 https://www.acmicpc.net/problem/2606

## ⏰  **소요 시간**
20분

## :pushpin: **Algorithm**
그래프 탐색, BFS, DFS

## ⏲️**Time Complexity (시간 복잡도)**
$O(N)$

## :round_pushpin: **Logic**
이번엔 DFS로 문제를 풀어보았다.
DFS는 재귀를 사용하면 된다.

1. 입력받은 컴퓨터 번호들로 2차원 배열 그래프를 만든다.

2. 1번 컴퓨터부터 시작하니까 dfs 함수의 인자로 정점의 index번호를 받는다.

3. 노드 방문 처리를 하고 해당 노드와 인접한 점들을 for문으로 탐색한다.

4. 방문 처리가 되지 않았을 경우 dfs안에 그 점을 넣어서 재귀를 돌린다.

5. dfs 재귀가 끝나면 1번과 연결된 노드들은 전부 방문처리가 된다.

6. 방문처리가 된 것의 개수에서 -1을 한 값이 정답이다
    -> 문제의 조건이 1번을 통해 바이러스가 걸린 컴퓨터 수 출력이기 때문

## :black_nib: **Review**
지금까지 bfs를 훨씬 더 많이 썼는데 dfs가 훨씬 코드가 간결한 것 같다.
재귀에 익숙해지고 dfs 연습을 많이 해보자. 
