# [백준 S1] 14940.쉬운최단거리
 
## ⏰  **소요 시간**
40분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity (시간 복잡도)**
$O(N)$

## :round_pushpin: **Logic**
- 2차원 배열을 처음부터 돌면서 2인 지점을 찾고, 그 지점부터 bfs를 돌려서 갈 수 있는 길에 +1을 하면 된다.
- 못가는 길은 0 그대로 둔다.
- 갈 수 있는 길인데 탐색하지 못하면 방문 처리를 보고 판단하여 -1로 바꿔준다.


## :black_nib: **Review**
n, m으로 입력받을 때 세로, 가로 순서로 입력받는데 2차원 배열에서 좌표를 찍을 때
x, y값이 반대이기 때문에 인덱스를 설정하는 과정에서 시간이 많이 걸렸다.

## 📡 Link
https://www.acmicpc.net/problem/14940