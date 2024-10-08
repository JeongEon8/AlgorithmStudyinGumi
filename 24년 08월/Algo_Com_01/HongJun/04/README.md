# [백준 - S1] 2468. 안전 영역
 https://www.acmicpc.net/problem/2468

## ⏰  **소요 시간**
40분

## :pushpin: **Algorithm**
그래프 탐색, BFS, DFS

## ⏲️**Time Complexity (시간 복잡도)**
$O(N^2)$

## :round_pushpin: **Logic**
비의 양에 따라 건물들이 물에 잠기는 경우를 모두 봐야한다.

1. 2차원 배열로 좌표를 입력받고 상하좌우 좌표를 지정한다.

2. 비의 양에 따라 높이가 n이하인 지점이 물에 잠겸서 안전하지 못하기 떄문에 2중 for문으로 모든 좌표를 탐색해서 새로운 2차원 배열에 잠긴 지역은 -1, 안잠겼으면 0으로 값을 바꾼다.

3. bfs 함수를 만든다. 인자로는 시작 지점의 x, y좌표와 새로 만든 배열을 받는다.
    - deque을 사용해서 시작 지점의 x, y좌표를 넣어주고 방문처리 해준다.
    - deque가 빌 때까지 while문을 돌린다.
    - 맨 앞에 있는 좌표쌍을 꺼내서 거기에 상하좌우 좌표값을 더한다.
    - 더한 좌표가 배열 크기를 넘어가지 않는지 확인한다.
    - 잠기지 않은 곳이면 방문처리하고 deque에 좌표쌍을 넣는다.

4. 2중 for문으로 좌표가 잠기지 않았고 방문하지 않았을 때 bfs함수를 실행한다.

5. bfs가 끝나면 영역 한 곳이 탐색이 끝난 것이니까 count+1 해준다.

6. 영역의 개수를 저장하는 배열에 추가한다.

7. 이 배열에서 최대값을 출력한다.

## :black_nib: **Review**
dfs로 풀어보려다 이런 유형의 문제는 전부 bfs로만 풀었어서 결국 bfs로 풀었다. 

처음에는 건물의 최소 높이와 최대 높이를 구해서 해당 범위만큼만 for문을 돌렸다.
근데 69%에서 틀렸다.
그 이유는 건물 높이가 모두 같을 경우 for문이 돌아가지 않을 수 있기 때문인 것 같다.

그래서 최대값-1만큼 for문을 돌렸더니 맞았다.
